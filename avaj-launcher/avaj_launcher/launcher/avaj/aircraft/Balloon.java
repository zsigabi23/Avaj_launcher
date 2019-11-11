package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class Balloon extends Aircraft implements Flyable {
  Balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    String identifier = "Balloon#" + this.name + "(" + this.id + ")";

    System.out.printf("%s", identifier);
    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 2,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() + 4
        );
        System.out.println(": It's too hot");
        break;
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 5
        );
        System.out.println(": The Balloon is too wet");
        break;
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 3
        );
        System.out.println(": I can't see clearly because of the fog");
        break;
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 15
        );
        System.out.println(": It's too cold in this Balloon");
        break;
    }

    if (this.coordinates.getHeight() <= 0)
    {
      System.out.println(identifier + " landing.");
      this.weatherTower.unregister(this);
      System.out.println("Tower says: " + identifier + " unregistered from the weather tower.");
    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
    System.out.println("Balloon#" + this.name + "(" + this.id + ") registered to the tower.");
  }

  private WeatherTower weatherTower;
}