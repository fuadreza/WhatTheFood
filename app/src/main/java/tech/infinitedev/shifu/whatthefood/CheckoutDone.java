package tech.infinitedev.shifu.whatthefood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by shifu on 6/9/17.
 */

public class CheckoutDone extends AppCompatActivity {

    Button btn_balik;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);

        btn_balik = (Button) findViewById(R.id.btn_balik);

        btn_balik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart.CartOrder = new ArrayList<Daftar>();
                Cart.Totale = 0;
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Cart.CartOrder = new ArrayList<Daftar>();
        Cart.Totale = 0;
        finish();
    }
}
