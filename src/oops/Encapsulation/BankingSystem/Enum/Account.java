package oops.Encapsulation.BankingSystem.Enum;

public enum Account {
    Saving(3,0) {
        @Override
        public double getMinimumBalance() {
            return MinimumBalance;
        }
        @Override
        public double rate(){
            return Rate;
        }
    },Current(0,1000) {
        @Override
        public double getMinimumBalance() {
            return MinimumBalance;
        }
        @Override
        public double rate(){
            return Rate;
        }
    },Fixed(6.5,10000) {
        @Override
        public double getMinimumBalance() {
            return MinimumBalance;
        }
        @Override
        public double rate(){
            return Rate;
        }

    };

    public  final  double Rate;
    public   final double MinimumBalance;

    public abstract double getMinimumBalance();
    public abstract  double rate();
    Account(double rate, double minimumBalance){
        this.Rate=rate;
        this.MinimumBalance=minimumBalance;
    }
}
