package AlgorithmsAndDataStructures;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

/* Author: Cole Stoltz
 * Date: 1/7/2021
 * Purpose: This class will update the time and date labels present in the NorthPanel class
 * so that the time and date are changed in real time, giving the user a view of the current
 * time and date.
 */

public class TimeKeeper extends Thread {

	// Variables
	private JLabel time = new JLabel();
	private JLabel date = new JLabel();
	

	public TimeKeeper(JLabel Time, JLabel Date) { // Constructor

		/* These assignments allow this class to edit the JLabels in the main application frame
		 * and update them as needed.
		 */
		time = Time;
		date = Date;

	}

	public void run() { // Will execute when thread is started

		for (;;) { // Infinite Loop
			
			time.setText(DateTimeFormatter.ofPattern("h:mm:ss|a").format(LocalTime.now())); // Update Time Constantly
			date.setText("[" + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDateTime.now()) + "]"); // Update Date Constantly 
			
			try { // this sleep will prevent the loop from running so often and using so much memory
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
