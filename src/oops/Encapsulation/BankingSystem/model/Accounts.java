package oops.Encapsulation.BankingSystem.model;

import oops.Encapsulation.BankingSystem.Enum.Account;
import oops.Encapsulation.BankingSystem.utils.GenerateAccountNumber;

public class Accounts {

    private final long AccountId;
    private String AccountHolderName;
    private double Balance;
    private Account Types;

    Accounts(String AccountHolderName,Account Types){
        this.AccountHolderName=AccountHolderName;
        this.Types=Types;
        this.AccountId= GenerateAccountNumber.Next();
        this.Balance=Types.getMinimumBalance();
    }

    Account GetAccountTypes(){
        return Types;
    }
    void WithDraw(int amount){
        if(amount+Types.getMinimumBalance()>Balance){
            throw new IllegalArgumentException("Balance is not sufficient to make this Transaction");
        }
        Balance-=amount;
    }
    void Deposite(int amount){
        Balance+=amount;
    }
    double GetBalance(){
        return Balance;
    }
    double GetRate(){

        return Types.rate();
    }
    void SoutAccountInfo(){
        System.out.println("________________________________");
        System.out.println("__ACCOUNT_INFORMATION___________");
        System.out.println("--------------------------------");
        System.out.println("ACCOUNTHOLDER = "+AccountHolderName);
        System.out.println("AccountTypes = "+GetAccountTypes());
        System.out.println("AccountID = "+AccountId);
        System.out.println("Balance = "+GetBalance());
        System.out.println("_________________________________");
    }
    double CalculateROIofTotalYears(int years){
        return (Balance*Types.rate()*years)*100;
    }

}
