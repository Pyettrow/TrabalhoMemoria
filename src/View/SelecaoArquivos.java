/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.BestFit;
import Model.ManipularArquivo;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author William
 */
public class SelecaoArquivos extends javax.swing.JFrame {
    
    // Criano array que irá referencia a memória
    ArrayList<Model.Processo> memoriaRAM = new ArrayList();
    
    public SelecaoArquivos() {
        initComponents();        
        
        // Desabilitando os campos do segundo arquivo
        jTFCaminhoArquivo.setEditable(false);
        jTFCaminhoArquivo2.setEditable(false);
        jTFCaminhoArquivo2.setEnabled(false);
        jBSelecionarArquivo2.setEnabled(false);
        jBProcessaArquivo2.setEnabled(false);
        jBVoltar.setEnabled(false);
        jRBBest.setEnabled(false);
        jRBCircular.setEnabled(false);
        jRBFifo.setEnabled(false);
        jRBWorst.setEnabled(false);
        
        // Adicionando os RadionButtons ao RadioGroup
        buttonGroup1.add(jRBFifo);
        buttonGroup1.add(jRBBest);
        buttonGroup1.add(jRBWorst);
        buttonGroup1.add(jRBCircular);
        
        // Apagando arquivos para não manter info duplicados
        Model.ManipularArquivo manip = new Model.ManipularArquivo();
        manip.apagaTxts();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jBSelecionarArquivo = new javax.swing.JButton();
        jBPorcessaArquivo1 = new javax.swing.JButton();
        jTFCaminhoArquivo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBSelecionarArquivo2 = new javax.swing.JButton();
        jBProcessaArquivo2 = new javax.swing.JButton();
        jTFCaminhoArquivo2 = new javax.swing.JTextField();
        jBVoltar = new javax.swing.JButton();
        jRBFifo = new javax.swing.JRadioButton();
        jRBBest = new javax.swing.JRadioButton();
        jRBWorst = new javax.swing.JRadioButton();
        jRBCircular = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Memória");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Primeiro arquivo entrada"));

        jBSelecionarArquivo.setText("...");
        jBSelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarArquivoActionPerformed(evt);
            }
        });

        jBPorcessaArquivo1.setText("Processar");
        jBPorcessaArquivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPorcessaArquivo1ActionPerformed(evt);
            }
        });

        jTFCaminhoArquivo.setToolTipText("Selecione o arquivo para ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTFCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jBPorcessaArquivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBPorcessaArquivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Segundo arquivo entrada"));

        jBSelecionarArquivo2.setText("...");
        jBSelecionarArquivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarArquivo2ActionPerformed(evt);
            }
        });

        jBProcessaArquivo2.setText("Processar");
        jBProcessaArquivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcessaArquivo2ActionPerformed(evt);
            }
        });

        jTFCaminhoArquivo2.setToolTipText("Selecione o arquivo para ");

        jBVoltar.setText("<-");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jRBFifo.setText("First-Fit");

        jRBBest.setText("Best-Fit");

        jRBWorst.setText("Worst-Fit");

        jRBCircular.setText("Circular-Fit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBVoltar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFCaminhoArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBSelecionarArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRBFifo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jBProcessaArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jRBBest)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBWorst)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBCircular)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jBVoltar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCaminhoArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSelecionarArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBFifo)
                    .addComponent(jRBBest)
                    .addComponent(jRBWorst)
                    .addComponent(jRBCircular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBProcessaArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botão que chama a tela para selecionar o arquivo TXT.
     * @param evt 
     */
    private void jBSelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarArquivoActionPerformed
        
        Model.SelecionarArquivo selecionarArquivo = new Model.SelecionarArquivo();
        File localArquivo = selecionarArquivo.localizarArquivo();
        jTFCaminhoArquivo.setText(localArquivo.toString());
        
    }//GEN-LAST:event_jBSelecionarArquivoActionPerformed

    /**
     * Aqui realiza o tratamento do primeiro botão de processar, que é composto 
     * pela classe para manipular o arquivo, para realizar a leitura do txt e 
     * criação dos processos no txt memória.
     * @param evt 
     */
    private void jBPorcessaArquivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPorcessaArquivo1ActionPerformed
        if(!jTFCaminhoArquivo.getText().isEmpty()){
            
            Model.ManipularArquivo manu = new Model.ManipularArquivo();
            manu.salvarDadosMemoria(null); // Salvando os processos "X" no txt memoria
            
            String localArquivo = jTFCaminhoArquivo.getText(); // Lendo os processos do Processo1.txt e salvando no log.txt e memoria.txt
            memoriaRAM = manu.lerDados(localArquivo, 1);
            
            atualizaMemoriaTxt();
            
            JOptionPane.showMessageDialog(this, "Arquivo processado!");
            
            //Bloqueando os campos da primeira etapa
            jTFCaminhoArquivo.setEnabled(false);
            jBSelecionarArquivo.setEnabled(false);
            jBPorcessaArquivo1.setEnabled(false);
            
            //Liberando os itens do segundo arquivo.
            jTFCaminhoArquivo2.setEnabled(true);
            jBSelecionarArquivo2.setEnabled(true);
            jBProcessaArquivo2.setEnabled(true);
            jBVoltar.setEnabled(true);
            jRBBest.setEnabled(true);
            jRBCircular.setEnabled(true);
            jRBFifo.setEnabled(true);
            jRBWorst.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o TXT de entrada.");
            jBSelecionarArquivo.requestFocus();
        }
    }//GEN-LAST:event_jBPorcessaArquivo1ActionPerformed

    private void jBSelecionarArquivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarArquivo2ActionPerformed
        Model.SelecionarArquivo select = new Model.SelecionarArquivo();
        Model.ManipularArquivo manu = new ManipularArquivo();
        
        File localArquivo = select.localizarArquivo();
        jTFCaminhoArquivo2.setText(localArquivo.toString());        
        
    }//GEN-LAST:event_jBSelecionarArquivo2ActionPerformed

    private void jBProcessaArquivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcessaArquivo2ActionPerformed
        if(!jTFCaminhoArquivo2.getText().isEmpty()){
            if(jRBFifo.isSelected()){
                JOptionPane.showMessageDialog(null, "Adicionar modo FIFO - Cicero");
            }else if(jRBBest.isSelected()){
                
                Model.ManipularArquivo maniArq = new ManipularArquivo();
                ArrayList<Model.Processo> novosProcessos = maniArq.lerDados(jTFCaminhoArquivo2.getText().toString(), 2);
                
                Model.BestFit best = new Model.BestFit();
                best.gerenciaBest(memoriaRAM, novosProcessos);
                
            }else if(jRBWorst.isSelected()){
                JOptionPane.showMessageDialog(null, "Adicionar modo WORST - Wililam");
            }else if(jRBCircular.isSelected()){
                JOptionPane.showMessageDialog(null, "Adicionar modo CIRCULAR - Cicero");
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um modo de gerenciamente de memória.");
            }
            
            JOptionPane.showMessageDialog(this, "Arquivo processado!");
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o TXT de entrada.");
            jBSelecionarArquivo2.requestFocus();
        }
    }//GEN-LAST:event_jBProcessaArquivo2ActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        jTFCaminhoArquivo.setEnabled(true);
        jBSelecionarArquivo.setEnabled(true);
        jBPorcessaArquivo1.setEnabled(true);

        jTFCaminhoArquivo2.setEnabled(false);
        jBSelecionarArquivo2.setEnabled(false);
        jBProcessaArquivo2.setEnabled(false);
        jBVoltar.setEnabled(false);
        jRBBest.setEnabled(false);
        jRBCircular.setEnabled(false);
        jRBFifo.setEnabled(false);
        jRBWorst.setEnabled(false);
        jTFCaminhoArquivo2.setText("");
    }//GEN-LAST:event_jBVoltarActionPerformed

    // Atualizando o memoria.txt, pois foi processado o memoriaRAM e criado as lacunas
    public void atualizaMemoriaTxt(){
        Model.ManipularArquivo maniPu = new Model.ManipularArquivo();
        for (int i = 0; i < memoriaRAM.size(); i++) {
            Model.Processo pro = memoriaRAM.get(i);
            maniPu.salvarDadosMemoria(pro);            
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecaoArquivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBPorcessaArquivo1;
    private javax.swing.JButton jBProcessaArquivo2;
    private javax.swing.JButton jBSelecionarArquivo;
    private javax.swing.JButton jBSelecionarArquivo2;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRBBest;
    private javax.swing.JRadioButton jRBCircular;
    private javax.swing.JRadioButton jRBFifo;
    private javax.swing.JRadioButton jRBWorst;
    private javax.swing.JTextField jTFCaminhoArquivo;
    private javax.swing.JTextField jTFCaminhoArquivo2;
    // End of variables declaration//GEN-END:variables
}
