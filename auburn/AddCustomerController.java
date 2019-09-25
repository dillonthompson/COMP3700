package edu.auburn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerController {

    public AddCustomerView view;
    public SQLiteDataAdapter adapter;

    public AddCustomerController(AddCustomerView view, SQLiteDataAdapter adapter)   {
        this.view = view;
        this.adapter = adapter;

        this.view.btnAdd.addActionListener(new AddButtonListener());
        this.view.btnCancel.addActionListener(new CancelButtonListener());

    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel Customer = new CustomerModel();

            String id = AddCustomerController.this.view.txtCustomerID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
                return;
            }

            try {
                Customer.mCustomerID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
                return;
            }

            String name = AddCustomerController.this.view.txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Customer name cannot be empty!");
                return;
            }

            Customer.mName = name;

            String Address = AddCustomerController.this.view.txtAddress.getText();
            try {
                Customer.mAddress = Address;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Address is invalid!");
                return;
            }

            String Phone = AddCustomerController.this.view.txtPhone.getText();
            try {
                Customer.mPhone = Integer.parseInt(Phone);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Phone number is invalid!");
                return;
            }

            switch (adapter.saveCustomer(Customer)) {
                case SQLiteDataAdapter.CUSTOMER_DUPLICATE_ERROR:
                    JOptionPane.showMessageDialog(null, "Customer NOT added successfully! Duplicate Customer ID!");
                default:
                    JOptionPane.showMessageDialog(null, "Customer added successfully!" + Customer);
            }
        }
    }

    class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(null, "You click on Cancel button!!!");
        }
    }

}