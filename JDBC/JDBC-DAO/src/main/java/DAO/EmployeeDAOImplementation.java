package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.Connect.*;

/*
 * Implementation of EmployeeDAO interface CRUD Methods
 */

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation implements EmployeeDAO, AutoCloseable{
	
	private Connection con;
	private Statement st;
	private ResultSet rs; 
	private PreparedStatement pst;

	// Constructor which will take connection of Database
	public EmployeeDAOImplementation() throws ClassNotFoundException, SQLException{
		Connection con = Database.Connect.getConnection();
		this.con = con;
	}
	
	@Override
	// Returns particular data of employee having the id
	public EmployeeDTO get(int id) throws SQLException {
		
		String query="Select * from Employee where Employee_id="+"\""+id+"\"";
		st= con.createStatement();
		rs = st.executeQuery(query);
		EmployeeDTO empdata = null;
		if(rs.next()){
			int empid = rs.getInt(1);
			String empname = rs.getString(2);
			
			empdata = new EmployeeDTO(empid,empname);
		}
		return empdata;

	}
	

	@Override
	public List<EmployeeDTO> getAll() throws SQLException {
		String query="Select * from Employee;";
		st= con.createStatement();
		rs = st.executeQuery(query);
		List<EmployeeDTO> allempdata = new ArrayList<EmployeeDTO>();
		while(rs.next()) {
			allempdata.add(new EmployeeDTO(rs.getInt(1),rs.getString(2)));
		}
		return allempdata;
	}

	@Override
	public int update(EmployeeDTO data) throws SQLException {
		String query="update Employee set Employee_name=? where Employee_id=?;";
		
		pst = con.prepareStatement(query);
		pst.setString(1, data.getEmployee_name());
		pst.setInt(2,data.getEmployee_id());
		
		try{
			pst.executeUpdate();
			return 0;
		}
		catch(Exception e) {
			return 1;
		}
	}

	@Override
	public int delete(EmployeeDTO data) throws SQLException {
		String query="delete from Employee where Employee_id=?;";
		pst = con.prepareStatement(query);
		pst.setInt(1,data.getEmployee_id());
		try{
			pst.executeUpdate();
			return 0;
		}
		catch(Exception e) {
			return 1;
		}
	}
	

	@Override
	public int insert(EmployeeDTO data) throws SQLException {
		String query="insert into Employee values (?,?);";
		pst = con.prepareStatement(query);
		pst.setInt(1,data.getEmployee_id());
		pst.setString(2, data.getEmployee_name());
		try{
			pst.executeUpdate();
			return 0;
		}
		catch(Exception e) {
			return 1;
		}
		
	}
	
	@Override
	// Destructor closing all connections
	public void close() throws SQLException{
		// Use if else, because in the method some of the connections are used. If any 
		// of the connection is found in exception, rest connection below in exception won't get
		// closed.
		if (con != null) {
			con.close();
		}
		if (st != null) {
			st.close();
		}
		if (rs !=null) {
			rs.close();
		}
		if (pst!=null) {
			pst.close();
		}
		System.out.println("---------Connections close-----------");
	}

}
