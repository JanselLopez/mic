package cu.gd.mic.fragments.presentation_fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cu.gd.mic.R
import kotlinx.android.synthetic.main.activity_main.*
import cu.gd.mic.R.drawable.progeso

class SecondPresentationPage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_presentation_page, container, false)
    }

}
