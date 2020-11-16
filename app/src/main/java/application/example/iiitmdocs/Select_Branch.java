package application.example.iiitmdocs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select_Branch extends AppCompatActivity {

    ////////////////////////////////
    public Guide g = new Guide();
    ////////////////////////////////

    private Button BcsButton;
    private Button ImtButton;
    private Button ImgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__branch);

        BcsButton = (Button) findViewById(R.id.bcs_button);
        ImtButton = (Button) findViewById(R.id.imt_button);
        ImgButton = (Button) findViewById(R.id.img_button);

        BcsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                g.setGuide(1,'s');//second position
                Intent intent = new Intent(Select_Branch.this, Select_year4.class);
                startActivity(intent);
            }
        });

        ImtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                g.setGuide(1,'t');//second position
                Intent intent = new Intent(Select_Branch.this, Select_year5.class);
                startActivity(intent);
            }
        });

        ImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                g.setGuide(1,'g');//second position
                Intent intent = new Intent(Select_Branch.this, Select_year5.class);
                startActivity(intent);
            }
        });
    }
}
