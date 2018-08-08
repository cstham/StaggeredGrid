package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SolventViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView itemName, originalPrice;
    public ImageView itemPhoto;

    public SolventViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemName = (TextView) itemView.findViewById(R.id.itemName);
        itemPhoto = (ImageView) itemView.findViewById(R.id.itemPhoto);

        originalPrice = (TextView) itemView.findViewById(R.id.originalPrice);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
