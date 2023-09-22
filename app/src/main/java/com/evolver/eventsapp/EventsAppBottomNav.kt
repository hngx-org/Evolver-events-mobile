package com.evolver.eventsapp

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.evolver.eventsapp.ui.theme.latoFont

val destinations= listOf(TimelineGraph, MyPeopleGraph, CalendarGraph, SettingsGraph)

@Composable
fun EventsAppBottomNav(
    modifier: Modifier = Modifier,
    currentBackStackEntry : NavBackStackEntry?,
    navController: NavHostController
){

    val currentDestination = currentBackStackEntry?.destination
    val showBottomNav=currentDestination?.route != SplashScreen.route && currentDestination?.route != SignInScreen.route


    if (showBottomNav){
        NavigationBar(
            modifier = modifier,
            containerColor = Color.White
        ) {

            destinations.forEachIndexed { index, eventsAppDestination ->


                val labelText = when (index) {
                    0 -> "Timeline"
                    1 -> "My people"
                    2 -> "Calendar"
                    else -> "Settings"
                }

                val iconResId = when (index) {
                    0 -> R.drawable.timeline
                    1 -> R.drawable.people
                    2 -> R.drawable.calendar
                    else -> R.drawable.settings
                }

                val selected = currentDestination?.hierarchy?.any { it.route == eventsAppDestination.route } == true

                NavigationBarItem(
                    selected = selected ,
                    onClick = {
                        // To be replaced by a ViewModel implementation
                        when(index){
                            0 -> navController.navigate(route = TimelineScreen.route){
                                launchSingleTop = true
                                popUpTo(TimelineScreen.route)
                            }
                            1 -> navController.navigate(route = MyPeopleScreen.route){
                                launchSingleTop = true
                                popUpTo(MyPeopleScreen.route)
                            }
                            2 -> navController.navigate(route = CalendarScreen.route){
                                launchSingleTop = true
                                popUpTo(CalendarScreen.route)
                            }
                            else -> navController.navigate(route = SettingsScreen.route){
                                launchSingleTop = true
                                popUpTo(SettingsScreen.route)
                            }
                        }
                    },
                    icon = { Icon(painter = painterResource(id = iconResId), contentDescription =null )},
                    alwaysShowLabel = true,
                    label = {
                        Text(
                            text = labelText,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(latoFont)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xff571FCD),
                        selectedTextColor = Color(0xff571FCD),
                        unselectedIconColor = Color(0xffCBBAF0),
                        unselectedTextColor = Color(0xffCBBAF0),
                        indicatorColor = Color.White
                    )
                )
            }


        }
    }




}

@Preview
@Composable
fun BottomBarPreview(){
    //EventsAppBottomNav()
}
