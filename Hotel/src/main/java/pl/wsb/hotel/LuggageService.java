package pl.wsb.hotel;

public class LuggageService extends SpecialService{
    @Override
    public void orderService() {
        System.out.println("Your Luggage is in our hotel.");
    }

    @Override
    public void orderClothesCleaning() {
        System.out.println("Your ordered cleaning of clothes.");
    }

    @Override
    public void orderNetflix() {
        System.out.println("Your ordered Netflix.");
    }
}
