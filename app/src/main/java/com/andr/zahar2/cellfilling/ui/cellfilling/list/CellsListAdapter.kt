package com.andr.zahar2.cellfilling.ui.cellfilling.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andr.zahar2.cellfilling.data.model.Cell
import com.andr.zahar2.cellfilling.databinding.ItemCellBinding

class CellsListAdapter(private val context: Context) :
    ListAdapter<Cell, CellsListAdapter.CellsListHolder>(CellsListDiffCallback) {

    inner class CellsListHolder(private var binding: ItemCellBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cell: Cell) {
            val content = when(cell) {
                is Cell.Dead -> ItemCellContent.Dead
                is Cell.Alive -> ItemCellContent.Alive
                is Cell.Life -> ItemCellContent.Life
            }

            with(binding) {
                emoji.text = context.getString(content.emojiId)
                emoji.background = context.getDrawable(content.backgroundId)
                title.text = context.getString(content.titleId)
                description.text = context.getString(content.descriptionId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CellsListHolder(
        ItemCellBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: CellsListHolder, position: Int) =
        holder.bind(getItem(position))
}