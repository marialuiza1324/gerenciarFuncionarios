package br.unifae.engsoftware.marias.gerenciadorfuncionarios.controller;

import br.unifae.engsoftware.marias.gerenciadorfuncionarios.dao.FuncionarioDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import br.unifae.engsoftware.marias.gerenciadorfuncionarios.model.Funcionario;
import br.unifae.engsoftware.marias.gerenciadorfuncionarios.service.FuncionarioService;

/**
 *
 * @author Maria Eduarda de Oliveira Furini e Maria Luiza Nery Pinto
 */
public class FuncionarioController {
    private static FuncionarioDAO dao = null;
    
    public FuncionarioController() throws FileNotFoundException {
        if (dao == null) {
            dao = new FuncionarioDAO();
            dao.init(); 
        }
    }
    public Collection<Funcionario> index(){
        return dao.index();
    }
    
    public boolean store(String codigo, String nome, double salario) {
        return dao.store(codigo, nome, salario);
    }
        
    public Collection<Funcionario> show(String code) {
        Funcionario funcionario = dao.show(code);
        
        if (funcionario != null) {
            Collection<Funcionario> funcionarios = new ArrayList<>();
            funcionarios.add(funcionario);
            
            return funcionarios;
        }  
        
        return null;
    }
    
    public void fileStore() throws IOException {
        dao.fileStore();
    }
    
    public DefaultTableModel buildTable(Collection<Funcionario> funcionarios) {
        if (funcionarios == null) {
            return FuncionarioService.buildTable(this.index());
        }
        
        return FuncionarioService.buildTable(funcionarios);
    }
}