package com.velocity.groupI.quiz.operation;

import java.sql.SQLException;
import java.util.Scanner;


import com.velocity.groupI.quiz.connection.MakeConnection;
import com.velocity.groupI.quiz.encapsulate.QuizQuestion;
import com.velocity.groupI.quiz.encapsulate.StudentInfo;


public interface QuizOperation {
	public abstract void getStudentInput(Scanner scan, StudentInfo student);
	public abstract void getQuizScore(MakeConnection makeConnection,QuizQuestion quizQuestions,Scanner scan, StudentInfo student) ;
	public abstract void calculateGrade(int score,StudentInfo student);
	public abstract void insertStudentDetails(MakeConnection makeConnection, StudentInfo student);

	public abstract void displayStudentDetailsRank(MakeConnection makeConnection,StudentInfo student);
	
	public abstract void getStudentDetails(int id, MakeConnection makeConnection);
}
