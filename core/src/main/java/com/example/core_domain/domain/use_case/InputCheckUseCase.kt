package com.example.core_domain.domain.use_case

interface InputCheckUseCase {
    operator fun invoke(text: String): Boolean
}