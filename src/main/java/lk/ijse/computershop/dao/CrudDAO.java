package lk.ijse.computershop.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {

    int save(T entity) throws SQLException;

    T search(String id) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(String id) throws SQLException;

    List<T> getAll() throws SQLException;

    String getNextId() throws SQLException;
}
