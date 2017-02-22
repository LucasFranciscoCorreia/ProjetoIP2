package br.ufrpe.GUI.model;

import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.PetCare;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

	//TABLEVIEW DE SERVIÇO EM ANDAMENTO
	@FXML
	private TableView<PetCare> andamentoTable;
	@FXML
	private TableColumn<PetCare, String> servicoCol;
	@FXML
	private TableColumn<PetCare, String> funcionarioCol;
	@FXML
	private TableColumn<PetCare, String> clienteCol;
	@FXML
	private TableColumn<PetCare, String> cpfClienteCol;
	@FXML
	private TableColumn<PetCare, String> nomeAnimalCol;

	//TABLEVIEW DE SERVIÇO CONCLUIDOS
	@FXML
	private TableView<PetCare> concluidoTable;
	@FXML
	private TableColumn<PetCare, String> dataInicioCol;
	@FXML
	private TableColumn<PetCare, String> dataFimCol;

	@FXML
	private TextField codigo, cpf, nomeAnimal, cpfFuncionario, raca, especie;
	@FXML
	private Label avisoPesquisar, avisoCliente, listarAnimais, avisoServico, avisarAnimais;
	@FXML
	private AnchorPane clientePesquisarScene, petsScene, iniciarServicoScene, animalScene;
	@FXML
	private Button finalizar, buttonPesquisar;
	



	public void preencherTabela(){
		ArrayList<Produto> servicoListar = FachadaControlador.getInstance().listarServico();

		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		codigoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo"));

		servicosTable.setItems(FXCollections.observableArrayList(servicoListar));
	}

	public void preencherTabelaAndamento(){
		ArrayList<PetCare> servicoAndamento = FachadaControlador.getInstance().listarServicoEmAndamento();
		
		dataInicioCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("dataCom"));
		servicoCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeServico"));
		funcionarioCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeFuncionario"));
		clienteCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeCliente"));
		cpfClienteCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("cpfCliente"));
		nomeAnimalCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeAnimal"));
		andamentoTable.refresh();
		andamentoTable.setItems(FXCollections.observableArrayList(servicoAndamento));
	}

	public void preencherTabelaConcluido(){
		ArrayList<PetCare> servicoConcluido = FachadaControlador.getInstance().listarServicoConcluido();
		
		dataFimCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("dataFi"));
		dataInicioCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("dataCom"));
		servicoCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeServico"));
		funcionarioCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeFuncionario"));
		clienteCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("nomeCliente"));
		cpfClienteCol.setCellValueFactory(new PropertyValueFactory<PetCare, String>("cpfCliente"));
		concluidoTable.refresh();
		concluidoTable.setItems(FXCollections.observableArrayList(servicoConcluido));
	}

	public boolean cpfOk(String cpf){
		boolean ok = true;
		char[] cpfChar = cpf.toCharArray();

		if(cpf.length() == 11){
			for(int i = 0; i < cpf.length(); i++){
				if(!Character.isDigit(cpfChar[i])){
					ok = false;
				}
			}			
		}else{
			ok = false;
		}

		return ok;
	}

	public String cpfPadronizar(String cpf){
		String novoCpf = "";
		char[] cpfChar = cpf.toCharArray();

		for(int i = 0; i < cpf.length(); i++){
			novoCpf += cpfChar[i];
			if(i == 2 || i == 5){
				novoCpf += ".";
			}else if(i == 8){
				novoCpf += "-";
			}
		}

		return novoCpf;
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
		ScreenManager.getInstance().showFinalizarServico();
	}


	@FXML
	public void pesquisarServico(ActionEvent evt){
		//clientePesquisarScene.setVisible(true);
		if(!avisoPesquisar.getText().isEmpty() || !avisoCliente.getText().isEmpty()){
			avisoPesquisar.setText("");
			avisoCliente.setText("");
		}

		if(codigo.getText().isEmpty()){
			avisoPesquisar.setText("INFORME UM CÓDIGO VÁLIDO!!!");
			codigo.setText("");
		}else{
			try {
				Servico achado = FachadaControlador.getInstance().buscarServico(codigo.getText());
				clientePesquisarScene.setDisable(false);
			} catch (ObjectNaoExisteException e) {
				avisoPesquisar.setText(e.getMessage());
				codigo.setText("");
			}
		}
	}

	@FXML
	public void pesquisarCliente(ActionEvent evt){
		if(cpf.getText().isEmpty()){
			avisoCliente.setText("INFORME UM CPF VÁLIDO!");
			cpf.setText("");
		}else if (cpfOk(cpf.getText())) {
			try {
				String cpfNovo = cpfPadronizar(cpf.getText());
				Cliente achado = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				String animaisS = "";					

				String mensagem = "CLIENTE ENCONTRADO NO SISTEMA!!!";

				ArrayList<Animal> animais;
				if(achado.getPets() != null){
					animais = achado.getPets();
					for(Animal animal: animais){
						animaisS += animal.getNome() + "\n";
					}					
				}
				if(animaisS.length() == 0){
					avisoCliente.setText( mensagem + "\nESTE CLIENTE NÃO POSSUI ANIMAIS EM NOSSO CADASTRO!!!");
				}else{
					avisoCliente.setText(mensagem);
					listarAnimais.setText(animaisS);
					iniciarServicoScene.setDisable(false);
					clientePesquisarScene.setDisable(true);
				}
			} catch (Exception e) {
				avisoCliente.setText(e.getMessage());
				cpf.setText("");
			}
		}
	}

	@FXML
	public void iniciarServico(ActionEvent evt){
		boolean ok = false;
				
		if(nomeAnimal.getText().isEmpty() && cpfFuncionario.getText().isEmpty()){
			avisoServico.setText("INFORME TODOS OS DADOS!!!");
		}else if (cpfOk(cpfFuncionario.getText())) {
			try {
				String cpfNovo = cpfPadronizar(cpf.getText());
				String cpfFuncionarioNovo = cpfPadronizar(cpfFuncionario.getText());

				Cliente achado = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				Animal pet = null;
				ArrayList<Animal> animais = new ArrayList<>();
				animais = achado.getPets();
				for(Animal animal: animais){
					if(animal.getNome().equalsIgnoreCase(nomeAnimal.getText())){
						pet = animal;
						break;
					}
				}

				Funcionario funcionario = (Funcionario) FachadaControlador.getInstance().buscarPessoa(cpfFuncionarioNovo);
				Cliente cliente = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				Servico servico = FachadaControlador.getInstance().buscarServico(codigo.getText());

				if(pet != null){
					PetCare petcare = new PetCare(servico, cliente, funcionario, pet);
					FachadaControlador.getInstance().adicionarPetCare(petcare);
					FachadaControlador.getInstance().salvarNoArquivoPetCare();
					avisoServico.setText("PETCARE INICIADO!!");
					iniciarServicoScene.setDisable(true);
					ok = true;
				}else{
					avisoServico.setText("ANIMAL NÃO CADASTRADO!!!");
				}

			} catch (Exception e) {
				avisoServico.setText(e.getMessage());
			}
		}else{
			avisoServico.setText("INFORME UM CPF VÁLIDO");
		}

		if(ok){
			avisoPesquisar.setText("");
			codigo.setText("");
			cpf.setText("");
			avisoCliente.setText("");
			listarAnimais.setText("");
			nomeAnimal.setText("");
			cpfFuncionario.setText("");			
		}

	}

	@FXML
	public void pesquisarClienteFinalizar(ActionEvent evt) throws ObjectNaoExisteException{
		if(cpf.getText().isEmpty()){
			avisoCliente.setText("INFORME UM CPF VÁLIDO!!");
		} if(cpfOk(cpf.getText())){
			try {
				String cpfNovo = cpfPadronizar(cpf.getText());
				if(FachadaControlador.getInstance().buscarPessoa(cpfNovo) instanceof Cliente){
					Cliente cliente = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);					
					if(cliente.getPets() == null){
						avisoCliente.setText("ESSE CLIENTE NÃO POSSUI ANIMAIS CADASTRADOS!!!");
					}else{
						avisoCliente.setText(cliente.getNome() + " CADASTRADO NO SISTEMA");
						animalScene.setDisable(false);	
						buttonPesquisar.setDisable(false);
					}
				}else{
					avisoCliente.setText("INFORME O CPF DE UM CLIENTE");
				}
				
				
			} catch (Exception e) {
				avisoCliente.setText(e.getMessage());
			}
			
		}
	}
	
	@FXML
	public void pesquisarAnimalFinalizar(ActionEvent evt){
		boolean ok = false;
		
		if(!raca.getText().isEmpty() && !especie.getText().isEmpty()
				&& !nomeAnimal.getText().isEmpty()){
			try {
				String cpfNovo = cpfPadronizar(cpf.getText());
				Cliente cliente = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				
				ArrayList<Animal> pets = new ArrayList<>();
				pets = cliente.getPets();
				Animal achado = null;
				for (Animal animal : pets) {
					if(animal.getEspecie().equalsIgnoreCase(especie.getText())
							&& animal.getRaca().equalsIgnoreCase(raca.getText())
							&& animal.getNome().equalsIgnoreCase(nomeAnimal.getText())){
						achado = animal;
						break;
					}
				}
				
				if(achado != null){
					PetCare petcare = FachadaControlador.getInstance().busca(cliente, achado);
					
					if(petcare == null){
						avisarAnimais.setText("NÃO EXISTE SERVIÇO ATIVO NO MOMENTO!!!!");
					}else{
						ok = true;
						avisarAnimais.setText(petcare.toString());
						finalizar.setDisable(false);
						buttonPesquisar.setDisable(true);
					}
				}else{
					avisarAnimais.setText("ANIMAL NÃO EXISTE NO SISTEMA!!!");
				}
			} catch (Exception e) {
				avisarAnimais.setText(e.getMessage());
			}
		}else{
			avisarAnimais.setText("ENTRE COM TODOS OS DADOS!!!");
		}
	}
	
	@FXML
	public void finalizarServico(ActionEvent evt){
		try {
			boolean ok = false;
			String cpfNovo = cpfPadronizar(cpf.getText());
			Cliente cliente = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
			
			ArrayList<Animal> pets = new ArrayList<>();
			pets = cliente.getPets();
			Animal achado = null;
			for (Animal animal : pets) {
				if(animal.getEspecie().equalsIgnoreCase(especie.getText())
						&& animal.getRaca().equalsIgnoreCase(raca.getText())
						&& animal.getNome().equalsIgnoreCase(nomeAnimal.getText())){
					achado = animal;
					break;
				}
			}
			ArrayList<PetCare> servicoAndamento = FachadaControlador.getInstance().listarServicoEmAndamento();
			
			for (PetCare pet : servicoAndamento) {
				if(pet.getCpfCliente().equals(cliente.getCpf()) && pet.getNomeAnimal().equalsIgnoreCase(achado.getNome())){
					pet.setDataFim(LocalDateTime.now());
					FachadaControlador.getInstance().salvarNoArquivoPetCare();
					finalizar.setDisable(true);
					ok = true;
					
				}
			}
			
			if(!ok){
				avisarAnimais.setText("PETCARE JÁ FINALIZADO!!! \nTENTE OUTRO SERVIÇO");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		raca.setText("");
		especie.setText("");
		nomeAnimal.setText("");
		avisarAnimais.setText("");
		avisoCliente.setText("");
		cpf.setText("");
	}
}
