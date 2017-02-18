package br.ufrpe.GUI.model;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.GUI.ScreenManager;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.FachadaControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClienteController implements Initializable{

	@FXML
	private JFXButton okButton, buttonAddCliente, buttonRemoverCliente, buttonListarCliente, buttonPesquisarCliente, buttonAtualizarCliente, buttonCancelar;
	@FXML
	private Label aviso, avisoCadastro, clienteEncontrado, clienteDeletado, avisoRemover, avisoAtualizar, syso, erroPesquisa;
	@FXML
	private Label avisoAddPetCliente, infDonoPet; 
	@FXML
	private Button buttonCliente, buttonCadastrarCliente, buttonCancelarCadastroCliente, buttonCadastrarNovoCliente, buttonProcurar, buttonDeletar, btnPesquisar, salvarPet, salvarEnd	;
	@FXML	
	private TextField nome, cpf, aniversario, cep, rua, numero, complemento, cidadeUF, buscaRemover, salario, cargo, cpfDono;
	@FXML
	private TextField raça, nomePet, peso, altura, especie;

	private static Funcionario logado;
	private static Pessoa donoPet;
	
	
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
	public void voltarMenu(ActionEvent evento){
		ScreenManager.getInstance().showFuncionarioListar();
	}
	
	
	
	@FXML
	public void procuraDono(ActionEvent evt){
		if(cpfDono.getText().isEmpty()){
			infDonoPet.setText("Digite um cpf para busca");
		}else{
			try {
				donoPet = FachadaControlador.getInstance().buscarPessoa(cpfDono.getText());
				infDonoPet.setText(donoPet.getNome());
				raça.setDisable(false);
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
			} catch (ObjectNaoExisteException e) {
				infDonoPet.setText(e.getMessage());
			}
		}
	}
	
	@FXML
	public void adicionarPet(ActionEvent evt){
		if(raça.getText().isEmpty() || peso.getText().isEmpty() || altura.getText().isEmpty() || especie.getText().isEmpty() || nome.getText().isEmpty()){
			avisoAddPetCliente.setText("Todos os campos devem ser preenchidos");
		}else{
			Animal novo = new Animal(true, especie.getText(), raça.getText(), donoPet, Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText()), nomePet.getText(),null);
			try {
				FachadaControlador.getInstance().cadastrar(novo);
			} catch (ObjectJaExisteException e) {
				avisoAddPetCliente.setText(e.getMessage());
			}
			((Cliente) donoPet).addPet(novo);
			try {
				FachadaControlador.getInstance().atualizar(donoPet);
			} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
				avisoAddPetCliente.setText(e.getMessage());
			}
		}
		
	}
	
	@FXML
	public void pesquisarCliente(ActionEvent evt){
		Pessoa p;
		try {
			p = (Cliente) FachadaControlador.getInstance().buscarPessoa(this.cpf.getText());
			if(!(p instanceof Cliente)){
				throw new ObjectNaoExisteException();
			}
			syso.setText(p.toString());
		} catch (ObjectNaoExisteException e) {
			erroPesquisa.setText(e.getMessage());
		}
	}
	
	@FXML
	public void cadastrarCliente(ActionEvent evt){
		if(nome.getText().isEmpty() || cpf.getText().isEmpty() || aniversario.getText().isEmpty() || cep.getText().isEmpty() || rua.getText().isEmpty() || numero.getText().isEmpty() || complemento.getText().isEmpty() || cidadeUF.getText().isEmpty()){
			avisoCadastro.setText("Todos os campos devem ser preenchidos");
		}else{
			if(dataOk(aniversario.getText())){
				Pessoa novo = null;
				boolean ok = true;
				try{					
					Endereco end = new Endereco(rua.getText(), complemento.getText(), Short.parseShort(numero.getText()), cep.getText(), cidadeUF.getText());
					DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate aniversario = LocalDate.parse(this.aniversario.getText(), DATE_FORMAT);
					novo = new Cliente(cpf.getText(),aniversario, nome.getText(), end);
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
		
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
