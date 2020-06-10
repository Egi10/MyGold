package id.buaja.abstraction.until.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

fun ImageView.load(imageUri: Any) {
    Glide.with(this.context)
        .load(imageUri)
        .into(this)
}

fun ImageView.circle(imageUri: Any) {
    Glide.with(this.context)
        .asBitmap()
        .load(imageUri)
        .apply(
            RequestOptions()
            .transform(CircleCrop())
        )
        .into(this)
}