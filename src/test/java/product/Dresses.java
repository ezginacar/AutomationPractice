package product;

class Dresses implements Product{
    private String name;
    private double price;

    @Override
    public void name(String productName) {
       this.name = productName;
    }

    @Override
    public void price(double productPrice) {
       this.price = productPrice;
    }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public double getPrice() {
      return price;
   }


   @Override
    public String toString() {
       return "Dress info ->{" +
               "name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
 }
