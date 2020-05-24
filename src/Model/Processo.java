/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Nomenclatura do processo:
 * 1|50000|-|sw,1000,1|sw,0001,49997|-|sw,1111,500|ES|lw,500
 * código|tamMemoria|NãoFazNada|;;;
 * Classe processo que terá as informações que serão lidas pelos txts
 * @author William
 */
public class Processo {
    private int id;
    private long qtdMemoriaSolicitada;
    private long inicioMemoriaAlocada;
    private long fimMemoriaAlocada;
    private boolean finalizado = false;

    public Processo(int id, long qtdMemoriaSolicitada) {
        this.id = id;
        this.qtdMemoriaSolicitada = qtdMemoriaSolicitada;
    }

    public long getFimMemoriaAlocada() {
        return fimMemoriaAlocada;
    }

    public void setFimMemoriaAlocada(long fimMemoriaAlocada) {
        this.fimMemoriaAlocada = fimMemoriaAlocada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getQtdMemoriaSolicitada() {
        return qtdMemoriaSolicitada;
    }

    public void setQtdMemoriaSolicitada(long qtdMemoriaSolicitada) {
        this.qtdMemoriaSolicitada = qtdMemoriaSolicitada;
    }

    public long getInicioMemoriaAlocada() {
        return inicioMemoriaAlocada;
    }

    public void setInicioMemoriaAlocada(long inicioMemoriaAlocada) {
        this.inicioMemoriaAlocada = inicioMemoriaAlocada;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
}
