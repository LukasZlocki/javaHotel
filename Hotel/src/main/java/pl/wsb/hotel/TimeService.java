package pl.wsb.hotel;

import java.time.LocalTime;

public class TimeService extends SpecialService{
    @Override
    public void orderService() {
        System.out.println("Actual time: " + LocalTime.now());
    }

    @Override
    public void orderClothesCleaning() {
        // code body here... //
    }

    @Override
    public void orderNetflix() {
        // code body here... //
    }
}
