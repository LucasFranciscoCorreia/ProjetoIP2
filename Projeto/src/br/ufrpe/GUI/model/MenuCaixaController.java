package br.ufrpe.GUI.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
import br.ufrpe.negocios.FachadaControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MenuCaixaController {
	@FXML
	private Button buttonAtualizar;
	@FXML
	private Label aviso, clienteToString, avisoAtualizar;
	@FXML	
	private TextField nome, cpf, aniversario, cep, rua, numero, complemento, cidadeUF;
	@FXML
	private TextField raca, peso, altura, especie, nomeAnimal;
	
	@SuppressWarnings("finally")
	public boolean dataOk(String data){
		boolean ok = false;
		try{
			DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dataok = LocalDate.parse(data, DATE_FORMAT);
			ok = true;
		}catch(DateTimeParseException e){
			aviso.setText("Data deve ser escrita no formato: \"dia-mes-ano\"");
		}finally{
			return ok;			
		}
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
	public void menuCaixa(ActionEvent evt){
		ScreenManager.getInstance().showMenuCaixa();
	}
	
	@FXML
	public void abrirClienteCadastarCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClienteCadastrarCaixa();
	}
	
	@FXML
	public void abrirClienteAtualizarCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClienteAtualizarCaixa();
	}
	
	@FXML
	public void abrirClienteBuscarCaixa(ActionEvent evt){
		ScreenManager.getInstance().showClientePesquisarCaixa();
	}
	
	@FXML
	public void cadastrarClienteCaixa(ActionEvent evt) throws ObjectNaoExisteException{
		if(rua.getText().isEmpty() || numero.getText().isEmpty() || cep.getText().isEmpty()
				|| cidadeUF.getText().isEmpty() || cpf.getText().isEmpty()
				|| nome.getText().isEmpty() || aniversario.getText().isEmpty()){
			aviso.setText("Dado Inválido!! Tente novamente");
		
		}else{
			if(dataOk(aniversario.getText()) && cpfOk(cpf.getText())){
				try {
					String cpfNovo = cpfPadronizar(cpf.getText());
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(this.aniversario.getText(), formatter);
					
					Endereco end = new Endereco(rua.getText(), complemento.getText(), 
							Short.valueOf(numero.getText()), cep.getText(), 
							cidadeUF.getText());
					
					Cliente cliente = new Cliente(cpfNovo, date, nome.getText(), end);
					
					FachadaControlador.getInstance().cadastrar(cliente);
					FachadaControlador.getInstance().salvarNoArquivoPessoa();
					
					aviso.setText(nome.getText() + " cadastrado(a) com sucesso no sistema");
				} catch (NumberFormatException e) {
					aviso.setText("Numero de residencia deve ser um numero");
				} catch (ErroAoSalvarException | ObjectJaExisteException e) {
					aviso.setText(e.getMessage());
				} 
			}else{
				aviso.setText("Entre com dados válidos!!!");
			}
		}

		if(!rua.getText().isEmpty() || !numero.getText().isEmpty() || !cep.getText().isEmpty()
				|| !cidadeUF.getText().isEmpty() || !cpf.getText().isEmpty()
				|| !nome.getText().isEmpty() || !aniversario.getText().isEmpty()){
			
			rua.setText("");
			numero.setText("");
			complemento.setText("");
			cep.setText("");
			cidadeUF.setText("");
			cpf.setText("");
			nome.setText("");
			aniversario.setText("");
		} else if (!aviso.getText().isEmpty()) {
			aviso.setText("");
		}
	}
	
	@FXML
	public void pesquisarCliente(ActionEvent evt){
		if(!clienteToString.getText().isEmpty()){
			clienteToString.setText("");
		} if(!aviso.getText().isEmpty()){
			aviso.setText("");
		}
		
		if(cpfOk(cpf.getText())){
			try {				
				Cliente achada = null;
				String cpfNovo = cpfPadronizar(cpf.getText());
				achada = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				
				aviso.setText("Cliente encontrado no sistema!!!");
				clienteToString.setText(achada.toString());
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		}else{
			aviso.setText("CPF invalido!!");
		}
		
		if(!cpf.getText().isEmpty()){
			cpf.setText("");
		}
	}

	@FXML
	public void pesquisarClienteAtualizar(ActionEvent evt){
		if(!aviso.getText().isEmpty()){
			aviso.setText("");
		}
		
		if(cpfOk(cpf.getText())){
			try {				
				Cliente achada = null;
				String cpfNovo = cpfPadronizar(cpf.getText());
				achada = (Cliente) FachadaControlador.getInstance().buscarPessoa(cpfNovo);
				
				aviso.setText("Cliente encontrado no sistema!!!");
				buttonAtualizar.setVisible(true);
			} catch (ObjectNaoExisteException e) {
				aviso.setText(e.getMessage());
			}
		}else{
			aviso.setText("CPF invalido!!");
		}
		
		if(!cpf.getText().isEmpty()){
			cpf.setText("");
		}
	}

	@FXML
	public void buttonSalvarAtualizarFuncionario(ActionEvent evt) throws NumberFormatException, ObjectNaoExisteException{
		boolean salvar = false;
		
		if(cpfOk(cpf.getText())){
			String cpfNovo = cpfPadronizar(cpf.getText());
			Cliente cliente = new Cliente(cpfNovo);
			
			if(!raca.getText().isEmpty() || !peso.getText().isEmpty()
					|| !altura.getText().isEmpty() || !especie.getText().isEmpty()
					|| !nomeAnimal.getText().isEmpty()){
				salvar = true;
				
				Animal novo = new Animal(true, especie.getText(), raca.getText(), FachadaControlador.getInstance().buscarPessoa(cpf.getText()), 
						Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText()), 
						nomeAnimal.getText(), null);
				cliente.addPet(novo);
			} if (!rua.getText().isEmpty() && !numero.getText().isEmpty() && !cep.getText().isEmpty()
				&& !cidadeUF.getText().isEmpty()) {
			
				Endereco end = new Endereco(rua.getText(), complemento.getText(), Short.valueOf(numero.getText()), 
						cep.getText(), cidadeUF.getText());
				cliente.setEnd(end);
				salvar = true;
			}
			
			if(salvar){
				try {
					FachadaControlador.getInstance().atualizar(cliente);
					FachadaControlador.getInstance().salvarNoArquivoPessoa();
					
					avisoAtualizar.setText("Informações atualizadas");
					buttonAtualizar.setVisible(false);
				} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
					avisoAtualizar.setText(e.getMessage());
				}	
			}else{
				avisoAtualizar.setText("Informe dados válidos!!!");
			}
		}else{
			avisoAtualizar.setText("Informe um CPF válido!!");
		}
	}
}
