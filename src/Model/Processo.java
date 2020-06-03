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
    private String[] operacao;

    public Processo(int id, long qtdMemoriaSolicitada, long inicioMemoriaAlocada, long fimMemoriaAlocada, String[] operacao) {
        this.id = id;
        this.qtdMemoriaSolicitada = qtdMemoriaSolicitada;
        this.inicioMemoriaAlocada = inicioMemoriaAlocada;
        this.fimMemoriaAlocada = fimMemoriaAlocada;
        this.operacao = operacao;
    }
    
    /**
     * Realiza os processos de leitura e de escrita que os processo possuem.
     */
    public void gerenciaProcesso(){
        ManipularArquivo maniPu = new ManipularArquivo();        
        String[] detalheSetor;

        //Percorre a linha lida setor por setor. Setor é devidido pelo "|"
        for (int i = 0 ; i < this.operacao.length; i++) {
            if(i >= 2){ // Esta validando se o setor é posterior ou igual ao segundo                   
                if(this.operacao[i].contains("sw")){// Verifica se no setor tem SW
                    detalheSetor = this.operacao[i].split(",");
                    String acao = detalheSetor[0];
                    String posicao = detalheSetor[1];
                    String escrita = detalheSetor[2];

                    maniPu.salvarDadosLog(2, "Processo "+this.id+" escreveu "+escrita+
                            " na posição "+posicao);

                }else if(this.operacao[i].contains("lw")){// Verifica se no setor tem LW
                    detalheSetor = this.operacao[i].split(",");
                    maniPu.salvarDadosLog(2, "Processo "+this.id+" leu na posição "+detalheSetor[1]);
                }else if(this.operacao[i].contains("-")){// Verifica se no setor tem =
                    
                }else if(this.operacao[i].contains("ES")){// Verifica se no setor tem ES
                    maniPu.salvarDadosLog(2, "Processo "+this.id+" irá interagir com um ES.");
                    /**
                     * Quando encontrar um ES precisa coloca o processo no fim da file e
                     * esse processo e ir para o outro. Não sei oq fazer ao certo.
                     * Esse processo voltará a ser processado? <---------
                     */
                    break;
                }
                // Verifica se o setor + 1 é igual ao tamanho da linha lida, se for finaliza o processo
                if((i+1) == this.operacao.length){
                    finalizaProcesso();
                    maniPu.salvarDadosLog(2, "Processo "+this.id+" encerrado.");
                }
            }
        }
    }
    
    public void espacoLivre(){
        if(this.finalizado == true){
            
        }
    }
    
    public void finalizaProcesso(){
        this.finalizado = true;
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

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
}
