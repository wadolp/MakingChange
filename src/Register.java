public class Register {
    public static void main(String[] args) {
        Register register = new Register();
        Purse purse1 = new Purse();
        purse1=register.makeChange(54.32);
        System.out.println(purse1.toString());
    }
    public Purse makeChange(double amt){
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
            if(amt > 100){
                amt = amt - 100;
                purse.add(hundred,1);
            }
            else if (amt > 20) {
                amt = amt - 20;
                purse.add(twenty,1);
            }
            else if(amt > 5){
                amt = amt - 5;
                purse.add(five,1);
            }
            else if(amt > 1){
                amt = amt - 1;
                purse.add(dollar,1);
            }
            else if(amt > 0.25){
                amt = amt - 0.25;
                purse.add(quarter,1);
            }
            else if(amt > 0.1){
                amt = amt - 0.1;
                purse.add(dime,1);
            }
            else if(amt > 0.05){
                amt = amt - 0.05;
                purse.add(nickel,1);
            }
            else if(amt > 0.01){
                amt = amt - 0.01;
                purse.add(penny,1);
            }

        }while(amt > 0);



        return purse;
    }
}
