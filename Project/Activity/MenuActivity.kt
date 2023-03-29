package com.example.dabawala_food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dabawala_food.adapter.MenuListAdapter
import com.example.dabawala_food.models.Menus
import com.example.dabawala_food.models.RestaurentModel
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(), MenuListAdapter.MenuListClickListener {
    private var itemInTheCartList: MutableList<Menus?>? = null
    private var totalItemInCartCount = 0
    private var menuList: List<Menus?>? = null
    private var menuListAdapter: MenuListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val restaurentModel = intent?.getParcelableExtra<RestaurentModel>("RestaurantModel")

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setTitle(restaurentModel?.name)
        actionBar?.setSubtitle(restaurentModel?.address)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        menuList = restaurentModel?.menus

        initRecyclerView(menuList)
        checkoutButton.setOnClickListener {
             if (itemInTheCartList != null && itemInTheCartList!!.size <=0){
                 Toast.makeText(this@MenuActivity,"please add some items in cart",Toast.LENGTH_LONG).show()
             }
            else{
                restaurentModel?.menus = itemInTheCartList
                 val intent = Intent(this@MenuActivity,PlaceYourOrderActivity::class.java)
                 intent.putExtra("RestaurantModel",restaurentModel)
                 startActivityForResult(intent,1000)
            }
        }
    }
    private fun initRecyclerView(menus: List<Menus?>?){
        menuRecyclerView.layoutManager = GridLayoutManager(this,2)
        menuListAdapter = MenuListAdapter(menus,this)
        menuRecyclerView.adapter = menuListAdapter
    }

    override fun addToCartClickListener(menu: Menus) {
        if (itemInTheCartList == null){
            itemInTheCartList = ArrayList()
        }
        itemInTheCartList?.add(menu)
        totalItemInCartCount = 0
        for (menu in itemInTheCartList!!){
            totalItemInCartCount = totalItemInCartCount + menu?.totalInCart!!
        }
        checkoutButton.text = "Checkout(" + totalItemInCartCount + ") Item"
    }

    override fun updateCartClickListener(menu: Menus) {
        val index = itemInTheCartList!!.indexOf(menu)
        itemInTheCartList?.removeAt(index)
        itemInTheCartList?.add(menu)
        totalItemInCartCount = 0
        for (menu in itemInTheCartList!!){
            totalItemInCartCount = totalItemInCartCount + menu?.totalInCart!!
        }
        checkoutButton.text = "Checkout(" + totalItemInCartCount + ") Item"
    }

    override fun removeFromCartClickListener(menu: Menus) {
        if (itemInTheCartList!!.contains(menu)){
            itemInTheCartList?.remove(menu)
            totalItemInCartCount = 0
            for (menu in itemInTheCartList!!){
                totalItemInCartCount = totalItemInCartCount + menu?.totalInCart!!
            }
            checkoutButton.text = "Checkout(" + totalItemInCartCount + ") Item"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && resultCode == RESULT_OK){
            finish()
        }
    }
}