package com.mike.core.di

import com.mike.core.image.ImageLoader
import com.mike.core.image.ImageLoaderWrapper
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
internal object ImageModule {

    @Provides
    fun provideCorePicasso(): Picasso = Picasso.get()

    @Provides
    fun provideCoreImageLoader(picasso: Picasso): ImageLoader = ImageLoaderWrapper(picasso)

}
