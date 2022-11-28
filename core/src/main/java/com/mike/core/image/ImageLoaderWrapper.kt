package com.mike.core.image

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.io.File
import javax.inject.Singleton

@Singleton
internal class ImageLoaderWrapper(private val picasso: Picasso) : ImageLoader {

    override fun load(
        imageView: ImageView,
        @RawRes @DrawableRes resId: Int,
        @RawRes @DrawableRes placeholder: Int?,
        @RawRes @DrawableRes errorPlaceholder: Int?,
    ) {
        picasso
            .load(resId).apply {
                placeholder?.let { placeholder(it) }
                errorPlaceholder?.let { error(it) }
            }
            .resize(imageView.width, imageView.height)
            .into(imageView, object : Callback {
                override fun onSuccess() = Unit
                override fun onError(p0: Exception?) = imageView.setImageResource(resId)
            })
    }

    override fun load(
        imageView: ImageView,
        uri: Uri?,
        @DrawableRes placeholder: Int?,
        @DrawableRes errorPlaceholder: Int?,
    ) {
        picasso
            .load(uri).apply {
                placeholder?.let { placeholder(it) }
                errorPlaceholder?.let { error(it) }
            }
            .resize(imageView.width, imageView.height)
            .into(imageView, object : Callback {
                override fun onSuccess() = Unit
                override fun onError(p0: Exception?) = imageView.setImageURI(uri)
            })
    }

    override fun load(
        imageView: ImageView,
        file: File,
        @DrawableRes placeholder: Int?,
        @DrawableRes errorPlaceholder: Int?,
    ) {
        picasso
            .load(file).apply {
                placeholder?.let { placeholder(it) }
                errorPlaceholder?.let { error(it) }
            }
            .resize(imageView.width, imageView.height)
            .into(imageView, object : Callback {
                override fun onSuccess() = Unit
                override fun onError(p0: Exception?) = imageView.setImageURI(Uri.fromFile(file))
            })
    }

    override fun load(
        imageView: ImageView,
        path: String?,
        @DrawableRes placeholder: Int?,
        @DrawableRes errorPlaceholder: Int?,
    ) {
        picasso
            .load(path).apply {
                placeholder?.let { placeholder(it) }
                errorPlaceholder?.let { error(it) }
            }
            .resize(imageView.width, imageView.height)
            .into(imageView, object : Callback {
                override fun onSuccess() = Unit
                override fun onError(p0: Exception?) {
                    path?.let { imageView.setImageURI(Uri.fromFile(File(it))) }
                }
            })
    }

}