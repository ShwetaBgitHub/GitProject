package com.velocity.groupI.quiz.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.groupI.quiz.Validate.InputValidation;
import com.velocity.groupI.quiz.connection.MakeConnection;
import com.velocity.groupI.quiz.encapsulate.QuizQuestion;
import com.velocity.groupI.quiz.encapsulate.StudentInfo;
import com.velocity.groupI.quiz.exception.InvalidNameException;

public class QuizOperations implements QuizOperation{
	int score;
	@Override
	public void getQuizScore(MakeConnection makeConnection, QuizQuestion quizQuestions, Scanner scan, StudentInfo student) {
try {
			
	        Connection connection = makeConnection.getConnectionInfo();
			//StudentInfo student = new StudentInfo();
	        String sql="select * from mcq  order by rand() limit 10";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			int i=1;
			score =0;
			while(rs.next())
			{   quizQuestions.setQuestionId(rs.getInt(1));
				quizQuestions.setQuestion(rs.getString(2));
				quizQuestions.setChoice1(rs.getString(3));
				quizQuestions.setChoice2(rs.getString(4));
				quizQuestions.setChoice3(rs.getString(5));
				quizQuestions.setChoice4(rs.getString(6));
				quizQuestions.setCorrectAnswer(rs.getInt(7));
				
				/*System.out.println(" Question id = "+quizQuestions.getQuestionId());
				System.out.println("Question = "+quizQuestions.getQuestion());
				System.out.println("Choice1 = "+quizQuestions.getChoice1());
				System.out.println("Choice2 = "+quizQuestions.getChoice2());
				System.out.println("Choice3 = "+quizQuestions.getChoice3());
				System.out.println("Choice4 = "+quizQuestions.getChoice4());
				System.out.println("CorrectAnswer = "+quizQuestions.getCorrectAnswer());
				*/
				
				System.out.println("Question "+i+". "+quizQuestions.getQuestion());
				System.out.println("            1. "+quizQuestions.getChoice1());
				System.out.println("            2. "+quizQuestions.getChoice2());
				System.out.println("            3. "+quizQuestions.getChoice3());
				System.out.println("            4. "+quizQuestions.getChoice4());
				
				System.out.println("Enter Your Answer ");
				int userAns = scan.nextInt();
				InputValidation inputValid = new InputValidation();
				inputValid.validateNumberInput(userAns);
				i++;
				//System.out.println("Score Before "+score);
				
				if(userAns==quizQuestions.getCorrectAnswer())
				{
					score++;
					//System.out.println("Score After "+score);
				}	
				
			}
			student.setScore(score);
			connection.close();
			ps.close();
		 } catch (Exception e) {
		    	// TODO Auto-generated catch block
		    	e.printStackTrace();
		    }//System.out.println("Student Score "+score);
		//return score;
	}
	
	
	@Override
	public void getStudentInput(Scanner scan, StudentInfo student) {
		
		System.out.println("Please Enter Your First Name : ");
		String firstName =scan.next();
		InputValidation valid = new InputValidation();
		 
			
				valid.validateStringInput(firstName);
			
		 student.setStdFirstName(firstName);
		 
		 System.out.println("Please Enter Your Last Name : ");
		 String lastName = scan.next();
		 
				valid.validateStringInput(firstName);
			
		 student.setStdLastName(lastName);
		 
		//return student;
	}


	@Override
	public void calculateGrade(int score,StudentInfo student) {
		String grade = null;
		 if(score>=8 && score<=10)
			 grade ="A";
		 else if(score>=6 && score<8)
			 grade ="B";
		 else if(score==5)
			 grade ="C";
		 else if(score<5)
			 grade ="D";
		 student.setGrade(grade);
		// return grade;
	}


	@Override
	public void insertStudentDetails(MakeConnection makeConnection, StudentInfo student) {
		Connection connection;
		try {
			connection = makeConnection.getConnectionInfo();
		
		
		String sql="insert into student(stdFName,stdLName,score,grade) values (?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, student.getStdFirstName());
		ps.setString(2, student.getStdLastName());
		ps.setInt(3, student.getScore());
		ps.setString(4, student.getGrade());
		int i= ps.executeUpdate();
		System.out.println("Student details inserted Success");
		connection.close();
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void displayStudentDetailsRank(MakeConnection makeConnection, StudentInfo student) {
try {
			
	        Connection connection = makeConnection.getConnectionInfo();
			
	        String sql="select * from student order by score";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			System.out.println("stdId\t"+"stdFName "+"stdLName\t\t"+"score\t"+"grade");
			while(rs.next())
			{   
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+" "+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t"+rs.getString(5));
			}
			
			connection.close();
			ps.close();
		
		    } catch (Exception e) {
		    	// TODO Auto-generated catch block
		    	e.printStackTrace();
		    }
		
	}


	@Override
	public void getStudentDetails(int id, MakeConnection makeConnection) {
		try {
			Connection connection = makeConnection.getConnectionInfo();
			String sql="select * from student where stdId=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs==null) {
				System.out.println("Result is empty ");
			}
			System.out.println("stdId\t"+"stdFName "+"stdLName\t\t"+"score\t"+"grade");
			
			while(rs.next())
			{   
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+" "+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
			}
			connection.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
