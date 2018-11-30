package it_anurak.co.th.usuiitcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.ContentServiceFragment, new ServiceFragment())
                    .commit();
        }





    }
}
