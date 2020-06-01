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
    
    public void apagaTxts(){
        File logTxt = new File("log.txt");
        File memoriaTxt = new File("memoria.txt");
        logTxt.delete();
        memoriaTxt.delete();        
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
            if (processo == 1){
                linha = bf.readLine();
                while(linha != null){
                    String [] linhaLida = linha.split("\\|");
                    int id = Integer.parseInt(linhaLida[0]);
                    long qtdMemoriaSolicitada = Long.parseLong(linhaLida[1]);
                    long inicioMemoriaAlocada = proximaMemoria;
                    long fimMemoriaAlocada = proximaMemoria+qtdMemoriaSolicitada;
                    proximaMemoria = fimMemoriaAlocada+10000;
                    
                    salvarDados(2, "Criado porcesso "+id+", com "+qtdMemoriaSolicitada+"kb."
                            + " Alocado de "+inicioMemoriaAlocada+" até "+fimMemoriaAlocada,0);
                    
                    Processo newProcesso = new Processo(id, qtdMemoriaSolicitada, 
                            inicioMemoriaAlocada, fimMemoriaAlocada);
                    
                    newProcesso.gerenciaProcesso(linhaLida);
                    
                    listProcessos.add(newProcesso);
                    linha = bf.readLine();
                }
                
                GerenciaMemoria gereMemoria = new GerenciaMemoria();
                gereMemoria.organizaMemoria();
            }else if(processo == 2){
                return null;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema com a leitura do arquivo txt, ex!");
            System.out.println(ex);
        }
        return listProcessos;
    }
    
    /**
     * Para fazer a gravação no arquivo é necessário chamar o método passando o 
     * caminho do arquivo que deseje salvar, somente txt. Verificar qual o tipo 
     * de arquivo que precisrá salvar.   
     * @param processo (1) é para mexer no arquivo memoria e (2) mexer no 
     * arquivo log
     * @param texto Enviar texto para salvar no arquivo.(Se for para o process)
     * 1 passar ID do processo
     * @param qtdMemoria Enviar somente para o PROCESSO 1, para saber quantas 
     * vezes repitir o loop de salvar a memoria
     */
    public void salvarDados(int processo, String texto, long qtdMemoria){
        try {
            if(processo == 1){
                File file = new File("memoria.txt");
                FileWriter fw = new FileWriter("memoria.txt",true);
                
                if(texto == null){
                    for (int i = 0; i < 50; i++) {
                        fw.write("X\r\n");
                    }
                }else{
                    int memoria = 0;
                    while(memoria < qtdMemoria){
                        if(texto.equals("-----")){
                            fw.write(texto+"\r\n");
                        }else{
                            fw.write("10000"+texto+"\r\n");
                        }
                        memoria += 10000;
                    }
                }
                fw.close();
            }else{
                File file = new File("log.txt");
                FileWriter fw = new FileWriter(file,true);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
                Date date = new Date();
                fw.write(dateFormat.format(date)+": "+texto+"\r\n");
                fw.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problema na escrita do artquivo, ex!");
            System.out.println(ex);
        }
    }
}