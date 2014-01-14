package suthan.service.text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button; 
import android.widget.TextView;

public class ServiceTestStart extends Activity {	
	Button start; //start button
	public static TextView countR; //step counter view
    boolean StartcheckR=false; //check if start button clicked
    
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        countR = (TextView) findViewById(R.id.Text1);
        start= (Button) findViewById(R.id.buttonS);
        start.setOnClickListener(StartClick);
       
    }
    
    
    private OnClickListener StartClick = new OnClickListener() {
        public void onClick(View v) {
          // do something when the button is clicked
        	if(!StartcheckR){
        		start.setText("Pause");
            	StartcheckR=true;
            	
                startService(new Intent(ServiceTestStart.this, Service1.class));

        	}
        	else{
        		start.setText("Start");
        		StartcheckR=false;
        		
                stopService(new Intent(ServiceTestStart.this, Service1.class));

        	}
        }
    };
    
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}