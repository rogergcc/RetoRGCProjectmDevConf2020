package com.rogergcc.retorgcprojectmdevconf2020.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogergcc.retorgcprojectmdevconf2020.BuildConfig
import com.rogergcc.retorgcprojectmdevconf2020.R
import com.rogergcc.retorgcprojectmdevconf2020.data.FireBaseHelper
import com.rogergcc.retorgcprojectmdevconf2020.databinding.ActivityMainBinding
import com.rogergcc.retorgcprojectmdevconf2020.model.mSpeaker
import com.rogergcc.retorgcprojectmdevconf2020.ui.speakers.AboutSpeakerDialog
import com.rogergcc.retorgcprojectmdevconf2020.ui.speakers.AboutSpeakerDialog.Companion.KEY_SPEAKER_ENTITY
import com.rogergcc.retorgcprojectmdevconf2020.ui.speakers.ISpeakerClickListener
import com.rogergcc.retorgcprojectmdevconf2020.ui.speakers.SpeakerAdapter
import com.rogergcc.retorgcprojectmdevconf2020.ui.utils.TimberAppLogger

class MainActivity : AppCompatActivity()
    , ISpeakerClickListener {

    private lateinit var binding: ActivityMainBinding;
//    lateinit var linearLayoutManager: LinearLayoutManager

//    lateinit var speakerAdapter: SpeakerAdapter
    private var sliderAdapter: SpeakerAdapter =
    SpeakerAdapter(this)
//    private var linearLayoutManager: LinearLayoutManager= LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val num = listOf(2,3,4,5,6)
//        num.forEach { number->
//            Timber.e(number.toString())
//        }
//        FirebaseApp.initializeApp(this);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rvSpeakers.layoutManager= LinearLayoutManager(this)
        FireBaseHelper.getSpeakers(::renderSpeakers)


        TimberAppLogger.e("MainActivity ${getString(R.string.app_name_build)}")

        TimberAppLogger.e("MainActivity ${BuildConfig.BASE_URL}")
        //binding.btnShowAbout.setOnClickListener { view -> showAboutSpeakerDialogBottomDialog() }

    }

    private fun renderSpeakers(speakers: List<mSpeaker>) {



        binding.rvSpeakers.apply {
            layoutManager = LinearLayoutManager(
                context!!,
//                this@MainActivity
                LinearLayoutManager.VERTICAL,
                false
            )
            this.adapter = sliderAdapter
        }

//        binding.rvSpeakers.adapter = sliderAdapter;
        sliderAdapter.setSpeakers(speakers)
        TimberAppLogger.e("MainActivity ${speakers.toString()}")
    }

    private fun showAboutSpeakerDialogBottomDialog() {

        AboutSpeakerDialog().show(supportFragmentManager,
            AboutSpeakerDialog.TAG
        )
    }

    private fun showBottomSheet(
        context: Context,
        data: String,
        mspeaker: mSpeaker?
    ) {

        val bottomSheetFragment =
            AboutSpeakerDialog()

        val bundle = Bundle()

        bundle.putParcelable(KEY_SPEAKER_ENTITY, mspeaker)


        bundle.putString("name", data)

        bottomSheetFragment.arguments = bundle


        bottomSheetFragment.show(
            (context as AppCompatActivity).supportFragmentManager,
            AboutSpeakerDialog.TAG
        )

    }

    override fun clickDetails(mspeaker: mSpeaker) {
        Toast.makeText(this, mspeaker.origin,Toast.LENGTH_SHORT).show()
//        showBottomSheet(this,"ROGER",mspeaker)
//        showAboutSpeakerDialogBottomDialog()

        AboutSpeakerDialog.getAddFragment(
            mspeaker
        )

    }

}