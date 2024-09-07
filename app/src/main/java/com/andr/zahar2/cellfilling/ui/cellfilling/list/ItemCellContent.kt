package com.andr.zahar2.cellfilling.ui.cellfilling.list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.andr.zahar2.cellfilling.R

sealed class ItemCellContent (
    @StringRes val emojiId: Int,
    @DrawableRes val backgroundId: Int,
    @StringRes val titleId: Int,
    @StringRes val descriptionId: Int
) {

    data object Dead: ItemCellContent(
        R.string.dead_cell_emoji,
        R.drawable.dead_cell_emoji_background,
        R.string.dead_cell_title,
        R.string.dead_cell_description
    )

    data object Alive: ItemCellContent(
        R.string.alive_cell_emoji,
        R.drawable.alive_cell_emoji_background,
        R.string.alive_cell_title,
        R.string.alive_cell_description
    )

    data object Life: ItemCellContent(
        R.string.life_cell_emoji,
        R.drawable.life_cell_emoji_background,
        R.string.life_cell_title,
        R.string.life_cell_description
    )
}