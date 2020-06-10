package id.buaja.abstraction.until

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

@GlideModule
class CustomGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}