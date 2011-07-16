/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TransicionPanel.java
 *
 * Created on 19/02/2010, 12:42:21 AM
 */

package org.edisoncor.gui.varios;

import com.sun.animation.transitions.ScreenTransition;
import com.sun.animation.transitions.TransitionTarget;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author edisoncor
 */
public class TransicionHorzontal extends javax.swing.JPanel implements TransitionTarget{

    private ScreenTransition transitionPanel;
    private int index = -1;
    private Vector<JPanel> paneles;
    private int delay = 1000;
    private boolean navegadorVisible=true;
    private int desde = 0;
    private int hasta = 0;

    /** Creates new form TransicionPanel */
    public TransicionHorzontal() {
        initComponents();
        paneles = new Vector<JPanel>();
        transitionPanel = new ScreenTransition(panel, this);
        setNavegadorVisible(false);
    }

    public void addPanel(JPanel panel){
        if(paneles.isEmpty()){
            index=0;
            this.panel.add(panel);
            panel.setBounds(0, 0, this.panel.getWidth(), this.panel.getHeight());
        }else{
            int i = paneles.size();
            this.panel.add(panel);
            panel.setBounds(this.panel.getWidth()*i, 0, this.panel.getWidth(), this.panel.getHeight());
        }
        paneles.add(panel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new org.edisoncor.gui.panel.Panel();
        panelBotones = new org.edisoncor.gui.panel.Panel();
        btnDerecha = new org.edisoncor.gui.button.ButtonRect();
        btnIzquierda = new org.edisoncor.gui.button.ButtonRect();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        panel.setLayout(null);
        add(panel, java.awt.BorderLayout.CENTER);

        btnDerecha.setBackground(new java.awt.Color(32, 39, 55));
        btnDerecha.setText(">>");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        btnIzquierda.setBackground(new java.awt.Color(32, 39, 55));
        btnIzquierda.setText("<<");
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDerecha, 0, 0, Short.MAX_VALUE)
            .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)
        );

        add(panelBotones, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        izquierda();
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        derecha();
    }//GEN-LAST:event_btnDerechaActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        presionar(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        soltar(evt);
    }//GEN-LAST:event_formMouseReleased

    public void presionar(java.awt.event.MouseEvent evt){
        if(evt.getButton()==1)
            desde = evt.getX();
        else
            desde =0;
    }

    public void soltar(java.awt.event.MouseEvent evt){
        if(evt.getButton()==1){
            hasta = evt.getX();
            if ((desde - hasta >= 50) & (desde > hasta))
                derecha();
            else if ((hasta - desde >= 50) & (desde < hasta))
                izquierda();
        }
    }

    public void izquierda(){
        if(index>0){
            index=index-1;
            transitionPanel.startTransition(delay);
        }
    }

    public void derecha(){
        if(index<paneles.size()-1){
            index=index+1;
            transitionPanel.startTransition(delay);
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnDerecha;
    private org.edisoncor.gui.button.ButtonRect btnIzquierda;
    private org.edisoncor.gui.panel.Panel panel;
    private org.edisoncor.gui.panel.Panel panelBotones;
    // End of variables declaration//GEN-END:variables

    public void resetCurrentScreen() {
        panel.removeAll();
    }

    public void setupNextScreen() {
        int i = index*-1;
        for (JPanel jPanel : paneles) {
            panel.add(jPanel);
            jPanel.setBounds(this.panel.getWidth()*i++, 0, this.panel.getWidth(), this.panel.getHeight());
        }
        
    }

    public void transitionComplete() {
    }

    public boolean isNavegadorVisible() {
        return navegadorVisible;
    }

    public void setNavegadorVisible(boolean navegadorVisible) {
        this.navegadorVisible = navegadorVisible;
        panelBotones.setVisible(navegadorVisible);
        btnDerecha.setVisible(navegadorVisible);
        btnIzquierda.setVisible(navegadorVisible);
    }


}
