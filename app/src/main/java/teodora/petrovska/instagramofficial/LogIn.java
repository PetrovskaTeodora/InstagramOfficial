package teodora.petrovska.instagramofficial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogIn extends AppCompatActivity {

    private ImageView imgInstagram2;
    private EditText edtEmailLogIn, edtPasswordLogIn;
    Button btnLogIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTitle("Log In");

        imgInstagram2=findViewById(R.id.imgInstagram2);
        edtEmailLogIn=findViewById(R.id.edtEmailLogIn);
        edtPasswordLogIn=findViewById(R.id.edtPasswordLogIn);
        btnLogIn=findViewById(R.id.btnLogIn);
        btnSignUp=findViewById(R.id.btnSignUp);

        if(ParseUser.getCurrentUser() !=null){
//            ParseUser.getCurrentUser().logOut();
            transitionToSocialMediaAcivity();
        }

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            ParseUser.logInInBackground(edtEmailLogIn.getText().toString(), edtPasswordLogIn.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(user!=null && e==null){
                        FancyToast.makeText(LogIn.this,user.getUsername() + "logged in successfully!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        transitionToSocialMediaAcivity();
                    }
                    else
                    {
                        FancyToast.makeText(LogIn.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                    }
                }
            });

            }
        });



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogIn.this, SignUp.class);
                        startActivity(intent);
            }
        });


    }


    public void LogInLayoutTapped(View view){

        try {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    private void  transitionToSocialMediaAcivity(){
        Intent intent=new Intent(LogIn.this, SocialMediaActivity.class);
        startActivity(intent);
    }
}
