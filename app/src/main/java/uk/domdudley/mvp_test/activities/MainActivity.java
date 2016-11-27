package uk.domdudley.mvp_test.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uk.domdudley.mvp_test.R;
import uk.domdudley.mvp_test.iLoginView;
import uk.domdudley.mvp_test.presenters.LoginPresenter;

public class MainActivity extends AppCompatActivity implements iLoginView {

    LoginPresenter presenter;
    EditText etUsername;
    EditText etPassword;
    Button btnLogin;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText)findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.loginBtn);

        presenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginTapped();
            }
        });
    }

    @Override
    public void loginSuccess() {
        progressDialog.dismiss();
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    private void loginTapped(){
        progressDialog = ProgressDialog.show(this,"Authenticating...",null);
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        presenter.attemptLogin(username, password);
    }
}
