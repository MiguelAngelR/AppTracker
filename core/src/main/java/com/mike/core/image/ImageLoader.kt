package com.mike.core.image

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import java.io.File

/**
 * Interface to provide custom implementation of the image loading functionality.
 */
interface ImageLoader {

    /**
     * Start an image request using the specified URI.
     * @param imageView Target [ImageView] of resource loading.
     * @param uri Resource [Uri].
     * @param placeholder A placeholder drawable to be used while the image is being loaded.
     * If the requested image is not immediately available in the memory cache then this resource will be set on the target ImageView.
     * @param errorPlaceholder An error drawable to be used if the request image could not be loaded.
     */
    fun load(
        imageView: ImageView,
        uri: Uri?,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

    /**
     * Start an image request using the specified drawable resource ID.
     * @param imageView Target [ImageView] of resource loading.
     * @param resId Local resource id.
     * @param placeholder A placeholder drawable to be used while the image is being loaded.
     * If the requested image is not immediately available in the memory cache then this resource will be set on the target ImageView.
     * @param errorPlaceholder An error drawable to be used if the request image could not be loaded.
     */
    fun load(
        imageView: ImageView,
        @RawRes @DrawableRes resId: Int,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

    /**
     * Start an image request using the specified image file.
     * @param imageView Target [ImageView] of resource loading.
     * @param file File to load as image.
     * @param placeholder A placeholder drawable to be used while the image is being loaded.
     * If the requested image is not immediately available in the memory cache then this resource will be set on the target ImageView.
     * @param errorPlaceholder An error drawable to be used if the request image could not be loaded.
     */
    fun load(
        imageView: ImageView,
        file: File,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

    /**
     * Start an image request using the specified path.
     * @param imageView Target [ImageView] of resource loading.
     * @param path File path to load as image.
     * @param placeholder A placeholder drawable to be used while the image is being loaded.
     * If the requested image is not immediately available in the memory cache then this resource will be set on the target ImageView.
     * @param errorPlaceholder An error drawable to be used if the request image could not be loaded.
     */
    fun load(
        imageView: ImageView,
        path: String?,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

}
