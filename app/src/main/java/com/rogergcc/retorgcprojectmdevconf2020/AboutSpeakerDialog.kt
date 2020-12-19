package com.rogergcc.retorgcprojectmdevconf2020

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AboutSpeakerDialog : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "AboutSpeakerDialog"
    }

    override fun getTheme(): Int = R.style.AppModalStyle

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speaker_about, container, false)
    }
}
