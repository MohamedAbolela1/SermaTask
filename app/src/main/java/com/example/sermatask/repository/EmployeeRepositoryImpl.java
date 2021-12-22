package com.example.sermatask.repository;


import com.example.sermatask.model.Record;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Record> database;

    public EmployeeRepositoryImpl() {
        this.database = new ArrayList<>();
    }

    @Override
    public void save(Record record) {
        this.database.add(record);
    }

    @Override
    public void saveAll(Collection<Record> records) {
        this.database.addAll(records);
    }

    @Override
    public List<Record> getAllRecords() {
        return Collections.unmodifiableList(this.database);
    }
}
