package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;

import java.awt.image.*;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import application.DatabasePull;


public class uiController {
	
	DatabasePull datastuff = new DatabasePull();
	
	
	@FXML
	private Button scrollDown;
	
	@FXML
	private void handleScrollDown(ActionEvent event){
		//pulls next dialog entry from the database and post into dialogText
		
		datastuff.nextScene();
		datastuff.loadScene();
		postNewText(datastuff.getSceneText());
		updateBackGround();
	}
	
	
	@FXML
	private Button scrollUp;
	
	@FXML
	private void handleScrollUp(ActionEvent event){
		//pulls previous dialog entry from the database and post into dialogText
		datastuff.priorScene();
		datastuff.loadScene();
		postNewText(datastuff.getSceneText());
	}
	
	
	@FXML
	private TextArea dialogText;
	
	@FXML
	private void postNewText(String newDialog){
		//newDialog will come from scrollUp/Down button calls
		dialogText.setText(newDialog);
	}
	
	@FXML
	private ImageView backgroundIMG;
	
	@FXML
	private void updateBackGround(){
		datastuff.loadImages();
		Image bg = SwingFXUtils.toFXImage(datastuff.getBackground(), null);
		backgroundIMG.setImage(bg);
	}
	
	@FXML
	private ImageView characterLeft;
	
	@FXML
	private ImageView characterRight;
	
	
	//ESC Menu code BEGIN
	@FXML 
	private AnchorPane inGameMenu;
	
	@FXML 
	private void handleEscPress(KeyEvent event){
		if (event.getCode() == KeyCode.ESCAPE){
			if (inGameMenu.isVisible() == true){
				inGameMenu.setVisible(false);
			}
			else{
				inGameMenu.setVisible(true);
			}
			
		}
	}
	
	
	@FXML
	private Button resumeGame;
	
	@FXML
	private void handleResumeClick(ActionEvent event){
		inGameMenu.setVisible(false);
	}


	@FXML
	private Button quitGame;
	
	@FXML
	private void handleQuitClick(ActionEvent event){
		System.exit(0);
	}
	
	
	@FXML
	private Button saveGame;
	
	@FXML
	private void handleSaveClick(ActionEvent event){
		datastuff.setConnection();
		
		
	}
	
	
	@FXML
	private Button loadGame;
	
	@FXML
	private void handleLoadClick(ActionEvent event){
		//datastuff.setConnection();
		
		
	}
	
	@FXML
	private Button createAccount;
	
	@FXML
	private void handleCreateClick(ActionEvent event){
		datastuff.setConnection();
		
	}
	
	@FXML
	private Button login;
	
	@FXML private void handleLoginClick(ActionEvent event){
		datastuff.setConnection();
		//for the save table
		datastuff.setSaveTableName("playersave");
		datastuff.setUserColumnName("playerName");
		datastuff.setPasswordColumnName("password");
		datastuff.setSceneIDColumnName("sceneID");
		datastuff.setSaveSceneTableName("storyPath");
		  
		  //for the scene table
		datastuff.setRouteTableName("path1");
		datastuff.setSceneColumnName("sceneID");
		datastuff.setTextColumnName("text");
		datastuff.setBackgroundColumnName("backgroundURL");
		datastuff.setLeftCharacterColumnName("characterLeftURL");
		datastuff.setRightCharacterColumnName("characterRightURL");
	    datastuff.setChoiceColumnName("isChoice");
		datastuff.setUser(accountName.getText());
		datastuff.setPassword(password.getText());
		datastuff.loadPlayer();
		datastuff.loadScene();
		postNewText(datastuff.getSceneText());
	}
	
	@FXML
	private PasswordField accountName;
	
	@FXML
	private PasswordField password;
	//ESC Menu code END
	
		
	
	
	
}
