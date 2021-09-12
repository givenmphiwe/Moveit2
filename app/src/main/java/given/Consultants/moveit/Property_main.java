package given.Consultants.moveit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Property_main extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    Button upload_image, chooser,btnbrowse;

    ArrayList<Uri> ImageList = new ArrayList<Uri>();
    private Uri ImageUri;
    private ProgressDialog progressDialog;
    private int upload_count = 1;
    DatabaseReference reff;
    private StorageReference folder;
    int Image_Request_Code = 7;


    //EditText
    EditText Location,Price,Bedroom,square;
    Member member;

    //firebase images for the front
    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_main);

        chooser = findViewById(R.id.chooser);
        upload_image = findViewById(R.id.upload_image);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading image...");

        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");

        //for the text part
        //Location = (EditText)findViewById(R.id.Location);
        //Price = (EditText)findViewById(R.id.Price);
        //Bedroom = (EditText)findViewById(R.id.Bedroom);
        square = (EditText)findViewById(R.id.square);
        btnbrowse = (Button) findViewById(R.id.btnbrowse);

        member=new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        //for the slideView in where a user clicks

        chooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, PICK_IMAGE);

            }
        });


        //for the button to browse ..using Member
        //btnbrowse.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent();
                //intent.setType("image/*");
                //intent.setAction(Intent.ACTION_GET_CONTENT);
                //startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);
            //}
        //});
        //uploading images for the slide view
        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //The
                int me=Integer.parseInt(Price.getText().toString().trim());
                Float squa = Float.parseFloat(square.getText().toString().trim());
                int bed=Integer.parseInt(Bedroom.getText().toString().trim());
                member.setLocation(Location.getText().toString().trim());

                //Member is the word used to save words in the firebase
                member.setPrice(me);
                member.setBedroom(bed);
                member.setSquare(squa);
                reff.push().setValue(member);

                progressDialog.show();

                StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("ImageFolder");

                for (upload_count = 0; upload_count < ImageList.size(); upload_count++) {

                    Uri IndividualImage = ImageList.get(upload_count);
                    final StorageReference ImageName = ImageFolder.child("Image"+IndividualImage.getLastPathSegment());

                    ImageName.putFile(IndividualImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ImageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String url = String.valueOf(uri);
                                    StoreLink(url);
                                }
                            });

                        }
                    });
                }

            }

        });


    }

    private void StoreLink(String url) {
        //the UserOne is the name in the firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserOne");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Imglink", url);

        databaseReference.push().setValue(hashMap);
        progressDialog.dismiss();
        //alert.setText("Images uploaded Successfully");
        upload_image.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            if (resultCode == RESULT_OK) {
                if (data.getClipData() != null) {

                    int countClipData = data.getClipData().getItemCount();

                    int currentImageSelect = 0;
                    while (currentImageSelect < countClipData) {
                        ImageUri = data.getClipData().getItemAt(currentImageSelect).getUri();
                        ImageList.add(ImageUri);
                        currentImageSelect = currentImageSelect + 1;
                    }
                    //alert.setVisibility(View.VISIBLE);
                    //alert.setText("You Have Selected"+ ImageList.size() +"Images");
                    chooser.setVisibility(View.GONE);

                } else {
                    Toast.makeText(this, "Please Select Multiple Images", Toast.LENGTH_SHORT).show();
                }
            }
        }
        //the part where i get the front image


    }
}

