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
        cmbCategory = new JComboBox();
        label2 = new JLabel();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label3 = new JLabel();
        label4 = new JLabel();
        txtProduct = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        txtAmount = new JTextField();
        btnComplete = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        txtCustomerSearch = new JTextField();
        label7 = new JLabel();
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
                            .addContainerGap(201, Short.MAX_VALUE))
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
                        .addGap(0, 786, Short.MAX_VALUE)
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
                    panel7.setBorder(new TitledBorder("Sale Page"));

                    //---- label2 ----
                    label2.setText("Choose the Product Category to List");

                    //---- button2 ----
                    button2.setText("List");

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    //---- label3 ----
                    label3.setText("Choose from the list to sale");

                    //---- label4 ----
                    label4.setText("Chosen Product:");

                    //---- label5 ----
                    label5.setText("Amount:");

                    //---- label6 ----
                    label6.setText("Customers:");

                    //---- btnComplete ----
                    btnComplete.setText("Complete the Sale");

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(table2);
                    }

                    //---- label7 ----
                    label7.setText("Search:");

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addGroup(panel7Layout.createParallelGroup()
                                            .addComponent(cmbCategory, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createSequentialGroup()
                                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(scrollPane2))
                                                .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createSequentialGroup()
                                                    .addGroup(panel7Layout.createParallelGroup()
                                                        .addGroup(panel7Layout.createSequentialGroup()
                                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtProduct, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panel7Layout.createSequentialGroup()
                                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(58, 58, 58)
                                                    .addGroup(panel7Layout.createParallelGroup()
                                                        .addGroup(panel7Layout.createSequentialGroup()
                                                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panel7Layout.createSequentialGroup()
                                                            .addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))))
                                        .addGap(63, 63, 63))))
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addComponent(cmbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label2)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addComponent(txtProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(label4))
                                    .addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5)
                                    .addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7))
                                .addGap(13, 13, 13)
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addContainerGap(81, Short.MAX_VALUE))
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                    );
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(0, 786, Short.MAX_VALUE)
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
                        .addGap(0, 786, Short.MAX_VALUE)
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
    private JComboBox cmbCategory;
    private JLabel label2;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label3;
    private JLabel label4;
    private JTextField txtProduct;
    private JLabel label5;
    private JLabel label6;
    private JTextField txtAmount;
    private JButton btnComplete;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JTextField txtCustomerSearch;
    private JLabel label7;
    private JPanel panel4;
    private JPanel panel5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
