package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import android.os.Bundle;

public class PropertyViewing extends AppCompatActivity {

    //TODO am viewing for the view in the front

    RecyclerView recyclerView;
    private DatabaseReference myRef;

    private ArrayList<Messages> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_viewing);

        findViewById(R.id.imageAdd).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (view.getId() == R.id.imageAdd) {
                    //open a new activity
                    Intent intent2 = new Intent(PropertyViewing.this, Front_view_image.class);
                    startActivity(intent2);
                }
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerAdapter = new RecyclerAdapter(this,messagesList);
        recyclerView.setAdapter(recyclerAdapter);
        //adapter = new RecyclerAdapter(ViewProperty.this, list);
        //recyclerAdapter.notifyDataSetChanged();

        myRef = FirebaseDatabase.getInstance().getReference("Images");

        //ArrayList
        messagesList = new ArrayList<>();

        //clearAll Arraylist
        //ClearAll();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Messages messages = new Messages();

                    messages.setBeds(snapshot1.child("imageLocation").getValue().toString());
                    messages.setLoca(snapshot1.child("imageName").getValue().toString());
                    messages.setPric(snapshot1.child("imagePrice").getValue().toString());
                    messages.setSqua(snapshot1.child("imageURL").getValue().toString());
                    messages.setImageUrl(snapshot1.child("imageEmail").getValue().toString());

                    messagesList.add(messages);
                }


                //recyclerAdapter = new RecyclerAdapter(getApplicationContext(), messagesList);
                //recyclerView.setAdapter(recyclerAdapter);
                //recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    private void GetDataFirebase() {

        //for the words & images in the firebase
        Query query = myRef.child("Images");
        //for the images in the firebase

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Messages messages = new Messages();

                    messages.setBeds(snapshot1.child("imageLocation").getValue().toString());
                    messages.setLoca(snapshot1.child("imageName").getValue().toString());
                    messages.setPric(snapshot1.child("imagePrice").getValue().toString());
                    messages.setSqua(snapshot1.child("imageURL").getValue().toString());
                    messages.setImageUrl(snapshot1.child("imageEmail").getValue().toString());

                    messagesList.add(messages);
                }


                //recyclerAdapter = new RecyclerAdapter(getApplicationContext(), messagesList);
                //recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //for the images in the firebase

           // if (messagesList != null) {
             //   messagesList.clear();

             //   if (recyclerAdapter != null) {
               //     recyclerAdapter.notifyDataSetChanged();
             //   }
            //}

            //messagesList = new ArrayList<>();


    }

}