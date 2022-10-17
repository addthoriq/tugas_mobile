package com.example.tugasmobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tugasmobile.R
import com.example.tugasmobile.databinding.FragmentHomeBinding
import com.example.tugasmobile.databinding.FragmentMatchListBinding
import com.example.tugasmobile.ui.matchlist.MatchListsViewModel
import com.example.tugasmobile.ui.teamlist.TeamListFragment

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var btnTeamList: Button
    private lateinit var btnMatchList: Button

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeListsViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val textView: TextView = binding.textHome
//        homeListsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        relationToXml(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun relationToXml(v: View){
//        btnTeamList = v.findViewById(R.id.btn_team_list)
//        btnTeamList = v.findViewById(R.id.btn_team_list)
//        btnTeamList.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_team_list -> {
                val mTeamListFragment = TeamListFragment()
                val mFragmentManager = parentFragmentManager
                mFragmentManager.beginTransaction().apply {
                    replace(R.id.container, mTeamListFragment, TeamListFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }


}