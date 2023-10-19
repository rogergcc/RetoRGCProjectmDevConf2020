package com.rogergcc.retorgcprojectmdevconf2020.ui.speakers

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rogergcc.retorgcprojectmdevconf2020.R
import com.rogergcc.retorgcprojectmdevconf2020.model.mSpeaker


class AboutSpeakerDialog : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "AboutSpeakerDialog"
        const val KEY_SPEAKER_ENTITY = "speaker_entity"
        fun getAddFragment(speaker: mSpeaker): AboutSpeakerDialog {
            val bundle = Bundle().apply { putParcelable(KEY_SPEAKER_ENTITY,speaker) }
            return AboutSpeakerDialog()
                .apply { arguments= bundle }
        }
    }


    override fun getTheme(): Int =
        R.style.AppModalStyle

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val data =  arguments?.getString("name")
        val speaker = arguments?.getParcelable<mSpeaker>(KEY_SPEAKER_ENTITY)

        val view = inflater.inflate(R.layout.fragment_speaker_about, container, false)

        view.findViewById<TextView>(R.id.tvTitleAbout).text=speaker?.origin
        view.findViewById<TextView>(R.id.tvNameAbout).text=speaker?.name
        view.findViewById<TextView>(R.id.tvBioAbout).text=speaker?.bio

        return view
//        return inflater.inflate(R.layout.fragment_speaker_about, container, false)
    }
}
