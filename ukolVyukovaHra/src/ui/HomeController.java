package ui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Bu�ek Tom�
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

        primaryStage.setTitle("D�tsk� hra pro v�uku anglick�ho jazyka"); 
        primaryStage.setScene(scene); 
        primaryStage.sizeToScene(); 
        primaryStage.show(); 
    }
	
	private HBox nastavLabel(){
         HBox labelPanel = new HBox();
         hadej.setText("H�dej");
         nazev.setText("   Klikni na tla��tko H�dej pro spu�t�n� hry.");              
                 return labelPanel;
            }
	
	private HBox hlavniPanel() {
        HBox mainPanel = new HBox();
        mainPanel.setPrefWidth(200);
        mainPanel.setPrefHeight(200);
      return mainPanel;
    }
	
	
	public HBox body(){
        HBox bodyPanel = new HBox();
        VBox sloupec = new VBox();
        spravnaOdpoved.setText(" Spr�vn� Odpov�di: "+ bodySpravne);
        spatnaOdpoved.setText(" �patn� Odpov�di: "+ bodySpatne);
        
        sloupec.getChildren().addAll(spravnaOdpoved, spatnaOdpoved);
        bodyPanel.getChildren().add(sloupec);
        return bodyPanel;
    }
    public static void main(String[] args) {
       launch(args);
   }
	
}
        
        
	
	
        
	
	