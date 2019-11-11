package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class Helicopter extends Aircraft implements Flyable {
  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    String identifier = "Helicopter#" + this.name + "(" + this.id + ")";

    System.out.printf("%s", identifier);
    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 10,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() + 2
        );
        System.out.println(": It's surely hot in this Helicopter");
        break;
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 5,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight()
        );
        System.out.println(": It's surely raining hard outside");
        break;
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 1,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight()
        );
        System.out.println(": The fog makes it hard to see");
        break;
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 12
        );
        System.out.println(": It's surely very cold outside");
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
    System.out.println("Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
  }

  private WeatherTower weatherTower;
}