package ua.nuop.elkamali.repo

import ua.nuop.elkamali.data.datastore.ThemeDataStore
import ua.nuop.elkamali.data.deviceDataFlow.ThemeController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeRepo @Inject constructor(
    private val themeDataStore: ThemeDataStore,
    private val themeController: ThemeController
) {

    suspend fun init(isSystemDarkEnabled: Boolean) {
        val isDatastoreDarkEnabled = themeDataStore.isDarkTheme()
        if (isDatastoreDarkEnabled != null) {
            themeController.setScheme(isDatastoreDarkEnabled)
        } else {
            themeController.setScheme(isSystemDarkEnabled)
            themeDataStore.setTheme(isSystemDarkEnabled)
        }
    }

    suspend fun toggleScheme() {
        themeController.toggle()
        val isDarkEnabled = themeDataStore.isDarkTheme() ?: false
        themeDataStore.setTheme(!isDarkEnabled)
    }



}