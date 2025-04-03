package br.unifae.engsoftware.marias.gerenciadorfuncionarios.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import br.unifae.engsoftware.marias.gerenciadorfuncionarios.model.Funcionario;

/**
 *
 * @author Maria Eduarda de Oliveira Furini e Maria Luiza Nery Pinto
 */
public class FuncionarioDAO {
    private String fileName = "funcionarios.txt";
    private Collection<Funcionario> funcionarios = new ArrayList<>();
    
    public FuncionarioDAO() throws FileNotFoundException  {}
    
    public void init() throws FileNotFoundException {
        // Ler os funcionários já cadastrados no arquivo e armazenar na coleção

        FileReader arquivo = new FileReader(fileName);
        Scanner scanner = new Scanner(arquivo);
        
        while(scanner.hasNext()) {
            String codigo = scanner.nextLine();
            String nome = scanner.nextLine();
            double salario = Double.parseDouble(scanner.nextLine());

            funcionarios.add(new Funcionario(codigo, nome, salario));
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
        }
    }
    
    public Collection<Funcionario> index() {
        return funcionarios;    
    }
    
    public boolean store(String codigo, String nome, double salario) {
        return funcionarios.add(new Funcionario(codigo, nome, salario));
    }
        
    public Funcionario show(String code) {
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getCodigo().equals(code)){
                return funcionario;
            }
        }
        
        return null;
    }
   
    public void fileStore() throws IOException {
        // Arquivo sera excluido e criado novamente para resetar os dados
        FileWriter arquivo;
        arquivo = new FileWriter(fileName);
        
        PrintWriter out; 
        out = new PrintWriter(arquivo);

        // Gravar os funcionários da coleção no arquivo
        for(Funcionario funcionario : funcionarios) {
            out.println(funcionario);
        }
        
        // Fechar o arquivo na ordem inversa da de abertura
        out.close();
        arquivo.close();
    }
}