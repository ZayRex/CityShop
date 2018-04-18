/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import shoplog.Customer;
import shoplog.DBHandler;
import shoplog.Order;
import shoplog.OrderLine;
import shoplog.Product;

/**
 * Date 17/04/2018
 * @author Mohamad Harah
 */
public class ViewProducts extends javax.swing.JFrame {

    /**
     * Creates
     */
    private Customer loggedInCustomer;
    private HashMap<Integer, Product> products;
    private Product selectedProduct;
    private  int quantity;
   // public boolean loggedIn = false;

    /**
     * Creates 
     */
    public ViewProducts(Customer c) {
        loggedInCustomer = c;
        DBHandler db = new DBHandler();
        products = db.loadProducts();
        
        initComponents();
        
        if(loggedInCustomer.getIsRegistered())
        {
            btnBack.setText("BACK TO HOME");
            btnViewOrders.setVisible(true);
        }
        else
        {
            btnBack.setText("BACK TO MAIN");
            btnViewOrders.setVisible(false);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btnViewOrders = new javax.swing.JButton();
        btnAddtoBasket = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCateg = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProduct = new javax.swing.JList();
        cmbQuantity = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnViewOrders.setText("View Basket");
        btnViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrdersActionPerformed(evt);
            }
        });

        btnAddtoBasket.setText("Add to basket");
        btnAddtoBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoBasketActionPerformed(evt);
            }
        });

        btnBack.setText("Return To Customer Home");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lstCateg.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Footwear", "Clothing" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCateg.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCateg);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstCateg, org.jdesktop.beansbinding.ELProperty.create("${selectedElement}"), lstProduct, org.jdesktop.beansbinding.BeanProperty.create("selectedElements"));
        bindingGroup.addBinding(binding);

        lstProduct.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstProduct);

        cmbQuantity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cmbQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQuantityActionPerformed(evt);
            }
        });

        jLabel1.setText("Products");

        jLabel2.setText("Product");

        jLabel3.setText("Categories");

        lblMessage.setText("----------");

        jLabel4.setText("Stock:");

        lblStock.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lblMessage)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAddtoBasket)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblStock)
                                .addGap(14, 14, 14)))
                        .addComponent(btnViewOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMessage))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblStock))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAddtoBasket)
                    .addComponent(btnViewOrders))
                .addGap(26, 26, 26))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbQuantityActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if(loggedInCustomer.getIsRegistered())
        {
        CustomerHome rForm = new CustomerHome(loggedInCustomer);
           this.dispose();
           rForm.setVisible(true);
        }
        else
        {
            MainMenu rForm = new MainMenu();
           this.dispose();
           rForm.setVisible(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void lstProductValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProductValueChanged
        // TODO add your handling code here:
    //   String productValue = (String) lstProduct.getSelectedValue();
  /*  Product selectedProduct = (Product)lstProduct.getSelectedValue();       
        
            for(Map.Entry<Integer, Product> productEntry : products.entrySet())
            {
                Product aP = productEntry.getValue();
                if(aP.getProductName().equalsIgnoreCase(selectedProduct.toString()))
                {
                    lblStock.setText(Integer.toString(aP.getStockLevel()));
                    
                    if(Integer.parseInt(lblStock.getText()) > 0)
                    {
                        btnAddtoBasket.setEnabled(true);
                    }
                    else
                    {
                        btnAddtoBasket.setEnabled(false);
                    }
                }
            }*/
  if(lstProduct.getSelectedIndex() != -1)
        {
      try {
          //txtMessage.setText("");
          
          cmbQuantity.removeAllItems();
          Product selectedProduct = (Product)lstProduct.getSelectedValue();
          int amountInCurrentOrder = loggedInCustomer.findLatestOrder().getQuantityofProduct(selectedProduct.getProductId());
          int amountAvailable = selectedProduct.getStockLevel() ;
          if (amountInCurrentOrder>0){
              amountAvailable -= amountInCurrentOrder;
          }
          System.out.println("each amount: "+selectedProduct.getStockLevel() +"-"+ loggedInCustomer.findLatestOrder().getQuantityofProduct(selectedProduct.getProductId()));
          System.out.println("total: "+ amountAvailable);
             lblStock.setText(String.valueOf(amountAvailable));
          for(int i = 0; i <= amountAvailable; i++)
          {
              cmbQuantity.addItem(String.valueOf(i));
          }
      } catch (SQLException ex) {
          Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
      }
        }
        
    }//GEN-LAST:event_lstProductValueChanged

    private void btnAddtoBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoBasketActionPerformed
       if(lstProduct.getSelectedIndex() != -1)
        {           
            if(loggedInCustomer.getIsRegistered())
            {
                
                quantity = Integer.parseInt((String)cmbQuantity.getSelectedItem());
                if (quantity>0)
                {
                   OrderLine newOrderLine;
                try {
                    Order o = loggedInCustomer.findLatestOrder();
                
                   Product selectedProduct = (Product)lstProduct.getSelectedValue();
                    newOrderLine = new OrderLine(loggedInCustomer.findLatestOrder(), selectedProduct, this.quantity);
                    loggedInCustomer.findLatestOrder().addOrderLine(newOrderLine);
                    lblMessage.setText("Added to Order");
                    int amountAvailable = selectedProduct.getStockLevel() - quantity;
             lblStock.setText(Integer.toString(amountAvailable)); 

                    int selectedIndex = lstProduct.getSelectedIndex();
                    DefaultListModel model = (DefaultListModel)lstProduct.getModel();
                    model.remove(selectedIndex);

                
                
                } catch (SQLException ex) {
                    Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
                else
                {
                    lblMessage.setText("Please select a quantity");
                }
                
                

                
            }
            else
            {
                CustomerLogin cLogin = new CustomerLogin();
                this.dispose();
                cLogin.setVisible(true);
            }
        }
        else
        {
            lblMessage.setText("Please first select a product");
        }
    }//GEN-LAST:event_btnAddtoBasketActionPerformed

    private void lstCategValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategValueChanged
        // TODO add your handling code here:
        DefaultListModel model = new DefaultListModel();
        
        lstProduct.clearSelection();
                
        for(Map.Entry<Integer, Product> productEntry : products.entrySet())
        {
            Product actualProduct = productEntry.getValue();
            if(actualProduct.getClass().getName().equalsIgnoreCase("shoplog." + lstCateg.getSelectedValue()))
            {
                //model.addElement(actualProduct.getProductName());
                model.addElement(actualProduct);
            }
        }
        
        lstProduct.setModel(model);
        cmbQuantity.removeAllItems();
    }//GEN-LAST:event_lstCategValueChanged

    private void btnViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrdersActionPerformed
        try {
            // TODO add your handling code here:
            
            ViewBasket myBasket = new ViewBasket(loggedInCustomer);
            this.dispose();
            myBasket.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewOrdersActionPerformed

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
            java.util.logging.Logger.getLogger(ViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new ViewProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddtoBasket;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewOrders;
    private javax.swing.JComboBox<String> cmbQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblStock;
    private javax.swing.JList<String> lstCateg;
    private javax.swing.JList lstProduct;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
