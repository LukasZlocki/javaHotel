package pl.wsb.hotel;

import java.time.LocalTime;

public class TimeService extends SpecialService {

    // cosntructor //
    public TimeService(String name){
        super(name);
    }
    @Override
    public void orderService() {
        System.out.println("Actual time: " + LocalTime.now());
    }

    @Override
    public void helpService() {
        System.out.println("Time help request recieved. We will call you within minute.");
    }

    @Override
    public void payForService() {
        System.out.println("Time service payed.");
    }

    @Override
    public void claimService() {
        System.out.println("Time service claim recieved.");
    }
}
