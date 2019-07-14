package com.example.politechfood.mainPackage.singleCafePackage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politechfood.R
import com.example.politechfood.common.ItemComment
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_single_cafe.*
import kotlinx.android.synthetic.main.item_comment.view.*

class FragmentSingleCafe : Fragment() {

    private var adapterComments = GroupAdapter<ViewHolder>()
    lateinit var recyclerView: RecyclerView

    private var cafeName : String ?= null
    private var cafeLogo : String ?= null
    private var cafeDescription : String ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_single_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /**
         * Подгрука из базы
         * */
        cafeName = "Столовая 1"
        cafeLogo = null
        cafeDescription = "Краткое описание заведения. Самая вкусная еда здесь"

        if (cafeName != null) {
            single_cafe_name.text = cafeName
        } else {
            single_cafe_name.text = getString(R.string.not_know)
        }
        if (cafeDescription != null) {
            single_cafe_description.text = cafeDescription
        } else {
            single_cafe_description.text = getString(R.string.not_know)
        }
        if (cafeLogo == null) {
           single_cafe_logo.setImageResource(R.drawable.politeh)
        } else {
            val url = cafeLogo
            Picasso.get().load(url).into(single_cafe_logo)
        }

        single_cafe_create_comment.setOnClickListener {
            val intent = Intent(context, ActivityCreateComment::class.java)
            startActivity(intent)
        }

        initial()
    }

    private fun initial() {

        recyclerView = single_cafe_recycler_view_comments
        recyclerView.adapter = adapterComments
        val mLayoutManager = LinearLayoutManager(activity)

        recyclerView.layoutManager = mLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context, DividerItemDecoration.VERTICAL
        )
        dividerItemDecoration.setDrawable(context!!.getDrawable(R.drawable.divider_item_decoration)!!)
        recyclerView.addItemDecoration(dividerItemDecoration)

        if (adapterComments.itemCount == 0) {
            //near cafes
            val comment1 = ItemComment(1.toString(), "Арнольд", null, 4.5, "18-06-2019 17:38", "Рандомный комментарий номер 1")
            val comment2 =  ItemComment(2.toString(), "Джеймс", null, 4.5, "18-06-2019 17:38", "Рандомный комментарий номер 2")
            val comment3 =   ItemComment(3.toString(), "Настя", null, 3.0, "18-06-2019 17:38", "Рандомный комментарий номер 3")
            val comment4 =    ItemComment(4.toString(), "Саша", null, 5.0, "18-06-2019 17:38", "Рандомный комментарий номер 4")
            val comment5  = ItemComment(5.toString(), "Луиджи", null, 3.0, "18-06-2019 17:38", "Рандомный комментарий номер 5")
            adapterComments.add(
                ItemCommentsHolder(
                    comment1,
                    activity!!
                )
            )
            adapterComments.add(
                ItemCommentsHolder(
                    comment2,
                    activity!!
                )
            )
            adapterComments.add(
                ItemCommentsHolder(
                    comment3,
                    activity!!
                )
            )
            adapterComments.add(
                ItemCommentsHolder(
                    comment4,
                    activity!!
                )
            )
            adapterComments.add(
                ItemCommentsHolder(
                    comment5,
                    activity!!
                )
            )
        }

    }

}

class ItemCommentsHolder(private val comment: ItemComment, private val activity: FragmentActivity) : Item<ViewHolder>() {


    override fun bind(viewHolder: ViewHolder, position: Int) {

        if (comment.author != null) {
            viewHolder.itemView.item_comment_author_name.text = comment.author
        } else {
            viewHolder.itemView.item_comment_author_name.text = activity.getString(R.string.not_know)
        }
        if (comment.rating != null) {
            viewHolder.itemView.item_comment_rating.text = comment.rating.toString()
        } else {
            viewHolder.itemView.item_comment_rating.text = activity.getString(R.string.not_know)
        }
        if (comment.authorLogo == null || comment.authorLogo == "") {
            viewHolder.itemView.item_comment_author_logo.setImageResource(R.drawable.politeh)
        } else {
            val url = comment.authorLogo
            Picasso.get().load(url).into(viewHolder.itemView.item_comment_author_logo)
        }
        if (comment.text != null) {
            viewHolder.itemView.item_comment_text.text = comment.text
        } else {
            viewHolder.itemView.item_comment_text.text = activity.getString(R.string.not_know)
        }
        if (comment.timeCreate != null) {
            viewHolder.itemView.item_comment_time_create.text = comment.timeCreate
        } else {
            viewHolder.itemView.item_comment_time_create.text = activity.getString(R.string.not_know)
        }

    }
    override fun getLayout(): Int {
        return R.layout.item_comment
    }


}