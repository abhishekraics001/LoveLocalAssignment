package com.example.lovelocalassigment.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.ui.home.model.CategoryListModel

class CategoryListViewModel : ViewModel() {


    private val _data = MutableLiveData<List<CategoryListModel>>()
    val categoryList: LiveData<List<CategoryListModel>> = _data


    fun getCategoryList(){
        var data = mutableListOf<CategoryListModel>()
        data.add(CategoryListModel(7814, R.drawable.fruits_vegetables, "Fruits & Vegetables"))
        data.add(CategoryListModel(7828, R.drawable.meat_seafood, "Meat & Sea Food"))
        data.add(CategoryListModel(7827, R.drawable.health_medicine, "Health & Medicines"))
        data.add(CategoryListModel(7818, R.drawable.dairy, "Dairy"))
        data.add(CategoryListModel(7915, R.drawable.chocolates_snacks, "Chocolate & Snacks"))
        data.add(CategoryListModel(7821, R.drawable.fruits_vegetables, "Personal Care"))

        _data.apply {
            this.value = data
        };
    }
}