package com.andr.zahar2.cellfilling.data

import com.andr.zahar2.cellfilling.data.model.Cell
import kotlinx.coroutines.flow.StateFlow

interface CellFillingProcessor {

    val cells: StateFlow<List<Cell>>

    suspend fun create()
}