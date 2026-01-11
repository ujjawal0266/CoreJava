package oops.Encapsulation.BankingSystem.utils;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateAccountNumber {
    private final static AtomicLong AccountNumber=new AtomicLong(10000);
    public static long Next(){
        return AccountNumber.incrementAndGet();
    }
}
