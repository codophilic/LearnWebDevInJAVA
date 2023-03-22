package DAO;

import java.sql.SQLException;
import java.util.List;

/*
 * Creating a generic interface which can be implemented by different class
 */

public interface DAO<T> {
	
	T get(int id) throws SQLException;
	
	List<T> getAll() throws SQLException;
	
	int update(T t ) throws SQLException;
	
	int delete(T t ) throws SQLException;
	
	int insert(T t ) throws SQLException;
	
	void finalize() throws Exception;
}
