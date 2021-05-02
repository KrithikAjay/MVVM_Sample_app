package com.example.mvvmapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ThalaivarViewModel : ViewModel() {
    private val _quote = MutableLiveData<String>()
   val quote: LiveData<String>
   get() = _quote
    lateinit var quoteList:MutableList<String>




    fun getListOfQuotes() {

               quoteList = mutableListOf(
            "Nee Aaniya Pudungavenam",
            "Dey, Enna Vechi Comedy Geemedy Panlaye",
            "Aahaan",
            "Vada Poche",
            "Naa Apdiye Shock Ayita",
            " Venaam..Valikudhu…Aluthuduven",
            " Maapu Vecchitanda Aappu",
            "Vaaya Moodra Korangu",
            "Why blood?  Same blood",
            "Engalukku Risk Yadukradu Yellam Rusk Sapidra Madiri",
            " Oh Ethu Thaan azhagula mayakaratha …?",
            "Building strongu… basementu .. weak",
            "Evalavu adichaalum summaa erukkaan da , evan romba naalavana.. nu soliitaaan…",
            " Ippadi usuppethi, usuppethi-e odamba ranagalam aakkitaanuga pa!",
            "Avana neeyi",
            " Indha rangalathalayum unakku oru kilukiluppu kekkudhu",
            "Dei Naan Yokkiyanda",
            "Swing In The Rain I Am Swaying In The Rain",
        )
        quoteList.shuffle()

    }
    init {

        getListOfQuotes()
        nextWord()


    }

    fun nextWord() {

        if (quoteList.isEmpty()) {
            getListOfQuotes()
        }
        _quote.value = quoteList.removeAt(0)

    }

}