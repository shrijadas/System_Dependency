package com.dependency.resolution.management;
import java.io.File;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dependency.resolution.management.CommandFactory;
import com.dependency.resolution.management.InputParser;
import com.dependency.resolution.management.command.CommandException;

@SpringBootApplication
public class DependencyResolutionFinder {
	
	 public static void main(String[] args) throws Exception {
	
	  InputParser parser = new InputParser();
      CommandFactory cf = CommandFactory.init();
      Scanner scanner = new Scanner(new File("C:\\Users\\TEMP\\Desktop\\shri\\dependency-resolution\\src\\main\\resources\\input.txt"));
      
      while (scanner.hasNext()) {
          String line = scanner.nextLine();
          System.out.println(line);
          String[] arguments = parser.parse(line);
          try {
              String response = cf.execute(arguments);
              if (response != null) {
                  System.out.print(response);
              }
          } catch (CommandException e) {
              System.out.println(e.getMessage());
          }
      }

      scanner.close(); 
	 }
}
