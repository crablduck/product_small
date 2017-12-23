package com.xjw.dbcenter;

import java.util.ArrayList;
import java.util.List;

import com.xjw.entity.Student;

public class DBCenter {

	private static List<Student> stu = new ArrayList<>();
	
	static{
		stu.add(new Student(1, "xiaoming", "123321"));
		stu.add(new Student(1, "xiaogang", "123321"));
		stu.add(new Student(1, "xiaohong", "123321"));
		stu.add(new Student(1, "xiaolv", "123321"));
	}
	
	public static List<Student> getStu(){
		return stu;
	}
}
