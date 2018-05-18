package tech.infinitedev.shifu.whatthefood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by shifu on 6/8/17.
 */

class DaftarAdapter extends RecyclerView.Adapter<DaftarAdapter.MyViewHolder>{

    private Context mContext;
    private List<Daftar> daftarMenu;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;
        public Button btn_order;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            btn_order = (Button) view.findViewById(R.id.btn_order);
        }
    }

    public DaftarAdapter(Context mContext, List<Daftar> daftarMenu) {
        this.mContext = mContext;
        this.daftarMenu = daftarMenu;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Daftar daftar = daftarMenu.get(position);
        holder.title.setText(daftar.getName());
        holder.count.setText("Rp " + daftar.getDisplay_harga());

        // loading album cover using Glide library
        Glide.with(mContext).load(daftar.getThumbnail()).into(holder.thumbnail);

        holder.btn_order.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent;

                intent = new Intent( view.getContext(), DetailMenus.class);
                intent.putExtra("menune",daftar.getName());
                intent.putExtra("hargadis", daftar.getDisplay_harga());
                intent.putExtra("hargane", daftar.getHarga());
                intent.putExtra("gambare", daftar.getThumbnail());
                intent.putExtra("tipe", daftar.getTipe());
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return daftarMenu.size();
    }
}
