package com.example.mvvmapp



import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import java.util.List.of
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var viewObj : ThalaivarViewModel
    lateinit var textView : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewObj =ViewModelProvider(this).get(ThalaivarViewModel::class.java)
        val button = findViewById<Button>(R.id.button)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            viewObj.getListOfQuotes()
            viewObj.quote.observe(this, Observer { ViewQuotes -> textView.text = (ViewQuotes) })
            viewObj.nextWord()
        }

        if(savedInstanceState !=null){
            viewObj.quote.observe(this, Observer { ViewQuotes -> textView.text=(ViewQuotes) })
        }
    }


}







