package br.unifae.engsoftware.poo3.gerenciadorFuncionarios.controller;

import br.unifae.engsoftware.poo3.gerenciadorFuncionarios.model.Funcionario;
import br.unifae.engsoftware.poo3.gerenciadorFuncionarios.model.FuncionarioDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria Eduarda de Oliveira Furini e Maria Luiza Nery Pinto
 */
public class FuncionarioController {
    FuncionarioDAO dao;
    
    public FuncionarioController(String fileName) throws FileNotFoundException {
        dao = new FuncionarioDAO(fileName);
    }
    
    public void index(JTable tabela){
        Collection<Funcionario> funcionarios = dao.index();
        
        // inicializando a tabela
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        tabela.setModel(dtm);
        dtm.setRowCount(funcionarios.size());
        
        // cadastrar na tabela
        int posicaoLinha = 0;
        for(Funcionario funcionario : funcionarios){
            cadastrarTabela(funcionario, tabela, posicaoLinha);
            posicaoLinha += 1;
        }
    }
    
    public void show(String code, JTable tabela){
        // inicializando a tabela
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        tabela.setModel(dtm);
        dtm.setRowCount(1);
        
        Funcionario funcionario = dao.show(code);
        
        // cadastrar na tabela
        cadastrarTabela(funcionario, tabela, 0);
    }
    
    public boolean create(String codigo, String nome, double salario) {
        return dao.create(codigo, nome, salario);
    }
    
    public void gravarNoArquivo() throws IOException {
        dao.gravarNoArquivo();
    }
    
    private void cadastrarTabela(Funcionario funcionario, JTable tabela, int posicaoLinha){
        tabela.setValueAt(funcionario.getCodigo(), posicaoLinha, 0);
        tabela.setValueAt(funcionario.getNome(), posicaoLinha, 0);
        tabela.setValueAt(funcionario.getSalario(), posicaoLinha, 0);
    }
}
