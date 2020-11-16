package application.example.iiitmdocs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadFiles extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////
    String s = String.valueOf(g.getGuide());
//    public static final String STORAGE_PATH_UPLOADS = "uploads/";
    public static final String DATABASE_PATH_UPLOADS = "uploads";
    //this is the pic pdf code used in file chooser
    //final static int PICK_PDF_CODE = 2342;

    EditText editFileName;
    Button uploadFileButton;
    Button viewFilesButton;

    StorageReference mStorageReference;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_files);

        editFileName = (EditText) findViewById(R.id.enter_file_name);
        uploadFileButton = (Button) findViewById(R.id.upload_button);

        String s = String.valueOf(g.getGuide());                       //TODO:creation of location

        mStorageReference = FirebaseStorage.getInstance().getReference();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(s);//TODO:location insered

        uploadFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFile();
            }
        });


    }

    private void selectFile() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select file bruh"),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK
                && data!=null&& data.getData()!=null)
        {
            uploadFile(data.getData());
        }
    }

    private void uploadFile(Uri data) {

        final ProgressDialog mProgressDialog =new ProgressDialog(this);
        mProgressDialog.setTitle("Uploading...");
        mProgressDialog.show();


        StorageReference reference = mStorageReference.
                child(s+"/"+System.currentTimeMillis()+".pdf");     //TODO:location inserted
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                    @SuppressWarnings("VisibleForTests")
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while(!uri.isComplete());
                        Uri url = uri.getResult();

                        helpUpload helpUpload = new helpUpload(editFileName.
                                getText().toString(),url.toString());
                        mDatabaseReference.child(mDatabaseReference.push().getKey()).
                                setValue(helpUpload);

                        Toast.makeText(UploadFiles.this,"File Uploaded " ,
                                Toast.LENGTH_SHORT).show();

                        mProgressDialog.dismiss();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                double progress = (100.0*taskSnapshot.getBytesTransferred())/
                        taskSnapshot.getTotalByteCount();

                mProgressDialog.setMessage("Uploaded: "+(int)progress+"%");
            }
        });
    }

    public void btn_action(View view) {
        startActivity(new Intent(getApplicationContext(),view_files.class));
    }
}
