package com.example.sermatask.io;

import android.content.Context;

import java.io.IOException;
import java.util.List;

public interface FileIO {

    List<String> readFile (Context context) throws IOException;

    void write(String fileContent, String file);

}
