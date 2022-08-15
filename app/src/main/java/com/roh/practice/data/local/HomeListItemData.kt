package com.roh.practice.data.local

import com.roh.practice.R
import com.roh.practice.domain.util.HomeDestinations
import com.roh.practice.domain.model.HomeItem

class HomeListItemData {

    companion object {

        val homeListData = listOf(
            HomeItem(
                CardId = 1,
                CardName = "Circular ImageView",
                CardImage = null,
                HomeDestination = HomeDestinations.CIRCULARIMAGEVIEW,
                Description = "",
                LastModifyDate = ""

            ),
            HomeItem(
                CardId = 2,
                CardName = "Custom Seekbar",
                CardImage = R.drawable.ic_seekbar,
                HomeDestination = HomeDestinations.SEEKBAR,
                Description = "",
                LastModifyDate = ""

            ),
            HomeItem(
                CardId = 3,
                CardName = "Custom Snackbar",
                CardImage = null,
                HomeDestination = HomeDestinations.SNACKBAR,
                Description = "",
                LastModifyDate = ""
            )
        )

    }
}