package com.example.sermatask.serveces;


import com.example.sermatask.model.Record;
import com.example.sermatask.model.Team;

import java.util.List;

public interface EmployeeService {

    void addEmployeeRecords(List<Record> records);

    List<Team> findAllTeamsWithOverlap();
}
