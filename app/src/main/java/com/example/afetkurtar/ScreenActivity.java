package com.example.afetkurtar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ScreenActivity extends AppCompatActivity implements View.OnClickListener{
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Button but = findViewById(R.id.button_sign_out);

        findViewById(R.id.button_sign_out).setOnClickListener(this);
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {

                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intentLogin = new Intent(ScreenActivity.this, MainActivity.class);
                        startActivity(intentLogin);
                    }
                });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            // ...
            case R.id.button_sign_out:
                signOut();
                break;
            // ...
        }
    }
}