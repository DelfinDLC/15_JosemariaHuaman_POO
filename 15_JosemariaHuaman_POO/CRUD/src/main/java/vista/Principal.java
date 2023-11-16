/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.mycompany.crud_ass.config.Conexion;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author CristhianRojas
 */
public class Principal extends javax.swing.JFrame {
    Conexion con=new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    int id;
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        listar();
    }

void listar(){
        String sql = "SELECT * FROM personas";
        try{
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
           
            Object[] persona = new Object[3];
            modelo = (DefaultTableModel) TablaDatos.getModel();
            
            while(rs.next()){
                persona[0]= rs.getInt("id");
                persona[1]= rs.getString("nombre");
                persona[2]= rs.getString("dni");
                modelo.addRow(persona);
            }
            TablaDatos.setModel(modelo);
        }catch(Exception e){
    
        }
    }
    
    void Agregar(){
        String nom = txtNom.getText();
        String dni = txtDni.getText();
    
        if(dni.equals("")||nom.equals("")){
            JOptionPane.showMessageDialog(null,"Las cajas estan vacias");
        }else{
            String sql = "INSERt INTO personas (nombre,dni) values ('"+nom+"','"+dni+"')";
            
            try{
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            
            }catch(Exception e){
            }
           
        }
    }
    void limpiar(){
        for(int i = 0 ; i<=TablaDatos.getRowCount(); i++){
            modelo.removeRow(i);
            i--;
        }
        
    }
    
    void modificar(){
        
        String nom = txtNom.getText();
        String dni = txtDni.getText();
        
        
         String sql ="UPDATE personas set nombre ='"+nom+"' , dni='"+dni+"' WHERE id= "+id ;
        if( dni.equals("")||nom.equals("")){
        
        JOptionPane.showMessageDialog(null,"Ingresar datos");
        }else{
           
            try{
              
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Usuario Actualizado");
            
            limpiar();
            
            }catch(Exception e){
                System.out.println(e);  
            }
        
        }
    }

    void Eliminar() {
        String sql = "delete from personas where id=" + id;
        int fila = TablaDatos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Usuario no Seleccionado");
        } else {
            try {
                cn = con.getConnection();
                st = cn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                limpiarTabla(modelo);

            } catch (Exception e) {
            }

        }

    }

    void nuevo() {
        txtId.setText("");
        txtDni.setText("");
        txtNom.setText("");
        txtDni.requestFocus();
    }

    void limpiarTabla(DefaultTableModel modelo) {
        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    void Actualizar() {
        limpiarTabla(modelo);
        listar();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        btnAgre = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        btnElim = new javax.swing.JButton();
        btnNue = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("DNI:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("NOMBRE:");

        txtId.setBackground(new java.awt.Color(204, 255, 255));

        txtDni.setBackground(new java.awt.Color(204, 255, 255));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        txtNom.setBackground(new java.awt.Color(204, 255, 255));

        btnAgre.setBackground(new java.awt.Color(0, 255, 153));
        btnAgre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgre.setText("AGREGAR");
        btnAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreActionPerformed(evt);
            }
        });

        btnMod.setBackground(new java.awt.Color(0, 255, 153));
        btnMod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMod.setText("MODIFICAR");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnElim.setBackground(new java.awt.Color(0, 255, 153));
        btnElim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnElim.setText("ELIMINAR");
        btnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimActionPerformed(evt);
            }
        });

        btnNue.setBackground(new java.awt.Color(0, 255, 153));
        btnNue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNue.setText("NUEVO");
        btnNue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("CRUD - APLICATION");
        jLabel1.setToolTipText("");

        TablaDatos.setBackground(new java.awt.Color(0, 255, 255));
        TablaDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dni"
            }
        ));
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaDatos);
        if (TablaDatos.getColumnModel().getColumnCount() > 0) {
            TablaDatos.getColumnModel().getColumn(0).setMinWidth(40);
            TablaDatos.getColumnModel().getColumn(0).setPreferredWidth(40);
            TablaDatos.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgre)
                        .addGap(18, 18, 18)
                        .addComponent(btnMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElim)
                        .addGap(18, 18, 18)
                        .addComponent(btnNue))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgre)
                    .addComponent(btnMod)
                    .addComponent(btnElim)
                    .addComponent(btnNue))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreActionPerformed
       Agregar();
       listar();
    }//GEN-LAST:event_btnAgreActionPerformed

    private void btnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimActionPerformed
        Eliminar();
        listar();
    }//GEN-LAST:event_btnElimActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        modificar();
        listar();
    }//GEN-LAST:event_btnModActionPerformed

    private void btnNueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueActionPerformed
        nuevo();
        listar();
    }//GEN-LAST:event_btnNueActionPerformed

    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMouseClicked
        int fila = TablaDatos.getSelectedRow();
        if(fila== -1){
        
         JOptionPane.showMessageDialog(null, "Usuario no seleccionado ");
        }
        else{
            
        id = Integer.parseInt((String)TablaDatos.getValueAt(fila,0).toString());
        String nom = (String)TablaDatos.getValueAt(fila,1);
        String dni = (String)TablaDatos.getValueAt(fila,2);
        
        txtId.setText(""+id);
        txtNom.setText(nom);
        txtDni.setText(dni);
    }//GEN-LAST:event_TablaDatosMouseClicked
   }
   

    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDatos;
    private javax.swing.JButton btnAgre;
    private javax.swing.JButton btnElim;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnNue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
