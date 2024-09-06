package com.andr.zahar2.cellfilling.data.model

import java.util.UUID

sealed class Cell(val id: UUID = UUID.randomUUID()) {

    class Dead: Cell()

    class Alive: Cell()

    class Life: Cell()
}
