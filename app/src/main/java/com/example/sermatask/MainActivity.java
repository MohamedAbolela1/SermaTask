package com.example.sermatask;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sermatask.Core.Engine;
import com.example.sermatask.io.FileIO;
import com.example.sermatask.io.FileIOImpl;
import com.example.sermatask.repository.EmployeeRepository;
import com.example.sermatask.repository.EmployeeRepositoryImpl;
import com.example.sermatask.serveces.EmployeeService;
import com.example.sermatask.serveces.EmployeeServiceImpl;

import sermatask.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tvOutPut);

        FileIO fileIO = new FileIOImpl();
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        EmployeeService emplService = new EmployeeServiceImpl(employeeRepository);

        Engine engine = new Engine(fileIO, emplService,this,textView);
        engine.run();
    }




}