package launcher.avaj.tower;

import java.util.*;
import launcher.avaj.aircraft.*;

abstract class Tower {
  public void register(Flyable flyable) {
    System.out.printf("Tower: ");
    observers.add(flyable);
  }

  public void unregister(Flyable flyable) {
    landed.add(flyable);
  }

  protected void conditionsChanged() {
    for (Flyable f : this.observers) {
      f.updateConditions();
    }

    this.observers.removeAll(this.landed);
    this.landed = new ArrayList<Flyable>();
  }

  private List<Flyable> observers = new ArrayList<Flyable>();
  private List<Flyable> landed = new ArrayList<Flyable>();
}