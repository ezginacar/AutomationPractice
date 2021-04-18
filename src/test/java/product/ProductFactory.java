package product;

import static utils.LogUtil.logger;


import java.util.*;

public class ProductFactory {

    private static ProductFactory productFactory;
    private static ArrayList<Product> products = new ArrayList<Product>();


    private ProductFactory(){};


    public static ProductFactory getProductInstance(){
        if(products.size() == 0)
            productFactory = new ProductFactory();

        return productFactory;
    }

    public  Product getProduct(String category) throws Exception {
        Product product;
        if(category.equalsIgnoreCase("T-SHIRTS") | (category.equalsIgnoreCase("TSHIRTS"))){
            product = new TShirts();
        } else if(category.equalsIgnoreCase("DRESSES")){
            product = new Dresses();
        } else if(category.equalsIgnoreCase("WOMEN")){
            product = new Women();
        } else{
            product = new Other();
        }
        products.add(product);
        return product;

    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public void removeEmptyObject(){
        Iterator<Product> iterator = products.iterator();
     
        while (iterator.hasNext()) {

            if(iterator.next().toString().contains("{name='null', price=0.0}")){
                iterator.remove();
                break;
            }
     
        }
    }






}
