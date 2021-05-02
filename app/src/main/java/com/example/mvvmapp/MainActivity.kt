package com.example.mvvmapp



import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import java.util.List.of
import androidx.databinding.DataBindingUtil
import com.example.mvvmapp.databinding.ActivityMainBinding
import com.example.mvvmapp.databinding.ActivityMainBinding.bind
import com.example.mvvmapp.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var viewObj : ThalaivarViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        viewObj =ViewModelProvider(this).get(ThalaivarViewModel::class.java)
        binding.lifecycleOwner = this
        viewObj.quote.observe(this, Observer { quote ->
            binding.textView.text = "${quote.toString()}"

        })
        binding.button.setOnClickListener{
            viewObj.nextWord()
        }




    }


}







