package pl.wsb.hotel;

public abstract class SpecialService {
    private String name;
    public abstract void orderService();
    public abstract void helpService();
    public abstract void payForService();
    public abstract void claimService();
    public String getServiceName() {
        return name;
    }
}
