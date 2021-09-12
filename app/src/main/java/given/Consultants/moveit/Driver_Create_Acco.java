package given.Consultants.moveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Driver_Create_Acco extends AppCompatActivity {

    private EditText Drivername;
    private EditText Driveremail;
    private EditText Driverspassword;
    private EditText Driverconpassword;
    private EditText oPassword;
    private EditText numberPlates;
    private Button create;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver__create__acco);


        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onBackPressed();
            }
        });

        findViewById(R.id.textSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        Drivername = findViewById(R.id.name);
        Driveremail = findViewById(R.id.Driveremail);
        Driverspassword = findViewById(R.id.Driverspassword);
        Driverconpassword = findViewById(R.id.Driverspassword);
        oPassword = findViewById(R.id.oPassword);
        create = (Button)findViewById(R.id.txtcreate);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmail = Driveremail.getText().toString();
                String getPassword = Driverspassword.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Driver_Create_Acco.this,"Account created",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Driver_Create_Acco.this,"fill in the empty fields",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });



    }
}