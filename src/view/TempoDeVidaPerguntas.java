package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Perguntas;
import model.dao.PerguntasDao;

public class TempoDeVidaPerguntas extends javax.swing.JFrame  {

    public TempoDeVidaPerguntas() {
        initComponents();
        pgt = new ArrayList<>();
        readPerguntas();
        mudaPergunta();
    }
    List<Perguntas> pgt;
    int contador=0;
    int soma = 0;
    int random;

    public void readPerguntas(){
        PerguntasDao receba = new PerguntasDao();
        pgt= receba.read();
    }
    
    public void mudaPergunta(){
        jrdioC.setVisible(true);
        jrdioD.setVisible(true);
        
        Random rnd = new Random();
        random = rnd.nextInt(4);
        
        if(pgt.get(random).getAlternativaC()==null){
            jrdioC.setVisible(false);
        }
        
        if(pgt.get(random).getAlternativaD() == null){
            jrdioD.setVisible(false);
        }
        
        jtxtPergunta.setText(pgt.get(random).getPergunta());
        jrdioA.setText(pgt.get(random).getAlternativaA());
        jrdioB.setText(pgt.get(random).getAlternativaB());
        jrdioC.setText(pgt.get(random).getAlternativaC());
        jrdioD.setText(pgt.get(random).getAlternativaD());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtPergunta = new javax.swing.JTextArea();
        jrdioA = new javax.swing.JRadioButton();
        jrdioB = new javax.swing.JRadioButton();
        jrdioC = new javax.swing.JRadioButton();
        jrdioD = new javax.swing.JRadioButton();
        jBtnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 266));
        setMinimumSize(new java.awt.Dimension(400, 266));
        setResizable(false);

        jtxtPergunta.setEditable(false);
        jtxtPergunta.setColumns(20);
        jtxtPergunta.setLineWrap(true);
        jtxtPergunta.setRows(5);
        jScrollPane1.setViewportView(jtxtPergunta);

        buttonGroup1.add(jrdioA);
        jrdioA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrdioAMouseClicked(evt);
            }
        });

        buttonGroup1.add(jrdioB);
        jrdioB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrdioAMouseClicked(evt);
            }
        });

        buttonGroup1.add(jrdioC);
        jrdioC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrdioAMouseClicked(evt);
            }
        });

        buttonGroup1.add(jrdioD);
        jrdioD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrdioAMouseClicked(evt);
            }
        });

        jBtnVoltar.setText("Desistir");
        jBtnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnVoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrdioA)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrdioD)
                            .addComponent(jrdioB)
                            .addComponent(jrdioC))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jBtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdioA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrdioB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrdioC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrdioD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jrdioAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrdioAMouseClicked
        if(contador == 30){
            TelaPrincipal.lista.get(0).setDataEspiritual(soma);
            TempoDeVidaFinal tmpvdfinal = new TempoDeVidaFinal();
            tmpvdfinal.setVisible(true);       
            this.dispose();
        } else{
            if(jrdioA.isSelected()){
               soma += pgt.get(random).getValorA();
               mudaPergunta();   
            }else if(jrdioB.isSelected()){
                soma += pgt.get(random).getValorB();
                mudaPergunta();    
                }else if(jrdioC.isSelected()){
                    soma+= pgt.get(random).getValorC();
                    mudaPergunta();
                    }else if(jrdioD.isSelected()){
                        soma+= pgt.get(random).getValorD();
                        mudaPergunta();
                    }  
            contador++;
        }    
    }//GEN-LAST:event_jrdioAMouseClicked

    private void jBtnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnVoltarMouseClicked
        TempoDeVida tmp = new TempoDeVida();
        tmp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnVoltarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TempoDeVidaPerguntas().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrdioA;
    private javax.swing.JRadioButton jrdioB;
    private javax.swing.JRadioButton jrdioC;
    private javax.swing.JRadioButton jrdioD;
    private javax.swing.JTextArea jtxtPergunta;
    // End of variables declaration//GEN-END:variables
}
