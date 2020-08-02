package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {
	
		public static final ClientDTO NULL_VALUE = new ClientDTO("", "", "");
		
		private final String nome;
	    private final String dataNascimento;
	    private final String email;

	    public ClientDTO(final String nome, final String dataNascimento, final String email){
	    	this.nome = nome;
	        this.dataNascimento = dataNascimento;
	        this.email = email;
	    }
	    
	    
	    public String getNome() {
	        return nome;
	    }
	    
	    public String getdataNascimento() {
	        return dataNascimento;
	    }
	    
	    public String getemail () {
	        return email;
	    }

	}