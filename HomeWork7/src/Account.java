public class Account {

    private String id;
    private String name;
    private int balnce = 0;
    private int amount;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public Account(String id, String name, int balnce) {
        this.id = id;
        this.name = name;
        this.balnce = balnce;

    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    

    public void setCredit(int amount) {
        this.amount = amount;
        this.balnce -= amount;
    }

    public int getCredit() {
        return this.balnce;
    }
    public void setDebit(int amount) {
        this.amount = amount;
        balnce = balnce + amount;
    }

    public int getBalnce() {
        return balnce;
    }

    public int getDebit() {
        return balnce;
    }

    public void TransferTo(Account another,int amount){
        if (balnce>amount){
            this.amount = amount;
            another.balnce = another.balnce +amount;
        }else System.out.println("balnce less than amount! ");



    }
    public int getTransferTo(Account another){
        return another.balnce;
    }


    public void setBalnce(int balnce) {
        this.balnce = balnce;
    }

    public String toString() {
        return "the ID as : " + this.id + " and NAME is " + this.name + " the balnce is : " + this.balnce;
    }

}
