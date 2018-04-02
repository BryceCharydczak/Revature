public class BuilderDriver {
    public static void main(String[] args){

        Cake cake = new Cake.CakeBuilder().almondMilk(1).bakingSoda(1).flour(1).sugar(1).vanilla(1).vegOil(1).bake();
    }
}
