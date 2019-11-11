import launcher.avaj.exceptions.*;
import launcher.avaj.provider.*;
import launcher.avaj.tower.*;
import java.io.*;
import java.util.*;

class Main {
  private static WeatherTower weatherTower = new WeatherTower();

  public static void main(String[] args) {
    try {
        File file = new File("sample.txt");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Integer numSimulations = 0;
        String line = null;

        if ((line = br.readLine()) != null) {
          numSimulations = Integer.valueOf(line);
        }
        System.out.println(numSimulations);
        while ((line = br.readLine()) != null) {
          String []arr = line.split("\\s+");
          if (arr.length != 5) {
            throw new InvalidArgumentException("Incorrect number of arguments for AircraftFactory");
          }
          Flyable f = AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
          
          if (f != null) {
            f.registerTower(weatherTower);
          }
        }

        for (Integer i = 1; i <= numSimulations; i += 1) {
          System.out.println("");
          System.out.println("Day " + i);
          weatherTower.changeWeather();
        }

        br.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e);
    }
  }
}