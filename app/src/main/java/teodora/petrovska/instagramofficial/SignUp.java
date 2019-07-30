package teodora.petrovska.instagramofficial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;



public class SignUp extends AppCompatActivity {
    private EditText edtEmail, edtUserName, edtPassword;
    private Button btnSignUp, btnLogIn;
    private ImageView imgInstagram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");

        imgInstagram=findViewById(R.id.imgInstagram);
        edtEmail=findViewById(R.id.edtEmail);
        edtUserName=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnLogIn=findViewById(R.id.btnLogIn);

        if(ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
     }
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser appUser=new ParseUser();

                appUser.setUsername(edtUserName.getText().toString());
                appUser.setPassword(edtPassword.getText().toString());
                appUser.setEmail(edtEmail.getText().toString());

                final ProgressDialog progressDialog=new ProgressDialog(SignUp.this);
                progressDialog.setMessage("Signing up "+edtUserName.getText().toString());
                progressDialog.show();


                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(SignUp.this,appUser.getUsername() + "signed up successfully!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                        }
                        else
                        {
                            FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }

                        progressDialog.dismiss();
                    }
                });
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ParseUser.logInInBackground(edtPassword.getText().toString(), edtPassword.getText().toString(), new LogInCallback() {
////                    @Override
////                    public void done(ParseUser user, ParseException e) {
////                        if(user!=null && e==null){
////                            FancyToast.makeText(SignUp.this,ParseUser.getCurrentUser().getUsername() + "logged in successfully!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
////                        }
////                        else
////                        {
////                            FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
////                        }
////                    }
////                });


                Intent intent =new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });


    }
}
