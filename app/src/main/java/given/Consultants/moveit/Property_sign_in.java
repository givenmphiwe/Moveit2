package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;


import android.content.Intent;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Property_sign_in extends AppCompatActivity{
    private EditText email;
    private EditText password;
    private Button signin;
    private FirebaseAuth firebaseAuth;

    String emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_sign_in);

        findViewById(R.id.textcreateAccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(), Create_Account.class));
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        signin = (Button)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intilize();
                if (!validation()){
                    Toast.makeText(Property_sign_in.this,"welcome",Toast.LENGTH_SHORT).show();
                }

                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(getEmail, getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent i = new Intent(Property_sign_in.this, PropertyViewing.class);
                                startActivity(i);
                                Toast.makeText(Property_sign_in.this,"welcome",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Property_sign_in.this,"create account"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        });
            }

            private void intilize(){
                emails=email.getText().toString();
            }
        });


    }
    //method for validation in the click v
    private boolean validation() {

        boolean valid=true;
        if(emails.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(emails).matches()){
            email.setError("Invalid Email");

        }
        if (password.getText().toString().isEmpty()||password.getText().length()>10) {
            password.setError("Password must contain Upper & low keys ");
            valid = false;
        }
        return true;
    }
}
