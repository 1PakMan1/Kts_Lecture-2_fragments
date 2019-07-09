package com.packman.lecturefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : Fragment(), SubjectListFragment.SelectionListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (isFirstLaunch(savedInstanceState)) startNavigation()
    }

    override fun onSubjectSelected(subjectName: String) {
        val detailsFragment = DetailsFragment.getInstance(subjectName)
        if (details != null) {
            replaceFragment(R.id.details, detailsFragment, TAG_DETAILS)
        } else {
            replaceFragment(R.id.content, detailsFragment, TAG_DETAILS)
        }
    }

    private fun isFirstLaunch(state: Bundle?): Boolean = state == null

    private fun startNavigation() {
        replaceFragment(R.id.content, SubjectListFragment(), TAG_LIST)
    }

    private fun replaceFragment(containerViewId: Int, fragment: Fragment, tag: String) {
        childFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        private const val TAG_LIST = "list"
        private const val TAG_DETAILS = "details"
    }
}