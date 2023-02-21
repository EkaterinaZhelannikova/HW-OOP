package lesson2.game;

public class SwimmingPollObstacleAdapter implements Obstacle {
    
    private final SwimmingPoll swimmingPoll;

    public SwimmingPollObstacleAdapter(SwimmingPoll swimmingPoll) {
        this.swimmingPoll = swimmingPoll;
    }

    @Override
    public boolean pass(Participant participant) {
        return swimmingPoll.pass(participant);
    }
}
