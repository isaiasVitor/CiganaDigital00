package view;

import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Usuario;

public class TelaPrincipal extends javax.swing.JFrame {
    public static List<Usuario> lista;
    public List<String> textoString;
    public TelaPrincipal() {
        initComponents();
        lista = new ArrayList<>();
        textoString = new ArrayList<>();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cigana Digital");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTexto.setFont(new java.awt.Font("Chiller", 0, 48)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jTexto)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jTexto)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        String texto= "";
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){ // apertando para apagar
            if(textoString.size()>0){ 
                textoString.remove(textoString.size()-1);
                for(String b : textoString){
                    texto+=b;
                    jTexto.setText(texto);
                }
            }  else jTexto.setText(texto);
        }else{
            if (((evt.getKeyCode() >= KeyEvent.VK_A && evt.getKeyCode() <= KeyEvent.VK_Z) || 
                  evt.getKeyCode() == 32) && textoString.size()< 20 ){
                char c = evt.getKeyChar();
                textoString.add(String.valueOf(c));
                for(String b : textoString){
                    texto+=b;
                    jTexto.setText(texto);
                }   
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            
            if (jTexto.getText().trim().equals("") || jTexto.getText()== null){
                JOptionPane.showMessageDialog(null, "Campo Vazio");
            }else{
                Usuario us = new Usuario(jTexto.getText().toUpperCase(),true);
                lista.add(us);
                menuPrincipal menu = new menuPrincipal();
                menu.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_formKeyPressed

    //Metodo Não vale Numero no nome
    public boolean eNumero(java.awt.event.KeyEvent evt){
        return !(evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9);
    }
    
    //Metodo Só vale Letra no Nome
    /*public boolean eLetra(java.awt.event.KeyEvent evt){
        return !((evt.getKeyCode()) >= 33 && evt.getKeyCode() <= 64 || evt.getKeyCode() >= 91 && evt.getKeyCode() <= 93 || evt.getKeyCode() >= 123 && evt.getKeyCode() <= 159 || evt.getKeyCode() >= 162 && evt.getKeyCode() <= 191);
    }
    */
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jTexto;
    // End of variables declaration//GEN-END:variables
}
