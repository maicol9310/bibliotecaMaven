package com.example.bibliotecaMaven.infrastructure.persistence;

import com.example.bibliotecaMaven.domain.models.Book;
import com.example.bibliotecaMaven.domain.repositories.BookRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            String sql = "INSERT INTO Libros (Titulo, Descripcion, AutorId, FechaPublicacion) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, book.getTitle(), book.getDescription(), book.getAuthorId(), book.getPublicationDate());
            Long id = jdbcTemplate.queryForObject("SELECT SCOPE_IDENTITY()", Long.class);
            book.setId(id);
        } else {
            String sql = "UPDATE Libros SET Titulo = ?, Descripcion = ?, AutorId = ?, FechaPublicacion = ? WHERE Id = ?";
            jdbcTemplate.update(sql, book.getTitle(), book.getDescription(), book.getAuthorId(),
                    book.getPublicationDate(), book.getId());
        }
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        String sql = "SELECT * FROM Libros WHERE Id = ?";
        return jdbcTemplate.query(sql, new BookRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM Libros";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM Libros WHERE Id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM Libros WHERE Id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    @Override
    public boolean existsByAuthorId(Long authorId) {
        String sql = "SELECT COUNT(*) FROM Libros WHERE AutorId = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, authorId);
        return count != null && count > 0;
    }

    private static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getLong("Id"));
            book.setTitle(rs.getString("Titulo"));
            book.setDescription(rs.getString("Descripcion"));
            book.setAuthorId(rs.getLong("AutorId"));
            book.setPublicationDate(rs.getString("FechaPublicacion"));
            return book;
        }
    }
}