package application.example.iiitmdocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////

    private Button mFacultyButton ;
    private Button mStudentButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating buttons
        mFacultyButton = (Button) findViewById(R.id.faculty_button);
        mStudentButton = (Button) findViewById(R.id.student_button);


        //String s = String.valueOf(g.getGuide());
        //Log.d("guide",s);

        //creating on-click listeners
        mFacultyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                g.setGuide(0,'a');
                g.setdesignation('y');//position one

                Intent mFacultyIntent = new Intent(MainActivity.this
                        ,faculty_login.class);
                //finish();
                startActivity(mFacultyIntent);

            }
        });
        mStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                g.setGuide(0,'a');
                g.setdesignation('t');//position one

                Intent mStudentIntent = new Intent(MainActivity.this
                        ,faculty_login.class);
                //finish();
                startActivity(mStudentIntent);
            }
        });
    }
}
