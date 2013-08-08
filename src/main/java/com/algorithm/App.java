package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Long LOW = -10000L;
    private static Long HIGH = 10000L;

    private static Set<Long> all = new HashSet<Long>();

    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Calculating two sum..." );
        if(args.length < 1) {
            System.out.println("please provide the data file.");
            System.exit(-1);
        }

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Long start = System.currentTimeMillis();

        try {
            String line = reader.readLine();
            while (null != line) {
                all.add(Long.parseLong(line));
                line = reader.readLine();
            }

        } finally {
            reader.close();
        }

        Long finishLoadData = System.currentTimeMillis();
        System.out.println("data load took:" + (finishLoadData-start)/1000.0);

        long totalTwoNum = 0;

        for(Long t=LOW; t<= HIGH ; t++) {
            for( Long x : all) {
                Long y = t - x;
                if((!x.equals(y)) && all.contains(y)) {
                    totalTwoNum++;
                    break;
                }
            }
        }

        Long done = System.currentTimeMillis();
        System.out.println("find answer took:" + (done - finishLoadData)/1000.0);

        System.out.println("total two sum = " + totalTwoNum);

    }
}
