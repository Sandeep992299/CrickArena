package com.example.crickarina.Data

import com.example.crickarina.Model.kookabu
import com.example.crickarina.R

class kooka {
    fun loadKooka ():List<kookabu>{
        return listOf<kookabu>(
            kookabu(
                R.drawable.ssglad,
                R.string.bat1,
                R.string.price_bat2,
            ),
            kookabu(
                R.drawable.aura,
                R.string.bat2,
                R.string.price_bat2,
            ),
            kookabu(
                R.drawable.beast21,
                R.string.bat3,
                R.string.price_bat3,
            ),
            kookabu(
                R.drawable.beast31,
                R.string.bat4,
                R.string.price_bat4,
            )
        )
    }
}