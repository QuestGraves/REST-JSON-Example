package com.keltica.rest_json_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.keltica.rest_json_example.databinding.ActivityMainBinding
import com.keltica.rest_json_example.respository.Repository

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var mUserId: TextView
    private lateinit var mId: TextView
    private lateinit var mTitle: TextView
    private lateinit var mBody: TextView
    private lateinit var mFetchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUserId = findViewById(R.id.tv_userId)
        mId = findViewById(R.id.tv_id)
        mTitle = findViewById(R.id.tv_title)
        mBody = findViewById(R.id.tv_body)
        mFetchButton = findViewById(R.id.button_fetch)
        //Repository
        val repository = Repository()
        //ViewModel
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.mResponse.observe(this, Observer {
        mUserId.text = it.userID.toString()
        mId.text = it.id.toString()
        mTitle.text = it.title
        mBody.text = it.body
        })

        mFetchButton.setOnClickListener{
                viewModel.getPost()
            }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}