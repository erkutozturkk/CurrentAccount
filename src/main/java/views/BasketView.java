/*
 * Created by JFormDesigner on Mon Apr 25 14:57:57 TRT 2022
 */

package views;

import models.BasketImpl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class BasketView extends JFrame {
    BasketImpl basket = new BasketImpl();
    public BasketView() {
        initComponents();
        tblBasket.setModel(basket.basketTableModel());
    }

    private void btnAddProducts(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tblBasket = new JTable();
        btnAddProducts = new JButton();
        btnCompleteSale = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tblBasket);
        }

        //---- btnAddProducts ----
        btnAddProducts.setText("Add More Products");
        btnAddProducts.addActionListener(e -> btnAddProducts(e));

        //---- btnCompleteSale ----
        btnCompleteSale.setText("Complete the Sale");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnAddProducts)
                            .addGap(18, 18, 18)
                            .addComponent(btnCompleteSale)
                            .addGap(0, 385, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddProducts, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCompleteSale, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(76, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tblBasket;
    private JButton btnAddProducts;
    private JButton btnCompleteSale;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
