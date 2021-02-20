 package com.example.peyam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class GirisActvity extends AppCompatActivity {

    EditText kullaniciAdiEditText;
    Button kayitOlButton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_actvity);
        tanimla();
    }
    public void tanimla()
    {
        kullaniciAdiEditText = findViewById(R.id.kullaniciAdiEditText);
        kayitOlButton= findViewById(R.id.kayitOlButton);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();

        kayitOlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = kullaniciAdiEditText.getText().toString();
                kullaniciAdiEditText.setText("");
                ekle(username);
            }
        });
    }
    public void ekle(final String kadi)
    {
        reference.child("Kullanıcılar").child(kadi).child("kullaniciadi").setValue(kadi).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                  //  Toast.makeText(getApplicationContext(), "Ser Xere Kayıt Buyi", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(GirisActvity.this,MainActivity.class);
                    intent.putExtra("kadi",kadi);
                    startActivity(intent);
                }
                }
        });
    }

    public void kayitol()
    {

    }
}