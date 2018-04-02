public class Cake {

    private final double SUGAR;
    private final double BAKINGSODA;
    private final double VEGOIL;
    private final double VANILLA;
    private final double FLOUR;
    private final double ALMONDMILK;

    public static class CakeBuilder{
        private double sugar;
        private double bakingSoda;
        private double vegOil;
        private double vanilla;
        private double flour;
        private double almondMilk;

        public CakeBuilder sugar(double cups){
            this.sugar = cups;
            return this;
        }
        public CakeBuilder bakingSoda(double teaspoons){
            this.bakingSoda = teaspoons;
            return this;
        }
        public CakeBuilder vegOil(double cups){
            this.vegOil = cups;
            return this;
        }
        public CakeBuilder vanilla(double teaspoons){
            this.vanilla = teaspoons;
            return this;
        }
        public CakeBuilder flour(double cups){
            this.flour = cups;
            return this;
        }
        public CakeBuilder almondMilk(double cups){
            this.almondMilk = cups;
            return this;
        }

        public Cake bake(){
            return new Cake(this);
        }


    }
    public Cake(CakeBuilder cake){
        this.ALMONDMILK = cake.almondMilk;
        this.SUGAR = cake.sugar;
        this.BAKINGSODA = cake.bakingSoda;
        this.FLOUR = cake.flour;
        this.VEGOIL = cake.vegOil;
        this.VANILLA = cake.vanilla;
    }
    @Override
    public String toString(){
        return "cake made";
    }

}
