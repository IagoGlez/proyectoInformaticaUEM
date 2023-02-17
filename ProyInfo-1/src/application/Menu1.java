package application;
import control.Sistema;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Menu1 {
	static boolean b =true;//Este boolean lo uso para varios checks a la hora de pulsar botones.
	
	
    
    public static void show() {
    	Stage window;
    	window = new Stage();
        // tdexto perfil cargado  	
    	VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Cargue un perfil.");
        if (!Sistema.checkJug()) {
        	label.setText("Bienvenido "+Sistema.getJug().getNombre());
        }
        
        Button play = new Button("Jugar.");
        play.setOnAction(event -> {
        	/*Boolean t = true;
        	t=Sistema.checkJug(b);*/
        	if(Sistema.checkJug()) {
        		System.out.println("Juego NO se inicia.");
        		Stage window2;
            	window2 = new Stage();
                window2.setTitle("Error");
                window2.initModality(Modality.APPLICATION_MODAL);
                
                Button aceptar2 = new Button("Aceptar.");
                aceptar2.setOnAction(even -> {
                	window2.close();
                
                });
                Label label2 = new Label("Es necesario cargar primero un Perfil.");
                
                
                
                VBox root2 = new VBox();
                root2.setPadding(new Insets(10, 10, 10, 10));
                root2.setSpacing(10);
                root2.getChildren().addAll(label2,aceptar2);
                Scene scene2= new Scene(root2, 300, 250);
                
                window2.setScene(scene2);
                window2.show();
        	
        	}
        	else {
        		System.out.println("Juego se inicia."+b);
        		MenuJ.display();
        		window.close();
        	}
        	//window.close();
        
        });
        
        Button logout = new Button("Finalizar Sesión");
        logout.setOnAction(event -> {
        	/*Boolean t = true;
        	t=Sistema.checkJug(b);*/
        	if(!Sistema.checkJug()) {//Si tenemos un perfil cargado, lo devolvemos la vector.
        		Sistema.devolverPerfil();
        		System.out.println("PERFIL GUARDADO");
        	}
        	
        	Sistema.guardarVectores();//Guardamos el vector en un .txt.
        	window.close();
        
        });
        
        Button cargarPerfil = new Button("Cargar/Guardar Perfil");
       
        cargarPerfil.setOnAction(event -> {
        	MenuP.display();
        	window.close();
        
        });
        
        
        Button comparar = new Button("Puntuaciones.");
        comparar.setOnAction(event -> {
        	window.close();
        	Label tabla = new Label();
        	Stage window2;
        	window2 = new Stage();
            window2.setTitle("Puntuaciones.");
            Button volver2 = new Button("Volver.");
            volver2.setOnAction(even->{
            	window2.close();
            	Menu1.show();
            });
            Button ppt = new Button("PPT.");
            ppt.setOnAction(even->{
            	
            	tabla.setText(Sistema.ordenar(0));
            	
            
            });
            Button minas = new Button("Buscaminas.");
            minas.setOnAction(even->{
            	
            	tabla.setText(Sistema.ordenar(1));
            	
            
            });
            Button pong = new Button("Pong.");
            pong.setOnAction(even->{
            	
            	tabla.setText(Sistema.ordenar(2));
            	
            
            });
            
            VBox root2 = new VBox();
            root2.setPadding(new Insets(10, 10, 10, 10));
            root2.setSpacing(10);
            root2.getChildren().addAll(ppt,minas,pong,tabla,volver2);
            Scene scene2= new Scene(root2, 300, 250);
            
            window2.setScene(scene2);
            window2.show();	
        
        
        });
        
   
        
        root.getChildren().addAll(label,play, cargarPerfil,comparar,logout );

        Scene scene = new Scene(root, 300, 250);

        window.setTitle("Menú Inicial.");
        window.setScene(scene);
        window.show();
    }

   
}