package pe.kreatec.basetemplate.util.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.loadAny
import coil.transform.CircleCropTransformation

object CustomBinders {

    @JvmStatic
    @BindingAdapter("app:loadAvatarFromUrl")
    fun loadAvatarFromUrl(imageView: ImageView, url: String?) {
        url?.let {
            imageView.loadAny(it) {
                transformations(CircleCropTransformation())
            }
        }
    }

}