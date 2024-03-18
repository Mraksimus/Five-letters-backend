package dev.mraksimus.plugins.koin

import dev.mraksimus.infrastructure.repositories.ITestRepository
import dev.mraksimus.infrastructure.repositories.TestRepository
import org.koin.dsl.module

val testModule = module {
    single<ITestRepository> { TestRepository() }
}
