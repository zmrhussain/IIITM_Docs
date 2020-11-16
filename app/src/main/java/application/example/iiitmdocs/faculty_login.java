package application.example.iiitmdocs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class faculty_login extends AppCompatActivity {


    private EditText mFacultyLoginEmail;
    private EditText mFacultyLoginPassword;
    private Button mLoginButton;
    private Button mRegisterButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        //System.out.println(g.getGuide());

        //String s = String.valueOf(g.getGuide());
        //Log.d("guide",s);

        mFacultyLoginEmail = (EditText) findViewById(R.id.faculty_login_email);
        mFacultyLoginPassword = (EditText) findViewById(R.id.faculty_login_password);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mFacultyRegisterIntent = new Intent(faculty_login.this
                        ,faculty_registration.class);
                startActivity(mFacultyRegisterIntent);
            }
        });

        mAuth = FirebaseAuth.getInstance();
    }

    //should authorise user with fire base
    public void loginUser(){

        String email = mFacultyLoginEmail.getText().toString();
        String password = mFacultyLoginPassword.getText().toString();

        if(email.isEmpty())
        if (email.equals("")||password.equals("")) return;

        Toast.makeText(this, "Login in progress...", Toast.LENGTH_SHORT).show();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("IIITM Docs", "signInWithEmail() onComplete: " + task.isSuccessful());

                if (!task.isSuccessful()) {
                    Log.d("IIITM Docs", "Problem signing in: " + task.getException());
                    //showErrorDialog("There was a problem signing in");
                    showErrorToast();
                    //Toast.makeText(this,"Problem with signing in",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(faculty_login.this, Select_Branch.class);
                    finish();
                    startActivity(intent);
                }

            }
        });
    }

    private void showErrorToast()
    {
        Toast.makeText(this,"Problem with signing in",Toast.LENGTH_LONG).show();
    }
}
