package edu.auburn;

public class StoreManager {

    public static void main(String[] args) {
        SQLiteDataAdapter adapter = new SQLiteDataAdapter();
        adapter.connect();
        AddProductView apView = new AddProductView();
        AddCustomerView cView = new AddCustomerView();
        AddCustomerController cCtr = new AddCustomerController(cView, adapter);
        AddProductController apCtr = new AddProductController(apView, adapter);

        apView.setVisible(true);
        cView.setVisible(true);

    }
}
