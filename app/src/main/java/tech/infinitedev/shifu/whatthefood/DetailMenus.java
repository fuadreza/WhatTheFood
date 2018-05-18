package tech.infinitedev.shifu.whatthefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shifu on 6/9/17.
 */

public class DetailMenus extends AppCompatActivity {
    private TextView tvNamaMenune, tvHargane;
    private TextInputLayout inputLayoutJumlah;
    private ImageView ivMenune;
    private EditText edJumlah;
    private Button btn_order;
    private int hargane, gambar;
    private String jumlah = "", tipe;

    private Daftar a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_menune);

        // Toolbar title dan back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbare);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // End Toolbar

        inputLayoutJumlah = (TextInputLayout) findViewById(R.id.input_layout_jumlah);
        tvNamaMenune = (TextView) findViewById(R.id.tv_namaMenune);
        tvHargane = (TextView) findViewById(R.id.tvhargaMenune);
        ivMenune = (ImageView) findViewById(R.id.iv_detailMenune);
        edJumlah = (EditText) findViewById(R.id.input_jumlah);
        btn_order = (Button) findViewById(R.id.btn_pesen);
        edJumlah.clearFocus();

        Intent pindah = getIntent();
        gambar = pindah.getIntExtra("gambare",0);
        ivMenune.setImageResource(gambar);
        tvNamaMenune.setText(pindah.getStringExtra("menune"));
        tvHargane.setText(pindah.getStringExtra("hargadis"));
        hargane = pindah.getIntExtra("hargane", 0);
        tipe = pindah.getStringExtra("tipe");

        //Listener Tombol order
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitOrder();
            }
        });
    }

    /**
     * Validasi Order
     */
    private void submitOrder() {
        String Menune;
        Menune = tvNamaMenune.getText().toString();
        jumlah = edJumlah.getText().toString();

        if (!validateJumlah()) {
            return;
        }else {
            if (tipe.equalsIgnoreCase("Food")) {
                /*Cart.Menu[Cart.Item] = tvNamaMenune.getText().toString();
                Cart.Harga[Cart.Item] = hargane;
                Cart.Gambar[Cart.Item] = gambar;
                Cart.DisplayHarga[Cart.Item] = tvHargane.getText().toString();
                Cart.Jumlah[Cart.Item] = Integer.parseInt(jumlah);
                Cart.Item++;*/
                a = new Daftar(Menune,hargane,gambar,Integer.parseInt(jumlah));
                Cart.CartOrder.add(a);
                Cart.Totale = Cart.Totale + (hargane * Integer.parseInt(jumlah));
                finish();
            } else if (tipe.equalsIgnoreCase("Drink")) {
                a = new Daftar(Menune,hargane,gambar,Integer.parseInt(jumlah));
                Cart.CartOrder.add(a);
                Cart.Totale = Cart.Totale + (hargane * Integer.parseInt(jumlah));
                finish();
            } else {
                a = new Daftar(Menune,hargane,gambar,Integer.parseInt(jumlah));
                Cart.CartOrder.add(a);
                Cart.Totale = Cart.Totale + (hargane * Integer.parseInt(jumlah));
                finish();
            }
        }

        Toast.makeText(getApplicationContext(), "Matur Thank You!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateJumlah() {
        if (edJumlah.getText().toString().trim().isEmpty()) {
            inputLayoutJumlah.setError("Masukan Jumlah");
            requestFocus(edJumlah);
            return false;
        } else {
            inputLayoutJumlah.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
