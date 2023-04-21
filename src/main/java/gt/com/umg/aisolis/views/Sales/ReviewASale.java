/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gt.com.umg.aisolis.views.Sales;

import gt.com.umg.aisolis.dao.ClientDao;
import gt.com.umg.aisolis.dao.ProductDao;
import gt.com.umg.aisolis.dao.SalesDao;
import gt.com.umg.aisolis.dao.SalesDetailDao;
import gt.com.umg.aisolis.models.Client;
import gt.com.umg.aisolis.models.Product;
import gt.com.umg.aisolis.models.Sale;
import gt.com.umg.aisolis.models.SaleDetail;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author swords
 */
public class ReviewASale extends javax.swing.JFrame {

    SalesDetailDao sdd = new SalesDetailDao();
    SalesDao salesDao = new SalesDao();
    ClientDao clientDao = new ClientDao();
    ProductDao productDao = new ProductDao();
    
    
    public ReviewASale() {
        initComponents();
    }
    


    
    private void drawtable(List<Product> products){
        Object[][] data = new Object[products.size()][5];
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            data[i][0] = p.getCod_prod();
            data[i][1] = p.getName();
            data[i][2] = p.getPrice();
            data[i][3] = p.getQuantity();
            data[i][4] = p.getSubtotal();
        }
        
        String[] columnNames = {"Codigo de producto", "Nombre", "Precio", "cantidad", "sub total"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        productlist.setModel(model);
        this.total.setText("Total: Q." + String.valueOf(sumSubtotal(products)));
        
    }
    
    private double sumSubtotal(List<Product> products){
        double sum = 0D;
        for(Product product : products){
            sum+= product.getSubtotal();
        }
        return sum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        invoice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clientName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productlist = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        clientNit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setText("Total:");

        jLabel1.setText("No de Factura");

        invoice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                invoiceFocusLost(evt);
            }
        });
        invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre del cliente");

        clientName.setEditable(false);
        clientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientNameActionPerformed(evt);
            }
        });

        productlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo de producto", "Nombre", "Precio", "Cantidad", "sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productlist);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Resumen de venta");

        clientNit.setEditable(false);
        clientNit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clientNitFocusLost(evt);
            }
        });
        clientNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientNitActionPerformed(evt);
            }
        });

        jLabel7.setText("Nit del cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(total)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientNit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientName)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(clientNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceActionPerformed

    private void clientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientNameActionPerformed

    private void invoiceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invoiceFocusLost
        
        Sale sale = salesDao.findByInvoice(Integer.parseInt(invoice.getText().trim()));
        Client clientInfo = clientDao.findById(sale.getNit());
        if(!"".equals(clientInfo.getNit())){
            clientName.setText(clientInfo.getFullName());
            clientNit.setText(clientInfo.getNit());
            List<SaleDetail> sales = sdd.findByInvoice(Integer.parseInt(invoice.getText().trim()));
        
            List<Product> productsInvoice = new ArrayList<>();

            for(SaleDetail sale1 : sales){
                Product ss = productDao.findById(sale1.getCodProd());
                ss.setQuantity(sale1.getQuantity());
                ss.setPrice(sale1.getPrice());
                ss.setSubtotal(ss.getQuantity()*ss.getPrice());
                productsInvoice.add(ss);
            }
            drawtable(productsInvoice);  
        }
        
        
    }//GEN-LAST:event_invoiceFocusLost

    private void clientNitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clientNitFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_clientNitFocusLost

    private void clientNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientNitActionPerformed

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
            java.util.logging.Logger.getLogger(ReviewASale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewASale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewASale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewASale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewASale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientName;
    private javax.swing.JTextField clientNit;
    private javax.swing.JTextField invoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productlist;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}

