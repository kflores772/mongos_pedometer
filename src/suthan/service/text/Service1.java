package suthan.service.text;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;

public class Service1 extends Service implements SensorEventListener {
	 private SensorManager mySensorManager;
     private Sensor myAccelerometer;
     private StepCount myStep;
     int StepNUMBR;
     
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE); // access Sensors
        myAccelerometer = mySensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION); //access lin. accelerate sensors
        myStep = new StepCount();
        StepNUMBR = 0;
	}

	@Override
	public void onDestroy() {
        mySensorManager.unregisterListener(this);
		super.onDestroy();

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
	    mySensorManager.registerListener(this, myAccelerometer,SensorManager.SENSOR_DELAY_UI);
		return super.onStartCommand(intent, flags, startId);

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		myAccelerometer = e.sensor;
		
		synchronized (this){
			int G = (myAccelerometer.getType()==Sensor.TYPE_LINEAR_ACCELERATION) ? 1:0;
			//check if linear acceleration check is available on the phone
			if(G==1){
				StepNUMBR= myStep.stepTaken(e.values[0], e.values[1], e.values[2], e.timestamp);
				ServiceTestStart.countR.setText(""+StepNUMBR);
				//pass value to count view in Original activity				
				//HOW??????????????????????
			}
		}
	}

}