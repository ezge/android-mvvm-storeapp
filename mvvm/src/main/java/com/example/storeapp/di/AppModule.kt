package com.example.storeapp_mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://your.api.url")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

        // Retrofit
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://yourapi.com/") // Replace with your real base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun providePaymentApiService(retrofit: Retrofit): PaymentApiService {
            return retrofit.create(PaymentApiService::class.java)
        }

        @Provides
        @Singleton
        fun provideRemoteDataSource(api: PaymentApiService): PaymentRemoteDataSource {
            return PaymentRemoteDataSourceImpl(api)
        }

        // Room
        @Provides
        @Singleton
        fun provideAppDatabase(app: Application): AppDatabase {
            return Room.databaseBuilder(app,
                                        AppDatabase::class.java,
                                        "sports_store_db").build()
        }

        @Provides
        @Singleton
        fun providePaymentDao(db: AppDatabase): PaymentDao {
            return db.paymentDao()
        }

        @Provides
        @Singleton
        fun provideLocalDataSource(dao: PaymentDao): PaymentLocalDataSource {
            return PaymentLocalDataSourceImpl(dao)
        }

        // Repository
        @Provides
        @Singleton
        fun providePaymentRepository(remote: PaymentRemoteDataSource,
                                     local: PaymentLocalDataSource): PaymentRepository {
            return PaymentRepositoryImpl(remote, local)
        }
    }
}
