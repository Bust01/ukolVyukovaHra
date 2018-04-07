package ui;


import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
* 
* @author Bušek Tomáš
*
*/

public class HomeController extends Application {
BorderPane border;
private String slovo = "";	
Label spravnaOdpoved = new Label();
Label spatnaOdpoved = new Label();
Label nazev = new Label();	
Button hadej = new Button();

private int bodySpravne; 
private int bodySpatne;
private int volba;
	
@Override
public void start(Stage primaryStage) throws Exception {
   
 
    border = new BorderPane();
    border.setCenter(hlavniPanel());
    border.setBottom(nastavLabel());
    border.setRight(body());
    Scene scene = new Scene(border, 600,700);

    primaryStage.setTitle("Dìtská hra pro výuku anglického jazyka"); 
    primaryStage.setScene(scene); 
    primaryStage.sizeToScene(); 
    primaryStage.show(); 
}

private HBox nastavLabel(){
     HBox labelPanel = new HBox();
     hadej.setText("Hádej");
     nazev.setText("   Klikni na tlaèítko Hádej pro spuštìní hry.");
     hadej.setOnAction(new EventHandler<ActionEvent>() {
    	 
    	 @Override
         public void handle(ActionEvent event) {
             java.util.Random random = new java.util.Random();
            volba = random.nextInt(6)+1;
           if (volba == 1){
               slovo = "pes";
               nazev.setText(" Dog");
           }              
           if (volba == 2){
               slovo = "dum";
               nazev.setText(" House");
           }               
           if (volba == 3){
               slovo = "slunce";
               nazev.setText(" Sun");
           }              
           if (volba == 4){
               slovo = "postel";
               nazev.setText(" Bed");
           }              
           if (volba == 5){
               slovo = "strom";
               nazev.setText(" Tree");
           }               
           if (volba == 6){
               slovo = "stul";
               nazev.setText(" Table");
           }
         }
       });
             labelPanel.getChildren().addAll(hadej, nazev);
             
             return labelPanel;
        }

private HBox hlavniPanel() {
    HBox mainPanel = new HBox();
    mainPanel.setPrefWidth(200);
    mainPanel.setPrefHeight(200);
    VBox skupina1 = new VBox();
    VBox skupina2 = new VBox();
    
    Image pes = new Image(getClass().getResourceAsStream("/zdroje/dog.jpg"),200 , 200, false, false);
    Button pesButton = new Button("");
    pesButton.setTooltip(new Tooltip("Pes"));
    pesButton.setUserData("Dog");
    pesButton.setGraphic(new ImageView(pes));
    pesButton.setOnAction(new EventHandler<ActionEvent>() {
    	
    @Override public void handle(ActionEvent e) {
    if (slovo == "pes"){
             bodySpravne++; 
             spravnaOdpoved.setText(" Poèet správných odpovìdí: "+ bodySpravne);           
     Alert alert = new Alert(AlertType.CONFIRMATION);
     alert.setHeaderText("Jsi výborný! Uhádl jsi!");
     alert.setContentText("Chceš hádat znovu?");
        
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
            hadej.fire();
    } else {
            nazev.setText("Klikni na tlaèítko hádej.");
    }
    }       
    else {
        bodySpatne++; 
        spatnaOdpoved.setText(" Poèet špatných odpovìdí: "+ bodySpatne);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Tohle se nepovedlo.");
        alert.setContentText("Zkus to ještì jednou.");
        alert.showAndWait();
    }}
    });
    

    Image dum = new Image(getClass().getResourceAsStream("/zdroje/house.jpg"),200 , 200, false, false);
    Button dumButton = new Button("");
    dumButton.setTooltip(new Tooltip("Dùm"));
    dumButton.setUserData("House");
    dumButton.setGraphic(new ImageView(dum));
    
    dumButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    if (slovo == "dum"){
                 bodySpravne++; 
                 spravnaOdpoved.setText(" Poèet správných odpovìdí: "+ bodySpravne);           
     Alert alert = new Alert(AlertType.CONFIRMATION);
     alert.setHeaderText("Jsi výborný! Uhádl jsi!");
     alert.setContentText("Chceš hádat znovu?");
        
         Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
            hadej.fire();
    } else {
            nazev.setText("Klikni na tlaèítko hádej.");
    }
    }
    
    else {
    	 bodySpatne++; 
         spatnaOdpoved.setText(" Poèet špatných odpovìdí: "+ bodySpatne);
         Alert alert = new Alert(AlertType.CONFIRMATION);
         alert.setHeaderText("Tohle se nepovedlo.");
         alert.setContentText("Zkus to ještì jednou.");
         alert.showAndWait();
    }}
    });
    
    Image slunce = new Image(getClass().getResourceAsStream("/zdroje/sun.jpg"),200 , 200, false, false);
    Button slunceButton = new Button("");
    slunceButton.setTooltip(new Tooltip("Slunce"));
    slunceButton.setUserData("Sun");
    slunceButton.setGraphic(new ImageView(slunce));
    
    slunceButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    if (slovo == "slunce"){
    			bodySpravne++; 
    			spravnaOdpoved.setText(" Poèet správných odpovìdí: "+ bodySpravne);           
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setHeaderText("Jsi výborný! Uhádl jsi!");
    		alert.setContentText("Chceš hádat znovu?");
        
         Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            hadej.fire();
    } else {
            nazev.setText("Klikni na tlaèítko hádej.");
    }
    }
    
    else {
    	bodySpatne++; 
        spatnaOdpoved.setText(" Poèet špatných odpovìdí: "+ bodySpatne);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Tohle se nepovedlo.");
        alert.setContentText("Zkus to ještì jednou.");
        alert.showAndWait();
    }}
    });
    

    Image postel = new Image(getClass().getResourceAsStream("/zdroje/bed.jpg"),200 , 200, false, false);
    Button postelButton = new Button("");
    postelButton.setTooltip(new Tooltip("Postel"));
    postelButton.setUserData("Bed");
    postelButton.setGraphic(new ImageView(postel));
    
    postelButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    if (slovo == "postel"){
    	bodySpravne++; 
		spravnaOdpoved.setText(" Poèet správných odpovìdí: "+ bodySpravne);           
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setHeaderText("Jsi výborný! Uhádl jsi!");
	alert.setContentText("Chceš hádat znovu?");
        
         Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            hadej.fire();
    } else {
            nazev.setText("Klikni na tlaèítko hádej.");
    }
    }
    
    else {
    	bodySpatne++; 
        spatnaOdpoved.setText(" Poèet špatných odpovìdí: "+ bodySpatne);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Tohle se nepovedlo.");
        alert.setContentText("Zkus to ještì jednou.");
        alert.showAndWait();
    }}
    });
    
    Image strom = new Image(getClass().getResourceAsStream("/zdroje/tree.jpg"),200 , 200, false, false);
    Button stromButton = new Button("");
    stromButton.setTooltip(new Tooltip("Strom"));
    stromButton.setUserData("Tree");
    stromButton.setGraphic(new ImageView(strom));
    
    stromButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    if (slovo == "strom"){
    	bodySpravne++; 
		spravnaOdpoved.setText(" Poèet správných odpovìdí: "+ bodySpravne);           
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setHeaderText("Jsi výborný! Uhádl jsi!");
	alert.setContentText("Chceš hádat znovu?");
        
         Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
            hadej.fire();
    } else {
            nazev.setText("Klikni na tlaèítko hádej.");
    }
    }
    
    else {
    	bodySpatne++; 
        spatnaOdpoved.setText(" Poèet špatných odpovìdí: "+ bodySpatne);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Tohle se nepovedlo.");
        alert.setContentText("Zkus to ještì jednou.");
        alert.showAndWait();
    }}
    });
    
    Image stul = new Image(getClass().getResourceAsStream("/zdroje/table.jpg"),200 , 200, false, false);
    Button stulButton = new Button("");
    stulButton.setTooltip(new Tooltip("Stùl"));
    stulButton.setUserData("Table");
    stulButton.setGraphic(new ImageView(stul));
    
    stulButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    if (slovo == "stul"){
    	bodySpravne++; 
		spravnaOdpoved.setText(" Poèet správných odpovìdí: "+ bodySpravne);           
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setHeaderText("Jsi výborný! Uhádl jsi!");
	alert.setContentText("Chceš hádat znovu?");
        
         Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
            hadej.fire();
    } else {
            nazev.setText("Klikni na tlaèítko hádej.");
    }
    }
    
    else {
    	bodySpatne++; 
        spatnaOdpoved.setText(" Poèet špatných odpovìdí: "+ bodySpatne);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Tohle se nepovedlo.");
        alert.setContentText("Zkus to ještì jednou.");
        alert.showAndWait();
    }}
    });
    
  skupina1.getChildren().addAll(pesButton, dumButton, stromButton);
  skupina2.getChildren().addAll(slunceButton, postelButton, stulButton);
  mainPanel.getChildren().addAll(skupina1, skupina2); 
  return mainPanel;
}


public HBox body(){
    HBox bodyPanel = new HBox();
    VBox sloupec = new VBox();
    spravnaOdpoved.setText(" Správné Odpovìdi: "+ bodySpravne);
    spatnaOdpoved.setText(" Špatné Odpovìdi: "+ bodySpatne);
    
    sloupec.getChildren().addAll(spravnaOdpoved, spatnaOdpoved);
    bodyPanel.getChildren().add(sloupec);
    return bodyPanel;
}
public static void main(String[] args) {
   launch(args);
}

}
    
    


	
        
	
	