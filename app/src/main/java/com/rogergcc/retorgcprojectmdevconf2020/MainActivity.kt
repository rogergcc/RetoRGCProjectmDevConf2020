package com.rogergcc.retorgcprojectmdevconf2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rogergcc.retorgcprojectmdevconf2020.databinding.ActivityMainBinding
import com.rogergcc.retorgcprojectmdevconf2020.model.mSpeaker
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
//    lateinit var linearLayoutManager: LinearLayoutManager

//    lateinit var speakerAdapter: SpeakerAdapter
    private var sliderAdapter: SpeakerAdapter =SpeakerAdapter()
    private var linearLayoutManager: LinearLayoutManager= LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        val num = listOf(2,3,4,5,6)
//        num.forEach { number->
//            Timber.e(number.toString())
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager.orientation=RecyclerView.VERTICAL;

        FireBaseHelper.getSpeakers(::renderSpeakers)

        binding.btnShowAbout.setOnClickListener { view -> showAboutSpeakerDialogBottomDialog() }



    }

    private fun renderSpeakers(speakers: List<mSpeaker>) {



        binding.rvSpeakers.apply {
            adapter = sliderAdapter
            layoutManager =linearLayoutManager
        }

        sliderAdapter.setItems(speakers)
        Timber.tag("MainActivity").e(speakers.toString())
    }

    private fun showAboutSpeakerDialogBottomDialog() {
        AboutSpeakerDialog().show(supportFragmentManager, AboutSpeakerDialog.TAG)
    }

}