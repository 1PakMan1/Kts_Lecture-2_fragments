package com.packman.lecturefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lesson.*

class LessonFragment : Fragment() {

    private val isLessonDone: Boolean
        get() = arguments?.getBoolean(KEY_IS_DONE) ?: false

    private val lessonTopic: String?
        get() = arguments?.getString(KEY_LESSON_TOPIC)

    private var cardView: CardView? = null

    private val selectionListener
        get() = parentFragment as? LessonSelectionListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardView = view as CardView
        initViews()
    }

    fun getCard(): CardView? = cardView

    private fun initViews() {
        card.apply { maxCardElevation = CardAdapter.MAX_ELEVATION_FACTOR * elevation }

        lesson_topic.text = lessonTopic

        bookmark.visibility = if (isLessonDone) View.VISIBLE else View.GONE

        val actionText = if (isLessonDone) getString(R.string.lesson_redo) else getString(R.string.lesson_start)
        showDetails.apply {
            text = actionText
            setOnClickListener { selectionListener!!.onLessonSelected(lessonTopic!!) }
        }
    }

    interface LessonSelectionListener {
        fun onLessonSelected(lesson: String)
    }

    companion object {
        private const val KEY_IS_DONE = "KEY_IS_DONE"
        private const val KEY_LESSON_TOPIC = "KEY_LESSON_TOPIC"

        fun getInstance(model: LessonUiModel): LessonFragment {
            return LessonFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(KEY_IS_DONE, model.isDone)
                    putString(KEY_LESSON_TOPIC, model.topic)
                }
            }
        }
    }
}