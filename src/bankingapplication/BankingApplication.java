/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapplication;

import java.util.Scanner;

public class BankingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount mBankAccount=new BankAccount("Sam","BA001");
        mBankAccount.showMenu();
    }
    
}

class BankAccount
{
    String customerName;
    String customerId;
    int balance;
    int prevTransaction;
    
    BankAccount(String customerName,String customerId){
        this.customerId=customerId;
        this.customerName=customerName;                
    }
    
    void deposit(int amount)
    {
        if(amount!=0)
        {
            balance=balance+amount;
            prevTransaction=amount;
        }
    }
    
    void withdraw(int amount)
    {
         if(amount!=0)
        {
            balance=balance-amount;
            prevTransaction=-amount;
        }
        
    }  
  
    
    void getPreviousTrans()
    {
        if(prevTransaction>0)
        {
            System.out.println("Deposited "+prevTransaction);
        }
        else if(prevTransaction<0){
            System.out.println("Withdraw "+Math.abs(prevTransaction));

        }
        else
        {
            System.err.println("No Transaction Occured");
        }
        
    }
    
    void showMenu()
    {
        char option='\0';
        Scanner scanner=new Scanner(System.in);
        
        System.out.println("Welcome "+customerName);
        System.out.println("Your Id is: "+customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E.Exit");
            
        do{
            System.out.println("==================================");
            System.out.println("Enter Your Option");
            option= scanner.next().charAt(0);
            System.out.println("==================================");
            switch(option)
            {
                case 'A':
                    System.out.println("--------------------------------"); 
                    System.out.println("Your balance is "+balance);
                    System.out.println("--------------------------------"); 
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("--------------------------------"); 
                    System.out.println("Enter amount to be deposited ");                   
                    System.out.println("--------------------------------"); 
                    int amountDeposit=scanner.nextInt();
                    deposit(amountDeposit);
                    System.out.println("\n");
                    break;  
                case 'C':
                    System.out.println("--------------------------------"); 
                    System.out.println("Enter amount to be withdraw ");                   
                    System.out.println("--------------------------------"); 
                    int amountWithdraw=scanner.nextInt();
                    withdraw(amountWithdraw);
                    System.out.println("\n");
                    break; 
                case 'D':
                    System.out.println("--------------------------------"); 
                    getPreviousTrans();
                    System.out.println("--------------------------------");                   
                    System.out.println("\n");
                    break;  
                case 'E':
                    System.out.println("********************************");
                    break;
                default:
                    System.out.println("Invalid Option! Please try again");
                    break;                    
            }
        }while(option!='E');
        System.out.println("Thank you for using our services.");
    }
} 
