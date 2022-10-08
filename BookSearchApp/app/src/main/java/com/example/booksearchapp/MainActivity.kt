package com.example.booksearchapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearchapp.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView = itemView.findViewById<TextView>(R.id.textView)
}

class BookAdapter(var context: Context, var bookTitles:ArrayList<String>)
    : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        //inflate the view
        var view = LayoutInflater.from(context).inflate(R.layout.book_row, null)
        //create and return the view holder
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        var bookTitle = bookTitles.get(position)
        holder.textView.text = bookTitle
    }

    override fun getItemCount(): Int {
        return bookTitles.size
    }
}

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var bookTitleAdapter: BookAdapter
    var bookTitles:ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //if you want you can also use your own inflater and not the one inherited
        //using    LayoutInflater.from(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            var searchTerm = binding.searchTextEditText.text.toString()

            Thread {
                var jsonString = getBooks(searchTerm)
                var array = parseJSONString(jsonString)
                Log.i("MainActivity", "$array")
                bookTitles.clear();
                //add the new items from the server
                bookTitles.addAll(array)

                runOnUiThread{
                    bookTitleAdapter.notifyDataSetChanged()
                }


            }.start()
        }

        bookTitleAdapter = BookAdapter(this, bookTitles)
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.bookTitlesRecyclerView.layoutManager = layoutManager
        binding.bookTitlesRecyclerView.adapter = bookTitleAdapter

    }

    fun getBooks(search:String):String {
        var link = "https://www.googleapis.com/books/v1/volumes?q=$search"
        var url = URL(link)
        var connection = url.openConnection()
        var inputStream = connection.getInputStream()
        //convert byte stream into character stream
        val reader = InputStreamReader(inputStream)
        //convert the charecter
        val bufReader = BufferedReader(reader)
        var line:String? = ""
        line = bufReader.readLine()
        var stringBuffer = StringBuffer()
        stringBuffer.append(line)
        while( line != null) {
            line = bufReader.readLine()
            stringBuffer.append(line)
        }

        Log.i("MainActivity", "${stringBuffer.toString()}")
        return stringBuffer.toString()
    }

    fun parseJSONString(jsonString:String):ArrayList<String> {
        var resultArrayList = ArrayList<String>()

        var rootObject = JSONObject(jsonString)
        var itemsJSONArray = rootObject.getJSONArray("items")

        for (count in 0 until itemsJSONArray.length()) {
            var itemObject = itemsJSONArray.getJSONObject(count)
            var volumeInfoObject = itemObject.getJSONObject("volumeInfo")
            var title = volumeInfoObject.getString("title")
            resultArrayList.add(title)
        }

        return resultArrayList
    }

}