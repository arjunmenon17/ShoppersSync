//Author: Zachary M. Solomon
//Date Started: May 7, 2020
//Purpose: To have a timing mechanism that causes months (lasting 5 seconds) and generations (comprising 6 artificial months) to pass, by which the user will be able to tell how much
// and how many generations have elapsed, by which the environment class will know when it may be able to undergo changes, by which the natural selection class is able to determine
// the organisms that may proceed to the next generation and those that do not and by which the organisms class may tell when it may be able to cause mutations in the organisms that
//exist.
//Most Recent Modification: May 22, 2020
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//Author: Zachary M. Solomon
//Date Started: April 30, 2020
//Purpose: To create a class that will cause time, measured in months, to pass at an artificial rate of one month every 5 seconds and to record the passing of months and be
//able to indicate how many months have passed since the program was started. It should also record and indicate the passage of generations, to occur every 6 months in
//program time (30 seconds in real time) which will be used to determine when organisms should be given the opportunity to evolve and when their environment should be given
//the opportunity change.
//Most Recent Modification: May 21,2020
public class FstTime<monthCounter> {
    private long monthCounter;//Initializes a variable for the total number of months that have passed since the start of time/evolution it runs from 0 months-∞ months.
    private long timePeriod;//Initializes a variable for the generations/time periods, to occur every 6 months.
    private long a = System.currentTimeMillis();//Creates a global timer for the use of the month counter and time period counter.

    public FstTime(){
        this.monthCounter=0;//Gives an initial month value, as at the start of time/life 0 months have passed.
        this.timePeriod=0;//Gives an initial generation value, until the passage of 6 months, no generations/time period could have passed.
    }

    //public FstTime(long d, long tp)throws Exception{
    //setMonthCounter(d);
    //setTimePeriod(tp);

    //Start of setMonthCounter
    //Starts a timer and uses it to cause a new month pass every 5 seconds by checking the difference in time between the timer for the month counter and the global timer
    //and dividing by 5000 milliseconds.
    public void setMonthCounter(){
        System.currentTimeMillis();
        long b = System.currentTimeMillis();
        long overall = b-a;

        monthCounter = overall/5000;
    }
    //end of setMonthCounter

    //Start of setTimePeriod
    //Causes a new generation to pass after a time period of 6 months by checking the time difference between its local and the global timer and dividing by 30,000
    //milliseconds.
    public void setTimePeriod(){
        long b = System.currentTimeMillis();
        long overall = b-a;
        timePeriod= overall/30000;
    }//end of setTimePeriod

    //Start of getMonthCounter
    //Used to call on/get the number of months that have passed since the start of evolution/time for the user to see how much evolution has occurred in a given period of
    //time.
    public long getMonthCounter()
    { this.setMonthCounter();
        return this.monthCounter; }
        //End of getMonthCounter.

    //Start of getTimePeriod.
    //Used by setEnvirochange in FSTEnvironment know when/how often to see if environmental changes will occur and/or to call on/get the number of generations that have
    //passed since the start of evolution/time so the user can see how much evolution has occurred in a given number of generations.
    public long getTimePeriod()
    { this.setTimePeriod();
        return this.timePeriod; }
        //End of getTimePeriod

    //Start of toString.
    //Gives both the total number of months elapsed and the number of generations passed in one sentence.
    public String toString()
    { return "The number of months elapsed is: " +this.monthCounter+ " and the number of generations passed is: " + this.timePeriod;}//End of toString.

    //Commented code below is for easy testing of getTimePeriod or getMonthCounter.
    //public static void main(String[] args) {
    //FstTime x = new FstTime();
    //System.out.println(x.getTimePeriod());
    //}
}

