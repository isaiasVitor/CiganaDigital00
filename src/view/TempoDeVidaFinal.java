
package view;

import java.awt.Component;
import java.util.Date;
import java.util.Random;
import model.InputMask;
import model.Usuario;
import model.inputText;
import org.joda.time.*;
import org.joda.time.format.*;

public class TempoDeVidaFinal extends javax.swing.JFrame implements inputText {

    public TempoDeVidaFinal() {
        // variaveis locais
        String datenasc;
        DateTime dataNasc;  
        DateTime Hoje;
        Period per;
        PeriodFormatter pf;
        String morte;
        // fim variaveis locais
        // Atribuição de valores
        if(Usuario.dateRunning){
            datenasc = inputBox(this, "Digite um valor para data", "Pesquisa de data", "##/##/####");
            Usuario.dateRunning = false;
        }else{
            datenasc = Usuario.dataNascimento;
        }
        dataNasc = getAniversariante(Usuario.stringToDate(datenasc));
        Hoje = getDataAtual();
        per = new Period (dataNasc,Hoje);
        pf = new PeriodFormatterBuilder()
            .appendYears()
	    .appendSuffix (" ano, ", " anos, ")
            .appendMonths() 
            .appendSuffix (" mês, ", " meses, ")
            .appendWeeks() 
            .appendSuffix (" semana e ", " semanas e ")
            .appendDays()
            .appendSuffix (" dia ", " dias ")
            .toFormatter();
        morte = getMorte(per, Usuario.dataEspiritual);
        // fim de atribuição
        initComponents();
        //escrevendo no form
        jNome.setText(Usuario.nome);
        jIdadeEspiritual.setText(String.valueOf(Usuario.dataEspiritual));
        jIdadeUsuario.setText(pf.print(per));
        jJavivi.setText(getDiasTotais(dataNasc,Hoje));
        jMorte.setText(morte);
        // fim escrevendo no form
        // adicionando a lista
        Usuario.running = false;
        Usuario.dataNascimento=datenasc;
    }
    
    // metodos para calcular o tempo total de vida
    public String getDiasTotais(DateTime dataNasc, DateTime Hoje){
        return String.valueOf(Days.daysBetween(dataNasc,Hoje).getDays())+" Dias,   "+
               String.valueOf(Months.monthsBetween(dataNasc,Hoje).getMonths())+" Meses,   "+
               String.valueOf(Years.yearsBetween(dataNasc, Hoje).getYears())+" Anos";
    }
    
    // metodos para calcular o tempo de vida restante
    public String getMorte(Period idadeNasc , int idadeEspirital){
        String chave ;
        int valor = idadeNasc.getYears()-idadeEspirital;
        int valor1 = idadeEspirital-idadeNasc.getYears();
        Random aleatorio = new Random();
        
        if(idadeNasc.getYears()>idadeEspirital){
            switch (aleatorio.nextInt(3)+1) {
                case 1:
                    chave = " Meses";
                    break;
                case 2:
                    chave = " Anos";
                    break;
                default:
                    chave = " Dias";
                    break;
            }
            return String.valueOf(valor)+chave;
        }else{
            switch (aleatorio.nextInt(3)+1) {
                case 1:
                    chave = " Meses";
                    break;
                case 2:
                    chave = " Anos";
                    break;
                default:
                    chave = " Dias";
                    break;
            }
            return String.valueOf(valor1+chave); 
        }
    }
    
    // metodo para retornar a data de nascimento, recebe a DATA no formato Date e converte para dateTime( para usar joda-time )
    public DateTime getAniversariante(Date datenasc){
        DateTimeZone timeZone = DateTimeZone.forID("GMT");
        DateTime dateTime1 = new DateTime(datenasc,timeZone); 
        return dateTime1;
    }
    
    // metodo para pegar a data atual no formato datetime ( para usar joda-time )
    public DateTime getDataAtual(){
        DateTimeZone timeZone = DateTimeZone.forID("GMT");
        DateTime dateTime1 = new DateTime(timeZone);
        return dateTime1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jIdadeEspiritual = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jIdadeUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMorte = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jJavivi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Sua idade Espiritual é: ");

        jIdadeEspiritual.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jIdadeEspiritual.setText("xx");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Sua idade é: ");

        jIdadeUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jIdadeUsuario.setText("xx");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Ainda resta:");

        jMorte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMorte.setText("xx");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Voce Já Viveu");

        jJavivi.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jJavivi.setText("xx");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdadeEspiritual))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdadeUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMorte))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jJavivi)))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNome)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jIdadeEspiritual))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jIdadeUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jJavivi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jMorte))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jIdadeEspiritual.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        menuPrincipal mnu = new menuPrincipal();
        mnu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        menuPrincipal mnu = new menuPrincipal();
        mnu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(TempoDeVidaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TempoDeVidaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TempoDeVidaFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jIdadeEspiritual;
    private javax.swing.JLabel jIdadeUsuario;
    private javax.swing.JLabel jJavivi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jMorte;
    private javax.swing.JLabel jNome;
    // End of variables declaration//GEN-END:variables

    @Override
    public String inputBox(Component caller, String mens, String title, String mask) {
        InputMask imask = new InputMask(this, mens, title, mask);
        return imask.getResponse();
    }
}
