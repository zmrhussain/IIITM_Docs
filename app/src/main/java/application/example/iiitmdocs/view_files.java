package application.example.iiitmdocs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;


public class view_files extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////
    String s = String.valueOf(g.getGuide());//TODO: setting location
    ListView myFilesListView;

    DatabaseReference mDatabaseReference;
    List<helpUpload> mhelpUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_files);

        myFilesListView = (ListView) findViewById(R.id.myListView);
        mhelpUpload = new ArrayList<>();

        viewAllFiles();

        myFilesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                helpUpload helpUpload = mhelpUpload.get(position);

                Intent  intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(helpUpload.getUrl()));
                startActivity(intent);


            }
        });

    }

    private void viewAllFiles() {



        mDatabaseReference = FirebaseDatabase.getInstance().getReference(s);//TODO: getting files
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){

                    helpUpload mHelpUpload = postSnapshot.getValue
                            (application.example.iiitmdocs.helpUpload.class);
                    mhelpUpload.add(mHelpUpload);

                }

                String[] uploads = new String[mhelpUpload.size()];

                for(int i=0;i<uploads.length;i++){

                    uploads[i] = mhelpUpload.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                    @Override
                    public View getView(int position,View convertView,ViewGroup parent) {

                        View mView = super.getView(position, convertView, parent);

                        TextView mytext = (TextView) mView.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.BLACK);

                        return mView;
                    }
                };

                myFilesListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
