package app.tomsgenesis.phasmojournal.ui

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import app.tomsgenesis.phasmojournal.Evidence
import app.tomsgenesis.phasmojournal.EvidenceState
import app.tomsgenesis.phasmojournal.Ghost
import app.tomsgenesis.phasmojournal.getEvidenceIcon
import app.tomsgenesis.phasmojournal.ghosts
import kotlin.collections.iterator

@Composable
fun JournalScreenContent(
    evidenceStates: MutableMap<Evidence, EvidenceState>,
    onGhostClick: (Ghost) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Evidence",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset Evidence",
                tint = Color(0xFF4CAF50),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        Evidence.entries.forEach { evidenceStates[it] = EvidenceState.UNKNOWN }
                    }
            )
        }

        val possibleGhosts = ghosts.filter { isGhostPossible(it, evidenceStates) }
        val relevantEvidences = possibleGhosts.flatMap { it.evidences }.toSet()

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val chunkedEvidence = Evidence.entries.chunked(4)
            chunkedEvidence.forEach { rowItems ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    rowItems.forEach { evidence ->
                        val isRelevant = relevantEvidences.contains(evidence) || evidenceStates[evidence] != EvidenceState.UNKNOWN

                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            EvidenceItem(
                                evidence = evidence,
                                state = evidenceStates[evidence] ?: EvidenceState.UNKNOWN,
                                isRelevant = isRelevant,
                                onStateChange = { newState ->
                                    evidenceStates[evidence] = newState
                                }
                            )
                        }
                    }
                    val remaining = 4 - rowItems.size
                    repeat(remaining) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ghosts",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )

        val sortedGhosts = ghosts.sortedByDescending { isGhostPossible(it, evidenceStates) }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(sortedGhosts) { ghost ->
                val isPossible = isGhostPossible(ghost, evidenceStates)
                GhostItem(
                    ghost = ghost, 
                    isPossible = isPossible,
                    onClick = { onGhostClick(ghost) }
                )
            }
        }
    }
}

@Composable
fun EvidenceItem(
    evidence: Evidence,
    state: EvidenceState,
    isRelevant: Boolean,
    onStateChange: (EvidenceState) -> Unit
) {
    val backgroundColor = when (state) {
        EvidenceState.FOUND -> Color(0xFFE8F5E9)
        EvidenceState.RULED_OUT -> Color(0xFFFFEBEE)
        EvidenceState.UNKNOWN -> MaterialTheme.colorScheme.surfaceVariant
    }

    val borderColor = when (state) {
        EvidenceState.FOUND -> Color(0xFF4CAF50)
        EvidenceState.RULED_OUT -> Color(0xFFEF5350)
        EvidenceState.UNKNOWN -> Color.Transparent
    }

    val iconTint = when (state) {
        EvidenceState.FOUND -> Color(0xFF1B5E20)
        EvidenceState.RULED_OUT -> Color(0xFFB71C1C)
        EvidenceState.UNKNOWN -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    val alpha = if (isRelevant) 1f else 0.3f

    Box(
        modifier = Modifier
            .size(60.dp)
            .alpha(alpha)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .border(2.dp, borderColor, RoundedCornerShape(8.dp))
            .clickable { onStateChange(if (state == EvidenceState.UNKNOWN) EvidenceState.FOUND else if (state == EvidenceState.FOUND) EvidenceState.RULED_OUT else EvidenceState.UNKNOWN) }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = getEvidenceIcon(evidence),
            contentDescription = evidence.displayName,
            tint = iconTint,
            modifier = Modifier.size(32.dp)
        )

        if (state != EvidenceState.UNKNOWN) {
            Icon(
                imageVector = if (state == EvidenceState.FOUND) Icons.Default.Check else Icons.Default.Close,
                contentDescription = state.name,
                tint = iconTint,
                modifier = Modifier.align(Alignment.TopEnd).size(16.dp)
            )
        }
    }
}

@Composable
fun GhostItem(ghost: Ghost, isPossible: Boolean, onClick: () -> Unit) {
    val alpha = if (isPossible) 1f else 0.3f
    val textDecoration = if (isPossible) TextDecoration.None else TextDecoration.LineThrough

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alpha)
            .height(50.dp)
            .clickable(onClick = onClick),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = if (isPossible) 2.dp else 0.dp
    ) {
        Box(
            modifier = Modifier.padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = ghost.name,
                style = MaterialTheme.typography.bodyLarge,
                textDecoration = textDecoration,
                textAlign = TextAlign.Center
            )
        }
    }
}

fun isGhostPossible(ghost: Ghost, states: Map<Evidence, EvidenceState>): Boolean {
    for ((evidence, state) in states) {
        when (state) {
            EvidenceState.FOUND -> if (!ghost.evidences.contains(evidence)) return false
            EvidenceState.RULED_OUT -> if (ghost.evidences.contains(evidence)) return false
            else -> {}
        }
    }
    return true
}