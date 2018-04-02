public class FactoryDriver {
    public static void main(String[] args){

        String country = "USA";
        Currency usa = CurrencyFactory.createCurrency(country);
        System.out.println("USA currency " + usa.getSymbol());
    }
}
