package application.example.iiitmdocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select_year5 extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////

    private Button Year1;
    private Button Year2;
    private Button Year3;
    private Button Year4;
    private Button Year5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_year5);

        Year1 = (Button) findViewById(R.id.year1e_button);
        Year2 = (Button) findViewById(R.id.year2e_button);
        Year3 = (Button) findViewById(R.id.year3e_button);
        Year4 = (Button) findViewById(R.id.year4e_button);
        Year5 = (Button) findViewById(R.id.year5e_button);

        Year1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'1');//third position
                Intent intent = new Intent(Select_year5.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'2');//third position
                Intent intent = new Intent(Select_year5.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'3');//third position
                Intent intent = new Intent(Select_year5.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'4');//third position
                Intent intent = new Intent(Select_year5.this, Select_subject.class);
                startActivity(intent);
            }
        });
        Year5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setGuide(2,'5');//third position
                Intent intent = new Intent(Select_year5.this, Select_subject.class);
                startActivity(intent);
            }
        });


    }
}
