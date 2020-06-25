/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Método para organizar o txt Processo2.txt na memoria RAM.
 * @author William
 */
public class BestFit {
    
    public ArrayList<Processo> gerenciaBest(ArrayList<Processo> memoriaRam, ArrayList<Processo> novosProcessos){
        ManipularArquivo maniArq = new ManipularArquivo();
        ArrayList<Processo> novaListaRAM = new ArrayList();
        
        Processo newProcesso = null;
        Processo processoMemoriaRam = null;
        
        boolean encontrouEspaco = false;
        int processoExcluido = 0, j = 0, i = 0;
        long menorEspacoVazio = 100000000;
        
        for (i = 0; i < novosProcessos.size(); i++) { // Pega um dos processo para ser add que veio da nova lista
            newProcesso = novosProcessos.get(i);
            
            for (j = 0; j < memoriaRam.size(); j++) { // Percorre a memoriaRAM para poder validar todos os processos
                
                processoMemoriaRam = memoriaRam.get(j);
                if(processoMemoriaRam.getFinalizado() == true){ // Verificar se o processo que esta na memoriaRAM esta finalizado, ou seja, é uma lacuna e pode ser usado.
                    
                    if((processoMemoriaRam.getQtdMemoriaSolicitada() < menorEspacoVazio) && 
                        (newProcesso.getQtdMemoriaSolicitada() <= processoMemoriaRam.getQtdMemoriaSolicitada())
                            && (processoMemoriaRam.getQtdMemoriaSolicitada() < menorEspacoVazio)){
                        menorEspacoVazio = processoMemoriaRam.getQtdMemoriaSolicitada();
                        encontrouEspaco = true;
                        processoExcluido = j;
                    }
                }
            }
            menorEspacoVazio = 100000000;
            // Valida se encontrou uma lacuna que tenha o tamanho do novo processo a ser alocado
            if(encontrouEspaco == true){
                // Se o tamanho da lacuna e do novo processo forem iguais, só irá substituir os objetos
                if(newProcesso.getQtdMemoriaSolicitada() == memoriaRam.get(processoExcluido).getQtdMemoriaSolicitada()){
                    maniArq.salvarDadosLog(1, "Criado processo "+newProcesso.getId()+", com "+newProcesso.getQtdMemoriaSolicitada()+"kb."
                + " Alocado de "+memoriaRam.get(processoExcluido).getInicioMemoriaAlocada()+" até "
                +(memoriaRam.get(processoExcluido).getFimMemoriaAlocada())+" utilizando lacuna do processo "+memoriaRam.get(processoExcluido).getId());

                    memoriaRam.get(processoExcluido).setId(newProcesso.getId());
                    memoriaRam.get(processoExcluido).setOperacao(novosProcessos.get(i).getOperacao());
                    memoriaRam.get(processoExcluido).setFinalizado(false);

                    memoriaRam.get(processoExcluido).gerenciaProcesso();
                }else if(newProcesso.getQtdMemoriaSolicitada() < memoriaRam.get(processoExcluido).getQtdMemoriaSolicitada()){ //Se o processo for menor que a lacuna, esta criando uma lita temporaria para organizar os objetos
                    for (int k = 0; k < memoriaRam.size(); k++) { // Procurando o processo que foi escolhido para substituir com o novo(Processo2.txt) e criar uma lacuna do restante
                        Processo processoMemoria = memoriaRam.get(k);
                        if(k == processoExcluido){
                            
                            Processo novoProcessoParaAlocar = new Processo(newProcesso.getId(), newProcesso.getQtdMemoriaSolicitada() 
                                    , processoMemoria.getInicioMemoriaAlocada(), (processoMemoria.getInicioMemoriaAlocada()+(newProcesso.getQtdMemoriaSolicitada()-1))
                                    , novosProcessos.get(i).getOperacao());
                            
                            maniArq.salvarDadosLog(1, "Criado processo "+novoProcessoParaAlocar.getId()+", com "+novoProcessoParaAlocar.getQtdMemoriaSolicitada()+"kb."
                            + " Alocado de "+novoProcessoParaAlocar.getInicioMemoriaAlocada()+" até "+(novoProcessoParaAlocar.getFimMemoriaAlocada())+" utilizando "
                                    + "lacuna do processo "+ processoMemoria.getId());
                            
                            novoProcessoParaAlocar.gerenciaProcesso();
                            
                            Processo lacunaDoProcessoAntigo = new Processo(processoMemoria.getId(), (processoMemoria.getQtdMemoriaSolicitada() - novoProcessoParaAlocar.getQtdMemoriaSolicitada())
                                    , (novoProcessoParaAlocar.getFimMemoriaAlocada() + 1), processoMemoria.getFimMemoriaAlocada(), null);
                            lacunaDoProcessoAntigo.finalizaProcesso();
                            
                            for (int l = 0; l < memoriaRam.size(); l++) {
                                Processo consultaProcesso = memoriaRam.get(l);
                                if(l == processoExcluido){
                                    novaListaRAM.add(novoProcessoParaAlocar);
                                    novaListaRAM.add(lacunaDoProcessoAntigo);
                                }else{
                                    novaListaRAM.add(consultaProcesso);
                                }
                            }
                                
                            memoriaRam.clear();

                            for (int m = 0; m < novaListaRAM.size(); m++) {
                                Processo trocaLista = novaListaRAM.get(m);
                                memoriaRam.add(trocaLista);
                            }
                            
                            novaListaRAM.clear();
                            processoExcluido = -1;                            
                        }
                    }
                }else{
                    System.out.println("Problema na organização do novo processo,"
                            + " problema no modo Best Fit");
                }
                encontrouEspaco = false;
            }else{
                maniArq.salvarDadosLog(2, "Processo "+newProcesso.getId()+" não foi alocado "
                        + "devido a falta de espaço na memoria");
            }            
        }
        return memoriaRam;
    }
}