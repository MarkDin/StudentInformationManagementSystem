package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import student.Student;
import students.Students;

public class db1 {
	private static final String URL = "jdbc:mysql://localhost:3306/students";
	private static final String NAME = "root";
	private static final String PASSWORD = "154310";
	//
	Students list;
	Student stu;
	int id;
	String name;
	String sex;
	int age;
	int math;
	int computer;
	int Flanguage;
	java.sql.Statement stmt;
	Connection conn;
	java.sql.PreparedStatement psmt;
	public db1() throws Exception {
		stu = new Student();
		// 1.������������
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// 2.������ݿ������
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		// 3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
		stmt = conn.createStatement();
	}

	public void get_db_info() throws SQLException {

		ResultSet rs = stmt.executeQuery("select * from studnet");// ѡ��import //
																	// java.sql.ResultSet;
		while (rs.next()) {// ��������������ݣ��ͻ�ѭ����ӡ����
			// System.out.print(rs.getInt("id") + " ");
			// System.out.print(rs.getString("name") + " ");
			// System.out.print(rs.getInt("age") + " ");
			// System.out.print(rs.getString("sex") + " ");
			// System.out.print(rs.getInt("math") + " ");
			// System.out.print(rs.getInt("computer") + " ");
			// System.out.print(rs.getInt("Flanguage") + " ");
			// System.out.println();
			id = rs.getInt("id");
			name = rs.getString("name");
			age = rs.getInt("age");
			sex = rs.getString("sex");
			math = rs.getInt("math");
			computer = rs.getInt("computer");
			Flanguage = rs.getInt("Flanguage");
			stu = new Student(id, name, age, sex, math, computer, Flanguage);
			stu.cal_ave(stu);
			Students.list.add(stu);
		}
	}

	public void write_student(Student stu) throws SQLException {
//		String sql =  "insert into student" + "(id,name,age,sex,math,computer,Flanguage,"
//				+") " + "values("
//				+ "?,?,?,?,?,?,?)";// ������?��ʾ���൱��ռλ��
		// Ԥ����sql���
		String sql =  "insert into studnet(id,name,age,sex,math,computer,Flanguage) values(?,?,?,?,?,?,?)";// ������?��ʾ���൱��ռλ��
		psmt = conn.prepareStatement(sql);
		// �ȶ�ӦSQL��䣬��SQL��䴫�ݲ���
		psmt.setInt(1, stu.getId());
		psmt.setString(2, stu.getName());
		psmt.setInt(3, stu.getAge());
		psmt.setString(4, stu.getSex());
		psmt.setInt(5, stu.getMath());
		psmt.setInt(6, stu.getComputer());
		psmt.setInt(7, stu.getFlanguage());
		// ִ��SQL���
		psmt.execute();
	}
	public void write_all() {
		Iterator<Student>it = Students.list.iterator();
		while(it.hasNext()) {
			stu = it.next();
			stu.print_stu_info(stu);
			try {
				write_student(stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
