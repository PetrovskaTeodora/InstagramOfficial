package teodora.petrovska.instagramofficial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.ParseUser;

public class LogIn extends AppCompatActivity {

    private ImageView imgInstagram2;
    private EditText edtEmailLogIn, edtPasswordLogIn;
    Button btnLogIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        imgInstagram2=findViewById(R.id.imgInstagram2);
        edtEmailLogIn=findViewById(R.id.edtEmailLogIn);
        edtPasswordLogIn=findViewById(R.id.edtPasswordLogIn);
        btnLogIn=findViewById(R.id.btnLogIn);
        btnSignUp=findViewById(R.id.btnSignUp);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}
