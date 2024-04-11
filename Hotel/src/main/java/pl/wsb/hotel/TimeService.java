package pl.wsb.hotel;

import java.time.LocalTime;

public class TimeService extends SpecialService {
    @Override
    public void orderService() {
        System.out.println("Actual time: " + LocalTime.now());
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
