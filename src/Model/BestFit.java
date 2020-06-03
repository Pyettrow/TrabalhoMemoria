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
    
    public void gerenciaBest(ArrayList<Processo> memoriaRam, ArrayList<Processo> novosProcessos){
        ManipularArquivo maniArq = new ManipularArquivo();
        
        Processo newProcesso = null;
        Processo processoMemoriaRam = null;
        
        boolean encontrouEspaco = false;
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
            if(encontrouEspaco == true){
                if(newProcesso.getQtdMemoriaSolicitada() == memoriaRam.get(processoExcluido).getQtdMemoriaSolicitada()){
                    maniArq.salvarDadosLog(1, "Criado processo "+newProcesso.getId()+", com "+newProcesso.getQtdMemoriaSolicitada()+"kb."
                + " Alocado de "+memoriaRam.get(processoExcluido).getInicioMemoriaAlocada()+" até "
                +memoriaRam.get(processoExcluido).getFimMemoriaAlocada()+" utilizando lacuna do processo "+memoriaRam.get(processoExcluido).getId());

                    memoriaRam.get(processoExcluido).setId(newProcesso.getId());                            
                    memoriaRam.get(processoExcluido).setFinalizado(false);

                    encontrouEspaco = false;
                    newProcesso.gerenciaProcesso();
                }else if(newProcesso.getQtdMemoriaSolicitada() < memoriaRam.get(processoExcluido).getQtdMemoriaSolicitada()){
                    
                }else{
                    System.out.println("Problema na organização do novo processo,"
                            + " problema no modo Best Fit");
                }
            }else{
                maniArq.salvarDadosLog(2, "Processo "+newProcesso.getId()+" não foi alocado "
                        + "devido a falta de espaço na memoria");
            }            
        }
    }
}
