package pl.wsb.hotel;

public abstract class SpecialService {
    private String name;
    public abstract void orderService();
    // additional extra services //
    public abstract void orderClothesCleaning();
    public abstract void orderNetflix();

    public String getServiceName(){
        return name;
    }
}
