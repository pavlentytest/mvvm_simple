package ru.samsung.itschool.mdev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        val provider = ViewModelProvider(this)
        viewModel = provider.get(MainViewModel::class.java)
        observeViewModel()
        button.setOnClickListener {
            viewModel.onIncrementClicked()
        }
    }

    fun observeViewModel() {
        viewModel.counter.observe(this, Observer {
            textView.text = it.toString()
        })
    }
}
