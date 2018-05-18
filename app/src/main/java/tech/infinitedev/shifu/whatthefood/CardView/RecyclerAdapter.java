package tech.infinitedev.shifu.whatthefood.CardView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tech.infinitedev.shifu.whatthefood.About;
import tech.infinitedev.shifu.whatthefood.Dessert;
import tech.infinitedev.shifu.whatthefood.Drink;
import tech.infinitedev.shifu.whatthefood.Food;
import tech.infinitedev.shifu.whatthefood.R;

/**
 * Created by shifu on 6/5/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Food",
            "Drink",
            "Dessert",
            "About"};

    private String[] details = {"What The Food!",
            "What The Drink!", "What The Dessert!",
            "What About Us!"};

    private int[] images = {R.drawable.cover_food,
            R.drawable.cover_drink,
            R.drawable.cover_dessert,
            R.drawable.cover_wtf};

    private int[] icons = {R.drawable.icon_food,
            R.drawable.icon_drink,
            R.drawable.icon_dessert,
            R.drawable.icon_wtf};

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView itemImage;
        public ImageView itemIcon;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDetail = (TextView) itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent;

                    switch (position) {
                        case 0:
                            intent = new Intent(v.getContext(), Food.class);
                            v.getContext().startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(v.getContext(), Drink.class);
                            v.getContext().startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(v.getContext(), Dessert.class);
                            v.getContext().startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(v.getContext(), About.class);
                            v.getContext().startActivity(intent);
                            break;
                        default:
                            break;
                    }

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.itemIcon.setImageResource(icons[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}