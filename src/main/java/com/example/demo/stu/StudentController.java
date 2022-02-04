package com.example.demo.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController  {
	
	Scanner input= new Scanner(System.in);
	List <Student> stulist= new ArrayList <Student>();
	
	Connection con = null;
	
	String url="Jdbc:mysql://localhost:3306/mydb";
		
	
	@RequestMapping("/showstudents")
	public List<Student> getAllStudents() {
		try {
			
			Connection con= DriverManager.getConnection(url, "root", "1234");
			 Statement st= con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from Student");
			
				 while(rs.next()) {
					 stulist.add(new Student(rs.getInt("stuId"), rs.getString("stuName"), rs.getDouble("marks")));
				 }
	}
		
	 catch (SQLException e) {
		 System.out.println(e.getMessage());
	 }


		
		
		Collections.sort(stulist, new StuNameComp());
		return stulist;
	}
	
	
	
	@RequestMapping("/searchbyid")
	public String Studentbyid() {
try {
			
			Connection con= DriverManager.getConnection(url, "root", "1234");
			 Statement st= con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from Student");
			
				 while(rs.next()) {
					 stulist.add(new Student(rs.getInt("stuId"), rs.getString("stuName"), rs.getDouble("marks")));
				 }
	}
		
	 catch (SQLException e) {
		 System.out.println(e.getMessage());
	 }
        String res=" ";
		int id=5;
		for(Student st: stulist) {
			if(st.getStuId()==id) {
				res= st.getStuId()+" "+ st.getStuName() +" "+ st.getMarks();				
			}
		}
		return res;
		
		
	}
	
	@RequestMapping("/updatemarks")
	public String updateMarksById() {
try {
			
			Connection con= DriverManager.getConnection(url, "root", "1234");
			 Statement st= con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from Student");
			
				 while(rs.next()) {
					 stulist.add(new Student(rs.getInt("stuId"), rs.getString("stuName"), rs.getDouble("marks")));
				 }
	}
		
	 catch (SQLException e) {
		 System.out.println(e.getMessage());
	 }
        String res=" ";
		int id=6;
		for(Student st: stulist) {
			if(st.getStuId()==id) {
				st.setMarks(92);
				res= st.getStuId()+" "+ st.getStuName() +" "+ st.getMarks();
				
			}
			
		}
		return res;
	
		
		
	}

}
