package edu.auburn;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataAdapter {

    public static final int PRODUCT_SAVED_OK = 0;
    public static final int PRODUCT_DUPLICATE_ERROR = 1;
    public static final int CUSTOMER_SAVED_OK = 0;
    public static final int CUSTOMER_DUPLICATE_ERROR = 1;


    Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:./COMP3700.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = new ProductModel();

        try {
            String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            product.mProductID = rs.getInt("ProductId");
            product.mName = rs.getString("Name");
            product.mPrice = rs.getDouble("Price");
            product.mQuantity = rs.getDouble("Quantity");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }
    public int saveProduct(ProductModel product) {
        try {
            String sql = "INSERT INTO Products(ProductId, Name, Price, Quantity) VALUES " + product;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PRODUCT_DUPLICATE_ERROR;
        }

        return PRODUCT_SAVED_OK;
    }

    public CustomerModel loadCustomer(int CustomerID) {
        CustomerModel Customer = new CustomerModel();

        try {
            String sql = "SELECT CustomerId, Name, Address, Phone FROM Customers WHERE CustomerId = " + CustomerID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Customer.mCustomerID = rs.getInt("CusomterId");
            Customer.mName = rs.getString("Name");
            Customer.mAddress = rs.getString("Address");
            Customer.mPhone = rs.getInt("Phone");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Customer;
    }

    public int saveCustomer(CustomerModel Customer) {
        try {
            String sql = "INSERT INTO Customers(CustomerId, Name, Address, Phone) VALUES " + Customer;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return CUSTOMER_DUPLICATE_ERROR;
        }

        return CUSTOMER_SAVED_OK;
    }

}
