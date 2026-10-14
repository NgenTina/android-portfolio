package com.example.androidPortfolio.features.miniApps

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.androidPortfolio.navigation.MiniAppDetail
import com.example.androidPortfolio.navigation.MiniApps


fun NavGraphBuilder.miniAppsGraph(
    navController: NavController
) {

    /*
     * MINI APPS LIST
     */
    composable<MiniApps> {

        MiniAppsScreen(

            onMiniAppClick = { miniApp ->

                navController.navigate(
                    MiniAppDetail(
                        id = miniApp.id
                    )
                )
            }
        )
    }


    /*
     * MINI APP DETAIL
     */
    composable<MiniAppDetail> { backStackEntry ->

        val route = backStackEntry.toRoute<MiniAppDetail>()

        MiniAppDetailScreen(

            miniAppId = route.id,

            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}