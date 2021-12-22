package com.example.sermatask.io;



import android.content.Context;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import sermatask.R;

public class FileIOImpl implements FileIO {

    @Override
    public List<String> readFile(Context context) throws IOException {
        List<String> content = new ArrayList<>();
        String str="";
        InputStream is = context.getResources().openRawResource(R.raw.employees);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            while ((str = reader.readLine()) != null) {
                if (!str.trim().isEmpty()) {
                    content.add(str);
                }
            }
        }
        Objects.requireNonNull(is).close();
        return content;
    }


    @Override
    public void write(String fileContent, String file)  {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(fileContent);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            //log here...
        }
    }
}
