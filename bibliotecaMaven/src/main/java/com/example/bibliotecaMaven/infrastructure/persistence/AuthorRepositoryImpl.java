package com.example.bibliotecaMaven.infrastructure.persistence;

import com.example.bibliotecaMaven.domain.models.Author;
import com.example.bibliotecaMaven.domain.repositories.AuthorRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    private final JdbcTemplate jdbcTemplate;

    public AuthorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author save(Author author) {
        if (author.getId() == null) {
            String sql = "INSERT INTO Autores (Nombre, Nacionalidad) VALUES (?, ?)";
            jdbcTemplate.update(sql, author.getName(), author.getNationality());
            Long id = jdbcTemplate.queryForObject("SELECT SCOPE_IDENTITY()", Long.class);
            author.setId(id);
        } else {
            String sql = "UPDATE Autores SET Nombre = ?, Nacionalidad = ? WHERE Id = ?";
            jdbcTemplate.update(sql, author.getName(), author.getNationality(), author.getId());
        }
        return author;
    }

    @Override
    public Optional<Author> findById(Long id) {
        String sql = "SELECT * FROM Autores WHERE Id = ?";
        return jdbcTemplate.query(sql, new AuthorRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Author> findAll() {
        String sql = "SELECT * FROM Autores";
        return jdbcTemplate.query(sql, new AuthorRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM Autores WHERE Id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM Autores WHERE Id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    private static class AuthorRowMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(rs.getLong("Id"));
            author.setName(rs.getString("Nombre"));
            author.setNationality(rs.getString("Nacionalidad"));
            return author;
        }
    }
}