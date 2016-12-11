package cyanoboru.grabmycard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textoTest;
    private static final int REQUEST_QR = 0;
    private Button botonScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Así se pinta un QR de un string en un ImageView
        /*
        ImageView img = (ImageView) findViewById(R.id.imageView);
        try {
            img.setImageBitmap(QRCreator.crear("trolls"));
        } catch (WriterException e) {
            e.printStackTrace();
        }

        */
        textoTest = (TextView) findViewById(R.id.ShowEscaneado);
        botonScan = (Button) findViewById(R.id.ScanButton);
        botonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, CameraCapturer.class),REQUEST_QR);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_QR:
                textoTest.setText(data.getExtras().getParcelable("Barcode").toString()); //Barcode implementa Parcelable, lo busqué en jujel
        }
    }
}