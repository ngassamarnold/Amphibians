package com.example.grille.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val numberCourse: Int,
    @DrawableRes val image: Int
)
