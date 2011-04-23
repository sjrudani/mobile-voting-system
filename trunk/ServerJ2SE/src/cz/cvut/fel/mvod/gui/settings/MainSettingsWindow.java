/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainSettingsWindow.java
 *
 * Created on 19.4.2011, 21:39:43
 */
package cz.cvut.fel.mvod.gui.settings;

import cz.cvut.fel.mvod.global.GlobalSettingsAndNotifier;
import cz.cvut.fel.mvod.global.Notifiable;
import cz.cvut.fel.mvod.prologueServer.PrologueServer;
import cz.cvut.fel.mvod.prologueServer.RegistrantAuthorisationWindow;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murko
 */
public class MainSettingsWindow extends javax.swing.JFrame implements Notifiable {

    /** Creates new form MainSettingsWindow */
    public MainSettingsWindow() {
        initComponents();
        notifyOfChange();
        GlobalSettingsAndNotifier.singleton.addListener(this);
        

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        globalSettingsPanel1 = new cz.cvut.fel.mvod.gui.settings.panels.GlobalSettingsPanel();
        iPFilterPanel1 = new cz.cvut.fel.mvod.gui.settings.panels.IPFilterPanel();
        prologueSettingsPanel1 = new cz.cvut.fel.mvod.gui.settings.panels.PrologueSettingsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("MessagesBundle"); // NOI18N
        jTabbedPane1.addTab(bundle.getString("mainSetLabel"), globalSettingsPanel1); // NOI18N
        jTabbedPane1.addTab(bundle.getString("IPFiltrationLabel"), iPFilterPanel1); // NOI18N

        prologueSettingsPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prologueSettingsPanel1MouseClicked(evt);
            }
        });
        jTabbedPane1.addTab(bundle.getString("prologueLabel"), prologueSettingsPanel1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName(bundle.getString("mainSetLabel")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prologueSettingsPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prologueSettingsPanel1MouseClicked
        PrologueServer prologueServer = null;
        try {
            prologueServer = new PrologueServer();
        } catch (IOException ex) {
            Logger.getLogger(MainSettingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainSettingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(MainSettingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(MainSettingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(MainSettingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(MainSettingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
       // RegistrantAuthorisationWindow r = new RegistrantAuthorisationWindow(prologueServer);
    }//GEN-LAST:event_prologueSettingsPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainSettingsWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cz.cvut.fel.mvod.gui.settings.panels.GlobalSettingsPanel globalSettingsPanel1;
    private cz.cvut.fel.mvod.gui.settings.panels.IPFilterPanel iPFilterPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private cz.cvut.fel.mvod.gui.settings.panels.PrologueSettingsPanel prologueSettingsPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void notifyOfChange() {
        jTabbedPane1.setEnabledAt(1, false);

        if (GlobalSettingsAndNotifier.singleton.getSetting("NET_ORIGIN").equalsIgnoreCase("USE_ADVANCED")) {
            jTabbedPane1.setEnabledAt(1, true);
        }
    }
}
