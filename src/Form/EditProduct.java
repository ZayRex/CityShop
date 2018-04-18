/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import shoplog.Clothing;
import shoplog.DBHandler;
import shoplog.FootWear;
import shoplog.Product;
import shoplog.Staff;

/**
 * Date 17/04/2018
 * @author Mohamad Harah
 */
public class EditProduct extends javax.swing.JFrame {
    
    private Staff loggedInStaff;
    private Product selectedProduct;
    /**
     * Creates new form EditProduct
     * @param staffIn
     * @param product
     */
    public EditProduct(Staff staffIn, Product product) {
        loggedInStaff = staffIn;
        selectedProduct = product;
        initComponents();
        
        txtId.setText(String.valueOf(selectedProduct.getProductId()));
        txtId.setEnabled(false);
        
        txtName.setText(selectedProduct.getProductName());
        txtPrice.setText(String.valueOf(selectedProduct.getPrice()));
        txtStockLevel.setText(String.valueOf(selectedProduct.getStockLevel()));
        
        if(selectedProduct.getClass().getName().equals("shoplog.Clothing"))
        {
            Clothing selectedCl = (Clothing)selectedProduct;
            lblAdditional.setText("Measurement:");
            txtAdditional.setText(selectedCl.getMeasurement());
        }
        else
        {
            FootWear selectedFW = (FootWear)selectedProduct;
            lblAdditional.setText("Size:");
            txtAdditional.setText(String.valueOf(selectedFW.getSize()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStockLevel = new javax.swing.JLabel();
        lblAdditional = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtStockLevel = new javax.swing.JTextField();
        txtAdditional = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Edit Product Details ");

        jLabel3.setText("Name:");

        jLabel4.setText("Price:        £");

        lblStockLevel.setText("Stock Level:");

        lblAdditional.setText("additional");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear Changes");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnReturn.setText("Return to product Selected");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel7.setText("ID:");

        lblMessage.setText("........");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAdditional)
                                    .addComponent(lblStockLevel)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStockLevel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdditional)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(lblMessage)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStockLevel)
                    .addComponent(txtStockLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdditional)
                    .addComponent(txtAdditional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addComponent(btnReturn)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if(!txtName.getText().isEmpty() && !txtPrice.getText().isEmpty() &&
            !txtStockLevel.getText().isEmpty() && !txtAdditional.getText().isEmpty())
        {
            String name = txtName.getText();
            int stockLevel;
            double price;

            try
            {
                stockLevel = Integer.parseInt(txtStockLevel.getText());
            }
            catch(Exception ex)
            {
                lblMessage.setText("Error: Stock Level not in Correct Format");
                return;
            }
            
            try
            {
                price = Double.parseDouble(txtPrice.getText());
            }
            catch(Exception ex)
            {
                lblMessage.setText("Error: price not in Correct Format");
                return;
            }

            if(selectedProduct.getClass().getName().equals("shoplog.Clothing"))
            {
                String measurement = txtAdditional.getText();
                int productId = selectedProduct.getProductId();
                Clothing newCl = new Clothing(measurement, productId, name, price, stockLevel);
                DBHandler db = new DBHandler();
                try {
                    db.updateProduct(newCl);
                    lblMessage.setText("Clothing Updated Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else
            {
                int size;
                try
                {
                    size = Integer.parseInt(txtAdditional.getText());
                }
                catch(Exception ex)
                {
                    lblMessage.setText("Error: Stock Level not in Correct Format");
                    return;
                }
                int productId = selectedProduct.getProductId();
                FootWear newFW = new FootWear(size, productId, name, price, stockLevel);
                DBHandler db = new DBHandler();
                try {
                    db.updateProduct(newFW);
                    lblMessage.setText("Footwear Updated Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        else
        {
            lblMessage.setText("Please Complete All Fields");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        StaffViewProduct rForm = new StaffViewProduct(loggedInStaff);
            this.dispose();
            rForm.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtId.setText(String.valueOf(selectedProduct.getProductId()));
        txtName.setText(selectedProduct.getProductName());
        txtPrice.setText(String.valueOf(selectedProduct.getPrice()));
        txtStockLevel.setText(String.valueOf(selectedProduct.getStockLevel()));
        if(selectedProduct.getClass().getName().equals("shoplog.Clothing"))
        {
            Clothing selectedCl = (Clothing)selectedProduct;
            txtAdditional.setText(selectedCl.getMeasurement());
        }
        else
        {
            FootWear selectedFW = (FootWear)selectedProduct;
            txtAdditional.setText(String.valueOf(selectedFW.getSize()));
        }
        
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new EditProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAdditional;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblStockLevel;
    private javax.swing.JTextField txtAdditional;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStockLevel;
    // End of variables declaration//GEN-END:variables
}