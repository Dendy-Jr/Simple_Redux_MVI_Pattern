package ui.dendi.simplereduxmvipattern.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ui.dendi.simplereduxmvipattern.domain.model.Number
import ui.dendi.simplereduxmvipattern.domain.repository.NumbersRepository
import javax.inject.Inject
import javax.inject.Singleton

class NumbersRepositoryImpl @Inject constructor() : NumbersRepository {

    override suspend fun getNumbers(): List<Number> = withContext(Dispatchers.IO) {
        var startValue = 0.0
        var id = 0
        val numbers = mutableListOf<Number>().apply {
            add(
                Number(
                    id = id,
                    number = startValue,
                )
            )
        }

        repeat(999) {
            startValue += 0.1
            id += 1
            numbers.add(
                Number(
                    id = id,
                    number = String.format("%.1f", startValue).toDouble(),
                )
            )
        }
        return@withContext numbers
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface NumbersRepositoryModule {

    @Singleton
    @Binds
    fun binds(impl: NumbersRepositoryImpl): NumbersRepository
}