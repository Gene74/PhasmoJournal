package app.gene74.phasmojournal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.gene74.phasmojournal.Ghost
import app.gene74.phasmojournal.getEvidenceIcon
import app.gene74.phasmojournal.ghosts

@Composable
fun GhostInfoScreen(
    selectedGhost: Ghost,
    onGhostSelected: (Ghost) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        // Left Column: Ghost List
        LazyColumn(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize()
        ) {
            items(ghosts) { ghost ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onGhostSelected(ghost) }
                        .background(
                            if (selectedGhost == ghost) MaterialTheme.colorScheme.primaryContainer
                            else Color.Transparent
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = ghost.name,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = if (selectedGhost == ghost) FontWeight.Bold else FontWeight.Normal,
                        color = if (selectedGhost == ghost) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        VerticalDivider(
            modifier = Modifier.width(1.dp),
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
        )

        // Right Column: Details
        LazyColumn(
            modifier = Modifier
                .weight(0.7f)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // 1. Ghost Name
            item {
                Text(
                    text = selectedGhost.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp)) // Small space after name
            }

            // 2. Trivia
            item {
                Text(
                    text = selectedGhost.trivia,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp)) // Large space after trivia
            }

            // 3. Evidences
            item {
                Text(
                    text = "Evidences",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    selectedGhost.evidences.forEach { evidence ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(MaterialTheme.colorScheme.secondaryContainer, RoundedCornerShape(8.dp))
                                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = getEvidenceIcon(evidence),
                                    contentDescription = evidence.displayName,
                                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = evidence.displayName.replace(" ", "\n"),
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center,
                                lineHeight = MaterialTheme.typography.bodySmall.fontSize * 1.2
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }

            // 4. Strengths
            item {
                Column {
                    Text(
                        text = "Strengths",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = selectedGhost.strengths,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }

            // 5. Weaknesses
            item {
                Column {
                    Text(
                        text = "Weaknesses",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = selectedGhost.weaknesses,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}