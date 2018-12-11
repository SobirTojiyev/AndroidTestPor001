package com.example.tojiy.myapplication.fragments.httpbolim;

import android.content.Context;
import android.widget.ImageView;

import com.example.tojiy.myapplication.R;
import com.example.tojiy.myapplication.UNVERSALCLASS;
import com.squareup.picasso.Picasso;

public class PicassBolim {  public static void downloadImage(Context c, String imageUrl, ImageView img) {

    if (imageUrl.length() > 0 && imageUrl != null) {


//            Picasso.with(c).load(SuperClass.ip_adress + imageUrl)
//                    .networkPolicy(NetworkPolicy.OFFLINE)
//                    .placeholder(R.drawable.ic_icon)
//                    .error(R.drawable.ic_menu_camera)
//                    .into(img);
//            PicassoCache.getPicassoInstance(c).load(imageUrl).into(img);
//            Picasso.with(c).load(SuperClass.ip_adress + imageUrl).placeholder(R.drawable.ic_icon).into(img);
        Picasso.with(c).load(UNVERSALCLASS.url + imageUrl).placeholder(R.drawable.abc).into(img);
    } else {
        Picasso.with(c).load(R.drawable.abc).into(img);
    }
}
}