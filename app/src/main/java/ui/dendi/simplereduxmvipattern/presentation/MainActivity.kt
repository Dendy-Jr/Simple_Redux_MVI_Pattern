package ui.dendi.simplereduxmvipattern.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.siddroid.holi.colors.CoolColor
import dagger.hilt.android.AndroidEntryPoint
import ui.dendi.simplereduxmvipattern.presentation.screen.NumbersScreen
import ui.dendi.simplereduxmvipattern.presentation.theme.SimpleReduxMVIPatternTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            SimpleReduxMVIPatternTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CoolColor.DARK_ORANGE
                ) {
                    NumbersScreen()
                }
            }
        }
    }
}