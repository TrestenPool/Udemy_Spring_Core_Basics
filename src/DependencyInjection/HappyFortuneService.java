package DependencyInjection;

public class HappyFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "You are doing great, keep it up";
    }
}
