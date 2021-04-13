package com.azhar.newsapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.newsapp.R
import com.azhar.newsapp.adapter.NewsAdapter
import com.azhar.newsapp.model.ModelArticle
import com.azhar.newsapp.model.ModelNews
import com.azhar.newsapp.networking.ApiEndpoint.getApiClient
import com.azhar.newsapp.networking.ApiInterface
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

class FragmentSearch : Fragment() {

    companion object {
        const val API_KEY = "API KEY ada di Video YT"
    }

    var strKeywords: String = ""
    var modelArticle: MutableList<ModelArticle> = ArrayList()
    var newsAdapter: NewsAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvListNews.setLayoutManager(LinearLayoutManager(context))
        rvListNews.setHasFixedSize(true)
        rvListNews.hideShimmerAdapter()
        imageClear.setVisibility(View.GONE)
        linearNews.setVisibility(View.GONE)

        imageClear.setOnClickListener {
            etSearchView.getText().clear()
            modelArticle.clear()
            linearNews.setVisibility(View.GONE)
            imageClear.setVisibility(View.GONE)
        }

        //action search
        etSearchView.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                strKeywords = etSearchView.getText().toString()
                if (strKeywords.isEmpty()) {
                    Toast.makeText(context, "Form tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                } else {
                    getListNews(strKeywords)
                }
                val inputManager = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(v.windowToken, 0)
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun getListNews(strKeywords: String) {
        rvListNews.showShimmerAdapter()
        modelArticle.clear()

        //set api
        val apiInterface = getApiClient().create(ApiInterface::class.java)
        val call = apiInterface.getNewsSearch(strKeywords, "id", API_KEY)
        call.enqueue(object : Callback<ModelNews> {
            override fun onResponse(call: Call<ModelNews>, response: Response<ModelNews>) {
                if (response.isSuccessful && response.body() != null) {
                    modelArticle = response.body()?.modelArticle as MutableList<ModelArticle>
                    newsAdapter = NewsAdapter(modelArticle, context!!)
                    rvListNews.adapter = newsAdapter
                    newsAdapter?.notifyDataSetChanged()
                    rvListNews.hideShimmerAdapter()
                    linearNews.visibility = View.VISIBLE
                    imageClear.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<ModelNews>, t: Throwable) {
                Toast.makeText(context, "Oops, jaringan kamu bermasalah.", Toast.LENGTH_SHORT).show()
            }
        })
    }

}