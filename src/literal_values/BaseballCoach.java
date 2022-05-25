package literal_values;


public class BaseballCoach implements Coach {
    private String emailAddress;
    private String teamName;

    // constructor
    public BaseballCoach() {
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }

    // setters
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // getters
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeamName() {
        return teamName;
    }
}
