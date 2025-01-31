package com.example.crickarina.Data

import com.example.crickarina.Model.Quicknavigation2
import com.example.crickarina.R


class QuickNavigationIterm {
    fun loadQuickNavigationIterm ():List<Quicknavigation2>{
        return listOf<Quicknavigation2>(
            Quicknavigation2(
                R.drawable.bats,
                R.string.Batts,
                R.string.price_bat3,
            ),
            Quicknavigation2(
                R.drawable.balls,
                R.string.Balls,
                R.string.price_bat1,
            ),
            Quicknavigation2(
                R.drawable.gear,
                R.string.Gears,
                R.string.price_bat1,
            ),
            Quicknavigation2(
                R.drawable.promo1,
                R.string.Proms,
                R.string.price_bat4,
            ),
            Quicknavigation2(
                R.drawable.pack,
                R.string.pack,
            R.string.price_bat3,
        ),
        )
    }
}