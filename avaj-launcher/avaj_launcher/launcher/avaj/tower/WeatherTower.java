package launcher.avaj.tower;

import launcher.avaj.aircraft.*;
import launcher.avaj.provider.*;

public class WeatherTower extends Tower {
  public String getWeather(Coordinates coordinates) {
    return WeatherProvider.getProvider().getCurrentWeather(coordinates);
  }
  
  public void changeWeather() {
    this.conditionsChanged();
  }
}