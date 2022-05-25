package Dependency_Injection;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    // constructor
    public TrackCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    // setter
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
