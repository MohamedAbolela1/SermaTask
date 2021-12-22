package com.example.sermatask.repository;



import com.example.sermatask.model.Record;

import java.util.Collection;
import java.util.List;


public interface EmployeeRepository {

    void save(Record record);

    void saveAll(Collection<Record> records);

    List<Record> getAllRecords();
}
