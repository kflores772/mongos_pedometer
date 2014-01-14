package suthan.service.text;

public class StepCount {
     
     //pedometer variables
     private int count; //step counting variable
     private float TimePrevious, TimeDiff; //Time stamps for the previous step, current step, and the difference
     float accelSum; // acceleration sum across each axis
     
     //CONTRUCTOR
     public StepCount(){
    	 count = 0;
    	 TimePrevious = 0;
    	 TimeDiff = 0;
     }
     
     public int stepTaken(float AccelX, float AccelY, float AccelZ, float TimeNow){		
    	 
 		accelSum = 0; //variable to take sum of linear acceleration in x, y, z axis
 		TimeDiff = TimeNow - TimePrevious ; 
		accelSum = AccelX + AccelY + AccelZ;
	
		/* FAST WALK: if the difference between previous and current step is ~0.4s and the vector acceleration sum 
		 *is greater than 7m/s^2, counter increases by 1*/
		if((TimeDiff>=400000000) && (accelSum>7 || accelSum<-7)){
			count++;  					
			TimePrevious=TimeNow; //set time of previous to the current step, to make it the new previous step
		}
		
		/* NORMAL WALK: if the difference between previous and current step is ~0.6s and the vector acceleration sum 
		 *is greater than 3.5m/s^2, counter increases by 1*/
		else if((TimeDiff>=600000000) && (accelSum>3.5 || accelSum<-3.5)){
			count++;  						
			TimePrevious=TimeNow; //set time of previous to the current step, to make it the new previous step
		}
		
		/* SLOW WALK: if the difference between previous and current step is ~0.8s and the vector acceleration sum 
		 *is greater than 1.75m/s^2, counter increases by 1*/
		else if((TimeDiff>=800000000) && (accelSum>1.75 || accelSum<-1.75)){
			count++; 
			TimePrevious=TimeNow; //set time of previous to the current step, to make it the new previous step
		}
		return count;
	}
}


