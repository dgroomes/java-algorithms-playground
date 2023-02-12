package dgroomes;

/**
 * A collection of utilities for working with the terminal.
 */
public class TerminalUtil {
  /**
   * Reset the terminal text styles by sending a special ANSI escape sequence to the terminal.
   */
  public static void reset() {
      // "\033" is an octal number for 27 (the ASCII code for 'ESC')
      // The "0" means "reset".
      System.out.print("\033[0m");
  }

  /**
   * Make the terminal text bold by sending a special ANSI escape sequence to the terminal.
   */
  public static void bold() {
      // The "1" means "bold".
      System.out.print("\033[1m");
  }
}
