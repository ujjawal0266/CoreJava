package oops;


// do create immutable here fully safe if any one get acess to this it does not matter at all if this going to chnge
class userInfoPojo{
    private  long AccountNo;
    private  String UserName;

    userInfoPojo(long AccountNo,String UserName){
        InsertUserInfo(AccountNo,UserName);
    }

    public long getAccountNo() {
        return AccountNo;
    }
    private void setAccountNo(long accountNo) {
        AccountNo = accountNo;
    }
    public String getUserName() {
        return UserName;
    }
    private void setUserName(String userName) {
        UserName = userName;
    }
    private void InsertUserInfo(long accountNo,String userName){
        // templates method to get process all setter using one method only
        setAccountNo(accountNo);
        setUserName(userName);
    }
}


abstract class bank{
    private final long AccountNumber;
    private final String UserName;
    protected transient double money;
    ///  has a realationship achieved
    protected final userInfoPojo UIPojo;
    bank(long AccountNumber,String UserName,double money){
        this.AccountNumber=AccountNumber;
        this.UserName=UserName;
        this.money=money;
        UIPojo=new userInfoPojo(AccountNumber,UserName);
    }
    public String getUserInfo(){
        return new String("Account INFO \n"+"Account Number = "+AccountNumber+"\n  UserName =  "+UserName+"\n money "+money);
    }
    public abstract userInfoPojo getUserInfo(userInfoPojo NeedInThisPojo);

    public abstract void DepositMoney(double Amount);
    public abstract void WithDrawMoney(double Amount);
}
// abstraction through bank achieved
class SBI extends bank{

    SBI(long AccountNumber, String UserName, double money) {
        super(AccountNumber, UserName, money);
    }

    // polymorphism run time polymorphism via vTable
    @Override
    public String getUserInfo() {
        return super.getUserInfo();
    }



    @Override
    public userInfoPojo getUserInfo(userInfoPojo NeedInThisPojo) {
        return UIPojo;
    }

    @Override
    public void DepositMoney(double Amount) {
        money+=Amount;
    }

    @Override
    public void WithDrawMoney(double Amount) {
        if(money<Amount){
            throw new IllegalArgumentException("Not valid Argument");
        }
        money-=Amount;
    }


}








public class CreateAnClassWhichUtilizedAllOops4Pillors {

}
