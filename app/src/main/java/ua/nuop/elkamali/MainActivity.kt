package ua.nuop.elkamali

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ua.nuop.elkamali.data.deviceDataFlow.ThemeController
import ua.nuop.elkamali.navigation.destination.ApplicationDestination
import ua.nuop.elkamali.navigation.graph.AppNavGraph
import ua.nuop.elkamali.ui.theme.NotesAppTheme
import ua.nuop.elkamali.viewModel.MainViewModel
import javax.inject.Inject

val LocalAppThemeController = compositionLocalOf { ThemeController() }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var theme: ThemeController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        enableEdgeToEdge()
        setContent {
            val systemTheme = isSystemInDarkTheme()
            val viewModel: MainViewModel =
                hiltViewModel(creationCallback = { it: MainViewModel.Factory ->
                    it.create(systemTheme)
                })

            CompositionLocalProvider(LocalAppThemeController provides theme) {
                val currentTheme = LocalAppThemeController.current
                val darkThemeEnabled by currentTheme.isDarkEnabled.collectAsState()
                NotesAppTheme(darkThemeEnabled) {
                    AppNavGraph(startDestination = ApplicationDestination.MainScreens.route)

                }

            }
        }
    }
}


