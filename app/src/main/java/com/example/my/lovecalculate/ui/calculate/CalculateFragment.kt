package com.example.my.lovecalculate.ui.calculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.my.lovecalculate.R
import com.example.my.lovecalculate.databinding.FragmentCalculateBinding
import com.example.my.lovecalculate.di.Hero
import com.example.my.lovecalculate.model.LoveModel
import com.example.my.lovecalculate.presenter.MainPresenter
import com.example.my.lovecalculate.view.MainView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment(), MainView {

    private lateinit var binding: FragmentCalculateBinding

    @Inject
    lateinit var presenter: MainPresenter

    var hero = Hero()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        with(binding) {
            btnCalculate.setOnClickListener {
                Toast.makeText(requireContext(), "${hero.name} ${hero.damage}",Toast.LENGTH_SHORT).show()
                presenter.attachView(this@CalculateFragment)
                presenter.getData(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                )
            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    override fun changeScreen(loveModel: LoveModel) {
        /*val resultFragment = ResultFragment()
        val bundle = Bundle()
        bundle.putSerializable("key", loveModel)
        resultFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, resultFragment).addToBackStack(null).commit()*/
        findNavController().navigate(R.id.resultFragment, bundleOf("key" to loveModel))
    }

}