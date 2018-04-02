import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class AssociateDriver {


    private static Scanner sc;

    public static void main(String[] args) {

        AssociateCollection associateCollection = new AssociateCollection();
        //System.out.println(associateCollection);

        Collections.shuffle(associateCollection);
		for(Associate a : associateCollection) {
			System.out.println(a.getName());
		}
//
//        sc = new Scanner(System.in);
//
//        Iterator<Associate> itr = associateCollection.iterator();
//
//        while(itr.hasNext()) {
//            System.out.println(itr.next().getName());
//            sc.nextLine();
//        }
//
//        System.out.println("Everyone has been called");

    }

}