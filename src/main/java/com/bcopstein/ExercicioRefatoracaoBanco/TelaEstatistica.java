package com.bcopstein.ExercicioRefatoracaoBanco;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
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
import javafx.scene.control.Labeled;
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
	private LogicaOperacoes logicaop;
	
	public TelaEstatistica(Stage mainStage, Scene cenaOperacoes, LogicaOperacoes logicaop) {
		this.mainStage = mainStage;
		this.cenaOperacoes = cenaOperacoes;
		this.logicaop = logicaop;
	}
	
	public Scene getTelaEstatistica() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        String dadosCorr = logicaop.getNumeroConta()+" : "+logicaop.getCorrentistaConta();
        Text scenetitle = new Text(dadosCorr);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        String categoria = "Categoria: "+ logicaop.getStrStatusConta();
        
        Label cat = new Label(categoria);
        grid.add(cat, 0, 1);
     
        // implementar observer para alterar variavel na tela
        ChoiceBox<String> selecaoMes = new ChoiceBox(FXCollections.observableArrayList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"));

        int intEscolhaMes = logicaop.getOperacoes().get(logicaop.getOperacoes().size()-1).getMes();
        String escolhaMes = null;
        switch(intEscolhaMes) {
        	case 1:
        		escolhaMes = "Janeiro";
        		break;
        	case 2:
        		escolhaMes = "Fevereiro";
        		break;
        	case 3:
        		escolhaMes = "Março";
        		break;
        	case 4:
        		escolhaMes = "Abril";
        		break;
        	case 5:
        		escolhaMes = "Maio";
        		break;
        	case 6:
        		escolhaMes = "Junho";
        		break;
        	case 7:
        		escolhaMes = "Julho";
        		break;
        	case 8:
        		escolhaMes = "Agosto";
        		break;
        	case 9:
        		escolhaMes = "Setembro";
        		break;
        	case 10:
        		escolhaMes = "Outubro";
        		break;
        	case 11:
        		escolhaMes = "Novembro";
        		break;
        	case 12:
        		escolhaMes = "Dezembro";
        		break;
        	default:
        		break;
        }
        selecaoMes.setValue(escolhaMes);
        Label mesEstatistica = new Label("Mês :  " + escolhaMes);
        Label saldoMedio = new Label();
        saldoMedio(escolhaMes,saldoMedio);
		//Listen for selection changes
        selecaoMes.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) ->  printMes(newValue,mesEstatistica,saldoMedio));
        
        grid.add(mesEstatistica, 0,2);
        grid.add(saldoMedio, 0, 3);
        	
        
       
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
	
	public void printMes(String mes,Label l,Label ls) {
		l.setText("Mês :  " + mes);
		saldoMedio(mes,ls);
	}
	
	public void saldoMedio(String mes,Label ls) {
		int intMes = 0;
		switch(mes) {
    	case "Janeiro":
    		intMes = 1;
    		break;
    	case "Fevereiro":
    		intMes = 2;
    		break;
    	case "Março":
    		intMes = 3;
    		break;
    	case "Abril":
    		intMes = 4;
    		break;
    	case "Maio":
    		intMes = 5;
    		break;
    	case "Junho":
    		intMes = 6;
    		break;
    	case "Julho":
    		intMes = 7;
    		break;
    	case "Agosto":
    		intMes = 8;
    		break;
    	case "Setembro":
    		intMes = 9;
    		break;
    	case "Outubro":
    		intMes = 10;
    		break;
    	case "Novembro":
    		intMes = 11;
    		break;
    	case "Dezembro":
    		intMes = 12;
    		break;
    	default:
    		break;
    }	
		
		ls.setText("Saldo Médio: " + logicaop.saldoMedio(intMes));
	}
}
