package com.andr.zahar2.cellfilling.ui.cellfilling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.andr.zahar2.cellfilling.data.CellFillingProcessor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CellFillingViewModel @Inject constructor(
    private val cellFillingProcessor: CellFillingProcessor
): ViewModel() {

    val cellsList = cellFillingProcessor.cells.asLiveData()

    fun onCreateButtonClick() =
        cellFillingProcessor.create()
}