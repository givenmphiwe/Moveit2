package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Property_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_dashboard);

        findViewById(R.id.Photos).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.Photos) {
                    //open a new activity
                    Intent intent2 = new Intent(Property_dashboard.this, Maps_fr.class);
                    startActivity(intent2);
                }
            }
        });
    }
}