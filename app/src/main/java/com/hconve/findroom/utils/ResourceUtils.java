package com.hconve.findroom.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class ResourceUtils {
    public static int getColor(Context context, int resourceId) {
        return context.getResources().getColor(resourceId);
    }

    public static String readAllText(Context context, int resourceId) throws IOException {
        InputStream is = context.getResources().openRawResource(resourceId);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            is.close();
        }
        return writer.toString();
    }
}
