package com.example.transfers.di

import com.example.transfers.data.local.ContactDao
import com.example.transfers.data.remote.ContactsService
import com.example.transfers.data.repository.ContactDataSource
import com.example.transfers.data.repository.ContactLocalDataSource
import com.example.transfers.data.repository.ContactRemoteDataSource
import com.example.transfers.data.repository.ContactsRepositoryImpl
import com.example.transfers.domain.repository.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TransfersModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideContactsService(retrofit: Retrofit): ContactsService {
        return retrofit.create(ContactsService::class.java)
    }

    @Provides
    @Singleton
    fun provideContactDao(): ContactDao {
        return ContactDao()
    }

    @Provides
    @Singleton
    fun provideContactLocalDataSource(contactDao: ContactDao): ContactDataSource.Local {
        return ContactLocalDataSource(contactDao)
    }

    @Provides
    @Singleton
    fun provideContactRemoteDataSource(contactsService: ContactsService): ContactDataSource.Remote {
        return ContactRemoteDataSource(contactsService)
    }

    @Provides
    @Singleton
    fun provideContactsRepository(
        remote: ContactDataSource.Remote,
        local: ContactDataSource.Local
    ): ContactsRepository {
        return ContactsRepositoryImpl(
            remote = remote,
            local = local
        )
    }

}
