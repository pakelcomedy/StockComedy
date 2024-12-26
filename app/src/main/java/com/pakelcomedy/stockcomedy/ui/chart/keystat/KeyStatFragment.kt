package com.pakelcomedy.stockcomedy.ui.chart.keystat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pakelcomedy.stockcomedy.R

class KeyStatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the correct layout for KeyStatFragment
        return inflater.inflate(R.layout.fragment_key_stat, container, false)
    }
}
