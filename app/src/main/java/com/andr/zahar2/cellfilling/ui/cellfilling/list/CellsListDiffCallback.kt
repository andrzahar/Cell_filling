package com.andr.zahar2.cellfilling.ui.cellfilling.list

import androidx.recyclerview.widget.DiffUtil
import com.andr.zahar2.cellfilling.data.model.Cell

object CellsListDiffCallback: DiffUtil.ItemCallback<Cell>() {
    override fun areItemsTheSame(oldItem: Cell, newItem: Cell): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Cell, newItem: Cell): Boolean =
        oldItem.id == newItem.id
}