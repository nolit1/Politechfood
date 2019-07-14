package com.example.politechfood.mainPackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politechfood.R
import com.example.politechfood.common.ItemCafe
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_near_cafes.view.*

class FragmentMain : Fragment() {


    private var adapterCafes = GroupAdapter<ViewHolder>()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()

        main_btn_all_cafes.setOnClickListener {
            Navigation.findNavController(activity!!, R.id.main_section)
                .navigate(
                    R.id.action_fragmentMain_to_fragmentAllCafes
                    , Bundle().apply {
                    }
                )
        }
        main_btn_profile.setOnClickListener {
            Navigation.findNavController(activity!!, R.id.main_section)
                .navigate(
                    R.id.action_fragmentMain_to_profile
                    , Bundle().apply {
                    }
                )
        }
    }


    private fun initial() {

        main_swipe.isRefreshing = false
        recyclerView = main_recycler_view_near_cafes
        recyclerView.adapter = adapterCafes
        val mLayoutManager = LinearLayoutManager(activity)

        recyclerView.layoutManager = mLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context, DividerItemDecoration.VERTICAL
        )
        dividerItemDecoration.setDrawable(context!!.getDrawable(R.drawable.divider_item_decoration)!!)
        recyclerView.addItemDecoration(dividerItemDecoration)

        if (adapterCafes.itemCount == 0) {
            //near cafes
            val cafe1 = ItemCafe(1.toString(), "Макдональдс", null, 4.5)
            val cafe2 = ItemCafe(2.toString(), "Столовая 1", null, 4.2)
            val cafe3 = ItemCafe(3.toString(), "Столовая 2", null, 4.0)
            val cafe4 = ItemCafe(4.toString(), "Сабвэй", null, 4.7)
            val cafe5 = ItemCafe(5.toString(), "Столовая 2", null, 3.8)
            adapterCafes.add(ItemCafesHolder(cafe1, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe2, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe3, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe4, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe5, activity!!))
        }

    }



}

class ItemCafesHolder(private val cafe: ItemCafe, private val activity: FragmentActivity) : Item<ViewHolder>() {


    override fun bind(viewHolder: ViewHolder, position: Int) {

        if (cafe.name != null) {
            viewHolder.itemView.item_near_cafes_name.text = cafe.name
        } else {
            viewHolder.itemView.item_near_cafes_name.text = activity.getString(R.string.not_know)
        }
        if (cafe.rating != null) {
            viewHolder.itemView.item_near_cafes_rating.text = cafe.rating.toString()
        } else {
            viewHolder.itemView.item_near_cafes_rating.text = activity.getString(R.string.not_know)
        }
        if (cafe.logo == null || cafe.logo == "") {
            viewHolder.itemView.item_near_cafes_logo.setImageResource(R.drawable.politeh)
        } else {
            val url = cafe.logo
            Picasso.get().load(url).into(viewHolder.itemView.item_near_cafes_logo)
        }

        viewHolder.itemView.setOnClickListener {
            Navigation.findNavController(activity, R.id.main_section)
                .navigate(
                    R.id.action_fragmentMain_to_singleCaffee
                    , Bundle().apply {
                    }
                )
        }

    }
    override fun getLayout(): Int {
        return R.layout.item_near_cafes
    }


}