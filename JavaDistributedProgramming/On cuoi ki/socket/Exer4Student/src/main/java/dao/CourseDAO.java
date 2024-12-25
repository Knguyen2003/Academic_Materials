package dao;

import java.util.List;

import entity.Course;

public interface CourseDAO {
	public boolean add(Course course);
	public boolean update(Course course);
	public boolean delete(int courseID);
	public List<Course> findAll();
	public Course findByID(int id);
	public List<Course> findByTitle(String title); //Tuong doi
	public Course findByTitle2(String title); //Tuyet doi
	public List<Course> findCoursesWithMaxCredits();
}
