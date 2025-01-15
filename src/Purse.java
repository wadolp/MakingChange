import java.util.*;

public class Purse {
    //construction of Hash Map
    Map<Denomination,Integer> map = new HashMap<>();

    //Method to add currency to Purse
    public void add(Denomination type, int num) {

        //Function provided by ChatGPT
        map.merge(type,num, Integer::sum);

    }

    //Method to remove currency and return amount in purse.
    public double remove(Denomination type, int num) {
        //for difference
        map.merge(type,(-1*num), Integer::sum);

        return this.getValue();
    }

    //Method to return amount in purse
    public double getValue(){
        double total = 0;
        //Function to add up total amount
        //*******************************
        for (var entry : map.entrySet()) {
            Denomination denomination = entry.getKey(); // Get the key (Denomination)
            int count = entry.getValue();               // Get the value (Integer count)

            // Add to total: (denomination's worth per piece) * (count of pieces)
            total += denomination.amt() * count;
        }


        return total;
    }


    //Testing Ground
    public static void main(String[] args) {
        Purse purse = new Purse();
        Denomination dollar = new Denomination("Dollar", 1.0, "Bill", "dollar.png");
        Denomination quarter = new Denomination("Quarter", 0.25, "Coin", "quarter.png");
        Denomination dime = new Denomination("Dime", 0.1, "Coin", "dime.png");
        Denomination penny = new Denomination("Penny", 0.01, "Coin", "penny.png");
        purse.add(quarter, 1);
        purse.add(dollar, 1);
        purse.add(dime, 2);
        purse.add(penny, 3);

        System.out.println(String.format("%.2f",purse.getValue()));

    }
}
