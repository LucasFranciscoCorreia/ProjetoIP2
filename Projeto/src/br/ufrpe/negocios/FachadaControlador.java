package br.ufrpe.negocios;

import java.util.ArrayList;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.beans.PetCare;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.RepositorioAnimal;
import br.ufrpe.repositorios.RepositorioPessoa;
import br.ufrpe.repositorios.RepositorioPetCare;
import br.ufrpe.repositorios.RepositorioProduto;
import br.ufrpe.repositorios.RepositorioServico;
/* Facade */
/**
 * Esta classe representa a fachada do sistema, pela qual os controladores
 * e repositórios são instanciados.
 * 
 * @author srtacamelo
 *
 */

public class FachadaControlador {
	private IControladorAnimal controladorAnimal;
	private IControladorPessoa controladorPessoa;
	private IControladorProduto controladorProduto;
	private IControladorServico controladorServico;
	private IControladorPetCare controladorPetCare;
	private static FachadaControlador instance;
	
	/**
	 * Construtor da Classe Fachada
	 */
	private FachadaControlador(){
		this.controladorAnimal = new ControladorAnimal(RepositorioAnimal.getInstance());
		this.controladorProduto = new ControladorProduto(RepositorioProduto.getInstance());
		this.controladorPessoa = new ControladorPessoa(RepositorioPessoa.getInstance());
		this.controladorServico = new ControladorServico(RepositorioServico.getInstance());
		this.controladorPetCare = new ControladorPetCare(RepositorioPetCare.getInstance());
	}
	/**
	 * Método getInstance, para garantir a unicidade da classe.
	 * @return
	 */
	public static FachadaControlador getInstance(){
		if (instance == null){
			instance = new FachadaControlador();
		}
		return instance;
	}
	/**
	 * Salvar os objetos dos repositórios nos arquivos
	 */
	public void salvarNoArquivoAnimal(){
		controladorAnimal.salvarNoArquivo();
	}
	/**
	 * Cadastrar novo animal.
	 * 
	 * @param novo
	 * @throws ObjectJaExisteException
	 */
	public void cadastrar(Animal novo) throws ObjectJaExisteException {
		controladorAnimal.cadastrar(novo);
	}
	/**
	 * Remover animal do repositório
	 * @param codigo
	 * @throws CodigoNaoExisteException
	 */
	public void removerAnimal(String codigo) throws CodigoNaoExisteException {
		controladorAnimal.remover(codigo);
	}
	/**
	 * Atualizar animal já existente no repositório.
	 * @param novo
	 * @param antigo
	 * @throws ObjectJaExisteException
	 * @throws ObjectNaoExisteException
	 */
	public void atualizarAnimal(Animal novo, Animal antigo) throws ObjectJaExisteException, ObjectNaoExisteException {
		controladorAnimal.atualizar(novo, antigo);
	}
	/**
	 * Buscar um animal no repositório
	 * @param codigo
	 * @return
	 * @throws CodigoNaoExisteException
	 */
	public Animal buscarAnimal(String codigo) throws CodigoNaoExisteException {
		return controladorAnimal.buscar(codigo);
	}
	/**
	 * Buscar uma pessoa no repositório.
	 * 
	 * @param cpf
	 * @return
	 * @throws ObjectNaoExisteException
	 */
	public Pessoa buscarPessoa(String cpf) throws ObjectNaoExisteException {
		return controladorPessoa.buscar(cpf);
	}
	public Pessoa buscar(Login log) throws ObjectNaoExisteException {
		return controladorPessoa.buscar(log);
	}
	
	public void removerPessoa(String cpf) throws ObjectNaoExisteException, ErroAoRemoverException{
		controladorPessoa.remover(cpf);
	}
	
	public void remover(String codigo) throws ObjectNaoExisteException, ErroAoRemoverException {
		controladorProduto.remover(codigo);
	}
	public Produto pesquisar(String codigo) throws ObjectNaoExisteException {
		return controladorProduto.pesquisar(codigo);
	}
	public boolean equals(Object arg0) {
		return controladorAnimal.equals(arg0);
	}

