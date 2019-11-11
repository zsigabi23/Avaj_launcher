package launcher.avaj.exceptions;

public class MisspelledBalloonException extends Exception {
  public MisspelledBalloonException() {}

  public MisspelledBalloonException(String msg) {
    super(msg);
  }
}