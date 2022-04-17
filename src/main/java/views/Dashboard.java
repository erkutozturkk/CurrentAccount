/*
 * Created by JFormDesigner on Thu Apr 14 23:14:42 TRT 2022
 */

package views;

import java.awt.event.*;

import models.CategoryImpl;
import models.CustomerImpl;
import models.ProductImpl;
import props.Categories;
import props.Customers;
import props.Products;
import utils.Util;

import java.awt.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class Dashboard extends JFrame {
   ProductImpl productImpl = new ProductImpl();
   CategoryImpl cat = new CategoryImpl();
   CustomerImpl cus = new CustomerImpl();
   int row = -1;
   int selectedId = 0;
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    public Dashboard() {
        initComponents();
        tblCustomer.setModel(cus.model());
        fncCmbCategoryAdd();
        cmbCategory.setModel(cat.comboBoxCategories());
        tblProductManagement.setModel(productImpl.productTable());

    }
    private void fncCmbCategoryAdd() {
        Categories categories = new Categories();
        cmbCategory.addItem(categories.getCt_name());
    }

    public Products fncProductDataValid() {
        try {
            if (txtProductName.getText().equals("")){
                txtProductName.requestFocus();
                lblProductError.setText("Product Name Empty!");
            }else if (cmbCategory.getSelectedItem().equals("")){
                lblProductError.setText("Category Name Empty!");
            }else if (txtPurchasePrice.getText().equals("")){
                txtPurchasePrice.requestFocus();
                lblProductError.setText("Purchase Price Empty!");
            }else if (txtSalePrice.getText().equals("")){
                txtSalePrice.requestFocus();
                lblProductError.setText("Sales Price Empty!");
            }else if (txtStock.getText().equals("")){
                txtStock.requestFocus();
                lblProductError.setText("Stock Empty!");
            }else if (txtInfo.getText().equals("")){
                txtInfo.requestFocus();
                lblProductError.setText("Info Empty!");
            }else {
                String productName = txtProductName.getText().toLowerCase(Locale.ROOT).trim();
                int purchasePrice = Integer.parseInt(txtPurchasePrice.getText().toLowerCase(Locale.ROOT).trim());
                int salePrice = Integer.parseInt(txtSalePrice.getText().toLowerCase(Locale.ROOT).trim());
                int stock = Integer.parseInt(txtStock.getText().toLowerCase(Locale.ROOT).trim());
                String info = txtInfo.getText().toLowerCase(Locale.ROOT).trim();

                Products products = new Products(0,0,productName,purchasePrice,salePrice,stock,info);
                return products;
            }
        }catch (Exception ex) {
            System.err.println("fncProductDataValid Error : " +ex);
        }
        return null;
    }

    public void textProductClear() {
        txtProductName.setText("");
        txtPurchasePrice.setText("");
        txtSalePrice.setText("");
        txtStock.setText("");
        txtInfo.setText("");
    }

    public void rowSelectProduct() {
        int column = 0;
        row = tblProductManagement.getSelectedRow();
        selectedId = (int) tblProductManagement.getValueAt(row,column);

        int pid = Integer.parseInt(String.valueOf(tblProductManagement.getValueAt(row,0)));
        String categoryName = String.valueOf(tblProductManagement.getValueAt(row,1));
        String productName = String.valueOf(tblProductManagement.getValueAt(row,2));
        int purchasePrice = Integer.parseInt(String.valueOf(tblProductManagement.getValueAt(row,3)));
        int salePrice = Integer.parseInt(String.valueOf(tblProductManagement.getValueAt(row,4)));
        int stock = Integer.parseInt(String.valueOf(tblProductManagement.getValueAt(row,5)));
        String info = String.valueOf(tblProductManagement.getValueAt(row,6));

        txtProductName.setText(productName);
        cmbCategory.getSelectedItem();
        txtPurchasePrice.setText(String.valueOf(purchasePrice));
        txtSalePrice.setText(String.valueOf(salePrice));
        txtStock.setText(String.valueOf(stock));
        txtInfo.setText(info);

    }

    private void tblProductManagementKeyReleased(KeyEvent e) {
        rowSelectProduct();
    }

    private void tblProductManagementMouseClicked(MouseEvent e) {
        rowSelectProduct();
    }

    private void btnAddProduct(ActionEvent e) {
        Products products = fncProductDataValid();
            if (products != null ) {
                int status = productImpl.productInsert(products);
                if (status > 0) {
                    tblProductManagement.setModel(productImpl.productTable());
                    textProductClear();
                }else {
                    lblProductError.setText("Insert Error!");
                }
            }
    }

    private void btnUpdateProduct(ActionEvent e) {
        String productName = txtProductName.getText();
        String categoryName = (String) cmbCategory.getSelectedItem();
        int purchasePrice = Integer.parseInt(txtPurchasePrice.getText());
        int salePrice = Integer.parseInt(txtSalePrice.getText());
        int stock = Integer.parseInt(txtStock.getText());
        String info = txtInfo.getText();

       Products products = new Products();
        if (row!=-1){
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to update the product?","Update Window",JOptionPane.YES_OPTION);
            if (answer==0){
                productImpl.productUpdate(products);
                tblProductManagement.setModel(productImpl.productTable());
                textProductClear();
                row=-1;
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please choose.");
        }
    }

    private void btnDeleteProduct(ActionEvent e) {
        if (row != -1) {
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete the product?","Delete Window",JOptionPane.YES_OPTION);

            if (answer==0) {
                productImpl.productDelete(selectedId);
                tblProductManagement.setModel(productImpl.productTable());
                textProductClear();
                row = -1;
            }
        }else {
            JOptionPane.showMessageDialog(this,"Please choose.");
        }
    }
    private Categories fncCategoryDataValid(){
        String categoryName = txtCategoryName.getText().trim();
        String caegoryDefinition = txtDefinition.getText().trim();

        if (categoryName.equals("")){
            lblCategoryError.setText("Name is empty");
            txtCategoryName.requestFocus();
        }else if (caegoryDefinition.equals("")){
            lblCategoryError.setText("Definition is empty");
            txtCategoryName.requestFocus();
        }else{
            lblCategoryError.setText("");
            Categories c= new Categories(0 , categoryName, caegoryDefinition);
            return c;
        }
        return null;
    }
    private void btnCategoryAddClick(ActionEvent e) {
        Categories c = fncCategoryDataValid();
        if (c != null){
            int status = cat.categoryInsert(c);
            if (status > 0){
                tblCategoryList.setModel(cat.categoriesTable());
                txtCategoryName.setText("");
                txtDefinition.setText("");
            }else{
                lblCategoryError.setText("Insert Error");
            }
        }
    }
    private Customers fncDataValid(){
        String name=txtName.getText().trim();
        String surname=txtSurname.getText().trim();
        String phone=txtPhone.getText().trim();
        String address=txtAddress.getText().trim();

        if (name.equals("")){
            lblError.setText("Name is Empty!!!");
            txtName.requestFocus();
        }else if (surname.equals("")){
            lblError.setText("Surname is Empty!!!");
            txtSurname.requestFocus();
        }else if (phone.equals("")){ //boşşa sıfırsa
            lblError.setText("Phone is Empty!!!");
            txtPhone.requestFocus();//imleç otomatik olarak passwworde gelicek
        }
        else if (address.equals("")){ //boşşa sıfırsa
            lblError.setText("Adress is Empty!!!");
            txtAddress.requestFocus();//imleç otomatik olarak passwworde gelicek
        }else {
            lblError.setText("");
            Customers c = new Customers(0,name,surname,phone,address);
            return c;
        }
        return null; //olumsuz halinde

    }

    private void btnCustomerAddClick(ActionEvent e) {
        Customers c = fncDataValid();
        if(c!=null){
            int status = cus.customerInsert(c);
            if (status>0){
                System.out.println("Ekleme basarili");
                txtName.setText("");
                txtSurname.setText("");
                txtPhone.setText("");
                txtAddress.setText("");
                tblCustomer.setModel(cus.model() );
            }
            else {
                if (status == -1){
                    lblError.setText("E-mail or Phone have already used");
                }
                else {
                    lblError.setText("Insert Error");
                }
            }
        }
    }

    void rowVal(){
        row = tblCustomer.getSelectedRow();
        String name = (String) tblCustomer.getValueAt(row, 1);
        String surname = (String) tblCustomer.getValueAt(row, 2);
        String phone = (String) tblCustomer.getValueAt(row, 3);
        String address = (String) tblCustomer.getValueAt(row, 4);

        txtName.setText(name);
        txtSurname.setText(surname);
        txtPhone.setText(phone);
        txtAddress.setText(address);
    }
    private void tblCustomerMouseClicked(MouseEvent e) {
        rowVal();
    }

    private void tblCustomerKeyReleased(KeyEvent e) {
        rowVal();
    }
    int cid = 0;
    int column = 0;
    private void btnCustomerUpdateClick(ActionEvent e) {
        Customers c = fncDataValid();
        if(row != -1 ) {
            row = tblCustomer.getSelectedRow();
            cid = Integer.valueOf(tblCustomer.getModel().getValueAt(row,column).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Guncellemek istediginizden emin misniz?", "Guncelleme islemi", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                cus.customerUpdate(c,cid);
                tblCustomer.setModel(cus.model());
                row = -1;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Lutfen secim yapiniz.");
        }
    }

    private void btnCustomerDeleteClick(ActionEvent e) {
        if(row != -1 ) {
            row = tblCustomer.getSelectedRow();
            cid = Integer.valueOf(tblCustomer.getModel().getValueAt(row,column).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Silmek istediginizden emin miisniz?", "Silme islemi", JOptionPane.YES_NO_OPTION);
            if(answer==0){
                cus.customerDelete(cid);
                tblCustomer.setModel(cus.model());
                row = -1;
            }
        } else{
            JOptionPane.showMessageDialog(this, "Lutfen secim yapiniz.");
        }
    }







    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel17 = new JPanel();
        scrollPane4 = new JScrollPane();
        tblCustomer = new JTable();
        panel18 = new JPanel();
        label11 = new JLabel();
        txtName = new JTextField();
        label13 = new JLabel();
        txtAddress = new JTextField();
        label15 = new JLabel();
        txtSurname = new JTextField();
        label16 = new JLabel();
        txtPhone = new JTextField();
        btnCustomerDelete = new JButton();
        btnCustomerUpdate = new JButton();
        btnCustomerAdd = new JButton();
        lblError = new JLabel();
        panel7 = new JPanel();
        label2 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        textField1 = new JTextField();
        panel8 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel9 = new JPanel();
        panel10 = new JPanel();
        panel11 = new JPanel();
        label3 = new JLabel();
        spinner1 = new JSpinner();
        spinner2 = new JSpinner();
        spinner6 = new JSpinner();
        label4 = new JLabel();
        spinner5 = new JSpinner();
        spinner3 = new JSpinner();
        spinner4 = new JSpinner();
        panel6 = new JPanel();
        panel12 = new JPanel();
        cmbCategory2 = new JComboBox();
        label12 = new JLabel();
        button3 = new JButton();
        scrollPane5 = new JScrollPane();
        tblOrderProducts = new JTable();
        label14 = new JLabel();
        label17 = new JLabel();
        txtProduct = new JTextField();
        label18 = new JLabel();
        label19 = new JLabel();
        txtAmount = new JTextField();
        btnComplete = new JButton();
        scrollPane6 = new JScrollPane();
        tblOrderCustomers = new JTable();
        txtCustomerSearch = new JTextField();
        label20 = new JLabel();
        panel3 = new JPanel();
        panel13 = new JPanel();
        scrollPane2 = new JScrollPane();
        tblProductManagement = new JTable();
        panel14 = new JPanel();
        label5 = new JLabel();
        txtProductName = new JTextField();
        label6 = new JLabel();
        cmbCategory = new JComboBox();
        label7 = new JLabel();
        txtPurchasePrice = new JTextField();
        label8 = new JLabel();
        txtSalePrice = new JTextField();
        label9 = new JLabel();
        txtStock = new JTextField();
        label10 = new JLabel();
        txtInfo = new JTextField();
        btnDeleteProduct = new JButton();
        btnUpdateProduct = new JButton();
        btnAddProduct = new JButton();
        lblProductError = new JLabel();
        panel5 = new JPanel();
        panel15 = new JPanel();
        scrollPane3 = new JScrollPane();
        tblCategoryList = new JTable();
        panel16 = new JPanel();
        lblCategoryName = new JLabel();
        lblDefinition = new JLabel();
        txtCategoryName = new JTextField();
        txtDefinition = new JTextField();
        btnUpdate2 = new JButton();
        btnDelete = new JButton();
        btnCategoryAdd = new JButton();
        lblCategoryError = new JLabel();

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

                //======== panel17 ========
                {
                    panel17.setBorder(new TitledBorder("Customer List"));

                    //======== scrollPane4 ========
                    {

                        //---- tblCustomer ----
                        tblCustomer.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                tblCustomerMouseClicked(e);
                            }
                        });
                        tblCustomer.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyReleased(KeyEvent e) {
                                tblCustomerKeyReleased(e);
                            }
                        });
                        scrollPane4.setViewportView(tblCustomer);
                    }

                    GroupLayout panel17Layout = new GroupLayout(panel17);
                    panel17.setLayout(panel17Layout);
                    panel17Layout.setHorizontalGroup(
                        panel17Layout.createParallelGroup()
                            .addGroup(panel17Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel17Layout.setVerticalGroup(
                        panel17Layout.createParallelGroup()
                            .addGroup(panel17Layout.createSequentialGroup()
                                .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
                    );
                }

                //======== panel18 ========
                {
                    panel18.setBorder(new TitledBorder("Add New Customer"));

                    //---- label11 ----
                    label11.setText("Name");

                    //---- label13 ----
                    label13.setText("Address");

                    //---- label15 ----
                    label15.setText("Surname");

                    //---- label16 ----
                    label16.setText("Phone");

                    //---- btnCustomerDelete ----
                    btnCustomerDelete.setText("Delete");
                    btnCustomerDelete.addActionListener(e -> btnCustomerDeleteClick(e));

                    //---- btnCustomerUpdate ----
                    btnCustomerUpdate.setText("Update");
                    btnCustomerUpdate.addActionListener(e -> btnCustomerUpdateClick(e));

                    //---- btnCustomerAdd ----
                    btnCustomerAdd.setText("Add");
                    btnCustomerAdd.addActionListener(e -> btnCustomerAddClick(e));

                    //---- lblError ----
                    lblError.setText("text");

                    GroupLayout panel18Layout = new GroupLayout(panel18);
                    panel18.setLayout(panel18Layout);
                    panel18Layout.setHorizontalGroup(
                        panel18Layout.createParallelGroup()
                            .addGroup(panel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel18Layout.createParallelGroup()
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel18Layout.createParallelGroup()
                                    .addGroup(panel18Layout.createSequentialGroup()
                                        .addGroup(panel18Layout.createParallelGroup()
                                            .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAddress))
                                        .addGap(33, 33, 33)
                                        .addGroup(panel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label15, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(label16, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel18Layout.createParallelGroup()
                                            .addComponent(txtSurname, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                            .addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                                    .addGroup(panel18Layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(btnCustomerAdd)
                                        .addGap(48, 48, 48)
                                        .addComponent(btnCustomerUpdate)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnCustomerDelete)
                                        .addGap(0, 202, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(panel18Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(557, Short.MAX_VALUE))
                    );
                    panel18Layout.setVerticalGroup(
                        panel18Layout.createParallelGroup()
                            .addGroup(panel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel18Layout.createParallelGroup()
                                    .addGroup(panel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label11)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label15)
                                        .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panel18Layout.createParallelGroup()
                                    .addGroup(panel18Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label16)
                                            .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel18Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(panel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label13)
                                            .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGap(30, 30, 30)
                                .addGroup(panel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCustomerAdd)
                                    .addComponent(btnCustomerUpdate)
                                    .addComponent(btnCustomerDelete))
                                .addGap(18, 18, 18)
                                .addComponent(lblError)
                                .addContainerGap(25, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Customers", panel1);

            //======== panel7 ========
            {
                panel7.setBorder(new TitledBorder("Filter"));

                //---- label2 ----
                label2.setText("Search Area:");

                //---- radioButton1 ----
                radioButton1.setText("text");

                //---- radioButton2 ----
                radioButton2.setText("text");

                //---- radioButton3 ----
                radioButton3.setText("text");

                //======== panel8 ========
                {
                    panel8.setBorder(new TitledBorder("Result"));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                    panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                //======== panel9 ========
                {
                    panel9.setBorder(new TitledBorder("PROFIT AND LOSS"));

                    GroupLayout panel9Layout = new GroupLayout(panel9);
                    panel9.setLayout(panel9Layout);
                    panel9Layout.setHorizontalGroup(
                        panel9Layout.createParallelGroup()
                            .addGap(0, 230, Short.MAX_VALUE)
                    );
                    panel9Layout.setVerticalGroup(
                        panel9Layout.createParallelGroup()
                            .addGap(0, 149, Short.MAX_VALUE)
                    );
                }

                //======== panel10 ========
                {
                    panel10.setBorder(new TitledBorder("Sold"));

                    GroupLayout panel10Layout = new GroupLayout(panel10);
                    panel10.setLayout(panel10Layout);
                    panel10Layout.setHorizontalGroup(
                        panel10Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel10Layout.setVerticalGroup(
                        panel10Layout.createParallelGroup()
                            .addGap(0, 57, Short.MAX_VALUE)
                    );
                }

                //======== panel11 ========
                {
                    panel11.setBorder(new TitledBorder("Information"));

                    GroupLayout panel11Layout = new GroupLayout(panel11);
                    panel11.setLayout(panel11Layout);
                    panel11Layout.setHorizontalGroup(
                        panel11Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel11Layout.setVerticalGroup(
                        panel11Layout.createParallelGroup()
                            .addGap(0, 57, Short.MAX_VALUE)
                    );
                }

                //---- label3 ----
                label3.setText("Date Range:");

                //---- label4 ----
                label4.setText("between");

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(radioButton1)
                                            .addGap(0, 0, 0)
                                            .addComponent(radioButton2)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioButton3)
                                            .addGap(38, 38, 38))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                            .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(panel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel11, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(panel8, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinner2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(spinner6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinner5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinner3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(spinner4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                            .addGap(22, 22, 22))
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(radioButton1)
                                .addComponent(radioButton2)
                                .addComponent(radioButton3)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(spinner4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinner3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinner5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(spinner6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinner2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addGap(16, 16, 16)
                            .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Reports", panel7);

            //======== panel6 ========
            {

                //======== panel12 ========
                {
                    panel12.setBorder(new TitledBorder("Sale Page"));

                    //---- label12 ----
                    label12.setText("Choose the Product Category to List");

                    //---- button3 ----
                    button3.setText("List");

                    //======== scrollPane5 ========
                    {
                        scrollPane5.setViewportView(tblOrderProducts);
                    }

                    //---- label14 ----
                    label14.setText("Choose from the list to sale");

                    //---- label17 ----
                    label17.setText("Chosen Product:");

                    //---- label18 ----
                    label18.setText("Amount:");

                    //---- label19 ----
                    label19.setText("Customers:");

                    //---- btnComplete ----
                    btnComplete.setText("Complete the Sale");

                    //======== scrollPane6 ========
                    {
                        scrollPane6.setViewportView(tblOrderCustomers);
                    }

                    //---- label20 ----
                    label20.setText("Search:");

                    GroupLayout panel12Layout = new GroupLayout(panel12);
                    panel12.setLayout(panel12Layout);
                    panel12Layout.setHorizontalGroup(
                        panel12Layout.createParallelGroup()
                            .addGroup(panel12Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(panel12Layout.createParallelGroup()
                                    .addGroup(panel12Layout.createSequentialGroup()
                                        .addGroup(panel12Layout.createParallelGroup()
                                            .addComponent(cmbCategory2, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel12Layout.createSequentialGroup()
                                        .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.LEADING, panel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(GroupLayout.Alignment.LEADING, panel12Layout.createSequentialGroup()
                                                    .addComponent(label19, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(scrollPane6))
                                                .addGroup(GroupLayout.Alignment.LEADING, panel12Layout.createSequentialGroup()
                                                    .addGroup(panel12Layout.createParallelGroup()
                                                        .addGroup(panel12Layout.createSequentialGroup()
                                                            .addComponent(label17, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtProduct, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panel12Layout.createSequentialGroup()
                                                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(58, 58, 58)
                                                    .addGroup(panel12Layout.createParallelGroup()
                                                        .addGroup(panel12Layout.createSequentialGroup()
                                                            .addComponent(label20, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panel12Layout.createSequentialGroup()
                                                            .addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))))
                                        .addGap(63, 63, 63))))
                    );
                    panel12Layout.setVerticalGroup(
                        panel12Layout.createParallelGroup()
                            .addGroup(panel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel12Layout.createSequentialGroup()
                                        .addComponent(cmbCategory2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label12)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel12Layout.createParallelGroup()
                                    .addComponent(txtProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label14)
                                        .addComponent(label17))
                                    .addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label18)
                                    .addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label20))
                                .addGap(13, 13, 13)
                                .addGroup(panel12Layout.createParallelGroup()
                                    .addGroup(panel12Layout.createSequentialGroup()
                                        .addComponent(label19)
                                        .addContainerGap(93, Short.MAX_VALUE))
                                    .addComponent(scrollPane6, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    );
                }

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addComponent(panel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("Sales Management", panel6);

            //======== panel3 ========
            {

                //======== panel13 ========
                {
                    panel13.setBorder(new TitledBorder("Product List"));

                    //======== scrollPane2 ========
                    {

                        //---- tblProductManagement ----
                        tblProductManagement.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyReleased(KeyEvent e) {
                                tblProductManagementKeyReleased(e);
                            }
                        });
                        tblProductManagement.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                tblProductManagementMouseClicked(e);
                            }
                        });
                        scrollPane2.setViewportView(tblProductManagement);
                    }

                    GroupLayout panel13Layout = new GroupLayout(panel13);
                    panel13.setLayout(panel13Layout);
                    panel13Layout.setHorizontalGroup(
                        panel13Layout.createParallelGroup()
                            .addGroup(panel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel13Layout.setVerticalGroup(
                        panel13Layout.createParallelGroup()
                            .addGroup(panel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                //======== panel14 ========
                {
                    panel14.setBorder(new TitledBorder("Add New Product"));

                    //---- label5 ----
                    label5.setText("Product Name");

                    //---- label6 ----
                    label6.setText("Category");

                    //---- label7 ----
                    label7.setText("Purchase Price");

                    //---- label8 ----
                    label8.setText("Sale Price");

                    //---- label9 ----
                    label9.setText("Stock");

                    //---- label10 ----
                    label10.setText("Info");

                    //---- btnDeleteProduct ----
                    btnDeleteProduct.setText("Delete");
                    btnDeleteProduct.addActionListener(e -> btnDeleteProduct(e));

                    //---- btnUpdateProduct ----
                    btnUpdateProduct.setText("Update");
                    btnUpdateProduct.addActionListener(e -> btnUpdateProduct(e));

                    //---- btnAddProduct ----
                    btnAddProduct.setText("Add");
                    btnAddProduct.addActionListener(e -> btnAddProduct(e));

                    //---- lblProductError ----
                    lblProductError.setText(" ");
                    lblProductError.setBackground(Color.red);

                    GroupLayout panel14Layout = new GroupLayout(panel14);
                    panel14.setLayout(panel14Layout);
                    panel14Layout.setHorizontalGroup(
                        panel14Layout.createParallelGroup()
                            .addGroup(panel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label8, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(label7, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel14Layout.createParallelGroup()
                                    .addGroup(panel14Layout.createSequentialGroup()
                                        .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtProductName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(cmbCategory, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(txtPurchasePrice, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                        .addGap(33, 33, 33)
                                        .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label9, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(label10, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel14Layout.createParallelGroup()
                                            .addComponent(txtStock, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                            .addComponent(txtInfo, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                                    .addGroup(panel14Layout.createSequentialGroup()
                                        .addGroup(panel14Layout.createParallelGroup()
                                            .addComponent(txtSalePrice, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblProductError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                        .addComponent(btnAddProduct)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdateProduct)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeleteProduct)))
                                .addContainerGap())
                    );
                    panel14Layout.setVerticalGroup(
                        panel14Layout.createParallelGroup()
                            .addGroup(panel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDeleteProduct)
                                        .addComponent(btnUpdateProduct)
                                        .addComponent(btnAddProduct))
                                    .addGroup(panel14Layout.createSequentialGroup()
                                        .addGroup(panel14Layout.createParallelGroup()
                                            .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label5)
                                                .addComponent(txtProductName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label9)
                                                .addComponent(txtStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label6)
                                            .addComponent(cmbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label10)
                                            .addComponent(txtInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label7)
                                            .addComponent(txtPurchasePrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel14Layout.createParallelGroup()
                                            .addComponent(label8)
                                            .addComponent(txtSalePrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(lblProductError)
                                .addContainerGap(8, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(panel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Product Management", panel3);

            //======== panel5 ========
            {

                //======== panel15 ========
                {
                    panel15.setBorder(new TitledBorder("Category List"));

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setViewportView(tblCategoryList);
                    }

                    GroupLayout panel15Layout = new GroupLayout(panel15);
                    panel15.setLayout(panel15Layout);
                    panel15Layout.setHorizontalGroup(
                        panel15Layout.createParallelGroup()
                            .addComponent(scrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    );
                    panel15Layout.setVerticalGroup(
                        panel15Layout.createParallelGroup()
                            .addComponent(scrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    );
                }

                //======== panel16 ========
                {
                    panel16.setBorder(new TitledBorder("Category Operations"));

                    //---- lblCategoryName ----
                    lblCategoryName.setText("Category Name: ");

                    //---- lblDefinition ----
                    lblDefinition.setText("Definition:");

                    //---- btnUpdate2 ----
                    btnUpdate2.setText("Update");

                    //---- btnDelete ----
                    btnDelete.setText("Delete");

                    //---- btnCategoryAdd ----
                    btnCategoryAdd.setText("Add");
                    btnCategoryAdd.addActionListener(e -> btnCategoryAddClick(e));

                    GroupLayout panel16Layout = new GroupLayout(panel16);
                    panel16.setLayout(panel16Layout);
                    panel16Layout.setHorizontalGroup(
                        panel16Layout.createParallelGroup()
                            .addGroup(panel16Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panel16Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel16Layout.createSequentialGroup()
                                        .addComponent(lblCategoryName, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCategoryName))
                                    .addGroup(panel16Layout.createSequentialGroup()
                                        .addGroup(panel16Layout.createParallelGroup()
                                            .addGroup(panel16Layout.createSequentialGroup()
                                                .addComponent(lblDefinition, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28))
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel16Layout.createSequentialGroup()
                                                .addComponent(btnCategoryAdd, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(panel16Layout.createParallelGroup()
                                            .addGroup(panel16Layout.createSequentialGroup()
                                                .addComponent(btnUpdate2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtDefinition))))
                                .addContainerGap())
                    );
                    panel16Layout.setVerticalGroup(
                        panel16Layout.createParallelGroup()
                            .addGroup(panel16Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCategoryName)
                                    .addComponent(txtCategoryName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel16Layout.createParallelGroup()
                                    .addComponent(lblDefinition)
                                    .addComponent(txtDefinition, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCategoryAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                //---- lblCategoryError ----
                lblCategoryError.setText("text");

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(panel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(panel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(33, 33, 33))
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(223, 223, 223)
                            .addComponent(lblCategoryError, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(302, Short.MAX_VALUE))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addComponent(lblCategoryError)
                            .addContainerGap(82, Short.MAX_VALUE))
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 610, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(30, 30, 30))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE))
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
    private JPanel panel17;
    private JScrollPane scrollPane4;
    private JTable tblCustomer;
    private JPanel panel18;
    private JLabel label11;
    private JTextField txtName;
    private JLabel label13;
    private JTextField txtAddress;
    private JLabel label15;
    private JTextField txtSurname;
    private JLabel label16;
    private JTextField txtPhone;
    private JButton btnCustomerDelete;
    private JButton btnCustomerUpdate;
    private JButton btnCustomerAdd;
    private JLabel lblError;
    private JPanel panel7;
    private JLabel label2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JTextField textField1;
    private JPanel panel8;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel9;
    private JPanel panel10;
    private JPanel panel11;
    private JLabel label3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner6;
    private JLabel label4;
    private JSpinner spinner5;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JPanel panel6;
    private JPanel panel12;
    private JComboBox cmbCategory2;
    private JLabel label12;
    private JButton button3;
    private JScrollPane scrollPane5;
    private JTable tblOrderProducts;
    private JLabel label14;
    private JLabel label17;
    private JTextField txtProduct;
    private JLabel label18;
    private JLabel label19;
    private JTextField txtAmount;
    private JButton btnComplete;
    private JScrollPane scrollPane6;
    private JTable tblOrderCustomers;
    private JTextField txtCustomerSearch;
    private JLabel label20;
    private JPanel panel3;
    private JPanel panel13;
    private JScrollPane scrollPane2;
    private JTable tblProductManagement;
    private JPanel panel14;
    private JLabel label5;
    private JTextField txtProductName;
    private JLabel label6;
    private JComboBox cmbCategory;
    private JLabel label7;
    private JTextField txtPurchasePrice;
    private JLabel label8;
    private JTextField txtSalePrice;
    private JLabel label9;
    private JTextField txtStock;
    private JLabel label10;
    private JTextField txtInfo;
    private JButton btnDeleteProduct;
    private JButton btnUpdateProduct;
    private JButton btnAddProduct;
    private JLabel lblProductError;
    private JPanel panel5;
    private JPanel panel15;
    private JScrollPane scrollPane3;
    private JTable tblCategoryList;
    private JPanel panel16;
    private JLabel lblCategoryName;
    private JLabel lblDefinition;
    private JTextField txtCategoryName;
    private JTextField txtDefinition;
    private JButton btnUpdate2;
    private JButton btnDelete;
    private JButton btnCategoryAdd;
    private JLabel lblCategoryError;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
