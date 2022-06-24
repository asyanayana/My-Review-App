package org.d3if1016.asessment2.network

import com.squareup.moshi.Json

data class Profile(
    val nama: String,
    val nim: String,
    val jurusan: String,
    val hobi: String,
    @Json (name = "imageId")
    val imageUrl: String
)
