package io.seoj17.android_14th_compose_zzik.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.seoj17.android_14th_compose_zzik.data.BitRepository
import io.seoj17.android_14th_compose_zzik.data.BitRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsBitRepository(bitRepository: BitRepositoryImpl): BitRepository
}
