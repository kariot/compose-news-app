package me.kariot.composenewsapp.presentation.screens.languageSelection

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.kariot.composenewsapp.data.models.languageSelection.Languages
import me.kariot.composenewsapp.navigation.Screens
import me.kariot.composenewsapp.presentation.ui.theme.*

@Composable
fun LanguagePickerScreen(navController: NavController?) {
    val languages = listOf(
        Languages("E", colorAccent, "English"),
        Languages("മ", orange, "മലയാളം"),
        Languages("த", purple, "தமிழ்"),
        Languages("ಕ", darkBlue, "ಕನ್ನಡ"),
        Languages("ह", darkGray, "हिंदी")
    )
    var selectedItemIndex by remember {
        mutableStateOf(-1)
    }
    val onItemClick = { index: Int -> selectedItemIndex = index }

    Scaffold(topBar = { TopAppBar(title = { Text("Pick a language") }) }) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                LanguageListHeader()
            }
            itemsIndexed(languages) { index, language ->
                LanguageCard(
                    index,
                    language,
                    onItemClick,
                    selectedItemIndex == index
                )
            }
            item {
                LanguageListFooter {
                    if (selectedItemIndex > -1) {
                        navController?.navigate(Screens.DashScreen.route)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LanguagePickerScreenPreview() {
    LanguagePickerScreen(rememberNavController())
}