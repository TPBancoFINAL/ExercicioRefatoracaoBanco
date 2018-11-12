package com.bcopstein.ExercicioRefatoracaoBanco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaEstatistica {
	private Stage mainStage; 
	private Scene cenaOperacoes;
	private Scene cenaEstatistica;
	private Conta conta;
	private List<Operacao> listaOperacoes;
	public TelaEstatistica(Stage mainStage, Scene cenaOperacoes, Conta conta,List<Operacao> listaOperacoes) {
		this.mainStage = mainStage;
		this.cenaOperacoes = cenaOperacoes;
		this.conta = conta;
		this.listaOperacoes = listaOperacoes;
	}
	
	public Scene getTelaEstatistica() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        String dadosCorr = conta.getNumero()+" : "+conta.getCorrentista();
        Text scenetitle = new Text(dadosCorr);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        String categoria = "Categoria: "+conta.getStrStatus();
        
        Label cat = new Label(categoria);
        grid.add(cat, 0, 1);
        
        ChoiceBox selecaoMes = new ChoiceBox();
        for(Operacao op: listaOperacoes) {
        	if(op.getMes() == (Integer)selecaoMes.getValue()){
        		String choice = null;
        		switch(op.getMes()) {
        		case 1:
        			choice = "Janeiro";
        			break;
        		case 2:
        			choice = "Fevereiro";
        			break;
        		case 3:
        			choice = "Março";
        			break;
        		case 4:
        			choice = "Abril";
        			break;
        		case 5:
        			choice = "Maio";
        			break;
        		case 6:
        			choice = "Junho";
        			break;
        		case 7:
        			choice = "Julho";
        			break;
        		case 8:
        			choice = "Agosto";
        			break;
        		case 9:
        			choice = "Setembro";
        			break;
        		case 10:
        			choice = "Outubro";
        			break;
        		case 11:
        			choice = "Novembro";
        			break;
        		case 12:
        			choice = "Dezembro";
        			break;
        		default:
        			break;
        		}
        		selecaoMes.getItems().add(choice);
        		
        	}
        	
        }
        
        HBox hBoxMes = new HBox(selecaoMes);
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.TOP_CENTER);
        hbBtn.getChildren().add(selecaoMes);
        
        Button btnVoltar = new Button("Voltar");
        hbBtn.getChildren().add(btnVoltar);
        grid.add(hbBtn, 1, 2);
        
        btnVoltar.setOnAction(e->{
        	mainStage.setScene(cenaOperacoes);
        });
        
        cenaEstatistica = new Scene(grid);
        return cenaEstatistica;

        
	}

}
