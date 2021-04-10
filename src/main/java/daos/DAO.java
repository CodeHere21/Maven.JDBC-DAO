package daos;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
     public T findById(int id) throws SQLException;
     public List findAll() throws SQLException;
     public boolean update(T dto);
     public boolean create (T dto);
     public void delete(int id);

}
