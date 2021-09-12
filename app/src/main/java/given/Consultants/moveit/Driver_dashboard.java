package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Driver_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_dashboard);

        findViewById(R.id.Back).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        //opening the maps for driver
        findViewById(R.id.LocationMap).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.LocationMap) {
                    //open a new activity
                    Intent intent2 = new Intent(Driver_dashboard.this, Maps_fr.class);
                    startActivity(intent2);
                }
            }
        });
        //opening the services for the driver
        findViewById(R.id.Service).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.Service) {
                    //open a new activity
                    Intent intent2 = new Intent(Driver_dashboard.this, Driver_Services_dashboard.class);
                    startActivity(intent2);
                }
            }
        });


    }
}