package launcher.avaj.exceptions;

public class InvalidArgumentException extends Exception {
  public InvalidArgumentException() {}

  public InvalidArgumentException(String msg) {
    super(msg);
  }
}