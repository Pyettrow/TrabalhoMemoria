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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe para realizar a leitura/escrita em um arquivo txt.
 * @author William
 */
public class ManipularArquivo {
    
    /**
     * Apagar arquivos txt antigos.    
     * @param par 1 para memoria 2 para log e 3 para os dois
     */
    public void apagaTxts(int par){
        if((par == 1) || (par == 3)){
            File memoriaTxt = new File("memoria.txt");
            memoriaTxt.delete();        
        } if((par == 2) || (par == 3)){
            File logTxt = new File("log.txt");
            logTxt.delete();
        }
    }
    
    /**
     * Para fazer a leitura do arquivo é necessário chamar o método passando o 
     * caminho do arquivo que deseje ler, somente txt, e qual o processo que será lido.
     * @param processo - (1) para o "Processo 1" ou (2) para o "Proecsso 2"
     * @param caminhoArquivo
     * @return 
     */
    public ArrayList lerDados(String caminhoArquivo, int processo){
        long proximaMemoria = 500001;
        
        ArrayList<Processo> listProcessos = new ArrayList();
        String linha = "";
        
        try {
            FileReader reader = new FileReader(caminhoArquivo);
            BufferedReader bf = new BufferedReader(reader);            
            linha = bf.readLine();
            while(linha != null){
                String [] linhaLida = linha.split("\\|");
                int id = Integer.parseInt(linhaLida[0]);
                long qtdMemoriaSolicitada = Long.parseLong(linhaLida[1]);
                long inicioMemoriaAlocada = 0;
                long fimMemoriaAlocada = 0;
                /**
                 * IF para validar processo 1 e 2. Quando for 1, já adiciona 
                 * inicioMemoriaAlocada e fimMemoriaAlocada cfe os ultimos processos.
                 */
                if(processo == 1){ 
                    inicioMemoriaAlocada = proximaMemoria;
                    fimMemoriaAlocada = proximaMemoria+qtdMemoriaSolicitada;
                    proximaMemoria = fimMemoriaAlocada+10000;
                }else if(processo == 2){                    
                    inicioMemoriaAlocada = 0;
                    fimMemoriaAlocada = 0;
                }

                Processo newProcesso = new Processo(id, qtdMemoriaSolicitada, 
                        inicioMemoriaAlocada, fimMemoriaAlocada, linhaLida);
                if(processo == 1){
                    salvarDadosLog(1, "Criado processo "+newProcesso.getId()+", com "+newProcesso.getQtdMemoriaSolicitada()+"kb."
                    + " Alocado de "+newProcesso.getInicioMemoriaAlocada()+" até "+newProcesso.getFimMemoriaAlocada());
                    newProcesso.gerenciaProcesso();
                }


                listProcessos.add(newProcesso);
                linha = bf.readLine();
            }
                
                GerenciaMemoria gereMemoria = new GerenciaMemoria();
                gereMemoria.organizaMemoria();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema com a leitura do arquivo txt, ex!");
            System.out.println(ex);
        }
        return listProcessos;
    }
    
    /**
     * Salva os processos e as alocações no txt memoria
     * @param opcao 1 para os X e 2 para gravar os processos
     * @param newProcesso Passar o processo que ira salvar os dados no memoria.txt
     */
    public void salvarDadosMemoria(int opcao, Processo newProcesso){
        try {
            File file = new File("memoria.txt");
            FileWriter fw = new FileWriter(file, true);
            if(opcao == 1){
                for (int i = 0; i < 50; i++) {
                    fw.write("X\r\n");
                }
            }else if(opcao == 2){
                long memoria = 0;
                if(newProcesso != null){
                    while(memoria < newProcesso.getQtdMemoriaSolicitada()){
                        if(newProcesso.getFinalizado() == true){
                            fw.write("--------\r\n");
                        }else{
                            fw.write("10000 - "+newProcesso.getId()+"\r\n");
                        }
                        memoria += 10000;
                    }
                }
            }
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema na escrita do artquivo, ex!");
            System.out.println(ex);
        }
    }
    
    /**
     * Salvar os dados no arquivo txt LOG
     * @param operacao Enviar 1(criacao) ou 2(Ler/Escrever);
     * @param texto Enviar texto que deseja salvar
     */
    public void salvarDadosLog(int operacao, String texto){
        try {
            File file = new File("log.txt");
            FileWriter fw = new FileWriter(file,true);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            Date date = new Date();
            
            if(operacao == 1){
                fw.write(dateFormat.format(date)+": "+texto+"\r\n");
            }else if(operacao == 2){
                fw.write(dateFormat.format(date)+": "+texto+"\r\n");
            }
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema na escrita do artquivo, ex!");
            System.out.println(ex);
        }
    }
}