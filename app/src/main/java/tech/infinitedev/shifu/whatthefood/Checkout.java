package tech.infinitedev.shifu.whatthefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by shifu on 6/10/17.
 */

public class Checkout extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private List<Daftar> daftarOrder;
    private TextView tv_totale;
    private Button btn_ckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);

        // Toolbar title dan back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbare);
        toolbar.setTitle("Order Cart");
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

        /* Card View */
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

//        daftarOrder = new ArrayList<>();
        adapter = new CheckoutAdapter(this, Cart.CartOrder);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        /* End Card View */

        tv_totale = (TextView) findViewById(R.id.tv_harga_total);
        btn_ckout = (Button) findViewById(R.id.btn_checkout);
        tv_totale.setText("Rp " + String.valueOf(Cart.Totale));

        btn_ckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Cart.Totale != 0) {
                    Intent intent = new Intent(Checkout.this, CheckoutDone.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Pesen dulu bro!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
