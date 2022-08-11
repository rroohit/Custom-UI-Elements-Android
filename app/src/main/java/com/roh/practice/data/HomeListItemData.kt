package com.roh.practice.data

import com.roh.practice.R
import com.roh.practice.model.HomeItem

class HomeListItemData {

    companion object {

        val homeListData = listOf(
            HomeItem(
                CardId = 1,
                CardName = "Custom Seekbar",
                CardImage = R.drawable.ic_seekbar,
                HomeDestination = HomeDestinations.SEEKBAR,
                Description = "",
                LastModifyDate = ""

            ),
            HomeItem(
                CardId = 2,
                CardName = "Custom Snackbar",
                CardImage = null,
                HomeDestination = HomeDestinations.SNACKBAR,
                Description = "",
                LastModifyDate = ""
            )
        )

    }
}