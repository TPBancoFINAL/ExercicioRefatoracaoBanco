package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class App extends Application {
	private LogicaOperacoes logicaop = LogicaOperacoes.InstanceOf();
	private TelaEntrada telaEntrada;
	private Persistencia persistencia;
	
    @Override
    public void start(Stage primaryStage) {    	
    	
    	primaryStage.setTitle("$$ Banco NOSSA GRANA $$");

    	telaEntrada = new TelaEntrada(primaryStage, logicaop); 
        primaryStage.setScene(telaEntrada.getTelaEntrada());
        primaryStage.show();
    }
    
    @Override
    public void stop() {
    	//mudar 
        persistencia.saveContas(logicaop.getContas().values());
        persistencia.saveOperacoes(logicaop.getOperacoes());
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

