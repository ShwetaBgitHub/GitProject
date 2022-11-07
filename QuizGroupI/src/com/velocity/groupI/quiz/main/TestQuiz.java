package com.velocity.groupI.quiz.main;

import java.util.Scanner;

import com.velocity.groupI.quiz.connection.MakeConnection;
import com.velocity.groupI.quiz.encapsulate.QuizQuestion;
import com.velocity.groupI.quiz.encapsulate.StudentInfo;
import com.velocity.groupI.quiz.operation.QuizOperations;

public class TestQuiz {

	public static void main(String[] args) {
		MakeConnection connection = new MakeConnection();
		Scanner scan = new Scanner(System.in);
		//StudentDetails stdDetails = new StudentDetails();
		int a =1;
		int b =2;
		int c =3;
		
		
		
		String ch="Y";
		QuizOperations quizOp = new QuizOperations();
		QuizQuestion quizQuestion = new QuizQuestion();
		StudentInfo student = new StudentInfo();
		while(ch.equals("Y")) { 
			
			System.out.println(a+". Student Registration And Attempt Quiz. ");
			System.out.println(b+". Particular Student Details Based On Student Id.");
			System.out.println(c+". Display All Student Details In Ascending Order With Respect to Score.");
			
			System.out.println("Please Enter Your Option from 1, 2, 3 Only ");
			int option = scan.nextInt();
			
			if (option == 3) {
			
			quizOp.displayStudentDetailsRank(connection, student);
			System.out.println("Do u want to continue with other features ? Please Enter Y or N. ");
			ch =scan.next();
			}
			else if(option ==2)
			{
			
			System.out.println("Please Enter Student Id to get Details ");
			int stdId = scan.nextInt();
			
			quizOp.getStudentDetails(stdId, connection);
			System.out.println("Do u want to continue with other features ? Please Enter Y or N. ");
			ch =scan.next();
			}
			else if(option == 1) {
				quizOp.getStudentInput(scan,student);
				System.out.println("Student's First Name : "+student.getStdFirstName()+"Students Last Name : "+student.getStdLastName());
				quizOp.getQuizScore(connection,  quizQuestion,scan, student);
				int score = student.getScore();
				System.out.println("Student's Quiz Score : "+score);
				quizOp.calculateGrade(score, student);
				System.out.println("Student's Grade : "+student.getGrade());
		
				quizOp.insertStudentDetails( connection,  student) ;
		
				System.out.println("Do u want to continue with other features ? Please Enter Y or N. ");
				ch =scan.next();
		
			}
			else
			{
				System.out.println("Invalid option No. please enter 1 or 2 or 3 only. ");
				System.out.println("Do u want to continue with other features ? Please Enter Y or N. ");
				ch =scan.next();	
			}
		
		
	}
	}

}
