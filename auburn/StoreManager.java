package edu.auburn;

public class StoreManager {

    public static void main(String[] args) {
        System.out.println("Hello class!");
        SQLiteDataAdapter adapter = new SQLiteDataAdapter();
        adapter.connect();
        ProductModel product = adapter.loadProduct(3);

        System.out.println("Loaded product: " + product);

        AddProductView apView = new AddProductView();
        AddProductController apCtr = new AddProductController(apView, adapter);

        apView.setVisible(true);

    }
}
