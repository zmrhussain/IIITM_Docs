package application.example.iiitmdocs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class faculty_registration extends AppCompatActivity {

    // Constants
    static final String CHAT_PREFS = "ChatPrefs";
    static final String DISPLAY_NAME_KEY = "username";

    private EditText mEmailId;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private Button mRegisterButton;

    //fire-base variable
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_registration);

        mEmailId = (EditText) findViewById(R.id.faculty_registration_email);
        mPassword = (EditText) findViewById(R.id.faculty_registration_password);
        mConfirmPassword = (EditText) findViewById(R.id.faculty_registration_confirm_password);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        //fire-base authentication
        mAuth =FirebaseAuth.getInstance();

        //creating on-click behavior registerbutton
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });
    }

    private void attemptRegistration(){

        //setting-error
        mEmailId.setError(null);
        mPassword.setError(null);

        //storing values
        String email = mEmailId.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        Log.d("FlashChat", "TextUtils.isEmpty(password): " + TextUtils.isEmpty(password));
        Log.d("FlashChat", "TextUtils.isEmpty(password) && !isPasswordValid(password): "
                + (TextUtils.isEmpty(password) && !isPasswordValid(password)));

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            Log.d("FlashChat", "Password Invalid");
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        }

        //check for valid mail id
        if (TextUtils.isEmpty(email)) {
            mEmailId.setError(getString(R.string.error_field_required));
            focusView = mEmailId;
            cancel = true;
        }else if (!isEmailValid(email)) {
            mEmailId.setError(getString(R.string.error_invalid_email));
            focusView = mEmailId;
            cancel = true;
        }

        //Displaying  the error to user
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // TODO: Call create FirebaseUser() here
            createFirebaseUser();

        }

    }

    //checking if the email is valid
    private boolean isEmailValid(String email) {
        // You can add more checking logic here.
        return email.contains("@");
    }

    //checking if password is valid
    private boolean isPasswordValid(String password) {
        //TODO :Add own logic to check for a valid password
        String confirmPassword = mConfirmPassword.getText().toString();
        return confirmPassword.equals(password);// && password.length() > 6;
    }

    //registering the user in fire-base
    private void createFirebaseUser(){
        //storing values
        String email = mEmailId.getText().toString();
        String password = mPassword.getText().toString();

        //autherising 😉
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this
                , new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("FlashChat", "createUser onComplete: " + task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.d("FlashChat", "user creation failed", task.getException());
                    showErrorDialog("Registration attempt failed");
                } else {
                    saveDisplayName();
                    Intent intent = new Intent(faculty_registration.this, faculty_login.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    // TODO: Save the display name to Shared Preferences
    private void saveDisplayName() {
        String displayName = mEmailId.getText().toString();
        SharedPreferences prefs = getSharedPreferences(CHAT_PREFS, 0);
        prefs.edit().putString(DISPLAY_NAME_KEY, displayName).apply();
    }

    // TODO: Create an alert dialog to show in case registration failed
    private void showErrorDialog(String message){

        //there may be some error here
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(null)//android.R.drawable.ic_dialog_alert)
                .show();

    }
}
