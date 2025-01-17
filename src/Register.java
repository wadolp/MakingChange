public class Register {
    public static void main(String[] args) {
        Register register = new Register();
        Purse purse1 = new Purse();
        purse1 = register.makeChange(54.32);
        System.out.println(purse1.toString());
    }
    public Purse makeChange(double amt){
        amt = amt * 100;
        int int_amt = (int) amt;
        Purse purse = new Purse();
        Denomination hundred = new Denomination("Hundred",100.0,"Bill","hundred.png");
        Denomination twenty = new Denomination("Twenty",20.0,"Bill","twenty.png");
        Denomination five = new Denomination("Five",5.0,"Bill","five.png");
        Denomination dollar = new Denomination("Dollar", 1.0, "Bill", "dollar.png");
        Denomination quarter = new Denomination("Quarter", 0.25, "Coin", "quarter.png");
        Denomination dime = new Denomination("Dime", 0.1, "Coin", "dime.png");
        Denomination nickel = new Denomination("Nickel", 0.05, "Coin", "nickel.png");
        Denomination penny = new Denomination("Penny", 0.01, "Coin", "penny.png");
        do{
            if(int_amt >= 10000){
                int_amt = int_amt - 10000;
                purse.add(hundred,1);
            }
            else if (int_amt >= 2000) {
                int_amt = int_amt - 2000;
                purse.add(twenty,1);
            }
            else if(int_amt >= 500){
                int_amt = int_amt - 500;
                purse.add(five,1);
            }
            else if(int_amt >= 100){
                int_amt = int_amt - 100;
                purse.add(dollar,1);
            }
            else if(int_amt >= 25){
                int_amt = int_amt - 25;
                purse.add(quarter,1);
            }
            else if(int_amt >= 10){
                int_amt = int_amt - 10;
                purse.add(dime,1);
            }
            else if(int_amt >= 5){
                int_amt = int_amt - 5;
                purse.add(nickel,1);
            }
            else if(int_amt >= 1){
                int_amt = int_amt - 1;
                purse.add(penny,1);
            }

        }while(int_amt > 0);



        return purse;
    }
}
