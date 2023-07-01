public class Denomination {

    private int OneK;
    private int fiveHund;
    private int twoHund;
    private int oneHund;
    private int fiftyPhp;
    private int twentyPhp;
    private int tenPhp;
    private int fivePhp;
    private int one;
    

    public Denomination() {
        this.OneK = 0;
        this.fiveHund = 0;
        this.twoHund = 0;
        this.oneHund = 0;
        this.fiftyPhp = 0;
        this.twentyPhp = 0;
        this.tenPhp = 0;
        this.fivePhp = 0;
        this.one = 0;
        
    }

    public void setOneK(int quantity) {
        this.OneK = quantity;
    }

    public int getOneK() {
        return OneK;
    }

    public void setfiveHund(int quantity) {
        this.fiveHund = quantity;
    }

    public int getfiveHund() {
        return fiveHund;
    }

    public void settwoHund(int quantity) {
        this.twoHund = quantity;
    }

    public int gettwoHund() {
        return twoHund;
    }

    public void setoneHund(int quantity) {
        this.oneHund = quantity;
    }

    public int getoneHund() {
        return oneHund;
    }

    public void setfiftyPhp(int quantity) {
        this.fiftyPhp = quantity;
    }

    public int getfiftyPhp() {
        return fiftyPhp;
    }

    public void settwentyPhp(int quantity) {
        this.twentyPhp = quantity;
    }

    public int gettwentyPhp() {
        return twentyPhp;
    }

    public void setTen(int quantity) {
        this.tenPhp = quantity;
    }

    public int getTen() {
        return this.tenPhp;
    }

    public void setFive(int quantity) {
        this.fivePhp = quantity;
    }

    public int getFive() {
        return fivePhp;
    }

    public void setOne(int quantity) {
        this.one = quantity;
    }

    public int getOne() {
        return one;
    }

    public int getTotal() {

    int total = 0;
    total += OneK ;
    total += fiveHund ;
    total += twoHund ;
    total += oneHund ;
    total += fiftyPhp ;
    total += twentyPhp ;
    total += tenPhp ;
    total += fivePhp ;
    total += one;
    
    return total;
    
  }

      public void subtractFromDenomination(int denomination, int quantity) {
        switch (denomination) {
            case 1000:
                this.OneK -= quantity;
                break;
            case 500:
                this.fiveHund -= quantity;
                break;
            case 200:
                this.twoHund -= quantity;
                break;
            case 100:
                this.oneHund -= quantity;
                break;
            case 50:
                this.fiftyPhp -= quantity;
                break;
            case 20:
                this.twentyPhp -= quantity;
                break;
            case 10:
                this.tenPhp -= quantity;
                break;
            case 5:
                this.fivePhp -= quantity;
                break;
            case 1:
                this.one -= quantity;
                break;
            default:
                System.out.println("Invalid denomination.");
                break;
        }
    }

    public int getCountForDenomination(int denomination) {
        switch (denomination) {
            case 1000:
                return this.OneK;
            case 500:
                return this.fiveHund;
            case 200:
                return this.twoHund;
            case 100:
                return this.oneHund;
            case 50:
                return this.fiftyPhp;
            case 20:
                return this.twentyPhp;
            case 10:
                return this.tenPhp;
            case 5:
                return this.fivePhp;
            case 1:
                return this.one;
            default:
                System.out.println("Invalid denomination.");
                return 0;
        }
    }
    



    

    public void replenish(int oneK, int fiveHund, int twoHund, int oneHund,
                          int fiftyPhp, int twentyPhp, int tenPhp, int fivePhp, int one) {
        this.OneK += oneK;
        this.fiveHund += fiveHund;
        this.twoHund += twoHund;
        this.oneHund += oneHund;
        this.fiftyPhp += fiftyPhp;
        this.twentyPhp += twentyPhp;
        this.tenPhp += tenPhp;
        this.fivePhp += fivePhp;
        this.one += one;
    }
}
