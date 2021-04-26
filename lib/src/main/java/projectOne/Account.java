package projectOne;

public class Account {
    private String acctName;
    private Double acctBalance;

    public Account(String acctName, Double acctBalance){
        this.acctName = acctName;
        this.acctBalance = acctBalance;
    }

    public Account(){

    }

    public String getAcctName(){
        return acctName;
    }

    public Double getAcctBalance(){
        return acctBalance;
    }

    public void setAcctName(String acctName){
        this.acctName = acctName;
    }

    public void setAcctBalance(Double acctBalance){
        this.acctBalance = acctBalance;
    }
}
