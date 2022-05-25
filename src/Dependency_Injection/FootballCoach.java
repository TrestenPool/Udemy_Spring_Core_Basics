package Dependency_Injection;

public class FootballCoach implements Coach{
    private FortuneService fortuneService;

    // empty constructor
    public FootballCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    // setter for the dependency
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
