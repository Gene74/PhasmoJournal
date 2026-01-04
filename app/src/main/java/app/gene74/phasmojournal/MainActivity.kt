package app.gene74.phasmojournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import app.gene74.phasmojournal.ui.ChangesScreen
import app.gene74.phasmojournal.ui.GhostInfoScreen
import app.gene74.phasmojournal.ui.JournalScreenContent
import app.gene74.phasmojournal.ui.TopBar
import app.gene74.phasmojournal.ui.theme.PhasmoJournalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }
            PhasmoJournalTheme(darkTheme = isDarkTheme) {
                MainScreen(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { isDarkTheme = !isDarkTheme }
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    isDarkTheme: Boolean = true,
    onThemeChange: () -> Unit = {}
) {
    var selectedScreen by remember { mutableIntStateOf(0) }
    var selectedGhost by remember { mutableStateOf(ghosts.first()) }
    val evidenceStates = remember { mutableStateMapOf<Evidence, EvidenceState>() }
    if (evidenceStates.isEmpty()) {
        Evidence.entries.forEach { evidenceStates[it] = EvidenceState.UNKNOWN }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = "PHASMO JOURNAL",
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Journal") },
                    selected = selectedScreen == 0,
                    onClick = { selectedScreen = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ContactPage, contentDescription = "Ghosts Info") },
                    selected = selectedScreen == 1,
                    onClick = { selectedScreen = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Changes") },
                    selected = selectedScreen == 2,
                    onClick = { selectedScreen = 2 }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedScreen) {
                0 -> JournalScreenContent(
                    evidenceStates = evidenceStates,
                    onGhostClick = { ghost ->
                        selectedGhost = ghost
                        selectedScreen = 1
                    }
                )
                1 -> GhostInfoScreen(
                    selectedGhost = selectedGhost,
                    onGhostSelected = { ghost -> selectedGhost = ghost }
                )
                2 -> ChangesScreen(isDarkTheme = isDarkTheme)
            }
        }
    }
}