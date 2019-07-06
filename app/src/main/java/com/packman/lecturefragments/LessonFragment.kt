package com.packman.lecturefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lesson.*

class LessonFragment : Fragment() {

    private val isLessonDone: Boolean
        get() = arguments?.getBoolean(KEY_IS_DONE) ?: false

    private val lessonTopic: String?
        get() = arguments?.getString(KEY_LESSON_TOPIC)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lesson_topic.text = lessonTopic
        bookmark.visibility = if (isLessonDone) View.VISIBLE else View.GONE
        val actionText =
            if (isLessonDone) view.context.getText(R.string.lesson_redo) else view.context.getText(R.string.lesson_start)
        showDetails.text = actionText
    }

    companion object {
        private const val KEY_IS_DONE = "KEY_IS_DONE"
        private const val KEY_LESSON_TOPIC = "KEY_LESSON_TOPIC"
        fun getInstance(isDone: Boolean, lessonTopic: String): Fragment {
            return LessonFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(KEY_IS_DONE, isDone)
                    putString(KEY_LESSON_TOPIC, lessonTopic)
                }
            }
        }
    }
}