package br.ufrpe.GUI.model;

import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.ArrayList;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.PetCare;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PetCareController {
	@FXML
	private TableView<Produto> servicosTable;
	@FXML
	private TableColumn<Produto, String> nomeCol;
	@FXML
	private TableColumn<Produto, String> codigoCol;
	@FXML
	private TableColumn<Produto, Float> precoCol;
	
	@FXML
	private TableView<PetCare> andamentoTable;
	@FXML
	private TableColumn<Servico, String> servicoCol;
	@FXML
	private TableColumn<Funcionario, String> funcionarioCol;
	@FXML
	private TableColumn<Funcionario, String> cpfFuncionarioCol;
	@FXML
	private TableColumn<Cliente, String> clienteCol;
	@FXML
	private TableColumn<Cliente, String> cpfClienteCol;
	
	@FXML
	private TableView<PetCare> concluidoTable;
	@FXML
	private TableColumn<PetCare, LocalDateTime> dataInicioCol;
	@FXML
	private TableColumn<PetCare, LocalDateTime> dataFimCol;
	
	@FXML
	private TextField codigo, cpf, nomeAnimal, cpfFuncionario;
	@FXML
	private Label avisoPesquisar, avisoCliente, listarAnimais, avisoServico;
	@FXML
	private AnchorPane clientePesquisarScene, petsScene, iniciarServicoScene;
	
	

	public void preencherTabela(){
		ArrayList<Produto> servicoListar = FachadaControlador.getInstance().listarServico();
		
		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		codigoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));
		
		servicosTable.setItems(FXCollections.observableArrayList(servicoListar));
	}
	
	public void preencherTabelaAndamento(){
		// TODO chamar o ArrayList de serviços em andamento
	}
	
	public void preencherTabelaConcluido(){
		// TODO
	}
	
	@FXML
	public void abrirRealizarServico(ActionEvent evt){
		ScreenManager.getInstance().showRealizarServico();
	}
	
	@FXML
	public void voltarMenuServico(ActionEvent evt){
		ScreenManager.getInstance().showPetCareMenu();
		PetCareController controlador = ScreenManager.getInstance().getServicos().getController();
		controlador.preencherTabela();
	}
	
	@FXML
	public void voltarMenuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showMenuCaixa();
	}
	
	@FXML
	public void abrirServicoAndamento(ActionEvent evt){
		ScreenManager.getInstance().showServicoAndamento();
		PetCareController controlador = ScreenManager.getInstance().getServicoAndamentos().getController();
		controlador.preencherTabelaAndamento();
	}

	@FXML
	public void abrirServicoConcluido(ActionEvent evt){
		ScreenManager.getInstance().showServicoConcluido();
		PetCareController controlador = ScreenManager.getInstance().getServicoConcluidos().getController();
		controlador.preencherTabelaConcluido();
	}
	
	@FXML
	public void abrirFinalizarServico(ActionEvent evt){
		// TODO 
	}
	
	
	@FXML
	public void pesquisarServico(ActionEvent evt){
		//clientePesquisarScene.setVisible(true);
		if(!avisoPesquisar.getText().isEmpty()){
			avisoPesquisar.setText("");
		}
		
		if(codigo.getText().isEmpty()){
			avisoPesquisar.setText("INFORME UM CÓDIGO VÁLIDO!!!");
		}else{
			try {
				Servico achado = FachadaControlador.getInstance().buscarServico(codigo.getText());
				clientePesquisarScene.setVisible(true);
			} catch (ObjectNaoExisteException e) {
				avisoPesquisar.setText(e.getMessage());
			}
		}
	}
	
	@FXML
	public void pesquisarCliente(ActionEvent evt){
		if(cpf.getText().isEmpty()){
			avisoCliente.setText("INFORME UM CPF VÁLIDO!");
		}else{
			try {
				//TODO erro!!!
				Cliente achado = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
				petsScene.setVisible(true);
				
				ArrayList<Animal> animais = achado.getPets();
				String animaisS = "";
				for(Animal animal: animais){
					animaisS += animal.getNome() + "\n";
				}
				avisoCliente.setText("CLIENTE ENCONTRADO NO SISTEMA!!!");
				if(animaisS == ""){
					avisoCliente.setText("ESTE CLIENTE NÃO POSSUI ANIMAIS EM NOSSO CADASTRO!!!");
				}else{
					listarAnimais.setText(animaisS);
					iniciarServicoScene.setVisible(true);
				}
				
			} catch (Exception e) {
				avisoCliente.setText(e.getMessage());
			}
		}
	}
	
	@FXML
	public void iniciarServico(ActionEvent evt){
		if(nomeAnimal.getText().isEmpty() && cpfFuncionario.getText().isEmpty()){
			avisoServico.setText("INFORME TODOS OS DADOS!!!");
		}else{
			try {
				Cliente achado = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
				Animal pet = null;
				ArrayList<Animal> animais = achado.getPets();
				for(Animal animal: animais){
					if(animal.getNome().equals(nomeAnimal)){
						pet = animal;
						break;
					}
				}
				
				Funcionario funcionario = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpfFuncionario.getText());
				Cliente cliente = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpf.getText());
				Servico servico = FachadaControlador.getInstance().buscarServico(codigo.getText());
				
				if(pet != null){
					PetCare petcare = new PetCare(servico, cliente, funcionario, pet);
					//TODO
				}else{
					avisoServico.setText("ANIMAL NÃO CADASTRADO!!!");
				}
				
			} catch (Exception e) {
				avisoServico.setText(e.getMessage());
			}
			
		}
		
		if(!avisoPesquisar.getText().isEmpty() || !codigo.getText().isEmpty() 
				|| !cpf.getText().isEmpty() || !avisoCliente.getText().isEmpty()
				|| !listarAnimais.getText().isEmpty() || !nomeAnimal.getText().isEmpty()
				|| !cpfFuncionario.getText().isEmpty()){
			clientePesquisarScene.setVisible(false);
			petsScene.setVisible(false);
			avisoPesquisar.setText("");
			codigo.setText("");
			cpf.setText("");
			avisoCliente.setText("");
			listarAnimais.setText("");
			nomeAnimal.setText("");
			cpfFuncionario.setText("");
		}
	}
}
