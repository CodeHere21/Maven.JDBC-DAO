package daos;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
     public T findById(int id) throws SQLException;
     public List findAll() throws SQLException, ClassNotFoundException;
     public boolean update(T dto) throws ClassNotFoundException;
     public boolean create (T dto) throws ClassNotFoundException;
     public boolean delete(int id) throws ClassNotFoundException;

}
