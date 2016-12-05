package cyanoboru.grabmycard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import cyanoboru.grabmycard.core.QRCreator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        try {
            img.setImageBitmap(QRCreator.crear("trolls"));
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
