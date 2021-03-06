package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaOperacoes {
	private Stage mainStage; 
	private Scene cenaEntrada;
	private Scene cenaOperacoes;
	
	private ObservableList<Operacao> operacoesConta;

	private LogicaOperacoes logicaop;
	private TextField tfValorOperacao;
	private TextField tfSaldo;
	//tirar contaAtual
	public TelaOperacoes(Stage mainStage, Scene telaEntrada, LogicaOperacoes logicaop) { 																				// conta
		this.mainStage = mainStage;
		this.cenaEntrada = telaEntrada;
		this.logicaop = logicaop;
	}

	public Scene getTelaOperacoes() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        String dadosCorr = logicaop.getNumeroConta() + " : " + logicaop.getCorrentistaConta();
        Text scenetitle = new Text(dadosCorr);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        		//ATÉ AQUI OK
        
        // implementar observer para alterar variavel na tela
        ObservableList<String> statusConta = FXCollections.observableArrayList(logicaop.getStrStatusConta());
        String categoria = ("Categoria: "+statusConta);
        String limRetDiaria = "Limite retirada diaria: "+ logicaop.getLimRetiradaDiariaConta();
        
        Label cat = new Label(categoria);
        grid.add(cat, 0, 1);

        Label lim = new Label(limRetDiaria);
        grid.add(lim, 0, 2);
        
        Label tit = new Label("Ultimos movimentos");
        grid.add(tit,0,3);

        // Seleciona apenas o extrato da conta atual
        operacoesConta = 
        		FXCollections.observableArrayList(
        				logicaop.getOperacoes()
        				.stream()
        				.filter(op -> op.getNumeroConta() == this.logicaop.getNumeroConta())
        				.collect(Collectors.toList())
        				);
        
        ListView<Operacao> extrato = new ListView<>(operacoesConta);
        extrato.setPrefHeight(140);
        grid.add(extrato, 0, 4);

        tfSaldo = new TextField();
        tfSaldo.setDisable(true);
        tfSaldo.setText(""+logicaop.getSaldoConta());
        HBox valSaldo = new HBox(20);        
        valSaldo.setAlignment(Pos.BOTTOM_LEFT);
        valSaldo.getChildren().add(new Label("Saldo"));
        valSaldo.getChildren().add(tfSaldo);
        grid.add(valSaldo, 0, 5);        

        tfValorOperacao = new TextField();
        HBox valOper = new HBox(30);        
        valOper.setAlignment(Pos.BOTTOM_CENTER);
        valOper.getChildren().add(new Label("Valor operacao"));
        valOper.getChildren().add(tfValorOperacao);
        grid.add(valOper, 1, 1);        

        Button btnCredito = new Button("Credito");
        Button btnDebito = new Button("Debito");
        Button btnVoltar = new Button("Voltar");
        Button btnEstatistica = new Button("Tela Estatística");
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.TOP_CENTER);
        hbBtn.getChildren().add(btnCredito);
        hbBtn.getChildren().add(btnDebito);
        hbBtn.getChildren().add(btnEstatistica);
        hbBtn.getChildren().add(btnVoltar);
        grid.add(hbBtn, 1, 2);
        
        btnCredito.setOnAction(e->{
        	try {
        	  double valor = Integer.parseInt(tfValorOperacao.getText());
        	  if (valor < 0.0) {
        		  throw new NumberFormatException("Valor invalido");
        	  }
        	  logicaop.deposito(valor);
        	  GregorianCalendar date = new GregorianCalendar();
        	  Operacao op = new Operacao(
        			  date.get(GregorianCalendar.DAY_OF_MONTH),
        			  date.get(GregorianCalendar.MONTH+1),
        			  date.get(GregorianCalendar.YEAR),
        			  date.get(GregorianCalendar.HOUR),
        			  date.get(GregorianCalendar.MINUTE),
        			  date.get(GregorianCalendar.SECOND),
        			  logicaop.getNumeroConta(),
        			  logicaop.getStatusConta(),
        			  valor,
        			  0);
              logicaop.addOperacao(
        			  date.get(GregorianCalendar.DAY_OF_MONTH),
        			  date.get(GregorianCalendar.MONTH+1),
        			  date.get(GregorianCalendar.YEAR),
        			  date.get(GregorianCalendar.HOUR),
        			  date.get(GregorianCalendar.MINUTE),
        			  date.get(GregorianCalendar.SECOND),
        			  logicaop.getNumeroConta(),
        			  logicaop.getStatusConta(),
        			  valor,
        			  0);        	  
        	  tfSaldo.setText(""+logicaop.getSaldoConta());
        	  operacoesConta.add(op);
        	  //Alteracao nas contas
        	  if(logicaop.getStatusConta() == 0) {cat.setText("Categoria: SILVER");}
        	  if(logicaop.getStatusConta() == 1) {cat.setText("Categoria: GOLD");}
        	  if(logicaop.getStatusConta() == 2) {cat.setText("Categoria: PLATINUM");}
        	  
        	  cat.setText("Categoria: "+logicaop.getStatusConta());
        	}catch(NumberFormatException ex) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Valor inválido !!");
				alert.setHeaderText(null);
				alert.setContentText("Valor inválido para operacao de crédito!!");

				alert.showAndWait();
        	}        	
        });
        
        btnDebito.setOnAction(e->{
        	try {
          	  double valor = Integer.parseInt(tfValorOperacao.getText());
          	  if (valor < 0.0 || valor > logicaop.getSaldoConta()) {
          		  throw new NumberFormatException("Saldo insuficiente");
          	  }
          	  logicaop.retirada(valor);
        	  GregorianCalendar date = new GregorianCalendar();
        	  Operacao op = new Operacao(
        			  date.get(GregorianCalendar.DAY_OF_MONTH),
        			  date.get(GregorianCalendar.MONTH+1),
        			  date.get(GregorianCalendar.YEAR),
        			  date.get(GregorianCalendar.HOUR),
        			  date.get(GregorianCalendar.MINUTE),
        			  date.get(GregorianCalendar.SECOND),
        			  logicaop.getNumeroConta(),
        			  logicaop.getStatusConta(),
        			  valor,
        			  1);
        	  // Esta adicionando em duas listas (resolver na camada de negocio)
              logicaop.addOperacao(
        			  date.get(GregorianCalendar.DAY_OF_MONTH),
        			  date.get(GregorianCalendar.MONTH+1),
        			  date.get(GregorianCalendar.YEAR),
        			  date.get(GregorianCalendar.HOUR),
        			  date.get(GregorianCalendar.MINUTE),
        			  date.get(GregorianCalendar.SECOND),
        			  logicaop.getNumeroConta(),
        			  logicaop.getStatusConta(),
        			  valor,
        			  1);       	  
        	  tfSaldo.setText(""+logicaop.getSaldoConta());
        	  operacoesConta.add(op);
          	  tfSaldo.setText(""+logicaop.getSaldoConta());
          	}catch(NumberFormatException ex) {
  				Alert alert = new Alert(AlertType.WARNING);
  				alert.setTitle("Valor inválido !!");
  				alert.setHeaderText(null);
  				alert.setContentText("Valor inválido para operacao de débito!");

  				alert.showAndWait();
          	}        	
        });

        btnVoltar.setOnAction(e->{
        	mainStage.setScene(cenaEntrada);
        });
        btnEstatistica.setOnAction(e->{
        	TelaEstatistica te = new TelaEstatistica(mainStage,cenaOperacoes,logicaop);
        	Scene scene = te.getTelaEstatistica();
        	mainStage.setScene(scene);
        	

        });
        cenaOperacoes = new Scene(grid);
        return cenaOperacoes;
	}

}
