package com.Edu.CRUDemo;

import com.Edu.CRUDemo.repository.Student;
import com.Edu.CRUDemo.entity.StudentsEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDemoApplication {

	public static void main(String[] args) { SpringApplication.run(CruDemoApplication.class, args);}

	@Bean
	public CommandLineRunner commnadLineRunner(Student students){
		return runner -> {
			//createStudent(students);

			//createMultipleStudents(students);

			//readStudent(students);

			//findStudens(students);

			//findStudentByLastName(students);

			//updateStudent(students);

			removeStudent(students);
		};
	}

	private void removeStudent(Student students) {

		int studentId=3;
		System.out.println("Deleting student...");
		students.delete(studentId);
		System.out.println("Done: " + students.findById(studentId));
	}

	private void updateStudent(Student students) {

		//retrieve student based on the id: primary key
		System.out.println("Finding student...");
		int studentId=2;
		StudentsEntity tempStudent = students.findById(studentId);
		System.out.println("Student found: " + tempStudent);

		//change first name
		System.out.println("Updating student...");
		tempStudent.setFirstName("Lamboo");

		//update the student
		students.update(tempStudent);

		//display the updated student
		System.out.println("Student updated: " + students.findById(studentId));

	}

	private void findStudentByLastName(Student students) {
		String lastName = "Beitia";

		List<StudentsEntity> theStudent = students.findByLastName(lastName);

		for (StudentsEntity tempStudent : theStudent){
			System.out.println(tempStudent);
		}

	}

	private void findStudens(Student students) {

		//get list of students
		List<StudentsEntity> theStudents = students.findAll();

		//Display list of students
		for (StudentsEntity tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(Student students){
		System.out.println("Creating Student....");
		StudentsEntity tempStudent = new StudentsEntity("daffy","duck","ducky@gmail.com");

		System.out.println("Save Student");
		students.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		StudentsEntity myStudent = students.findById(theId);

		System.out.println("Found  the student: " + myStudent);
	}

	private void createMultipleStudents(Student students) {
		System.out.println("Creating 3 Student....");
		StudentsEntity tempStudent = new StudentsEntity("Eduardo","Beitia","lol@gmail.com");
		StudentsEntity tempStudent1 = new StudentsEntity("hola","no","play@gmail.com");
		StudentsEntity tempStudent2 = new StudentsEntity("chao","si","sup@gmail.com");

		System.out.println("Saving the students....");
		students.save(tempStudent);
		students.save(tempStudent1);
		students.save(tempStudent2);
	}

	private void createStudent(Student students) {

		//create student object
		System.out.println("Creating new Student....");
		StudentsEntity tempStudent = new StudentsEntity("Eduardo","Beitia","lol@gmail.com");

		//save the student object
		System.out.println("Saving the student....");
		students.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
