package com.example.dabawala_food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.dabawala_food.models.RestaurentModel
import kotlinx.android.synthetic.main.activity_success_order.*

class SuccessOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_order)

        val restaurentModel: RestaurentModel? = intent.getParcelableExtra("RestaurantModel")
        val actionbar: ActionBar? = supportActionBar
        actionbar?.setTitle(restaurentModel?.name)
        actionbar?.setSubtitle(restaurentModel?.address)
        actionbar?.setDisplayHomeAsUpEnabled(false)

        buttonDone.setOnClickListener {
            finish()
        }
    }
}