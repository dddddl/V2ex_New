package com.ddddl.v2ex.bingUtils;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.ddddl.v2ex.view.GlideRoundTransform;

public class ImageBindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)//缓存策略
                .transform(new GlideRoundTransform());

        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }
}
