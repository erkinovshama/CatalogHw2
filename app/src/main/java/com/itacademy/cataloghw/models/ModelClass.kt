package com.itacademy.cataloghw.models

import java.io.Serializable

data class ModelClass(
    val image1: Int,
    val image: String,
    val name: String,
    val description: String,
    val detailDescription: String
): Serializable
