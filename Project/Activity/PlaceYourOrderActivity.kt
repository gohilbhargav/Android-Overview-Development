package com.example.dabawala_food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dabawala_food.adapter.PlaceYourOrderAdapter
import com.example.dabawala_food.models.RestaurentModel
import kotlinx.android.synthetic.main.activity_place_your_order.*

class PlaceYourOrderActivity : AppCompatActivity() {

    var placeYourOrderAdapter: PlaceYourOrderAdapter? = null
    var isDeliveryOn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_your_order)

        val restaurentModel: RestaurentModel? = intent.getParcelableExtra("RestaurantModel")
        val actionbar: ActionBar? = supportActionBar
        actionbar?.setTitle(restaurentModel?.name)
        actionbar?.setSubtitle(restaurentModel?.address)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        buttonPlaceYourOrder.setOnClickListener {
             onPlaceOrderButtonClick(restaurentModel)
        }

        switchDelivery?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                inputAddress.visibility = View.VISIBLE
                inputCity.visibility = View.VISIBLE
                inputState.visibility = View.VISIBLE
                inputZip.visibility = View.VISIBLE
                tvDeliveryCharge.visibility = View.VISIBLE
                tvDeliveryChargeAmount.visibility = View.VISIBLE
                isDeliveryOn = true
            }else{
                inputAddress.visibility = View.GONE
                inputCity.visibility = View.GONE
                inputState.visibility = View.GONE
                inputZip.visibility = View.GONE
                tvDeliveryCharge.visibility = View.GONE
                tvDeliveryChargeAmount.visibility = View.GONE
                isDeliveryOn = false
            }
        }
        initRecyclerView(restaurentModel)
        calculateTotalAmount(restaurentModel)
    }

    private fun initRecyclerView(restaurentModel: RestaurentModel?){
        cartItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        placeYourOrderAdapter = PlaceYourOrderAdapter(restaurentModel?.menus)
        cartItemsRecyclerView.adapter = placeYourOrderAdapter
    }

    private fun calculateTotalAmount(restaurentModel: RestaurentModel?){
        var subTotalAmount = 0f
        for (menu in restaurentModel?.menus!!){
            subTotalAmount += menu?.price!! * menu?.totalInCart!!
        }
        tvSubtotalAmount.text = String.format("%.2f",subTotalAmount)
        if (isDeliveryOn){
            tvDeliveryChargeAmount.text = String.format("%.2f",restaurentModel?.delivery_charge?.toFloat())
            subTotalAmount += restaurentModel?.delivery_charge?.toFloat()!!
        }

        tvTotalAmount.text = String.format("%.2f",subTotalAmount)
    }

    private fun onPlaceOrderButtonClick(restaurentModel: RestaurentModel?){
        if (TextUtils.isEmpty(inputName.text.toString())){
            inputName.error = "Enter your name"
            return
        } else if (isDeliveryOn && TextUtils.isEmpty(inputAddress.text.toString())){
            inputAddress.error = "Enter your address"
            return
        } else if (isDeliveryOn && TextUtils.isEmpty(inputCity.text.toString())){
            inputCity.error = "Enter your City name"
            return
        } else if (isDeliveryOn && TextUtils.isEmpty(inputZip.text.toString())){
            inputZip.error = "Enter your Zip code"
            return
        } else if (TextUtils.isEmpty(inputCardNumber.text.toString())){
            inputCardNumber.error = "Enter your credit card number"
            return
        } else if (TextUtils.isEmpty(inputCardExpiry.text.toString())){
            inputCardExpiry.error = "Enter your credit card expiry"
            return
        } else if (TextUtils.isEmpty(inputCardPin.text.toString())){
            inputCardPin.error = "Enter your credit card pin/cvv"
            return
        }
        val intent = Intent(this@PlaceYourOrderActivity,SuccessOrderActivity::class.java)
        intent.putExtra("RestaurantModel", restaurentModel)
        startActivityForResult(intent,1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1000){
            setResult(RESULT_OK)
            finish()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(RESULT_CANCELED)
        finish()
    }
}