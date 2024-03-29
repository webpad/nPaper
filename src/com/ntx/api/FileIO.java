package com.ntx.api;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Helpers for doing basic file IO.
 *
 * @author yariv
 */
public class FileIO {

    static Context mContext;

    /**
     * Write the data to the file indicate by fileName. Create the file if it
     * isn't exist.
     *
     * @param activity
     * @param data
     * @param fileName
     * @throws IOException
     */
    private static void write(Context mContext, String data, String fileName) throws IOException {
        FileOutputStream fo = null;
        BufferedWriter bw = null;
        try {
            fo = mContext.openFileOutput(fileName, 0);
            bw = new BufferedWriter(new FileWriter(fo.getFD()));
            bw.write(data);
            bw.flush();
          } finally {
            try {
                bw.close();
                fo.close();
            } catch (Exception e) {
              // ignore exceptions generated by close()
            }
          }
    }

    /**
     * Read the contents of the file indicated by fileName
     *
     * @param activity
     * @param fileName
     * @return the contents
     * @throws IOException
     */
    private static String read(Context mContext, String fileName) throws IOException {
        FileInputStream fi = null;
        BufferedReader br = null;
        StringBuilder sb;
        try {
            fi = mContext.openFileInput(fileName);
            br = new BufferedReader(new InputStreamReader(fi));
            sb = new StringBuilder();
            while (br.ready()) {
                String line = br.readLine();
                sb.append(line);
            }
        } finally {
            try {
                br.close();
                fi.close();
            } catch (Exception e) {
                // ignore exceptions generated by close()
            }
        }

        String data = sb.toString();
        return data;
    }

    public static String readData(Context mContext, String DataName) {
        String read_cache = "";
        try {
            read_cache = read(mContext, DataName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return read_cache;
    }

    public static void writeData(Context mContext, String Data, String DataName) {
        try {
            write(mContext, Data, DataName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
