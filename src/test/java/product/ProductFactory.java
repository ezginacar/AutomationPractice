package product;

import static utils.LogUtil.logger;


import org.junit.Test;

import java.util.*;

public class ProductFactory {

    //Product, Quantity
    public static Map<Product, Integer> products = null;

    public static Product getProduct(String category) throws Exception {
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

        return product;

    }

    public void addAnyProductToBasket(Product testProduct) {
        // productta tanımlı ürünün ad - fiyatını kıyaslar. eğer eşleşiyorlarsa mapin içindeki ögeyi bulup QTY sayısını 1 arttırır


        Iterator<Product> iterator = products.keySet().iterator();
        String expected = testProduct.toString();

        int i = -1; // eşleşip eşleşmediğini kontrol etmek için
      
        while (iterator.hasNext()) {
            String actual = iterator.next().toString();
            if (actual.equals(expected)) {
                i = i + 1;
                break;
            }

        }
        //ürün ismi-fiyatı eşleşmediyse map e yeni bir öge eklenecek
        if (i != 0) {
            //  testProduct -> mape ekle
            products.put(testProduct, 1);
            logger.info("A new product added to cart -> " + testProduct.toString());
        } else {
            //ürünün sayısını 1 arttır
            int k = products.get(testProduct);
            products.put(testProduct , k+1);
        }


    }


}
