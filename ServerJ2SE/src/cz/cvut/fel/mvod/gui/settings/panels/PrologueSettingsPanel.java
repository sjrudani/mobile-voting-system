/*
Copyright 2011 Radovan Murin

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

/*
 * PrologueSettingsPanel.java
 *
 * Created on 19.4.2011, 22:20:45
 */
package cz.cvut.fel.mvod.gui.settings.panels;

import com.sun.net.httpserver.*;
import cz.cvut.fel.mvod.global.GlobalSettingsAndNotifier;
import cz.cvut.fel.mvod.global.Notifiable;
import cz.cvut.fel.mvod.crypto.CertManager;
import cz.cvut.fel.mvod.prologueServer.PrologueServer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.URL;
import java.security.*;
import java.security.cert.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Radovan Murin
 */
public class PrologueSettingsPanel extends javax.swing.JPanel implements Notifiable {

    /** Creates new form PrologueSettingsPanel */
    public PrologueSettingsPanel() {
        initComponents();
        GlobalSettingsAndNotifier.singleton.addListener(this);
        notifyOfChange();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        usePrologue = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        CNField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        prologueControlBTN = new javax.swing.JToggleButton();
        enableRegistration = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        prologuePort = new javax.swing.JTextField();
        useEmbeded = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText(GlobalSettingsAndNotifier.singleton.messages.getString("prologueSettingsLabel")); // NOI18N

        usePrologue.setSelected(true);
        usePrologue.setText(GlobalSettingsAndNotifier.singleton.messages.getString("usePrologueLabel")); // NOI18N
        usePrologue.setToolTipText("Prologue je server, ktorý beží pred započatím volieb. Prezentuje základné údaje nutné pre pripojenie a umožnuje registráciu uchádzačov");
        usePrologue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usePrologueMouseClicked(evt);
            }
        });
        usePrologue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usePrologueActionPerformed(evt);
            }
        });

        jLabel2.setText(GlobalSettingsAndNotifier.singleton.messages.getString("CNLabel")); // NOI18N

        CNField.setEditable(false);
        CNField.setText(CertManager.getCN(-1));
        CNField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNFieldActionPerformed(evt);
            }
        });

        jLabel3.setText(GlobalSettingsAndNotifier.singleton.messages.getString("certFingerPLabel")); // NOI18N

        prologueControlBTN.setText(GlobalSettingsAndNotifier.singleton.messages.getString("turnOnPrologue")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, usePrologue, org.jdesktop.beansbinding.ELProperty.create("${selected}"), prologueControlBTN, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        prologueControlBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prologueControlBTNMouseClicked(evt);
            }
        });
        prologueControlBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prologueControlBTNActionPerformed(evt);
            }
        });

        enableRegistration.setSelected(true);
        enableRegistration.setText(GlobalSettingsAndNotifier.singleton.messages.getString("enableRegsLabel")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, usePrologue, org.jdesktop.beansbinding.ELProperty.create("${selected}"), enableRegistration, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        enableRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enableRegistrationMouseClicked(evt);
            }
        });
        enableRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableRegistrationActionPerformed(evt);
            }
        });

        jLabel4.setText(GlobalSettingsAndNotifier.singleton.messages.getString("portNumberLabel")); // NOI18N

        prologuePort.setText(GlobalSettingsAndNotifier.singleton.getSetting("PROLOGUE_PORT"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, usePrologue, org.jdesktop.beansbinding.ELProperty.create("${selected}"), prologuePort, org.jdesktop.beansbinding.BeanProperty.create("editable"));
        bindingGroup.addBinding(binding);

        prologuePort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prologuePortFocusLost(evt);
            }
        });

        useEmbeded.setSelected(GlobalSettingsAndNotifier.singleton.getSetting("Prologue_USEDEFAULTCERT").equals("TRUE")?true:false);
        useEmbeded.setText(GlobalSettingsAndNotifier.singleton.messages.getString("useEmbeddedLabel")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, usePrologue, org.jdesktop.beansbinding.ELProperty.create("${selected}"), useEmbeded, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        useEmbeded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                useEmbededMouseClicked(evt);
            }
        });
        useEmbeded.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                useEmbededKeyPressed(evt);
            }
        });

        jLabel5.setText(GlobalSettingsAndNotifier.singleton.messages.getString("stateLabel")); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText(GlobalSettingsAndNotifier.singleton.getSetting("prologuestate").equals("1")?"OFFLINE":"ONLINE");

        jButton1.setText(GlobalSettingsAndNotifier.singleton.messages.getString("loadCertLabel")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, useEmbeded, org.jdesktop.beansbinding.ELProperty.create("${!selected}"), jButton1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText(GlobalSettingsAndNotifier.singleton.messages.getString("defaultCertInfoLabel")); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setText(CertManager.getFingerPrint(-1));
        jTextArea1.setToolTipText(CertManager.getFingerPrint(-1));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(usePrologue)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prologuePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enableRegistration)
                            .addComponent(prologueControlBTN)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(useEmbeded)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CNField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usePrologue)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prologuePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useEmbeded)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(CNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enableRegistration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prologueControlBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void usePrologueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usePrologueActionPerformed
    }//GEN-LAST:event_usePrologueActionPerformed

    private void prologueControlBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prologueControlBTNActionPerformed
    }//GEN-LAST:event_prologueControlBTNActionPerformed

    private void enableRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableRegistrationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enableRegistrationActionPerformed

    private void usePrologueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usePrologueMouseClicked
    }//GEN-LAST:event_usePrologueMouseClicked

    private void prologuePortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prologuePortFocusLost
        try {
            int port = Integer.parseInt(prologuePort.getText());
            if (port < 0 || port > 65555) {
                throw new NumberFormatException();
            }
            GlobalSettingsAndNotifier.singleton.modifySettings("PROLOGUE_PORT", port + "", true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    GlobalSettingsAndNotifier.singleton.messages.getString("portErrorTXT"),
                    GlobalSettingsAndNotifier.singleton.messages.getString("errorLabel"),
                    JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_prologuePortFocusLost

    private void prologueControlBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prologueControlBTNMouseClicked
        if (GlobalSettingsAndNotifier.singleton.getSetting("prologuestate").equalsIgnoreCase(PrologueServer.STATE_INACTIVE + "")) {
            try {
                PrologueServer prologue = new PrologueServer();
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(PrologueSettingsPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!enableRegistration.isSelected()) {
                GlobalSettingsAndNotifier.singleton.modifySettings("prologuestate", PrologueServer.STATE_PROVIDING + "", true);
            }
        } else {
            GlobalSettingsAndNotifier.singleton.modifySettings("prologuestate", PrologueServer.STATE_INACTIVE + "", true);
        }
    }//GEN-LAST:event_prologueControlBTNMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            CertManager.changeCert(CertManager.PROLOGUE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrologueSettingsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void enableRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enableRegistrationMouseClicked
        if (!GlobalSettingsAndNotifier.singleton.getSetting("prologuestete").equals(PrologueServer.STATE_INACTIVE + "")) {
        } else {
            GlobalSettingsAndNotifier.singleton.modifySettings("prologuestate", enableRegistration.isSelected() ? PrologueServer.STATE_REGISTERING + "" : PrologueServer.STATE_PROVIDING + "", true);
        }
    }//GEN-LAST:event_enableRegistrationMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void useEmbededMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_useEmbededMouseClicked

        GlobalSettingsAndNotifier.singleton.modifySettings("Prologue_USEDEFAULTCERT", useEmbeded.isSelected() ? "TRUE" : "FALSE", true);
    }//GEN-LAST:event_useEmbededMouseClicked

    private void useEmbededKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useEmbededKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_useEmbededKeyPressed

    private void CNFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CNField;
    private javax.swing.JCheckBox enableRegistration;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton prologueControlBTN;
    private javax.swing.JTextField prologuePort;
    private javax.swing.JCheckBox useEmbeded;
    private javax.swing.JCheckBox usePrologue;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void notifyOfChange() {
       
       
        jLabel6.setText(GlobalSettingsAndNotifier.singleton.getSetting("prologuestate").equals(PrologueServer.STATE_INACTIVE + "") ? "OFFLINE" : "ONLINE");
        String pStat = GlobalSettingsAndNotifier.singleton.getSetting("prologuestate");
        if (pStat.equals(PrologueServer.STATE_INACTIVE + "")) {
            prologuePort.setEditable(true);
            prologueControlBTN.setText(GlobalSettingsAndNotifier.singleton.messages.getString("turnOnPrologue"));
            boolean b = usePrologue.isSelected();
            usePrologue.setEnabled(true);
            useEmbeded.setEnabled(true);
            jLabel6.setForeground(new java.awt.Color(255, 0, 0));
            //jButton1.setEnabled(true);
            usePrologue.setSelected(b);



        } else {
            prologuePort.setEditable(false);

            prologueControlBTN.setText(GlobalSettingsAndNotifier.singleton.messages.getString("turnOffPrologue"));
            jLabel6.setForeground(new java.awt.Color(0, 255, 0));
            usePrologue.setSelected(true);
            usePrologue.setEnabled(false);
            useEmbeded.setEnabled(false);

            //jButton1.setEnabled(false);
        }
    }
}