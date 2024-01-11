import java.util.*;
import java.io.*;

class ATM
{ 
    String name;
    long acc;
    double balance;
    int pin;
    public ATM(String name, long acc,double balance,int pin){
        this.name = name;
        this.balance = balance;
        this.acc = acc;
        this.pin = pin;
    }
    public void Info(){
        System.out.println("Account Holder Name : " + this.name);
        System.out.println("Account Number : " + acc);
        return; 
    }
    
    public void Deposit(double deposit_amount){
        balance += deposit_amount;
        return;
    }
    public void Withdraw(double Withdraw_amount){
        if(balance >= Withdraw_amount){
            balance -= Withdraw_amount;
            System.out.println("Collect your money");
        }
        else{
            System.out.println("Insufficient balance");
        }
        return;
    }
    public void Balance(){
        System.out.println("Your balance amount is " + balance);
        return;
    }
    public boolean checkpin(int num){
            return pin == num;
    }
}


public class BankAccount{
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        HashMap<String,ATM> map = new HashMap<>();
        try {
            while(true){
            System.out.println("-----BANK-----" + "\n" + "Choose..." + "\n" + "1...SignIn" + "\n" + "2...LogIn" + "\n" + "3...Exit");
            int choice = in.nextInt();
		    String username;
            int pin;
            switch(choice){
                case 1:
                    System.out.println("-----SignIn-----");
                    System.out.println("Enter your name : ");
                    in.nextLine();
                    String name = in.nextLine();
                    int acc = 10001+map.size();
                    do{System.out.println("CREATE YOUR USERNAME: " );
                    username = in.nextLine();
                    if(map.containsKey(username)){
                        System.out.println("CREATE ANOTHER ENTERED USERNAME ALREADY EXISTS");
                    }
                }while(map.containsKey(username));
                   do{
                    System.out.println("CREATE YOUR PIN :(only four digits)");
                    pin = in.nextInt();
                    in.nextLine();
                   if(String.valueOf(pin).length()!=4) System.out.println("CREATE VALID PIN");
                   } while(String.valueOf(pin).length()!=4);
                    System.out.println("Your account number is : " + acc);

                    ATM obj = new ATM(name,acc, 0,pin);
                    map.put(username,obj);
                    break;
                case 2:
                    System.out.println("-----LogIn-----");
                    System.out.println("Enter your username: ");
                    in.nextLine();
                    String id = in.nextLine();
                    if(map.containsKey(id)){
                        System.out.println("ENTER PIN");
                        pin = in.nextInt();
                        in.nextLine();
                        ATM holder = map.get(id);
                        if(!holder.checkpin(pin)){
                            System.out.println("wrong pin ATM CLOSED");
                            System.exit(0);
                        }
                        holder.Info();
                        loop : while(true){
                            System.out.println("Choose... " + "1...Deposit " + "2...Withdraw " + "3...Balance " + "4...Exit");
                            int ch = in.nextInt();
                            switch (ch) {
                                case 1:
                                    System.out.println("Enter amount : ");
                                    double deposit_amount = in.nextDouble();
                                    holder.Deposit(deposit_amount);                            
                                    break;
                                case 2:
                                    System.out.println("Enter amount : ");
                                    double Withdraw_amount = in.nextDouble();  
                                    holder.Withdraw(Withdraw_amount);                        
                                    break;
                                case 3:
                                    holder.Balance();                              
                                    break;
                                case 4:                             
                                    break loop;
                                
                                default:
                                    System.out.println("Invalid Input");
                            }
                        }
                    }
                    else    System.out.println("Account username doesn't exit");

                break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");               
                    
            }
		    
		}
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("INVALID INPUT ATM CLOSED");
        }
	}
}
