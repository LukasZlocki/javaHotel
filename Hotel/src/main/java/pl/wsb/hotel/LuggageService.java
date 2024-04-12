package pl.wsb.hotel;

public class LuggageService extends SpecialService {

    // constructor //
    public LuggageService(String name){
        super(name);
    }

    @Override
    public void orderService() {
        System.out.println("Your Luggage is in our hotel now.");
    }

    @Override
    public void helpService() {
        System.out.println("Luggage help request recieved. We will call you within minute.");
    }

    @Override
    public void payForService() {
        System.out.println("Luggage service payed.");
    }

    @Override
    public void claimService() {
        System.out.println("Luggage service claim recieved.");
    }

}
