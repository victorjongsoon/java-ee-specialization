package com.student.dao;

import java.util.Collection;

import com.student.core.Student;

public interface StudentDaoWaitList {
	void add(Student student);
	Collection<Student> getAll();
}
