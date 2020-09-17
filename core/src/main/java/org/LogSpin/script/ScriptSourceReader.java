package org.LogSpin.script;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScriptSourceReader {
    public String getScriptSource(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            String s;
            while ((s = bf.readLine()) != null) {
                buffer.append("\n");
                buffer.append(s.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return buffer.toString();
    }
}
