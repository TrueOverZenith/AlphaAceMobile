package com.example.alphaacemobile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alphaacemobile.R
import com.example.alphaacemobile.adapter.HomeFavoriteAdapter
import com.example.alphaacemobile.adapter.HomeNewsAdapter
import com.example.alphaacemobile.adapter.HomeTopAdapter
import com.example.alphaacemobile.databinding.FragmentHomeBinding
import com.example.alphaacemobile.model.HomeFavoriteModel
import com.example.alphaacemobile.model.HomeNewsModel
import com.example.alphaacemobile.model.HomeTopModel

private lateinit var binding: FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvHomeFavoriteList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeFavoriteAdapter(createHomeFavoriteList()){
                    favorite, _ ->
                val bundle = Bundle()
                bundle.putString("name", favorite.name)
                Toast.makeText(requireActivity(), "Clicked on token: ${favorite.name}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.tokenDetailFragment, bundle)
            }
        }

        binding.rvHomeNewsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeNewsAdapter(createHomeNewsList()){
                    news, _ ->
                val bundle = Bundle()
                bundle.putString("name", news.title)
                bundle.putInt("image", news.image)
                Toast.makeText(requireActivity(), "Clicked on token: ${news.title}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.newsDetailFragment, bundle)
            }
        }

        binding.rvHomeTopList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = HomeTopAdapter(createHomeTopList()){
                    top, _ ->
                val bundle = Bundle()
                bundle.putString("name", top.name)
                Toast.makeText(requireActivity(), "Clicked on token: ${top.name}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.tokenDetailFragment, bundle)
            }
        }
    }

    private fun createHomeFavoriteList(): ArrayList<HomeFavoriteModel> {
        return arrayListOf<HomeFavoriteModel>(
            HomeFavoriteModel("BTC", "19"),
            HomeFavoriteModel("ETH", "11"),
            HomeFavoriteModel("PEJ", "11"),
            HomeFavoriteModel("RAM", "11"),
            HomeFavoriteModel("JAN", "11"),
            HomeFavoriteModel("SHI", "11")
        )
    }

    private fun createHomeNewsList(): ArrayList<HomeNewsModel> {
        return arrayListOf<HomeNewsModel>(
            HomeNewsModel(R.drawable.ic_coin, "Here comes the Coin", "This is description"),
            HomeNewsModel(R.drawable.ic_newspaper, "I am the legendary Mailbox", "This is description"),
            HomeNewsModel(R.drawable.ic_home, "Home is different to House", "This is description")
        )
    }

    private fun createHomeTopList(): ArrayList<HomeTopModel> {
        return arrayListOf<HomeTopModel>(
            HomeTopModel("1", "Ethereum", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("2", "BNB", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("3", "Solana", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("4", "ETH", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("5", "AWS", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("6", "PEJ", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("7", "RAM", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("8", "JAN", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("9", "SHI", "2000", "4593977000", R.drawable.ic_home),
            HomeTopModel("10", "Ethereum", "2000", "4593977000", R.drawable.ic_home)
        )
    }
}