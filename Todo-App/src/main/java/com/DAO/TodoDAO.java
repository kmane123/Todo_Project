package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.entity.TodoDtls;
import com.mysql.cj.xdevapi.PreparableStatement;

public class TodoDAO {

	private Connection con;

	public TodoDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addTodo(String name,String todo,String status) {
		
		boolean f=false;
		
		try {
			
			String sql="insert into add_app (name,todo,status) values (?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, todo);
			pst.setString(3, status);
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<TodoDtls> getTodo() {
		
		List<TodoDtls> list=new ArrayList<TodoDtls>();
		TodoDtls t=null;
		
		try {
			
			String sql="select * from add_app";
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				
				t=new TodoDtls();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
				
				list.add(t);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;	
	}
	
	public TodoDtls getTodoById(int id) {
		
		TodoDtls t=null;
		
		try {
			String sql="select * from add_app where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				t=new TodoDtls();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	
	public boolean UpdateTodo(TodoDtls t) {
		
		boolean f=false;
		
		try {
			String sql="update add_app set name=?,todo=?,status=? where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getTodo());
			pst.setString(3, t.getStatus());
			pst.setInt(4, t.getId());
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteTodo(int id) {
		boolean f=false;
		
		try {
			String sql="delete from add_app where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
 