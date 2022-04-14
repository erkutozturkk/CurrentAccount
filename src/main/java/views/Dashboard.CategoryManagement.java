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
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel7 = new JPanel();
        scrollPane1 = new JScrollPane();
        tblCategoryList = new JTable();
        panel9 = new JPanel();
        lblCategoryName = new JLabel();
        lblDefinition = new JLabel();
        txtCategoryName = new JTextField();
        txtDefinition = new JTextField();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnAdd = new JButton();

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
                            .addContainerGap(186, Short.MAX_VALUE))
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
                        .addGap(0, 771, Short.MAX_VALUE)
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Reports", panel2);

            //======== panel3 ========
            {

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGap(0, 771, Short.MAX_VALUE)
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Sales Management", panel3);

            //======== panel4 ========
            {

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGap(0, 771, Short.MAX_VALUE)
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Product Management", panel4);

            //======== panel5 ========
            {

                //======== panel7 ========
                {
                    panel7.setBorder(new TitledBorder("Category List"));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(tblCategoryList);
                    }

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    );
                }

                //======== panel9 ========
                {
                    panel9.setBorder(new TitledBorder("Category Operations"));

                    //---- lblCategoryName ----
                    lblCategoryName.setText("Category Name: ");

                    //---- lblDefinition ----
                    lblDefinition.setText("Definition:");

                    //---- btnUpdate ----
                    btnUpdate.setText("Update");

                    //---- btnDelete ----
                    btnDelete.setText("Delete");

                    //---- btnAdd ----
                    btnAdd.setText("Add");

                    GroupLayout panel9Layout = new GroupLayout(panel9);
                    panel9.setLayout(panel9Layout);
                    panel9Layout.setHorizontalGroup(
                        panel9Layout.createParallelGroup()
                            .addGroup(panel9Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel9Layout.createSequentialGroup()
                                        .addComponent(lblCategoryName, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCategoryName))
                                    .addGroup(panel9Layout.createSequentialGroup()
                                        .addGroup(panel9Layout.createParallelGroup()
                                            .addGroup(panel9Layout.createSequentialGroup()
                                                .addComponent(lblDefinition, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28))
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(panel9Layout.createParallelGroup()
                                            .addGroup(panel9Layout.createSequentialGroup()
                                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtDefinition))))
                                .addContainerGap())
                    );
                    panel9Layout.setVerticalGroup(
                        panel9Layout.createParallelGroup()
                            .addGroup(panel9Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCategoryName)
                                    .addComponent(txtCategoryName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel9Layout.createParallelGroup()
                                    .addComponent(lblDefinition)
                                    .addComponent(txtDefinition, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(panel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(33, 33, 33))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(144, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Category Management", panel5);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(30, 30, 30))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
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
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel7;
    private JScrollPane scrollPane1;
    private JTable tblCategoryList;
    private JPanel panel9;
    private JLabel lblCategoryName;
    private JLabel lblDefinition;
    private JTextField txtCategoryName;
    private JTextField txtDefinition;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnAdd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
