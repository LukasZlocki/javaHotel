package pl.wsb.hotel;

import java.time.LocalDate;

public class PremiumClient extends Client {
    public enum premiumAccountType {PREMIUM, PREMIUM_PLUS};
    private premiumAccountType accountType;

    // constructor //
    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String country, int numberPhone, String email, premiumAccountType accountType){
        super(id, firstName, lastName, birthDate, country, numberPhone, email);
        this.accountType = accountType;
    }
    @Override
    public String getFullName(){
        //return "[ " + accountType + " ] " + getFirstName() + " " + getLastName();
        return "[ " + accountType + " ] " + super.getFullName();
    }
}
