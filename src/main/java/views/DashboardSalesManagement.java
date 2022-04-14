/*
 * Created by JFormDesigner on Thu Apr 14 23:14:42 TRT 2022
 */

package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class Dashboard extends JFrame {
    public Dashboard() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel6 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel7 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel8 = new JPanel();
        label2 = new JLabel();
        txtProductName = new JTextField();
        label3 = new JLabel();
        cmbCategory = new JComboBox();
        label4 = new JLabel();
        txtPurchasePrice = new JTextField();
        label5 = new JLabel();
        txtSalePrice = new JTextField();
        label6 = new JLabel();
        txtStok = new JTextField();
        label7 = new JLabel();
        txtDetails = new JTextField();
        button2 = new JButton();
        btnUpdate = new JButton();
        btnAdd = new JButton();
        panel4 = new JPanel();
        panel5 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Log out");

        //---- label1 ----
        label1.setText("Sn. :::::::");

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //======== panel6 ========
                {
                    panel6.setBorder(new TitledBorder("Product List"));

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGap(0, 569, Short.MAX_VALUE)
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGap(0, 214, Short.MAX_VALUE)
                    );
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(162, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(207, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Customers", panel1);

            //======== panel2 ========
            {

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 747, Short.MAX_VALUE)
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Reports", panel2);

            //======== panel3 ========
            {

                //======== panel7 ========
                {
                    panel7.setBorder(new TitledBorder("Product List"));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                //======== panel8 ========
                {
                    panel8.setBorder(new TitledBorder("Add New Product"));

                    //---- label2 ----
                    label2.setText("Product Name");

                    //---- label3 ----
                    label3.setText("Category");

                    //---- label4 ----
                    label4.setText("Purchase Price");

                    //---- label5 ----
                    label5.setText("Sale Price");

                    //---- label6 ----
                    label6.setText("Stok");

                    //---- label7 ----
                    label7.setText("Details");

                    //---- button2 ----
                    button2.setText("Delete");

                    //---- btnUpdate ----
                    btnUpdate.setText("Update");

                    //---- btnAdd ----
                    btnAdd.setText("Add");

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label5, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel8Layout.createParallelGroup()
                                    .addGroup(panel8Layout.createSequentialGroup()
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtProductName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(cmbCategory, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(txtPurchasePrice, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                        .addGap(33, 33, 33)
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel8Layout.createParallelGroup()
                                            .addComponent(txtStok, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                            .addComponent(txtDetails, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                                    .addGroup(panel8Layout.createSequentialGroup()
                                        .addComponent(txtSalePrice, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                        .addComponent(btnAdd)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(button2)))
                                .addContainerGap())
                    );
                    panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button2)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnAdd))
                                    .addGroup(panel8Layout.createSequentialGroup()
                                        .addGroup(panel8Layout.createParallelGroup()
                                            .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label2)
                                                .addComponent(txtProductName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label6)
                                                .addComponent(txtStok, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label3)
                                            .addComponent(cmbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label7)
                                            .addComponent(txtDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label4)
                                            .addComponent(txtPurchasePrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel8Layout.createParallelGroup()
                                            .addComponent(label5)
                                            .addComponent(txtSalePrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(42, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Sales Management", panel3);

            //======== panel4 ========
            {

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGap(0, 747, Short.MAX_VALUE)
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Product Management", panel4);

            //======== panel5 ========
            {

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGap(0, 747, Short.MAX_VALUE)
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Category Management", panel5);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tabbedPane1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)))
                    .addGap(30, 30, 30))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label1))
                    .addGap(18, 18, 18)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JLabel label1;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel6;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel7;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel8;
    private JLabel label2;
    private JTextField txtProductName;
    private JLabel label3;
    private JComboBox cmbCategory;
    private JLabel label4;
    private JTextField txtPurchasePrice;
    private JLabel label5;
    private JTextField txtSalePrice;
    private JLabel label6;
    private JTextField txtStok;
    private JLabel label7;
    private JTextField txtDetails;
    private JButton button2;
    private JButton btnUpdate;
    private JButton btnAdd;
    private JPanel panel4;
    private JPanel panel5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
