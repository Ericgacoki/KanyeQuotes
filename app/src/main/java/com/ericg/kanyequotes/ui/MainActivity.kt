package com.ericg.kanyequotes.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ericg.kanyequotes.databinding.ActivityMainBinding
import com.ericg.kanyequotes.repository.Repository
import com.ericg.kanyequotes.viewmodel.MainViewModel
import com.ericg.kanyequotes.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    lateinit var repo: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repo = Repository()
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(repo)).get(MainViewModel::class.java)

        getQuote()
        binding.btnGetQuote.setOnClickListener {
            getQuote()
        }
    }

    private fun getQuote(){
        try {
            viewModel.getQuote()
            viewModel.response.observe(this, {
                if (it.isSuccessful) {
                    binding.tvQuote.text = it.body()?.quote
                } else {
                    Log.d("Response", it.errorBody().toString())
                }
            })
        } catch (e: Exception) {
            binding.tvQuote.text = e.toString()
        }
    }
}