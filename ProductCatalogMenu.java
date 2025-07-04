public class ProductCatalogMenu implements Menu {

    @Override
    public void start() {        
        ProductManagementService productManagementService = DefaultProductManagementService.getInstance();
        Product[] products = productManagementService.getProducts();
        
        for (Product product : products) {
            System.out.println(product);
        }
        
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** PRODUCT CATALOG *****");
    }
    
}
