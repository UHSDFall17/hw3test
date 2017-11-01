package com.UH.AnmolValabh.hw3;

import org.apache.commons.cli.*;
import org.apache.commons.cli.DefaultParser;
import static java.lang.System.exit;
import static java.lang.System.out;

public class Main {
	

    public static int binSearch(Comparable[] Arraylist, Comparable key) { // Binary search function
        int first = 0; 
        
        int last = Arraylist.length - 1;
        
        while (last >= first) 
        {
            int mid = first + (last - first) / 2;

            if (Arraylist[mid].compareTo(key) == 0) 
            {
                return 1;
            }

            if (Arraylist[mid].compareTo(key) < 0) 
            {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        CommandLineParser cmdParse = new DefaultParser();	
        Options options = new Options(); 

        /*Option setType = Option.builder().longOpt("type").hasArg().required(true).build();
        options.addOption(setType);
        
        Option setKey = Option.builder().longOpt("key").hasArg().required(true).build();
        options.addOption(setKey);
        
        Option setList = Option.builder().longOpt("list").hasArg().valueSeparator(' ').required(true).build();
        options.addOption(setLise);*/

		Option setType = new Option("t", "type", true, " “i”=int and “s”=string ");
		
		Option setKey = new Option("k", "key", true, " “i”=int and “s”=string ");
		
		Option setList = new Option("l", "list", true, " “i”=integer and “s”=string ");
		
		setList.setArgs(500);
		
		options.addOption(setType);
		options.addOption(setKey);
		options.addOption(setList);

        try {
            CommandLine cmdLine = cmdParse.parse(options, args, true);

            String type = cmdLine.getOptionValue("type");
            
            String key = cmdLine.getOptionValue("key");
            
            String[] arrayList = cmdLine.getOptionValues("list");
            

            if (arrayList.length < 1 && key.isEmpty()) 
            {
                System.out.println("0");
                return;
            }

            if (type.equals("i")) 
            {

                Integer[] arrayInteger = new Integer[arrayList.length];
                
                for (int i = 0; i < arrayList.length; i++) 
                {
                    arrayInteger[i] = Integer.parseInt(arrayList[i]);
                }
                
                int intKey = Integer.parseInt(key);
                
                int output = binSearch(arrayInteger, intKey);
                System.out.println(output);

            } else if (type.equals("s")) {

                int output = binSearch(arrayList, key);
                System.out.println(output);
            }

        } catch (ParseException e) 
        {
            e.printStackTrace();
        }

    }


}