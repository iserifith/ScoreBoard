package scoreBoard;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

   public static void main(String[] args) {

      // instantiate our TimerTask "extended" class 
      RunEverySecond tasknew = new RunEverySecond();

      // instantiate a Timer object
      Timer timer = new Timer();
         
      // scheduling the task at fixed rate delay. See http://docs.oracle.com/javase/7/docs/api/java/util/Timer.html#scheduleAtFixedRate(java.util.TimerTask,%20long,%20long)
      timer.scheduleAtFixedRate(tasknew,0,1000);      
   } 
}

/*
* TimerTask is an "Abstract" class - cannot be instantiated but can only be extended
* see https://docs.oracle.com/javase/7/docs/api/java/util/TimerTask.html#TimerTask()
*/
class RunEverySecond extends TimerTask {

   public void run() {
      
      // call the method to change the value of label for timer/clock here
      System.out.println("Beep! One second");
   }
}