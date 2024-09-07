package com.andr.zahar2.cellfilling.ui.cellfilling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.andr.zahar2.cellfilling.databinding.FragmentCellFillingBinding
import com.andr.zahar2.cellfilling.ui.cellfilling.list.CellsListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CellFillingFragment: Fragment() {

    private val viewModel by viewModels<CellFillingViewModel>()

    private var _binding: FragmentCellFillingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCellFillingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CellsListAdapter(requireContext())

        var itemsCount = 0

        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                if (itemsCount > 0) {
                    binding.list.smoothScrollToPosition(itemsCount - 1)
                }
            }
        })

        viewModel.cellsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            itemsCount = it.size
        }

        with(binding) {
            list.adapter = adapter
            createButton.setOnClickListener {
                viewModel.onCreateButtonClick()
            }
        }
    }

    override fun onDestroy() {
        binding.list.adapter = null
        _binding = null
        super.onDestroy()
    }
}