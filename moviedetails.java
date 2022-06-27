package net.codejava;

import java.sql.*;
import java.sql.Connection;
import java.util.*;
import java.sql.Statement;

public class MoviesDetails {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:mulesoftAsst.db");
			System.out.println("Database Connection opened.");
			Statement st=con.createStatement();
			st.executeUpdate("create table moviesDetails(movieName varchar(20),actor varchar(20),actress varchar(20),relesae varchar(10),director varchar(20))");
			System.out.println("Table Created");
			
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('snehithudu','vijay','illeana','2011','Shankar')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('Attarintikidaredi','pspk','samantha','2017','thrivikram')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('KGF','yash','srinidhi','2018','prashanth Neel')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('mirchi','prabhas','anushka','2015','Shiva')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('dangal','Amir khan','wrestler','2020','khan')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('Darling','prabhas','kajal','2012','Unknown')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('RRR','ntr','olivia','2022','rajamouli')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('bajrangi bhai jan','salman','kareena','2014','dev')");
			st.executeUpdate("INSERT INTO moviesDetails (movieName,actor,actress,relesae,director) VALUES ('Vikram','kamal hasasan','swathishta','2022','Lokesh')");
			
			ResultSet rs = st.executeQuery("select * from moviesDetails");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" : " +(rs.getString(2)+" : "+rs.getString(3)+" : "+ rs.getString(4)+" : "+rs.getString(5)));
			}
			
			ResultSet rs2 = st.executeQuery("select * from moviesDetails where actor='prabhas' ");
			
			while(rs2.next()) {
				System.out.println(rs2.getString(1)+" : " +(rs2.getString(2)+" : "+rs2.getString(3)+" : "+ rs2.getString(4)+" : "+rs2.getString(5)));
			}
			
			con.close();
			System.out.println("Connection closed.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}