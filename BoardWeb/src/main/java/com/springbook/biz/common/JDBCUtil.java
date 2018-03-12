package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn=null;
		try {
			/*Class.forName("org.h2.Driver");
			conn= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			if(conn!=null)
				System.out.println("connection 성공");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		if(pstmt!=null) {
			try {
				if(!pstmt.isClosed())pstmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				pstmt=null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				conn=null;
			}
		}
		
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null) {
			try {
				if(!rs.isClosed())rs.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				rs=null;
			}
		}
		
		if(pstmt!=null) {
			try {
				if(!pstmt.isClosed())pstmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				pstmt=null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				conn=null;
			}
		}
	}

}
