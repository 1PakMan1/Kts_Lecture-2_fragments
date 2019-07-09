package com.packman.lecturefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.packman.lecturefragments.data.DataSupplier
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private val titleStr: String
        get() = arguments?.getString(KEY_TITLE) ?: ""

    private val dataSupplier = DataSupplier()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        title.text = titleStr
        description.text = dataSupplier.getData()
            .find { it.name == titleStr }
            ?.details ?: ""
    }

    companion object {
        private const val KEY_TITLE = "KEY_TITLE"
        fun getInstance(title: String): Fragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_TITLE, title)
                }
            }
        }
    }
}