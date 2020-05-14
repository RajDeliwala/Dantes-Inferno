package application;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.*;

import javax.imageio.ImageIO;

import java.io.*;
//import javax.imageio.ImageIO;

public class DatabasePull 
{
	
	//Connecting to Database
	private String databaseURL;
	
	
	// Scene Table
	private String routeTableName;
	
	private String sceneColumnName;
	private int sceneID;
	
	private String textColumnName;
	private String sceneText;
	
	private String backgroundColumnName;
	private URL backgroundURL;
	private BufferedImage background;
	
	private String leftCharacterColumnName;
	private URL LeftCharacterURL;
	private BufferedImage leftCharacter;
	
	private String rightCharacterColumnName;
	private URL rightCharacterURL;
	private BufferedImage rightCharacter;
	
	private String choiceColumnName;
	private int choice;
	
	
	//Save Table
	private String saveTableName;
	
	private String userColumnName;
	private String user;
	
	private String passwordColumnName;
	private String password;
	
	private String sceneIDColumnName;
	private int saveSceneID;
	
	private String saveSceneTableName;
	private String saveSceneTable;
	private Connection con;
	
		
	//private int PrimaryKey1;
	//private BufferedImage img;
	//private String TextIn;
	//private URL myURL;
	//private String tableName;
	//private String tablePrimary1;
	//private String tableText;
	//private String tableImage;
	//private String usertable;
	//private String userName;
	//private String password;
	
	
	//Setters and Getters HAVE FUN
	public String getDatabaseURL() {
		return databaseURL;
	}
	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}
	public String getRouteTableName() {
		return routeTableName;
	}
	public void setRouteTableName(String routeTableName) {
		this.routeTableName = routeTableName;
	}
	public String getSceneColumnName() {
		return sceneColumnName;
	}
	public void setSceneColumnName(String sceneColumnName) {
		this.sceneColumnName = sceneColumnName;
	}
	public int getSceneID() {
		return sceneID;
	}
	public void setSceneID(int sceneID) {
		this.sceneID = sceneID;
	}
	public String getTextColumnName() {
		return textColumnName;
	}
	public void setTextColumnName(String textColumnName) {
		this.textColumnName = textColumnName;
	}
	public String getSceneText() {
		return sceneText;
	}
	public void setSceneText(String sceneText) {
		this.sceneText = sceneText;
	}
	public String getBackgroundColumnName() {
		return backgroundColumnName;
	}
	public void setBackgroundColumnName(String backgroundColumnName) {
		this.backgroundColumnName = backgroundColumnName;
	}
	public URL getBackgroundURL() {
		return backgroundURL;
	}
	public void setBackgroundURL(URL backgroundURL) {
		this.backgroundURL = backgroundURL;
	}
	public BufferedImage getBackground() {
		return background;
	}
	public void setBackground(BufferedImage background) {
		this.background = background;
	}
	public String getLeftCharacterColumnName() {
		return leftCharacterColumnName;
	}
	public void setLeftCharacterColumnName(String leftCharacterColumnName) {
		this.leftCharacterColumnName = leftCharacterColumnName;
	}
	public URL getLeftCharacterURL() {
		return LeftCharacterURL;
	}
	public void setLeftCharacterURL(URL leftCharacterURL) {
		LeftCharacterURL = leftCharacterURL;
	}
	public BufferedImage getLeftCharacter() {
		return leftCharacter;
	}
	public void setLeftCharacter(BufferedImage leftCharacter) {
		this.leftCharacter = leftCharacter;
	}
	public String getRightCharacterColumnName() {
		return rightCharacterColumnName;
	}
	public void setRightCharacterColumnName(String rightCharacterColumnName) {
		this.rightCharacterColumnName = rightCharacterColumnName;
	}
	public URL getRightCharacterURL() {
		return rightCharacterURL;
	}
	public void setRightCharacterURL(URL rightCharacterURL) {
		this.rightCharacterURL = rightCharacterURL;
	}
	public BufferedImage getRightCharacter() {
		return rightCharacter;
	}
	public void setRightCharacter(BufferedImage rightCharacter) {
		this.rightCharacter = rightCharacter;
	}
	public String getChoiceColumnName() {
		return choiceColumnName;
	}
	public void setChoiceColumnName(String choiceColumnName) {
		this.choiceColumnName = choiceColumnName;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public String getSaveTableName() {
		return saveTableName;
	}
	public void setSaveTableName(String saveTableName) {
		this.saveTableName = saveTableName;
	}
	public String getUserColumnName() {
		return userColumnName;
	}
	public void setUserColumnName(String userColumnName) {
		this.userColumnName = userColumnName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswordColumnName() {
		return passwordColumnName;
	}
	public void setPasswordColumnName(String passwordColumnName) {
		this.passwordColumnName = passwordColumnName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSceneIDColumnName() {
		return sceneIDColumnName;
	}
	public void setSceneIDColumnName(String sceneIDColumnName) {
		this.sceneIDColumnName = sceneIDColumnName;
	}
	public int getSaveSceneID() {
		return saveSceneID;
	}
	public void setSaveSceneID(int saveSceneID) {
		this.saveSceneID = saveSceneID;
	}
	public String getSaveSceneTableName() {
		return saveSceneTableName;
	}
	public void setSaveSceneTableName(String saveSceneTableName) {
		this.saveSceneTableName = saveSceneTableName;
	}
	public String getSaveSceneTable() {
		return saveSceneTable;
	}
	public void setSaveSceneTable(String saveSceneTable) {
		this.saveSceneTable = saveSceneTable;
	}

	//sets up the connection
	public void setConnection() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://mysql5.gear.host:3306/seniorprojectdb","seniorprojectdb","Vi0Js-as~v7b");
		} catch(SQLException e) {
			System.out.println(e);
		}
		
	}
	
	//Advance the place in the database
	public void nextScene() {
		sceneID = sceneID +1;
	}

	public void priorScene() {
		sceneID = sceneID -1;
	}
	
	public void loadImages() {
		try {
			background = ImageIO.read(backgroundURL);
			System.out.println("Background loaded");
			//leftCharacter = ImageIO.read(LeftCharacterURL);
			//rightCharacter = ImageIO.read(rightCharacterURL);
		}catch(IOException e) {
			System.out.println(e);
		}
		
		
	}
	
	//Loads a scene using an already determined scene ID. Its finished. :)
	public void loadScene()
	{
		try
		{

			//Connection con=DriverManager.getConnection("jdbc:mysql://mysql5.gear.host:3306/seniorprojectdb","seniorprojectdb","Vi0Js-as~v7b");   
			String query = "SELECT * FROM " + routeTableName + " WHERE " + sceneColumnName + " = " + sceneID;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				sceneID = rs.getInt(sceneColumnName);
				sceneText = rs.getString(textColumnName);
				backgroundURL = rs.getURL(backgroundColumnName);
				LeftCharacterURL = rs.getURL(leftCharacterColumnName);
				rightCharacterURL = rs.getURL(rightCharacterColumnName);
				choice = rs.getInt(choiceColumnName);
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//Loads what scene a specific player is on.
	public void loadPlayer() {
		
		
		try
		{

			//Connection con=DriverManager.getConnection("jdbc:mysql://mysql5.gear.host:3306/seniorprojectdb","seniorprojectdb","Vi0Js-as~v7b");   
			//String loadPlayer = "SELECT sceneID, storyPath FROM playersave WHERE playerName = 'admin' AND password = 'password';";
			//String loadPlayer = "SELECT " + sceneIDColumnName + " , " + saveSceneTableName + " FROM " + saveTableName + " WHERE " + userColumnName + " = " + user + " AND " + passwordColumnName + " = " + password + ";";
			String loadPlayer = "SELECT sceneID, storyPath FROM playersave WHERE playerName = ' "+ user +"' AND password = '"+ password +"';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(loadPlayer);
			while(rs.next())
			{
				sceneID = rs.getInt(sceneIDColumnName);
				routeTableName = rs.getString(saveSceneTableName);
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
		
	}
	
	//Save the fame for a specific player. It is now done :)
	public void save()
	{
		try 
		{

			
			//Connection con=DriverManager.getConnection("jdbc:mysql://mysql5.gear.host:3306/seniorprojectdb","seniorprojectdb","Vi0Js-as~v7b"); 
			String saveGame = "UPDATE" + saveTableName 
					+ " SET " + sceneIDColumnName + " = '" + sceneID + "' , " + saveSceneTableName + " = '" + routeTableName
					+ "' WHERE " + userColumnName + " = " + user + " , " + passwordColumnName + " = " + password +";";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(saveGame);				
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//creates a new player if the player's name or password isn't already taken.
	public void createPlayer(){
		try {
		String userCheck = "";
		String passCheck = "";
		//Establish connection to the database but will be replaced with a function
		//DatabasePull.forCreate("com.mysql.jdbc.Driver");
		//Connection con = DriverManager.getConnection("jdbc:mysql://mysql5.gear.host:3306/seniorprojectdb","seniorprojectdb","Vi0js-as~v7b");
		Statement stmt = con.createStatement();
		
		String checkPlayer = "SELECT " + userColumnName + ", " + passwordColumnName +   
				" FROM "+ saveTableName + 
				" WHERE " + userColumnName + " = " + user + "  AND " + passwordColumnName + "  = " + password + ";"; 
		ResultSet rs = stmt.executeQuery(checkPlayer);
		while(rs.next())
		{
			userCheck = rs.getString(userColumnName); 
			passCheck = rs.getString(passwordColumnName);
		}
		if(userCheck != user || passCheck != password)
		{
			String createPlayer = "INSERT INTO " + saveTableName + "VALUES (" + user + ", " + password + ", " + saveSceneID + saveSceneTable +");";
			 rs = stmt.executeQuery(createPlayer);
		}
		

	
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}

