package com.example.lovelocalassigment.ui.wallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.databinding.FragmentShoppingBinding
import com.example.lovelocalassigment.databinding.FragmentWalletBinding
import com.example.lovelocalassigment.ui.shoping.ShoppingViewModel


class WalletFragment : Fragment() {


    private var _binding: FragmentWalletBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val wallet =
            ViewModelProvider(this).get(WalletViewModel::class.java)

        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWallet
        wallet.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


}