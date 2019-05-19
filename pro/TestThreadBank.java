
public class TestThreadBank{

    public static void main(String[] args){
        Account a = new Account(100, "wyk");

        Drawing draw1 = new Drawing(80,a);
        Drawing draw2 = new Drawing(80,a);

        draw1.start();
        draw2.start();
    }
}

class Account{
    int money;
    String name;
    public Account(int money,String name){
        super();
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    int drawingNumber;
    Account account;
    int expenseTotal;

    public Drawing(int drawingNumber,Account account){
        super();
        this.drawingNumber = drawingNumber;
        this.account = account;
    }

    @Override
    public void run(){

        if(account.money - drawingNumber < 0)
            return ;
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        account.money -= drawingNumber;
        expenseTotal += drawingNumber;
        System.out.println(this.getName() + "账户余额： " + account.money);
        System.out.println(this.getName() + "总共花费： " + expenseTotal);
    }
}