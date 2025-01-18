import java.util.*;
/*
Purse (class)
	cash: Map<Denomination, Integer>   // represents the money in the purse
	add(type: Denomination, num: int): void  // adds a number of a particular denomination
remove(type: Denomination, num: int): double //diminishes the money in the purse and returns that amount.
	getValue(): double    // returns the amount of money in the Purse
	toString(): String    // returns a string representation of the Purse and its contents

 */
public class Purse {
    //construction of Hash Map
    public Map<Denomination,Integer> map = new HashMap<>();

    //Method to add currency to Purse
    public void add(Denomination type, int num) {


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
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(entry.getKey().name())
                    .append(" ")
                    .append(entry.getValue());
        }
        String output = result.toString();

        return output;
    }


    //Testing Ground
    public static void main(String[] args) {
        Purse purse = new Purse();
        Denomination hundred = new Denomination("Hundred",100.0,"Bill","hundred.png");
        Denomination twenty = new Denomination("Twenty",20.0,"Bill","twenty.png");
        Denomination ten = new Denomination("Ten",10.0,"Bill","ten.png");
        Denomination five = new Denomination("Five",5.0,"Bill","five.png");
        Denomination dollar = new Denomination("Dollar", 1.0, "Bill", "dollar.png");
        Denomination quarter = new Denomination("Quarter", 0.25, "Coin", "quarter.png");
        Denomination dime = new Denomination("Dime", 0.1, "Coin", "dime.png");
        Denomination penny = new Denomination("Penny", 0.01, "Coin", "penny.png");
        purse.add(quarter, 1);
        purse.add(dollar, 1);
        purse.add(dime, 2);
        purse.add(penny, 3);

        System.out.println(String.format("%.2f",purse.getValue()));
        System.out.println(purse.toString());

    }
}
