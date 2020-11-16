package application.example.iiitmdocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select_year4 extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////

    private Button Year1;
    private Button Year2;
    private Button Year3;
    private Button Year4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_year4);

        Year1 = (Button) findViewById(R.id.year1r_button);
        Year2 = (Button) findViewById(R.id.year2r_button);
        Year3 = (Button) findViewById(R.id.year3r_button);
        Year4 = (Button) findViewById(R.id.year4r_button);

        Year1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'1');//third position
                Intent intent = new Intent(Select_year4.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'2');//third position
                Intent intent = new Intent(Select_year4.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'3');//third position
                Intent intent = new Intent(Select_year4.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'4');
                Intent intent = new Intent(Select_year4.this, Select_subject.class);
                startActivity(intent);
            }
        });

    }
}
