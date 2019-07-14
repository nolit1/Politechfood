package com.example.politechfood.mainPackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politechfood.R
import com.example.politechfood.common.ItemCafe
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_all_cafes.*

class FragmentAllCafes : Fragment() {

    private var adapterCafes = GroupAdapter<ViewHolder>()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_cafes, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        all_cafe_swipe.isRefreshing = false
        recyclerView = all_cafe_recycler_view_near_cafes
        recyclerView.adapter = adapterCafes
        val mLayoutManager = LinearLayoutManager(activity)

        recyclerView.layoutManager = mLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context, DividerItemDecoration.VERTICAL
        )
        dividerItemDecoration.setDrawable(context!!.getDrawable(R.drawable.divider_item_decoration)!!)
        recyclerView.addItemDecoration(dividerItemDecoration)

        if (adapterCafes.itemCount == 0) {
            //all cafes order by rating
            val cafe1 = ItemCafe(1.toString(), "Макдональдс", null, 4.7)
            val cafe2 = ItemCafe(1.toString(), "Столовая 1", null, 4.2)
            val cafe3 = ItemCafe(1.toString(), "Сабвэй", null, 4.0)
            val cafe4 = ItemCafe(1.toString(), "Столовая 2", null, 4.0)
            val cafe5 = ItemCafe(1.toString(), "Столовая 3", null, 3.8)
            val cafe6 = ItemCafe(1.toString(), "Столовая 4", null, 3.5)
            val cafe7 = ItemCafe(1.toString(), "Столовая 5", null, 3.0)
            adapterCafes.add(ItemCafesHolder(cafe1, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe2, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe3, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe4, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe5, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe6, activity!!))
            adapterCafes.add(ItemCafesHolder(cafe7, activity!!))

        }
    }

}

