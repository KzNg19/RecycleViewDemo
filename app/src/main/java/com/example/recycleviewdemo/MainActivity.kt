package com.example.recycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),StudentAdapter.onItemClicklistener {
    private lateinit var binding: ActivityMainBinding
    private val studentList = listOf(
        Student("W001","a","RSA","m"),
        Student("W002", "b", "RSB","f"),
        Student("W003", "c", "RSC","m"),
        Student("W004", "d", "RSD","f"),
        Student("W005", "e", "RSE","m")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = StudentAdapter(studentList,this)

        binding.RecycleViewStudent.adapter = adapter
        binding.RecycleViewStudent.layoutManager = LinearLayoutManager(applicationContext)
        binding.RecycleViewStudent.setHasFixedSize(true)

    }

    override fun itemClick(position: Int) {
        val selectStudent = studentList[position]
        Toast.makeText(applicationContext, selectStudent.name, Toast.LENGTH_SHORT).show()
    }

}