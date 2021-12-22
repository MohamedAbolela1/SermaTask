package com.example.sermatask.Core;


import static com.example.sermatask.constants.ApplicationConstants.BEST_TEAM_PATTERN;
import static com.example.sermatask.constants.ApplicationConstants.EMPTY_COLLECTION_SIZE;
import static com.example.sermatask.constants.ApplicationConstants.INDEX_ZERO;
import static com.example.sermatask.constants.ApplicationConstants.NO_TEAMS_MSG;
import android.content.Context;
import android.widget.TextView;
import com.example.sermatask.factories.RecordFactory;
import com.example.sermatask.io.FileIO;
import com.example.sermatask.model.Record;
import com.example.sermatask.model.Team;
import com.example.sermatask.serveces.EmployeeService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Engine implements Runnable {

    private FileIO fileIO;
    private EmployeeService emplService;
    private Context context;
    private TextView textView;

    public Engine(FileIO fileIO, EmployeeService emplService, Context context, TextView textView) {
        this.fileIO = fileIO;
        this.emplService = emplService;
        this.context = context;
        this.textView = textView;
    }

    @Override
    public void run() {
        //Read all records data from .txt file

        List<Record> records = null;
        try {
            records = this.fileIO.readFile(context)
                    .stream()
                    .map(RecordFactory::execute)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Save all employee records into "database"
        this.emplService.addEmployeeRecords(records);

        //Find all team, couple of employees which r worked under same project and have overlap
        List<Team> teams = this.emplService.findAllTeamsWithOverlap();

        printResult(teams);
    }

    /**
     * If don't have couple of employees which are worked together under same project
     * will be print message with text "Doesn't exist teams", otherwise
     * will be find and print the team with best overlap under their joint projects.
     **/
    private void printResult(List<Team> teams) {
        if (teams.size() != EMPTY_COLLECTION_SIZE) {
            teams.sort((team1, team2) ->
                    (int) (team2.getTotalDuration() - team1.getTotalDuration()));
            Team bestTeam = teams.get(INDEX_ZERO);


            textView.setText(String.format(BEST_TEAM_PATTERN,
                    bestTeam.getFirstEmployeeId(),
                    bestTeam.getSecondEmployeeId(),
                    bestTeam.getTotalDuration()));
        } else {
            textView.setText(NO_TEAMS_MSG);
        }
    }
}
