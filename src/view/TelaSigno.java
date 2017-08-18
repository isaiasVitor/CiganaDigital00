package view;

import java.awt.Component;
import static jdk.nashorn.internal.objects.NativeString.charAt;
import model.InputMask;
import model.Usuario;
import model.dao.SignosDao;
import model.inputText;

public class TelaSigno extends javax.swing.JFrame implements inputText {
   
    public TelaSigno() {
       initComponents();
       String datenasc;
        if(Usuario.dateRunning){
            // variavel que recebe a data no formato STRING
            datenasc = inputBox(this, "Digite um valor para data", "Pesquisa de data", "##/##/####");
            // Salva na variavel Static datenasc no formato DD/MM/AAAA
            Usuario.dataNascimento = datenasc;
            // coloca false na dateRunning para o usuario não digitar duas vezes a data
            Usuario.dateRunning = false;
        }else{
            // caso o usuario tenha feito tempo de vida primeiro, ele busca na LISTA a data no formato STRING DD/MM/AAAA
            datenasc = Usuario.dataNascimento;
        }
        
        int dia = Integer.parseInt(charAt(datenasc, 0));
        dia = (dia * 10) + Integer.parseInt(charAt(datenasc, 1));
        
        int mes = Integer.parseInt(charAt(datenasc, 3));
        mes = (mes * 10) + Integer.parseInt(charAt(datenasc, 4));
        
        SignosDao signod = new SignosDao();
        jData.setText(signod.buscaSigno(Usuario.encontraSigno(dia, mes)));
            // jlabel pra testar a data, 
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jData = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jData.setText("jLabel1");

        jButton1.setText("Voltar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jData)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       menuPrincipal mnu = new menuPrincipal();
       mnu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

  
    
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
            java.util.logging.Logger.getLogger(TelaSigno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSigno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSigno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSigno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSigno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jData;
    // End of variables declaration//GEN-END:variables

    @Override
    public String inputBox(Component caller, String mens, String title, String mask){
        InputMask imask = new InputMask(this, mens, title, mask);
        return imask.getResponse();
    }
 
}
