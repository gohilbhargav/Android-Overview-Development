package com.example.dabawala_food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dabawala_food.adapter.RestaurantListAdapter
import com.example.dabawala_food.models.RestaurentModel
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer

class MainActivity : AppCompatActivity(),RestaurantListAdapter.RestaurantListClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val restaurentModel = getRestaurentData()
        initRecyclerView(restaurentModel)
    }

    private fun initRecyclerView(restaurantList: List<RestaurentModel?>?){
        val recyclerViewRestaurant = findViewById<RecyclerView>(R.id.recyclerViewRestaurant)
        recyclerViewRestaurant.layoutManager = LinearLayoutManager(this)
        val adapter = RestaurantListAdapter(restaurantList,this)
        recyclerViewRestaurant.adapter = adapter
    }

    private  fun getRestaurentData(): List<RestaurentModel?>?{
        val inputStream: InputStream = resources.openRawResource(R.raw.restaurent)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream,"UTF-8"))
            var n : Int
            while (reader.read(buffer).also { n = it } != -1){
                writer.write(buffer, 0, n)
            }

        }catch (e:java.lang.Exception){}
        val jsonStr:String = writer.toString()
        val gson = Gson()
        val restaurentModel = gson.fromJson<Array<RestaurentModel>>(jsonStr, Array<RestaurentModel>::class.java).toList()
        return  restaurentModel
    }

    override fun onItemClick(restaurentModel: RestaurentModel) {
        val intent = Intent(this@MainActivity,MenuActivity::class.java)
        intent.putExtra("RestaurantModel", restaurentModel)
        startActivity(intent)
    }
}