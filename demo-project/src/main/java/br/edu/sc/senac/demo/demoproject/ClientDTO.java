package br.edu.sc.senac.demo.demoproject;

public class ClientDTO {
	
	private String nome;
    private String dataNascimento;
    private String email;

    ClientDTO(String nome, String dataNascimento, String email){
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
