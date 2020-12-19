package com.rogergcc.retorgcprojectmdevconf2020

import com.google.firebase.firestore.FirebaseFirestore
import com.rogergcc.retorgcprojectmdevconf2020.model.mSpeaker
import timber.log.Timber


/**
 * Created by rogergcc on 18/12/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */
private const val COLLECTION_SPEAKERS = "speakers"

object FireBaseHelper {

    private val db = FirebaseFirestore.getInstance()

    fun getSpeakers(speakerListener: (List<mSpeaker>) -> Unit) {

        db.collection(COLLECTION_SPEAKERS)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Timber.tag("FireBaseHelper").e(error.message.toString())
                }

//                snapshot?.documents?.let { documents ->
//                    val document = documents[0].getString("name")
//                    Timber.tag("FireBaseHelper").e(document.toString())
//                }
                value?.documents?.map { document ->
                    mSpeaker(
                        id = document.id,
                        name = document.getString("name") ?: "",
                        bio = document.getString("bio") ?: "",
                        origin = document.getString("origin") ?: "",
                        photo = document.getString("photo") ?: ""
                    )
                }?.let {speakers->speakerListener(speakers)

                }



            }
        //.get()
//            .addOnSuccessListener { documentReference ->
//                for (document in documentReference.documents) {
//                    Timber.tag("FireBaseHelper").e(document.data.toString())
//                }
//            }
//            .addOnFailureListener { e ->
//                Timber.tag("FireBaseHelper").e(e, "Error in reading")
//            }

    }
}

