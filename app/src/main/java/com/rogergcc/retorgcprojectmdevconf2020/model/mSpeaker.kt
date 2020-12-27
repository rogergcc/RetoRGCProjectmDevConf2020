package com.rogergcc.retorgcprojectmdevconf2020.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by rogergcc on 18/12/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */
@Parcelize
data class mSpeaker(
    val id: String,
    val name: String,
    val origin: String,
    val bio: String,
    val photo: String
): Parcelable
