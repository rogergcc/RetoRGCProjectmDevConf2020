package com.rogergcc.retorgcprojectmdevconf2020.data

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.rogergcc.retorgcprojectmdevconf2020.model.mSpeaker
import timber.log.Timber


/**
 * Created by rogergcc on 18/12/2020.
 * Copyright Ⓒ 2020 . All rights reserved.
 */
private const val COLLECTION_SPEAKERS = "speakers"

object FireBaseHelper {

//    private val db = FirebaseFirestore.getInstance()

    fun getSpeakers(speakerListener: (List<mSpeaker>) -> Unit) {
         val db = FirebaseFirestore.getInstance()
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
                }?.let { speakers ->
                    speakerListener(speakers)

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

    fun getDummySpeakers(speakerListener: (List<mSpeaker>) -> Unit) {
        val mSpeakerList: List<mSpeaker> = listOf(
            mSpeaker(
                "1", "Ivan Limberth Sangueza Alarcon", "La Paz Bolivia",
                "Desarrollador Móvil. Entusiasta de las comunidades de tecnologías, " +
                        "promotor de colaboración y el trabajo en equipo amante del arte y " +
                        "la creatividad. Líder en en la comunidad GDG La Paz",
                "https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fspeakers%2FIvan%20Sangueza%20-%20Ivan%20Limberth%20Sangueza%20Alarcon-min.JPG?alt=media&token=58dc41ba-65db-4d83-be82-3e63f403e28a"
            ),

            mSpeaker(
                "2",
                "Diego Velásquez López",
                "Lima, Perú",
                "Soy de Lima Perú. GDE en Dart y Flutter con más de 10 años de experiencia en el desarrollo de apps móviles Android/iOS/Flutter. Ing. de Software Senior en Go social, portland USA",
                "https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fspeakers%2Fdiego_profile%20-%20Diego%20Vel%C3%A1squez-min.jpg?alt=media&token=513f1420-73cd-44aa-83b0-71b2fb5f2cf7"
            ),
            mSpeaker(
                "3",
                "Argel Bejarano",
                "Hermosillo, Sonora, México",
                "Flutter GDE,con más de 10 años de experiencia en desarrollo de software, creador de la comunidad de Flutter y Dart en Español y profesor de Dart en Platzi",
                "https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fspeakers%2FDevFest%20Profile%20-%20Argel%20Bejarano.jpeg?alt=media&token=6ce4f978-01c3-4998-80c6-c3ac5ed098bc"
            ),
            mSpeaker(
                "4",
                "Facundo Rodríguez Arceeri",
                "Buenos Aires, Argentina",
                "Facundo es un desarrollador Android con experiencia en esta plataforma desde Android Donut (1.6), y tuvo un amor a primera vista con Kotlin. También es co-organizador de Android Devs Buenos Aires y GDG Buenos Aires",
                "https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fspeakers%2Ffacu%20-%20Facundo%20Rodr%C3%ADguez%20Arceri.jpg?alt=media&token=b4cdcfe2-e306-409b-8550-2c928307cd15"
            ),
            mSpeaker(
                "4",
                "Cristian Gomez",
                "Medellin, Colombia",
                "Cristian es desarrollador de software, actualmente enfocado en el desarrollo de apps usando el JAMSTACK y también como GDE de Android. Activo en las comunidades de desarrollo de Colombia y Latam. Co-organizador de Droids4Droids, conferencia especializada para desarrolladores Android, Charlista de conferencias como Droidcon (Polonia, Santo Domingo). En su tiempo libre disfruta de la fotografía y tocar la guitarra",

                ""
            ),
            mSpeaker(
                "4",
                "Gianny Alfaro Gutierrez",
                "Lima, Perú",
                "Ingeniera Informática de la Universidad Nacional de Trujillo. Candidata a MBA - CENTRUM PUCP Graduate Business School y con más de 3 años de experiencia desarrollando aplicaciones móviles Android. Me gusta el Body Painting y las películas de ficción.",
                ""
            ),
            mSpeaker(
                "4",
                "Bruno Aybar",
                "Lima, Peru",
                "Principal Engineer @ Avantica Technologies. 7 años de experiencia desarrollando aplicaciones móviles de todo tipo. Instructor de Android &amp; Kotlin. Co-organizador de la comunidad Android Dev Perú",
                ""
            ),
            mSpeaker(
                "4",
                "Juan Guillermo Gómez Torres",
                "Cali, Colombia",
                "Juan Guillermo es co-organizador y fundador del GDG Cali. Ha estado involucrado en la comunidad tecnológica durante los últimos 15 años. Asiste a más de 30 eventos al año como orador invitado en toda Latinoamérica, donde habla sobre móvil, android, cloud, firebase, kotlin y arquitectura de software. Es reconocido por Google como un experto en Firebase y Google Cloud Platform. Actualmente es líder técnico de una startup en CDMX",
                ""
            )
        )
        speakerListener(mSpeakerList)

    }

    fun loadImageDrawable(context: Context, @DrawableRes resId: Int, targetView: ImageView) {
        Glide.with(context)
            .asBitmap()
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .apply(RequestOptions().override(100))
            .load(resId)
            .into(targetView)
    }

    fun loadImageDrawableUrl(context: Context, urlPhoto: String, targetView: ImageView) {
        Glide.with(context)
            .asBitmap()
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .apply(RequestOptions().override(100))
            .load(urlPhoto)
            .into(targetView)
    }


}

