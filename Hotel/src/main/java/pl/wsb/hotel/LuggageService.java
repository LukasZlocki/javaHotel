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
        // add code here ... //
    }

    @Override
    public void payForService() {
        // add code here ... //
    }

    @Override
    public void claimService() {
        // add code here ... //
    }

}
