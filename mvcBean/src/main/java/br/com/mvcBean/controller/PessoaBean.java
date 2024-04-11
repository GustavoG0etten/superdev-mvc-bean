package br.com.mvcBean.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mvcBean.model.Pessoa;

@Named("pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa;
	
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	// CRIAR UM METODO QUE SEJA CAPAZ DE INSERIR O ID AO USUARIO
	// DE FORMA SEQUENCIAL, OU SEJA, A CLASSE BEAN DEVE CONTROLAR 
	// A SEQUENCIA DO ID DAS PESSOAS
	
	
	public String adicionar() {
		pessoa.setId(adicionarId());
		pessoas.add(pessoa);
		pessoa = new Pessoa();
		System.out.println(pessoas.size());
		return null;
	}
	
	private int adicionarId() {
		if (pessoas.isEmpty()) {
			return 0;
		} else {
			int maiorId = 0;
	        for (Pessoa p : pessoas) {
	            if (p.getId() > maiorId) {
	                maiorId = p.getId();
	            }
	        }
	        return maiorId + 1; 
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}