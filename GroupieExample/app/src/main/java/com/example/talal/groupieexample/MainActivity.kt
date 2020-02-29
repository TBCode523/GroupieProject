package com.example.talal.groupieexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyler_image_layout.*
import org.jetbrains.anko.browse


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GroupAdapter<ViewHolder>()
        adapter.setOnItemClickListener { item, view -> R.layout.recyler_image_layout
            if(item.id== 1000.toLong()) {
                Log.v("Intent:", "Launching Intent")
                browse("https://www.google.com/")
            }

            else if (item.id== 2000.toLong()){
                Log.v("Intent:", "Launching Else Intent")
                browse("https://www.youtube.com/watch?v=-bKTdlkWp8E")
            }
            else{
                browse("https://github.com/lisawray/groupie")
            }




        }
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, adapter.spanCount)

        }
        recyclerView.adapter = adapter
        adapter.add(TextItem("Google"))
        adapter.add(YoutubeItem("Youtube tutorial"))
        adapter.add(GithubItem("View the Support Library!"))





    }



        class TextItem constructor(private val str: String) : Item() {
                val search = str
            override fun getLayout() = R.layout.recyler_image_layout
            override fun getId(): Long {
                return 1000.toLong()
            }
            override fun bind(viewHolder: ViewHolder, position: Int) {
                viewHolder.cardTitle.text = str + position
                viewHolder.image.setImageResource(R.drawable.google)



            }


            override fun getSpanSize(spanCount: Int, position: Int): Int {

                return super.getSpanSize(spanCount, position)
            }



        }


    class YoutubeItem constructor(private val str: String) : Item() {

        override fun getLayout() = R.layout.recyler_image_layout
        override fun getId(): Long {
            return 2000.toLong()
        }
        override fun bind(viewHolder: ViewHolder, position: Int) {
            viewHolder.cardTitle.text = str + position
            viewHolder.image.setImageResource(R.drawable.youtube)


        }


        override fun getSpanSize(spanCount: Int, position: Int): Int {

            return super.getSpanSize(spanCount, position)
        }
    }
        class GithubItem constructor(private val str: String) : Item() {

            override fun getLayout() = R.layout.recyler_image_layout
            override fun getId(): Long {
                return 3000.toLong()
            }
            override fun bind(viewHolder: ViewHolder, position: Int) {
                viewHolder.cardTitle.text = str + position
                viewHolder.image.setImageResource(R.drawable.githublogo)



            }


            override fun getSpanSize(spanCount: Int, position: Int): Int {

                return super.getSpanSize(spanCount, position)
            }



        }







    }





