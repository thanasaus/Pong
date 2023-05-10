import java.awt.*;
import javax.swing.*;

class Window extends JFrame {

  public Window() {

    
    // rectangle aspects
    int rectanglepox = 0;
    int rectanglepoy = 0;
    int width=25;
    int height=150;
    // Using these to slow movement down
    double fracpox = 0;
    double fracpoy = 0;

    
    
    //circle 
    int circlepox = 25;
    int circlepoy = 0;
    double fraccircley=0;
    double fraccirclex=25;
    //Direction of the ball
    int directionx = 0;
    int directiony = 0;
    //Speed
    double ballspeed=.00005;



    //score
    int score=0;
    
    
    // Creates Window 900*900
    JFrame frame = new JFrame("Pong");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 900);

    // Creates new JPanel
    JPanel jp = new JPanel();

    // sets background
    jp.setBackground(Color.lightGray);
    frame.add(jp);
    jp.setLayout(null);



    
    // makes objects
    JPanel rectangle = new JPanel();
    rectangle.setBackground(Color.RED);

    JPanel circle = new JPanel();
    circle.setBackground(Color.DARK_GRAY);

    JPanel rectangle2 = new JPanel();
    rectangle2.setBackground(Color.RED);

    //score
    JLabel scorefield = new JLabel();
    scorefield.setText("Score : "+score);
    scorefield.setBounds(50,50, 300,70);
    jp.add(scorefield);



    
    // initial positions + variables for the objects
    rectangle.setBounds(0, 0, width, height);
    jp.add(rectangle);

    rectangle2.setBounds(875, 0, width, height);
    jp.add(rectangle2);

    circle.setBounds(circlepox, circlepoy, 25, 25);
    jp.add(circle);


    
    // makes frame visible
    frame.setVisible(true);

    // run listener + add to frame
    Listener L = new Listener();
    frame.addKeyListener(L);

    //game loop boolean
    boolean gameRun=true;
    // while loop to constantly check for keypress
    while (gameRun) {



      
      //X axis ball movement
      //checks direction of the ball
      
     if(directionx == 0)
      {
      fraccirclex=fraccirclex+ballspeed;
      //fraccircley=fraccircley+.0001;

      circlepox=(int)fraccirclex;
      //circlepoy=(int)fraccircley;
      
      circle.setBounds(circlepox, circlepoy, 25, 25);
      
      //checks if exceeds play limits

      if(circlepox>=850)
      {
        
        directionx=1;
      }


      //moves opponent
      if(circlepoy>=0 && circlepoy<=750)
      {
        rectangle2.setBounds(875, circlepoy, width, height);
        
      }
      


      }
       
     //checks direction
     else if(directionx==1)
     {
      fraccirclex=fraccirclex-ballspeed;
      circlepox=(int)fraccirclex;
      circle.setBounds(circlepox, circlepoy, 25, 25);

      //checks if exceeds play limits and if its within player
      if(circlepox<=25)
      {
        
        //Is it within rectangle
        if(((rectanglepoy+150)<circlepoy)||(circlepoy<rectanglepoy))
        {
          System.out.print("L "+rectanglepoy +" "+circlepoy);
          gameRun=false;
          
        }
        else{
          score++;
          scorefield.setText("Score : "+score);
        }
        directionx=0;
      }

      //moves opponent
      if(circlepoy>=0 && circlepoy<=750)
      {
        rectangle2.setBounds(875, circlepoy, width, height);
        
      }
       
     }




     if(directiony == 0)
      {
      fraccircley=fraccircley+ballspeed;
      circlepoy=(int)fraccircley;
      circle.setBounds(circlepox, circlepoy, 25, 25);

      //checks if exceeds play limits
      if(circlepoy>=875)
      {
        directiony=1;
      }

      }

     //checks direction
     else if(directiony==1)
     {
      fraccircley=fraccircley-ballspeed;
      circlepoy=(int)fraccircley;
      circle.setBounds(circlepox, circlepoy, 25, 25);

      //checks if exceeds play limits
      if(circlepoy<=0)
      {
        directiony=0;
      }
     }

      
      // changes method in lestener to boolean
      int checkifde = L.checkifd();

      // checks for the press
      if (checkifde == 1) {
        // stays in game area
        if (rectanglepoy > 0) {

          fracpoy = fracpoy - .0001;
          rectanglepoy = (int) (fracpoy);
          rectangle.setBounds(rectanglepox, rectanglepoy, width, height);
        }

        else {
          // resets to 1y
          rectanglepoy = 1;
          rectangle.setBounds(rectanglepox, rectanglepoy, width, height);
        }
      }

      else if (checkifde == 2) {
        // stays in game area
        if (rectanglepoy < 751) {
          fracpoy = fracpoy + .0001;
          rectanglepoy = (int) (fracpoy);
          rectangle.setBounds(rectanglepox, rectanglepoy, width, height);

        }

        else {
          // resets to 800y
          rectanglepoy = 750;
          rectangle.setBounds(rectanglepox, rectanglepoy, width, height);
        }
      }
      // No key stops movement
      else {
        rectangle.setBounds(rectanglepox, rectanglepoy, width, height);
      }

      
    
    
    
    
    }
  }

}