package dev.m13d.helloworld

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val title: String,
    val counter: Int
) : Parcelable
