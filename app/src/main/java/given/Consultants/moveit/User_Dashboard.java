package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class User_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__dashboard);

        findViewById(R.id.Backss).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        //opening the maps for driver
        findViewById(R.id.LocationMaps).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.LocationMaps) {
                    //open a new activity
                    Intent intent2 = new Intent(User_Dashboard.this, Maps_user.class);
                    startActivity(intent2);
                }
            }
        });

        findViewById(R.id.Services).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.Services) {
                    //open a new activity
                    Intent intent2 = new Intent(User_Dashboard.this, Services_user_dashboard.class);
                    startActivity(intent2);
                }
            }
        });
    }
}