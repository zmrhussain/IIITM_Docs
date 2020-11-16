package application.example.iiitmdocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select_subject extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////

    private Button Subject1;
    private Button Subject2;
    private Button Subject3;
    private Button Subject4;
    private Button Subject5;
    private Button Subject6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_subject);

        Subject1 = (Button) findViewById(R.id.subject1_button);
        Subject2 = (Button) findViewById(R.id.subject2_button);
        Subject3 = (Button) findViewById(R.id.subject3_button);
        Subject4 = (Button) findViewById(R.id.subject4_button);
        Subject5 = (Button) findViewById(R.id.subject5_button);
        Subject6 = (Button) findViewById(R.id.subject6_button);

        Subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (g.getdesignation()=='y'){
                    g.setGuide(3,'1');//fourth position
                    Intent intent = new Intent(Select_subject.this, UploadFiles.class);
                    startActivity(intent);
                }
                else{
                    g.setGuide(3,'1');//fourth position
                    Intent intent = new Intent(Select_subject.this, view_files.class);
                    startActivity(intent);
                }
            }
        });
        Subject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g.getdesignation()=='y'){
                    g.setGuide(3,'2');//fourth position
                    Intent intent = new Intent(Select_subject.this, UploadFiles.class);
                    startActivity(intent);
                }
                else{
                    g.setGuide(3,'2');//fourth position
                    Intent intent = new Intent(Select_subject.this, view_files.class);
                    startActivity(intent);
                }
            }
        });
        Subject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g.getdesignation()=='y'){
                    g.setGuide(3,'3');//fourth position
                    Intent intent = new Intent(Select_subject.this, UploadFiles.class);
                    startActivity(intent);
                }
                else{
                    g.setGuide(3,'3');//fourth position
                    Intent intent = new Intent(Select_subject.this, view_files.class);
                    startActivity(intent);
                }
            }
        });
        Subject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g.getdesignation()=='y'){
                    g.setGuide(3,'4');//fourth position
                    Intent intent = new Intent(Select_subject.this, UploadFiles.class);
                    startActivity(intent);
                }
                else{
                    g.setGuide(3,'4');//fourth position
                    Intent intent = new Intent(Select_subject.this, view_files.class);
                    startActivity(intent);
                }
            }
        });
        Subject5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g.getdesignation()=='y'){
                    g.setGuide(3,'5');//fourth position
                    Intent intent = new Intent(Select_subject.this, UploadFiles.class);
                    startActivity(intent);
                }
                else{
                    g.setGuide(3,'5');//fourth position
                    Intent intent = new Intent(Select_subject.this, view_files.class);
                    startActivity(intent);
                }
            }
        });
        Subject6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g.getdesignation()=='y'){
                    g.setGuide(3,'6');//fourth position
                    Intent intent = new Intent(Select_subject.this, UploadFiles.class);
                    startActivity(intent);
                }
                else{
                    g.setGuide(3,'6');//fourth position
                    Intent intent = new Intent(Select_subject.this, view_files.class);
                    startActivity(intent);
                }
            }
        });
    }
}
