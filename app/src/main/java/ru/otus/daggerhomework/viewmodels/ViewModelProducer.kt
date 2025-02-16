package ru.otus.daggerhomework.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.EventBusProducer

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val producer: EventBusProducer,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
        producer.dispatch(colorGenerator.generateColor())
    }

}