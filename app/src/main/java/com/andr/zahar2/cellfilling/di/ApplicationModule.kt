package com.andr.zahar2.cellfilling.di

import com.andr.zahar2.cellfilling.data.CellFillingProcessor
import com.andr.zahar2.cellfilling.data.CellFillingProcessorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideCellFillingProcessor(): CellFillingProcessor =
        CellFillingProcessorImpl()
}