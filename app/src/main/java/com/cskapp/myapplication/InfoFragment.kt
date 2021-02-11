package com.cskapp.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class InfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = TableViewAdapter(arrayList)
        btnDigFrag.setOnClickListener {
            val dialogFragment = InfoDialogFragment()
            dialogFragment.show(childFragmentManager, "InfoDialogFragment")
        }
    }

    private val arrayList = ArrayList<AppModel>().apply {
        add(AppModel("Release Number", "1.0.0"))
        add(AppModel("NetworkApp Version", "1.4.0"))
        add(AppModel("AccountApp Version", "3.2.0"))
    }

}