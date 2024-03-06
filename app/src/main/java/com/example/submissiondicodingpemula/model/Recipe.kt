package com.example.submissiondicodingpemula.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val name: String?,
    val description: String?,
    val ingredient: String?,
    val step: String?,
    val photo: Int?,
) : Parcelable
