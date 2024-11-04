package com.emp.model;

import java.util.*;
import java.sql.*;

public class Platform_msgJDBCDAO implements Platform_msgDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia103g4?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "derek0830";

	private static final String INSERT_STMT = 
		"INSERT INTO platform_msg (id,member_id,business_id,message,msg_time,status) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT id,member_id,business_id,message,msg_time,status FROM platform_msg order by id";
	private static final String GET_ONE_STMT = 
		"SELECT id,member_id,business_id,message,msg_time,status FROM platform_msg where id = ?";
	private static final String DELETE = 
		"DELETE FROM platform_msg where id = ?";
	private static final String UPDATE = 
		"UPDATE platform_msg set member_id=?, business_id=?, message=?, msg_time=?, status=?,  where id = ?";

	@Override
	public void insert(Platform_msgVO msgVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, msgVO.getId());
			pstmt.setInt(2, msgVO.getMember_id());
			pstmt.setInt(3, msgVO.getBusiness_id());
			pstmt.setString(4, msgVO.getMessage());
			pstmt.setDate(5, msgVO.getMsg_time());
			pstmt.setInt(6, msgVO.getStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(Platform_msgVO msgVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, msgVO.getId());
			pstmt.setInt(2, msgVO.getMember_id());
			pstmt.setInt(3, msgVO.getBusiness_id());
			pstmt.setString(4, msgVO.getMessage());
			pstmt.setDate(5, msgVO.getMsg_time());
			pstmt.setInt(6, msgVO.getStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer empno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, empno);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public Platform_msgVO findByPrimaryKey(Integer empno) {

		Platform_msgVO msgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, empno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				msgVO = new Platform_msgVO();
				msgVO.setId(rs.getInt("id"));
				msgVO.setMember_id(rs.getInt("member_id"));
				msgVO.setBusiness_id(rs.getInt("business_id"));
				msgVO.setMessage(rs.getString("message"));
				msgVO.setMsg_time(rs.getDate("msg_time"));
				msgVO.setStatus(rs.getInt("status"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return msgVO;
	}

	@Override
	public List<Platform_msgVO> getAll() {
		List<Platform_msgVO> list = new ArrayList<Platform_msgVO>();
		Platform_msgVO msgVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				msgVO = new Platform_msgVO();
//				empVO.setEmpno(rs.getInt("empno"));
//				empVO.setEname(rs.getString("ename"));
//				empVO.setJob(rs.getString("job"));
//				empVO.setHiredate(rs.getDate("hiredate"));
//				empVO.setSal(rs.getDouble("sal"));
//				empVO.setComm(rs.getDouble("comm"));
//				empVO.setDeptno(rs.getInt("deptno"));
				msgVO.setId(rs.getInt("id"));
				msgVO.setMember_id(rs.getInt("member_id"));
				msgVO.setBusiness_id(rs.getInt("business_id"));
				msgVO.setMessage(rs.getString("message"));
				msgVO.setMsg_time(rs.getDate("msg_time"));
				msgVO.setStatus(rs.getInt("status"));
				list.add(msgVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		Platform_msgJDBCDAO dao = new Platform_msgJDBCDAO();

		// 新增
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);

		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);

		// 刪除
//		dao.delete(7014);

		// 查詢
		Platform_msgVO msgVO3 = dao.findByPrimaryKey(1);
		System.out.print(msgVO3.getId() + ",");
		System.out.print(msgVO3.getMember_id() + ",");
		System.out.print(msgVO3.getBusiness_id() + ",");
		System.out.print(msgVO3.getMessage() + ",");
		System.out.print(msgVO3.getMsg_time() + ",");
		System.out.print(msgVO3.getStatus() + ",");
		System.out.println("---------------------");

		// 查詢
		List<Platform_msgVO> list = dao.getAll();
		for (Platform_msgVO aMsg : list) {
			System.out.print(aMsg.getId() + ",");
			System.out.print(aMsg.getMember_id() + ",");
			System.out.print(aMsg.getBusiness_id() + ",");
			System.out.print(aMsg.getMessage() + ",");
			System.out.print(aMsg.getMsg_time() + ",");
			System.out.print(aMsg.getStatus() + ",");
			System.out.println();
		}
	}
}