package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.users).setOnClickListener(this);
        findViewById(R.id.property).setOnClickListener(this);
        findViewById(R.id.trucks).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.users) {
            //open a new activity
            Intent intent = new Intent(this, Sign_in.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.property){
            //opening a new activity for property
            Intent intent1 = new Intent(this, Property_sign_in.class);
            startActivity(intent1);
        }

        if (view.getId() == R.id.trucks){
            //opening a new activity for property
            Intent intent2 = new Intent(this, Driver_sign_in.class);
            startActivity(intent2);
        }
    }
}
