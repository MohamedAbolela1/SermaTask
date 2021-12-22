package  com.example.sermatask.factories;


import com.example.sermatask.model.Team;

public final class TeamFactory {

    public TeamFactory() {
    }

    public static Team execute(long firstEmployeeId, long secondEmployeeId, long overlapDuration) {
        return new Team(
                firstEmployeeId,
                secondEmployeeId,
                overlapDuration);
    }
}
