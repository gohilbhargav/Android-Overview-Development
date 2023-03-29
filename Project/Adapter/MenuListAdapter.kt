package com.example.dabawala_food.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dabawala_food.R
import com.example.dabawala_food.models.Menus
import kotlinx.android.synthetic.main.menu_list_row.view.*
import kotlinx.android.synthetic.main.recycler_restaurant_list_row.view.*
import kotlinx.android.synthetic.main.recycler_restaurant_list_row.view.thumbImage

class MenuListAdapter(val menuList: List<Menus?>?, val clickListener: MenuListClickListener): RecyclerView.Adapter<MenuListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.menu_list_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(menuList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return  if(menuList == null)return  0 else menuList.size
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var thumbImage: ImageView = view.thumbImage
        var menuName: TextView = view.menuName
        var menuPrice: TextView = view.menuPrice
        var addToCartButton:TextView = view.addToCartButton
        var addMoreLayout: LinearLayout =view.addMoreLayout
        var imageMinus : ImageView = view.imageMinus
        var imageAddOne: ImageView = view.imageAddOne
        var tvCount : TextView = view.tvCount

        fun bind(menus: Menus){
            menuName.text = menus?.name
            menuPrice.text = "Price:  ${menus?.price}"
            addToCartButton.setOnClickListener {
                menus?.totalInCart = 1
                clickListener.addToCartClickListener(menus)
                addMoreLayout?.visibility = View.VISIBLE
                addToCartButton.visibility = View.GONE
                tvCount.text = menus?.totalInCart.toString()
            }
            imageMinus.setOnClickListener {
                var total: Int = menus.totalInCart
                total--
                if (total > 0) {
                    menus?.totalInCart = total
                    clickListener.updateCartClickListener(menus)
                    tvCount.text = menus?.totalInCart.toString()
                } else{
                    menus.totalInCart = total
                    clickListener.removeFromCartClickListener(menus)
                    addMoreLayout.visibility = View.GONE
                    addToCartButton.visibility = View.VISIBLE
                }
            }
            imageAddOne.setOnClickListener {
                var total: Int = menus.totalInCart
                total++
                if (total <=10){
                    menus.totalInCart = total
                    clickListener.updateCartClickListener(menus)
                    tvCount.text = total.toString()
                }
            }
            Glide.with(thumbImage)
                .load(menus?.url)
                .into(thumbImage)
       }
    }

    interface  MenuListClickListener{
        fun addToCartClickListener(menu: Menus)
        fun updateCartClickListener(menu: Menus)
        fun removeFromCartClickListener(menu: Menus)
    }
}