	public int hashCode() {
		return controladorAnimal.hashCode();
	}

	public String toString() {
		return controladorAnimal.toString();
	}
	
	public void salvarNoArquivoPessoa(){
		controladorPessoa.salvarNoArquivo();
	}
	
	public void cadastrar(Pessoa novo) throws ObjectNaoExisteException, ErroAoSalvarException, ObjectJaExisteException {
		controladorPessoa.cadastrar(novo);;
	}

	public ArrayList<Cliente> listarCLiente() {
		return controladorPessoa.listarCLiente();
	}

	public ArrayList<Funcionario> listarFuncionario() {
		return controladorPessoa.listarFuncionario();
	}
	public int size() {
		return controladorPessoa.size();
	}

	public void atualizar(Pessoa novo) throws ObjectNaoExisteException, ErroAoAtualizarException {
		controladorPessoa.atualizar(novo);
	}

	public int sizeCliente() {
		return controladorPessoa.sizeCliente();
	}

	public int sizeFuncionario() {
		return controladorPessoa.sizeFuncionario();
	}

	public boolean login(String login, int senha) {
		return controladorPessoa.login(login, senha);
	}
	
	public void salvarNoArquivoProduto(){
		controladorProduto.salvarNoArquivo();
	}

	public void cadastrar(Produto produto) throws ObjectJaExisteException, ErroAoSalvarException {
		controladorProduto.cadastrar(produto);
	}

	public void atualizar(Produto produto) throws ObjectNaoExisteException, ErroAoAtualizarException {
		controladorProduto.atualizar(produto);
	}

	public ArrayList<Produto> listarProduto() {
		return controladorProduto.listarProduto();
	}
	public String gerarCodigo(){
		return controladorProduto.gerarCodigo();
	}
	
	public ArrayList<Produto> listarServico(){
		return controladorServico.listarServico();
	}
	
	public void salvarNoArquivoServico(){
		controladorServico.salvarNoArquivo();
	}
	
	public void cadastrarServico(Servico novo)throws ObjectJaExisteException,ObjectNaoExisteException, ErroAoSalvarException{
		controladorServico.cadastrarServico(novo);
	}
	
	public Servico buscarServico(String codigo)throws ObjectNaoExisteException{
		return controladorServico.buscarServico(codigo);
	}
	
	public void removerServicoNome(String codigo)throws ObjectNaoExisteException{
		controladorServico.removerServicoNome(codigo);
	}
	
	public void atualizarServico(Servico antigo, Servico novo)throws ErroAoAtualizarException, ObjectNaoExisteException{
		controladorServico.atualizarServico(antigo, novo);
	}
	
	public void adicionarPetCare(PetCare petcare) throws ObjectNaoExisteException, ObjectJaExisteException{
		controladorPetCare.adicionarPetCare(petcare);
	}
	
	public void removerPetCare(PetCare petcare) throws ObjectNaoExisteException{
		controladorPetCare.removerPetCare(petcare);
	}
	
	public void salvarNoArquivoPetCare(){
		controladorPetCare.salvarNoArquivo();
	}
	
	public ArrayList<PetCare> listarServicoEmAndamento(){
		return controladorPetCare.listarServicoEmAndamento();
	}
	
	public ArrayList<PetCare> listarServicoConcluido(){
		return controladorPetCare.listarServicoConcluido();
	}
	
	public PetCare busca(Cliente b, Animal p) throws ObjectNaoExisteException{
		return controladorPetCare.busca(b, p);
	}
	
	public void atualizar(Animal novo, Animal antigo) throws ObjectJaExisteException, ObjectNaoExisteException {
		controladorAnimal.atualizar(novo, antigo);
	}
	public Pessoa buscar(String cpf) throws ObjectNaoExisteException {
		return controladorPessoa.buscar(cpf);
	}
	public void salvarNoArquivo() {
		controladorServico.salvarNoArquivo();
	}
	
	

}
