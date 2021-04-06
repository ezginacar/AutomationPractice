package product;

class TShirts implements Product{




  private String name;
  private double price;


  @Override
  public String getName() {
   return name;
  }
  @Override
  public double getPrice() {
   return price;
  }

  @Override
  public void name(String productName) {
   this.name = productName;
  }

  @Override
  public void price(double productPrice) {
   this.price = productPrice;
  }


  @Override
  public String toString() {
   return "T-shirt info->{" +
           "name='" + name + '\'' +
           ", price=" + price +
           '}';
  }
 }
