/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author William
 */
public class BestFit {
    
    public ArrayList<Processo> gerenciaBest(ArrayList<Processo> memoriaRam, ArrayList<Processo> novosProcessos){
        ManipularArquivo maniArq = new ManipularArquivo();
        ArrayList<Processo> novaListaRAM = new ArrayList();
        
        Processo newProcesso = null;
        Processo processoMemoriaRam = null;
        
        boolean encontrouEspaco = false, criouNovaLista= false;
        int processoExcluido = 0, j = 0;
        int menorEspacoVazio = 100000000;
        
        for (int i = 0; i < novosProcessos.size(); i++) { // Pega um dos processo para ser add que veio da nova lista
            newProcesso = novosProcessos.get(i);
            
            for (j = 0; j < memoriaRam.size(); j++) { // Percorre a memoriaRAM para poder validar todos os processos
                
                processoMemoriaRam = memoriaRam.get(j);
                if(processoMemoriaRam.getFinalizado() == true){ // Verificar se o processo que esta na memoriaRAM esta finalizado, ou seja, é uma lacuna e pode ser usado.
                    
                    if((processoMemoriaRam.getQtdMemoriaSolicitada() < menorEspacoVazio) && 
                        (newProcesso.getQtdMemoriaSolicitada() <= processoMemoriaRam.getQtdMemoriaSolicitada())){
                        encontrouEspaco = true;
                        processoExcluido = j;
                    }
                }
            }
            // Valida se encontrou uma lacuna que tenha o tamanho do novo processo a ser alocado
            if(encontrouEspaco == true){
                // Se o tamanho da lacuna e do novo processo forem iguais, só irá substituir os objetos
                if(newProcesso.getQtdMemoriaSolicitada() == memoriaRam.get(processoExcluido).getQtdMemoriaSolicitada()){
                    maniArq.salvarDadosLog(1, "Criado processo "+newProcesso.getId()+", com "+newProcesso.getQtdMemoriaSolicitada()+"kb."
                + " Alocado de "+memoriaRam.get(processoExcluido).getInicioMemoriaAlocada()+" até "
                +memoriaRam.get(processoExcluido).getFimMemoriaAlocada()+" utilizando lacuna do processo "+memoriaRam.get(processoExcluido).getId());

                    memoriaRam.get(processoExcluido).setId(newProcesso.getId());                            
                    memoriaRam.get(processoExcluido).setFinalizado(false);

                    newProcesso.gerenciaProcesso();
                }else if(newProcesso.getQtdMemoriaSolicitada() < memoriaRam.get(processoExcluido).getQtdMemoriaSolicitada()){ //Se o processo for menor que a lacuna, esta criando uma lita temporaria para organzar os objetos
                    for (int k = 0; k < memoriaRam.size(); k++) {
                        Processo processoMemoria = memoriaRam.get(k);
                        if(processoMemoria.getId() == memoriaRam.get(processoExcluido).getId()){
                            
                            Processo novoProcessoParaAlocar = new Processo(newProcesso.getId(), newProcesso.getQtdMemoriaSolicitada() 
                                    , newProcesso.getInicioMemoriaAlocada(), (processoMemoria.getFimMemoriaAlocada()-newProcesso.getFimMemoriaAlocada())
                                    , null);
                            novaListaRAM.add(novoProcessoParaAlocar);
                            
                            Processo lacunaDoProcessoAntigo = new Processo(0, (newProcesso.getFimMemoriaAlocada() - processoMemoriaRam.getFimMemoriaAlocada())
                                    , (newProcesso.getFimMemoriaAlocada() + 10000), processoMemoriaRam.getFimMemoriaAlocada(), null);
                            lacunaDoProcessoAntigo.finalizaProcesso();
                            novaListaRAM.add(lacunaDoProcessoAntigo);
                            
                            criouNovaLista = true;
                        }
                    }
                }else{
                    System.out.println("Problema na organização do novo processo,"
                            + " problema no modo Best Fit");
                }
            }else{
                maniArq.salvarDadosLog(2, "Processo "+newProcesso.getId()+" não foi alocado "
                        + "devido a falta de espaço na memoria");
            }
            encontrouEspaco = false;
        }
        
        if(criouNovaLista == true){
            memoriaRam.clear();
        
            for (int i = 0; i < novaListaRAM.size(); i++) {
                memoriaRam.add(novaListaRAM.get(i));
            }
        }
        return memoriaRam;
    }
}
