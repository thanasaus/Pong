import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

  // changes if there is a keypress on d or w
  boolean wasSPressed = false;
  boolean wasWPressed = false;

  public void keyPressed(KeyEvent e) {
    // This method is called when a key is pressed
    // System.out.print("Key pressed: " + e.getKeyChar());

    // Was w pressed
    if (e.getKeyChar() == 'w') {
      wasSPressed = true;
    }

    // was d pressed
    if (e.getKeyChar() == 's') {
      wasWPressed = true;
    }

  }

  public void keyReleased(KeyEvent e) {
    // This method is called when a key is released
    // System.out.print("Key released: " + e.getKeyChar());

    // was w released
    if (e.getKeyChar() == 'w') {
      wasSPressed = false;
    }

    // was d released
    if (e.getKeyChar() == 's') {
      wasWPressed = false;
    }

  }

  public void keyTyped(KeyEvent e) {
    // This method is called when a key is typed (pressed and released)
    // System.out.print("Key typed: " + e.getKeyChar());
  }

  // Bascailly, cause i cant call rectangle here
  // I made a method within listener that returns true
  // when D is pressed to return in to the window class
  public int checkifd() {
    // if d was pressed return 1
    if (wasSPressed) {
      return (1);
    }

    // if w wasd pressed return 2
    else if (wasWPressed) {
      return (2);
    }
    // else return 0
    else {
      return (0);
    }
  }
}