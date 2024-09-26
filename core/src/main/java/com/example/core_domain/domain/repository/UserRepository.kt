package com.example.core_domain.domain.repository

interface UserRepository {
    fun inputCheck(text: String): Boolean
}