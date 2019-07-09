package com.packman.lecturefragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.packman.lecturefragments.data.DataSupplier

class SubjectListFragment : ListFragment() {
    private val data: List<String>
        get() = DataSupplier().getData().map { it.name }

    private var selectionListener: SelectionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listAdapter = ArrayAdapter<String>(inflater.context, R.layout.item_subject, data)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        selectionListener = parentFragment as SelectionListener
    }

    override fun onDetach() {
        super.onDetach()
        selectionListener = null
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        selectionListener?.onSubjectSelected(data[position])
    }

    interface SelectionListener {
        fun onSubjectSelected(subjectName: String)
    }
}