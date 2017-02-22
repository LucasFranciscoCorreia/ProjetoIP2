package br.ufrpe.GUI.model;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.FachadaControlador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteController implements Initializable{

	@FXML
	private TableView<Cliente> clienteTable;
	@FXML
	private TableColumn<Cliente, String> nomeCol;
	@FXML
	private TableColumn<Cliente, String> cpfCol;
	@FXML
	private JFXButton okButton, buttonAddCliente, buttonRemoverCliente, buttonListarCliente, buttonPesquisarCliente, buttonAtualizarCliente, buttonCancelar;
	@FXML
	private Label aviso, avisoCadastro, clienteEncontrado, avisoClienteAtualizar, clienteDeletado, avisoRemover, avisoAtualizar, syso, erroPesquisa;
	@FXML
	private Label avisoAddPetCliente, infDonoPet; 
	@FXML
	private Button buttonCliente, buttonCadastrarCliente, buttonCancelarCadastroCliente, buttonCadastrarNovoCliente, buttonProcurar, buttonDeletar, btnPesquisar, salvarPet, salvarEnd	;
	@FXML	
	private TextField nome, cpf, aniversario, cep, rua, numero, complemento, cidadeUF, buscaRemover, salario, cargo, cpfDono;
	@FXML
	private TextField raca, nomePet, peso, altura, especie;

	private static Pessoa donoPet;

	public void preencherTabela() {
		ArrayList<Cliente> clienteLista = FachadaControlador.getInstance().listarCLiente();

		nomeCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
		cpfCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
		clienteTable.setItems(FXCollections.observableArrayList(clienteLista));	
	}

	@FXML
	public void deletarCliente(ActionEvent evt){
		try{
			Pessoa p = FachadaControlador.getInstance().buscarPessoa(buscaRemover.getText());
			if(p instanceof Cliente){
				FachadaControlador.getInstance().removerPessoa(this.cpfPadronizar(buscaRemover.getText()));
				FachadaControlador.getInstance().salvarNoArquivoPessoa();
			}
			clienteEncontrado.setText("Cliente deletado com sucesso");
		}catch(ObjectNaoExisteException | ErroAoRemoverException e){
			clienteEncontrado.setText(e.getMessage());
		}finally{
			buttonDeletar.setDisable(true);
			buscaRemover.setText("");
		}
	}

	@FXML
	public void buscarCliente(ActionEvent evt){
		if(buscaRemover.getText().isEmpty()){
			clienteEncontrado.setText("Digite um cpf para busca");
			buttonDeletar.setDisable(true);
		}else{
			if(buscaRemover.getText().length() != 11){
				clienteEncontrado.setText("CPF deve ser escrito em numeros e ter 11 numeros");
				buttonDeletar.setDisable(true);
			}else if(!cpfOk(buscaRemover.getText())){
				clienteEncontrado.setText("CPF deve ter apenas numeros");
				buttonDeletar.setDisable(true);
			}else{
				try {
					clienteEncontrado.setText(FachadaControlador.getInstance().buscarPessoa(this.cpfPadronizar(buscaRemover.getText())).getNome());
					buttonDeletar.setDisable(false);
				}catch (ObjectNaoExisteException e) {
					clienteEncontrado.setText(e.getMessage());
					buttonDeletar.setDisable(true);
				}
			}
		}
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

	@SuppressWarnings("finally")
	public boolean dataOk(String data){
		boolean ok = false;
		try{
			DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dataok = LocalDate.parse(data, DATE_FORMAT);
			ok = true;
		}catch(DateTimeParseException e){
			avisoCadastro.setText("Data deve ser escrita no formato: \"dia-mes-ano\"");
		}finally{
			return ok;			
		}
	}

	@FXML
	public void menuPrincipal(ActionEvent evt){
		ScreenManager.getInstance().showMenu();
	}

	@FXML
	public void abrirClienteCadastrar(ActionEvent evt){
		ScreenManager.getInstance().showClienteCadastrar();;
	}

	@FXML
	public void abrirClienteAtualizar(ActionEvent evt){
		ScreenManager.getInstance().showClienteAtualizar();
	}

	@FXML
	public void abrirClientePesquisar(ActionEvent evt){
		ScreenManager.getInstance().showClientePesquisar();
	}

	@FXML
	public void abrirClienteRemover(ActionEvent evt){
		ScreenManager.getInstance().showClienteRemover();
	}

	@FXML
	public void abrirClienteCadastrarCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClienteCadastrarCaixa();
	}

	@FXML
	public void abrirClienteAtualizarCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClienteAtualizarCaixa();
	}

	@FXML
	public void abrirClientePesquisarCaixa(ActionEvent evt){

		ScreenManager.getInstance().showClientePesquisarCaixa();

	}

	@FXML
	public void voltarMenu(ActionEvent evento){
		ScreenManager.getInstance().showClienteListar();
		ClienteController controlador = ScreenManager.getInstance().getClientes().getController();
		controlador.preencherTabela();
	}

	@FXML
	public void voltarMenuClienteCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClienteMenuCaixa();
		ClienteController controlador = ScreenManager.getInstance().getClientesCaixa().getController();
		controlador.preencherTabela();
	}

	@FXML
	public void menuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showMenuCaixa();
	}

	@FXML
	public void procuraDono(ActionEvent evt){
		if(cpfDono.getText().isEmpty()){
			infDonoPet.setText("Digite um cpf para busca");
			raca.setDisable(true);
			nomePet.setDisable(true);
			peso.setDisable(true);
			altura.setDisable(true);
			especie.setDisable(true);
			rua.setDisable(true);
			numero.setDisable(true);
			complemento.setDisable(true);
			cep.setDisable(true);
			cidadeUF.setDisable(true);
			salvarEnd.setDisable(true);
			salvarPet.setDisable(true);
			avisoAddPetCliente.setText("");
			avisoClienteAtualizar.setText("");
		}else{
			if(cpfDono.getText().length() != 11){
				infDonoPet.setText("CPF deve ser escrito em numeros e ter 11 numeros");
				raca.setDisable(true);
				nomePet.setDisable(true);
				peso.setDisable(true);
				altura.setDisable(true);
				especie.setDisable(true);
				rua.setDisable(true);
				numero.setDisable(true);
				complemento.setDisable(true);
				cep.setDisable(true);
				cidadeUF.setDisable(true);
				salvarEnd.setDisable(true);
				salvarPet.setDisable(true);
			}else if(!cpfOk(cpfDono.getText())){
				infDonoPet.setText("CPF deve ter apenas numeros");
				raca.setDisable(true);
				nomePet.setDisable(true);
				peso.setDisable(true);
				altura.setDisable(true);
				especie.setDisable(true);
				rua.setDisable(true);
				numero.setDisable(true);
				complemento.setDisable(true);
				cep.setDisable(true);
				cidadeUF.setDisable(true);
				salvarEnd.setDisable(true);
				salvarPet.setDisable(true);
			}else{
				try {
					donoPet = FachadaControlador.getInstance().buscarPessoa(this.cpfPadronizar(cpfDono.getText()));
					if(donoPet instanceof Cliente){
						infDonoPet.setText(donoPet.getNome());
						raca.setDisable(false);
						nomePet.setDisable(false);
						peso.setDisable(false);
						altura.setDisable(false);
						especie.setDisable(false);
						rua.setDisable(false);
						numero.setDisable(false);
						complemento.setDisable(false);
						cep.setDisable(false);
						cidadeUF.setDisable(false);
						salvarEnd.setDisable(false);
						salvarPet.setDisable(false);
					}
				} catch (ObjectNaoExisteException e) {
					infDonoPet.setText(e.getMessage());
					raca.setDisable(true);
					nomePet.setDisable(true);
					peso.setDisable(true);
					altura.setDisable(true);
					especie.setDisable(true);
					rua.setDisable(true);
					numero.setDisable(true);
					complemento.setDisable(true);
					cep.setDisable(true);
					cidadeUF.setDisable(true);
					salvarEnd.setDisable(true);
					salvarPet.setDisable(true);
				}
			}
		}
	}

	@FXML
	public void adicionarPet(ActionEvent evt){
		if(raca.getText().isEmpty() || peso.getText().isEmpty() || altura.getText().isEmpty() || especie.getText().isEmpty() || nomePet.getText().isEmpty()){
			avisoAddPetCliente.setText("Todos os campos devem ser preenchidos");
		}else{
			Animal novo = new Animal(true, especie.getText(), raca.getText(), donoPet, Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText()), nomePet.getText(), FachadaControlador.getInstance().gerarCodigo());

			try {
				FachadaControlador.getInstance().cadastrar(novo);
				FachadaControlador.getInstance().salvarNoArquivoAnimal();

				avisoAddPetCliente.setText("Pet cadastrado ao dono com sucesso");
				raca.setText("");
				nomePet.setText("");
				peso.setText("");
				altura.setText("");
				especie.setText("");
				rua.setText("");
				numero.setText("");
				complemento.setText("");
				cep.setText("");
				cidadeUF.setText("");
				raca.setDisable(true);
				nomePet.setDisable(true);
				peso.setDisable(true);
				altura.setDisable(true);
				especie.setDisable(true);
				rua.setDisable(true);
				numero.setDisable(true);
				complemento.setDisable(true);
				cep.setDisable(true);
				cidadeUF.setDisable(true);
				salvarEnd.setDisable(true);
				salvarPet.setDisable(true);
			} catch (ObjectJaExisteException e) {
				avisoAddPetCliente.setText(e.getMessage());
			}
			((Cliente) donoPet).addPet(novo);
			try {
				FachadaControlador.getInstance().atualizar(donoPet);
				FachadaControlador.getInstance().salvarNoArquivoPessoa();

			} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
				avisoAddPetCliente.setText(e.getMessage());
			}
		}
	}

	@FXML
	public void alterarEndereco(ActionEvent evt){
		if(rua.getText().isEmpty() || complemento.getText().isEmpty() || numero.getText().isEmpty() || cep.getText().isEmpty() || cidadeUF.getText().isEmpty()){
			avisoClienteAtualizar.setText("Todos os campos devem ser preenchidos");
		}else{
			Endereco end;
			try{
				end = new Endereco(rua.getText(), complemento.getText(), Short.parseShort(numero.getText()), cep.getText(), cidadeUF.getText());
				donoPet.setEnd(end);
				avisoClienteAtualizar.setText("Endereço alterado com sucesso");
				FachadaControlador.getInstance().salvarNoArquivoPessoa();
				raca.setText("");
				nomePet.setText("");
				peso.setText("");
				altura.setText("");
				especie.setText("");
				rua.setText("");
				numero.setText("");
				complemento.setText("");
				cep.setText("");
				cidadeUF.setText("");
				raca.setDisable(true);
				nomePet.setDisable(true);
				peso.setDisable(true);
				altura.setDisable(true);
				especie.setDisable(true);
				rua.setDisable(true);
				numero.setDisable(true);
				complemento.setDisable(true);
				cep.setDisable(true);
				cidadeUF.setDisable(true);
				salvarEnd.setDisable(true);
				salvarPet.setDisable(true);
			}catch(NumberFormatException e){
				avisoClienteAtualizar.setText("Numero deve estar escrito em formato numerico");

			}catch(Exception e){
				avisoClienteAtualizar.setText(e.getMessage());
				raca.setText("");
				nomePet.setText("");
				peso.setText("");
				altura.setText("");
				especie.setText("");
				rua.setText("");
				numero.setText("");
				complemento.setText("");
				cep.setText("");
				cidadeUF.setText("");
				raca.setDisable(true);
				nomePet.setDisable(true);
				peso.setDisable(true);
				altura.setDisable(true);
				especie.setDisable(true);
				rua.setDisable(true);
				numero.setDisable(true);
				complemento.setDisable(true);
				cep.setDisable(true);
				cidadeUF.setDisable(true);
				salvarEnd.setDisable(true);
				salvarPet.setDisable(true);
			}
		}
	}

	public boolean cpfOk(String cpf){
		for(int i = 0; i < cpf.length();i++){
			try{
				Integer.parseInt(cpf.charAt(i)+"");
			}catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@FXML
	public void pesquisarCliente(ActionEvent evt){
		Pessoa p;
		try {
			if(!cpfOk(cpf.getText())){
				erroPesquisa.setText("CPF deve conter apenas numeros");
			}else if(this.cpf.getText().length() != 11){
				erroPesquisa.setText("CPF deve ter 11 numeros");
			}else{
				p = FachadaControlador.getInstance().buscarPessoa(this.cpfPadronizar(cpf.getText()));
				if(p instanceof Funcionario || p == null){
					throw new ObjectNaoExisteException();
				}
				syso.setText(p.toString());
				erroPesquisa.setText("");
			}
		} catch (ObjectNaoExisteException e) {
			erroPesquisa.setText(e.getMessage());
			syso.setText("");
		}
	}

	@FXML
	public void cadastrarCliente(ActionEvent evt){
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || aniversario.getText().isEmpty() || cep.getText().isEmpty() || rua.getText().isEmpty() || numero.getText().isEmpty() || complemento.getText().isEmpty() || cidadeUF.getText().isEmpty()){
			avisoCadastro.setText("Todos os campos devem ser preenchidos");
		}else{
			if(!cpfOk(cpf.getText())){
				avisoCadastro.setText("CPF deve conter apenas numeros");
			}else if(cpf.getText().length() != 11){
				avisoCadastro.setText("CPF deve ter 11 numeros");
			}else{
				if(dataOk(aniversario.getText())){
					Pessoa novo = null;
					boolean ok = true;
					try{					
						Endereco end = new Endereco(rua.getText(), complemento.getText(), Short.parseShort(numero.getText()), cep.getText(), cidadeUF.getText());
						DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						LocalDate aniversario = LocalDate.parse(this.aniversario.getText(), DATE_FORMAT);
						String cpfNovo = cpfPadronizar(cpf.getText());
						novo = new Cliente(cpfNovo,aniversario, nome.getText(), end);
					}catch(NumberFormatException e){
						avisoCadastro.setText("Numero de residencia deve ser um numero");
					}
					try {
						FachadaControlador.getInstance().cadastrar(novo);
					} catch (ObjectNaoExisteException | ErroAoSalvarException | ObjectJaExisteException e) {
						avisoCadastro.setText(e.getMessage());
						ok = false;
					}
					if(ok){
						avisoCadastro.setText("Cliente cadastrado com sucesso");
						FachadaControlador.getInstance().salvarNoArquivoPessoa();
					}
				}else{
					avisoCadastro.setText("Data invalida ou escrita num formato invalido(\"dia-mes-ano\")");
				}
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
