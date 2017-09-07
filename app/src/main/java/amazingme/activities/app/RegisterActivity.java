package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.database.FirebaseHelper;
import amazingme.model.AmazingMeAppCompatActivity;

public class RegisterActivity extends AmazingMeAppCompatActivity {
    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, doctorEmailEditText;
    private Button registerBtn, backBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        doctorEmailEditText = (EditText) findViewById(R.id.doctorEmailEditText);
        //registerBtn = (Button) findViewById(R.id.nextBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        nextBtn = (Button) findViewById((R.id.nextBtn));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // String doctoremail = doctorEmailEditText.getText().toString();
                FirebaseHelper.createNewUser(firstName, lastName, email, password, getApplicationContext());
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           final Intent backIntent = new Intent(getApplicationContext(), UserProfileActivity.class);
                                           startActivity(backIntent);
                                       }
                                   });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent backIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(backIntent);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.REGISTRATION;
    }
}
