package com.example.sandbox2

import de.jensklingenberg.ktorfit.http.GET

interface MyClass {

    @GET("test")
    suspend fun testGet(): String

}