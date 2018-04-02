public class CurrencyFactory {

    public static Currency createCurrency(String country){
        switch(country) {
            case "USA":
                return new USDollar();
            case "Germany":
                return new Euro();
            case "France":
                return new Euro();
        }

        }
    }
}
