package com.andr.zahar2.cellfilling.data

import com.andr.zahar2.cellfilling.data.model.Cell
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class CellFillingProcessorImpl: CellFillingProcessor {

    private val _cells = MutableStateFlow<List<Cell>>(emptyList())
    override val cells: StateFlow<List<Cell>> = _cells.asStateFlow()

    private var comboDeadCellsCounter = 0
    private var comboAliveCellsCounter = 0

    private var lastLifeCell: Cell.Life? = null

    override fun create() {
        CoroutineScope(Dispatchers.Default).launch {
            val newCell = if (Random.nextInt(0, 2) == 0) {
                comboDeadCellsCounter++
                comboAliveCellsCounter = 0
                Cell.Dead()
            } else {
                lastLifeCell = null
                comboAliveCellsCounter++
                comboDeadCellsCounter = 0
                Cell.Alive()
            }

            if (comboDeadCellsCounter == 3) {
                comboDeadCellsCounter = 0
                lastLifeCell?.let {
                    _cells.value -= it
                    lastLifeCell = null
                }
            }

            _cells.value += newCell

            if (comboAliveCellsCounter == 3) {
                comboAliveCellsCounter = 0
                lastLifeCell = Cell.Life()
                _cells.value += lastLifeCell!!
            }
        }
    }
}