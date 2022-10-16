package com.roh.practice.data.local.home

import com.roh.practice.domain.model.HomeItem
import com.roh.practice.domain.util.HomeDestinations

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
                CardImage = null,
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
            ),
            HomeItem(
                CardId = 4,
                CardName = "Work Manager",
                CardImage = null,
                HomeDestination = HomeDestinations.WORKMANAGER,
                Description = "",
                LastModifyDate = ""
            )
        )

    }
}