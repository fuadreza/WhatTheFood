package tech.infinitedev.shifu.whatthefood;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shifu on 6/10/17.
 */

/*class CheckoutAdapter{

}*/

class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {
    private Context mContext;
    private List<Daftar> daftarOrder;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_menune, tv_jumlahe, tv_hargane;
        private ImageView iv_gambare;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_gambare = (ImageView) itemView.findViewById(R.id.iv_cart);
            tv_menune = (TextView) itemView.findViewById(R.id.tv_cart);
            tv_jumlahe = (TextView) itemView.findViewById(R.id.tv_qty);
            tv_hargane = (TextView) itemView.findViewById(R.id.tv_total);
        }

    }

    public CheckoutAdapter(Context mContext, List<Daftar> daftarOrder) {
        this.mContext = mContext;
        this.daftarOrder = daftarOrder;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_cart, parent, false);

        return new ViewHolder(itemView);
    }

    //    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Daftar daftar = daftarOrder.get(position);
        holder.iv_gambare.setImageResource(daftar.getThumbnail());
        holder.tv_menune.setText(daftar.getName());
        holder.tv_jumlahe.setText(String.valueOf(daftar.getJumlah()));
        holder.tv_hargane.setText(String.valueOf(daftar.getJumlah() * daftar.getHarga()));

    }

    //    @Override
    public int getItemCount() {
        return daftarOrder.size();
    }
}
