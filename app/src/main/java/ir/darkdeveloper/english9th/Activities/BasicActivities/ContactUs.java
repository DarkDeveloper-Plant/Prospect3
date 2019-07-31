package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ir.plant.english9th.R;

public class ContactUs extends AppCompatActivity {
    EditText editText1, editText2;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ini();
        button.setOnClickListener(v -> {
            String email = textView.getText().toString();
            String subject = editText1.getText().toString();
            String content = editText2.getText().toString();
            String EmailAddress[]={email};
            Intent send = new Intent(Intent.ACTION_SEND);
            send.putExtra(Intent.EXTRA_EMAIL,EmailAddress);
            send.putExtra(Intent.EXTRA_SUBJECT,subject);
            send.putExtra(Intent.EXTRA_TEXT,content);
            send.setType("plain/text");
            startActivity(send);
        });
    }

    private void ini() {
        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et2);
        textView = findViewById(R.id.tv_contactUs);
        button = findViewById(R.id.btn_send);
    }
}
