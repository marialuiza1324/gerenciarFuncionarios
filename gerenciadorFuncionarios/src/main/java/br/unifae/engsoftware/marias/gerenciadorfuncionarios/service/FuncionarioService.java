package br.unifae.engsoftware.marias.gerenciadorfuncionarios.service;

import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import br.unifae.engsoftware.marias.gerenciadorfuncionarios.model.Funcionario;

/**
 *
 * @author Maria Eduarda de Oliveira Furini e Maria Luiza Nery Pinto
 */
public class FuncionarioService {
    public static DefaultTableModel buildTable(Collection<Funcionario> funcionarios) {
        String[] columns = {"Código", "Nome", "Salário"};
        DefaultTableModel template = new DefaultTableModel(columns, 0);
        
        if (funcionarios != null) {
            for (Funcionario funcionario : funcionarios) {
                template.addRow(new Object[] {
                    funcionario.getCodigo(),
                    funcionario.getNome(),
                    funcionario.getSalario()
                });
            }
        } 
        
        return template;
    }
}
