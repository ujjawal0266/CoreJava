package oops.Interface;

import com.sun.nio.sctp.SendFailedNotification;

import java.util.Date;
import java.util.HashMap;

class m1{

    void main() throws Exception{
        test1 t=new test1(new UPIPayment("123323@sbi","12312323@sbi",1000));
        t.ps.process();
    }
}

public class test1 {
    // payment system
    // Payment System (Interface, Polymorphism)
    //
    //Create interface: PaymentMethod
    //Implementations: CreditCard, DebitCard, UPI, CashOnDelivery
    //Learn: Different payment behaviors, validation logic
    PaymentSystem ps;  // constrcutreo injection
    test1(PaymentSystem psImplement){
        this.ps=psImplement;
    }

}
class verifyUserDataException extends Exception{
    verifyUserDataException(String e){
        super(e);
    }
}
class PaymentFailed extends Exception {
    PaymentFailed(String e){
            super(e);
    }
}


interface PaymentSystem{
    //Template Method
    default void process() throws PaymentFailed {
        try{
            VerifyInput();
            VerifyUserData();
            VerifyUserHasEnoughMoney();
            ValidateRecieverAccount();
            Payment();
            System.out.println("payment Successfull ");
        }  catch (Exception e) {
            // payment failed
            throw new PaymentFailed("Payment failed = "+e);
        }
    }
    void VerifyInput() throws IllegalArgumentException;
    void VerifyUserData()throws verifyUserDataException;
    void VerifyUserHasEnoughMoney() throws PaymentFailed;
    boolean ValidateRecieverAccount() throws Exception;
    void Payment();
    double getAmount();
}

class UPIPayment implements  PaymentSystem{
    private String SenderUPINumber;
    private String RecieverUPINumber;
    private double amount;

    UPIPayment(String sender,String reciever,double amount){
        sender=sender.trim();
        reciever=reciever.trim();
        this.RecieverUPINumber=reciever;
        this.SenderUPINumber=sender;
        this.amount=amount;
    }

    @Override
    public void VerifyInput() throws IllegalArgumentException {
        ///  verifiy as per buisness rules
        if(SenderUPINumber.isEmpty()||SenderUPINumber.indexOf('@')==-1){
            throw new IllegalArgumentException("not valid upi number");
        }
        if(RecieverUPINumber.isEmpty()||RecieverUPINumber.indexOf('@')==-1){
            throw new IllegalArgumentException("not valid upi number ");
        }
        if(amount<=0){
            throw new IllegalArgumentException("not Valid amount");
        }
    }

    @Override
    public void VerifyUserData() throws verifyUserDataException {
        // verify  then authentication of user is real or some fraud
        // get user inptu of the pin
        int userInput= Integer.parseInt(IO.readln());
        int actualPin=1234;
        if(userInput!=actualPin){
            throw new verifyUserDataException("not match pin ! Please try again ");
        }
    }

    @Override
    public void VerifyUserHasEnoughMoney() throws PaymentFailed {
        // verify
        int bankBalanceOfSender=1000;
        if(bankBalanceOfSender<amount){
          throw new PaymentFailed("not enough balance present");
        }
    }
    private boolean checkUpiExist(){
        // !checker   return false;

        return true;
    }
    @Override
    public boolean ValidateRecieverAccount() throws Exception {
        if(!checkUpiExist()){
            throw new Exception("fucked up reciever account not valid ");
        }
        return true;
    }

    @Override
    public void Payment() {
        // payment

    }

    @Override
    public double getAmount() {
        return amount;
    }

}
class CreditCard implements  PaymentSystem{

    private HashMap<Long,CreditCardModel> accountStore=new HashMap<>();

    // copy chatgpt stripes paymetho method credit card ok
    ///  getting card infomraion
    private long SenderAccountNo; private Date ExpireData; private byte CVC;
    private String fullName;
    private String address;
    boolean TermsAndCondition;
    private long RecieverAccountNo;
    private double amount;

    class CreditCardModel{
        private long SenderAccountNo; private Date ExpireData; private byte CVC;
        private String fullName;
        private String address;
        boolean TermsAndCondition;
        private long RecieverAccountNo;
        private double amount;

        public long getSenderAccountNo() {
            return SenderAccountNo;
        }

        public void setSenderAccountNo(long senderAccountNo) {
            SenderAccountNo = senderAccountNo;
        }

        public Date getExpireData() {
            return ExpireData;
        }

        public void setExpireData(Date expireData) {
            ExpireData = expireData;
        }

        public byte getCVC() {
            return CVC;
        }

        public void setCVC(byte CVC) {
            this.CVC = CVC;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public boolean isTermsAndCondition() {
            return TermsAndCondition;
        }

        public void setTermsAndCondition(boolean termsAndCondition) {
            TermsAndCondition = termsAndCondition;
        }

        public long getRecieverAccountNo() {
            return RecieverAccountNo;
        }

        public void setRecieverAccountNo(long recieverAccountNo) {
            RecieverAccountNo = recieverAccountNo;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }


    CreditCard(CreditCardModel argument){ // as per i study that if the arguments become too heavier so just try to create one DTO or MODEL ok
        accountStore.put(argument.getSenderAccountNo(),argument);
        this.SenderAccountNo=argument.getSenderAccountNo();
        this.RecieverAccountNo=argument.getRecieverAccountNo();
        this.amount=argument.getAmount(); //
        this.ExpireData =argument.ExpireData; //
        this.CVC=argument.getCVC();
        this.address= argument.getAddress();
        this.TermsAndCondition=argument.isTermsAndCondition();
        this.fullName=argument.getFullName();
    }

    ///  requirement is to  need 8 digit account number ok

    @Override
    public void VerifyInput() throws IllegalArgumentException {
        if(!TermsAndCondition){
            throw new IllegalArgumentException("please chck the box ");
        }
        if(address.isEmpty()||fullName.isEmpty()){
            throw new IllegalArgumentException("username or address not fullfilled ");
        }
        // same
        if(SenderAccountNo<10_00_00000||SenderAccountNo>=99_99_99999){
            throw new IllegalArgumentException("wrong account no ! Try Again");
        }
        if(amount<=0){
            throw new IllegalArgumentException("not right amount insert again ");
        }
        if(ExpireData==null){
            throw new IllegalArgumentException("not Selected ExpireDate ");
        }
        if(CVC>1000||CVC<100){
            throw new IllegalArgumentException("CVC Wrong bro ");
        }
    }
    private boolean isAccountActivated(long account){
        // check from database it has that if not so just try to return false
        return true;
    }
    // verify user account is valid or nto ?
    private boolean validated(long accountid){
            // validate thourhg the get account model from the hashmap through teh accountid
            // and process that account is valid /
        return true;
        }

    @Override
    public void VerifyUserData() throws verifyUserDataException {
        if(isAccountActivated(SenderAccountNo)){
            throw new IllegalArgumentException("not right Account number ");
        }
        // same
        if(ExpireData.before(new Date())){
            throw new IllegalArgumentException("not right amount insert again ");
        }
        if(validated(SenderAccountNo)){
            throw new IllegalArgumentException("not right amount insert again ");
        }
    }


    @Override
    public void VerifyUserHasEnoughMoney() throws PaymentFailed {
        double userHas=1000;
        if(userHas<amount){
            throw new PaymentFailed("not enoufh money ");
        }

    }

    @Override
    public boolean ValidateRecieverAccount() throws Exception {
        if(validated(RecieverAccountNo)){
            throw new IllegalArgumentException("not right amount insert again ");
        }
        return false;
    }

    @Override
    public void Payment() {
        // payment
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
