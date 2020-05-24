/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe para realizar a leitura/escrita em um arquivo txt.
 * @author William
 */
public class ManipularArquivo {
    
    /**
     * Para fazer a leitura do arquivo é necessário chamar o método passando o 
     * caminho do arquivo que deseje ler, somente txt, e qual o processo que será lido.
     * @param processo - (1) para o "Processo 1" ou (2) para o "Proecsso 2"
     * @param caminhoArquivo
     * @return 
     */
    public ArrayList lerDados(String caminhoArquivo, int processo){
        
        ArrayList<Processo> listProcessos = new ArrayList();
        String linha = "";
        
        try {
            FileReader reader = new FileReader(caminhoArquivo);
            BufferedReader bf = new BufferedReader(reader);
            if (processo == 1){
                linha = bf.readLine();
                while(linha != null){
                    String [] linhaLida = linha.split("\\|");
                    int id = Integer.parseInt(linhaLida[0]);
                    long qtdMemoriaSolicitada = Long.parseLong(linhaLida[1]);
                    Processo newProcesso = new Processo(id, qtdMemoriaSolicitada);
                    listProcessos.add(newProcesso);
                    linha = bf.readLine();
                }
            }else if(processo == 2){
                return null;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema com a leitura do arquivo txt, ex!");
        }
        return listProcessos;
    }
    
    /**
     * Para fazer a gravação no arquivo é necessário chamar o método passando o 
     * caminho do arquivo que deseje salvar, somente txt. Verificar qual o tipo 
     * de arquivo que precisrá salvar.    
     * @param processo - (1) para criar/escrever na leitura do priemiro processo 
     */
    public void salvarDados( int processo){
        try {
            File file = new File("..memoria.txt");
            if(file.delete()){
                
                FileWriter fw = new FileWriter("..memoria.txt");
                for (int i = 0; i < 50; i++) {
                    fw.write("X\r\n");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel apagar o arquivo memoria.txt");
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema na escrita do artquivo, ex!");
        }
    }
}
