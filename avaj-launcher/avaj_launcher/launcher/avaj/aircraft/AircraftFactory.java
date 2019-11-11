package launcher.avaj.aircraft;

import launcher.avaj.exceptions.*;

public abstract class AircraftFactory {
  private AircraftFactory() {}

  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
  {
    Coordinates coordinates = null;
    try {
      coordinates = new Coordinates(longitude, latitude, height);
    } catch (Exception e) {
      System.out.println("Coordinates does not exist");
    }

    try {
      switch(type) {
        case "Baloon":
          throw new MisspelledBalloonException("Balloon was misspelled");
        case "Balloon":
          return new Balloon(name, coordinates);
        case "Helicopter":
          return new Helicopter(name, coordinates);
        case "JetPlane":
          return new JetPlane(name, coordinates);
        default:
          throw new BadAircraftException("Bad aircraft");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e);
    } return null;
  }
}