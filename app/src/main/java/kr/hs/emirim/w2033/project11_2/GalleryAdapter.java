package kr.hs.emirim.w2033.project11_2;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    Context context;
    int[] posterIds = {R.drawable.i01, R.drawable.i02, R.drawable.i03, R.drawable.i04, R.drawable.i05,
                        R.drawable.i06, R.drawable.i07, R.drawable.i08, R.drawable.i09, R.drawable.i10,
                        R.drawable.i11,R.drawable.i12,R.drawable.i13};
    int[] tilteIds = {R.string.title01, R.string.title02, R.string.title03, R.string.title04, R.string.title05,
                        R.string.title06, R.string.title07, R.string.title08, R.string.title09, R.string.title10,
                        R.string.title11,R.string.title12,R.string.title13};
    ImageView imgvLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
    }

    @Override
    public int getCount() {
        return posterIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(300,300));
        imgv.setImageResource(posterIds[position]);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final  int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgvLarge.setImageResource(posterIds[pos]);
                Toast toast = new Toast(context);
                View toastView = View.inflate(context,R.layout.toast1,null);
                TextView textTitle = toastView.findViewById(R.id.text_title);
                textTitle.setText(tilteIds[pos]);
                toast.setView(toastView);
                toast.show();
            }
        });
        return imgv;
    }
}
