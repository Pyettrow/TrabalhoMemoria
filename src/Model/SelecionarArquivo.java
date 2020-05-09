/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe para realizar a seleção do arquivo, retorna uma string do tipo File
 * com o caminho do arquivo selecionado.
 * @author William
 */
public class SelecionarArquivo {
    public File localizarArquivo(){
        
        File localArquivo = null;
        JFileChooser escArquivo = new JFileChooser();
        escArquivo.setDialogTitle("Selecione o caminho do arquivo:");//Dando nome para a tela
        escArquivo.setFileSelectionMode(escArquivo.FILES_ONLY);//Escolhendo se ira aceitar diretorio ou arquivo(Nesse caso é só arquivos(Files_Only))
        FileNameExtensionFilter filtroArq = new FileNameExtensionFilter(null, "txt");//Escolhendo o tipo de arquivo para ser selecionado
        escArquivo.setFileFilter(filtroArq);//Setando o filtro na janela de "Escolher Arquivo"
        int retorno = escArquivo.showOpenDialog(null);//Pegando o click do botão na janela, tratando o "Selecionar" do "Cancelar"
        if(retorno == JFileChooser.APPROVE_OPTION){
            localArquivo = escArquivo.getSelectedFile();//Pegando o caminho do arquivo
        }
        return localArquivo;
    }
}
