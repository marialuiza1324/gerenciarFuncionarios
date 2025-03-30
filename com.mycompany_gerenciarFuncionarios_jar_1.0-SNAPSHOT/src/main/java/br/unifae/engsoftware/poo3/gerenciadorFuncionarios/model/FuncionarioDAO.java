package br.unifae.engsoftware.poo3.gerenciadorFuncionarios.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Maria Eduarda de Oliveira Furini e Maria Luiza Nery Pinto
 */
public class FuncionarioDAO {
    private String fileName = null;
    Collection<Funcionario> funcionarios;
    
    public FuncionarioDAO(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        
        // inicializar coleção de funcionários
        if(funcionarios == null){
            funcionarios = new ArrayList();
        }
        
        // ler os funcionários já cadastrados no arquivo e armazenar na coleção
        FileReader arquivo = new FileReader(fileName);
        Scanner scanner = new Scanner(arquivo);
        
        while(scanner.hasNext()) {
            String nome = scanner.nextLine();
            String codigo = scanner.nextLine();
            String salario = scanner.nextLine();

            funcionarios.add(new Funcionario(codigo, nome, Double.parseDouble(salario)));
        }   
    }
    
    public Collection<Funcionario> index() {
        return funcionarios;    
    }
    
    public Funcionario show(String code) {
        
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getCodigo().equals(code)){
                return funcionario;
            }
        }
        
        return null;
    }
    
    public boolean create(String codigo, String nome, double valor) {
        Funcionario funcionario = new Funcionario(codigo, nome, valor);
        return funcionarios.add(funcionario);
    }
    
    public void gravarNoArquivo() throws IOException {
        // o arquivo sera excluido e criado novamente para resetar os dados
        FileWriter arquivo = new FileWriter(fileName);
        PrintWriter out = new PrintWriter(arquivo); 

        // gravar os funcionários da coleção no arquivo
        for(Funcionario funcionario : funcionarios) {
            out.println(funcionario);
        }
        
        // fechar o arquivo na ordem inversa da de abertura
        out.close();
        arquivo.close();
    }
}
