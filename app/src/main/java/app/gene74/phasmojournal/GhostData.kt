package app.gene74.phasmojournal

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.LensBlur
import androidx.compose.material.icons.filled.Radio
import androidx.compose.material.icons.filled.Speed
import androidx.compose.ui.graphics.vector.ImageVector

enum class Evidence(val displayName: String) {
    EMF5("EMF 5"),
    SPIRIT_BOX("Spirit Box"),
    FINGERPRINTS("Fingerprints"),
    GHOST_ORB("Ghost Orb"),
    GHOST_WRITING("Ghost Writing"),
    FREEZING("Freezing"),
    DOTS("D.O.T.S")
}

enum class EvidenceState {
    UNKNOWN,
    FOUND,
    RULED_OUT
}

data class Ghost(val name: String, val evidences: Set<Evidence>, val strengths: String, val weaknesses: String)

val ghosts = listOf(
    Ghost(
        name = "Banshee",
        evidences = setOf(Evidence.FINGERPRINTS, Evidence.GHOST_ORB, Evidence.DOTS),
        strengths = "Will focus on one player at a time during a hunt.",
        weaknesses = "Has a chance for a unique wail sound on the Parabolic Microphone."
    ),
    Ghost(
        name = "Demon",
        evidences = setOf(Evidence.FINGERPRINTS, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "Can initiate a hunt more often than other ghosts.",
        weaknesses = "Smudge Sticks will prevent a hunt for 60 seconds instead of the standard 90."
    ),
    Ghost(
        name = "Deogen",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING, Evidence.DOTS),
        strengths = "Can sense the living, always knowing player locations.",
        weaknesses = "Moves very slowly when it gets close to a player."
    ),
    Ghost(
        name = "Goryo",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.DOTS),
        strengths = "Will only show itself on a video camera if no one is in the room.",
        weaknesses = "Tends to not wander far from its ghost room."
    ),
    Ghost(
        name = "Hantu",
        evidences = setOf(Evidence.FINGERPRINTS, Evidence.GHOST_ORB, Evidence.FREEZING),
        strengths = "Moves faster in colder rooms.",
        weaknesses = "Moves slower in warmer rooms."
    ),
    Ghost(
        name = "Jinn",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.FREEZING),
        strengths = "Moves faster than normal if a player is far away and the fuse box is on.",
        weaknesses = "Cannot use its ability if the fuse box is off."
    ),
    Ghost(
        name = "Mare",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.GHOST_WRITING),
        strengths = "Has an increased chance to attack in the dark.",
        weaknesses = "Has a decreased chance to attack when the lights are on."
    ),
    Ghost(
        name = "Moroi",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "Curses players, causing rapid sanity drain. Moves faster at low sanity.",
        weaknesses = "Is blinded by Smudge Sticks for a longer duration."
    ),
    Ghost(
        name = "Myling",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.GHOST_WRITING),
        strengths = "Its footsteps are almost silent during a hunt.",
        weaknesses = "Produces paranormal sounds more frequently on the Parabolic Microphone."
    ),
    Ghost(
        name = "Obake",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.GHOST_ORB),
        strengths = "Can leave a unique six-fingered handprint and may shapeshift during a hunt.",
        weaknesses = "Sometimes will not leave fingerprints at all."
    ),
    Ghost(
        name = "Oni",
        evidences = setOf(Evidence.EMF5, Evidence.FREEZING, Evidence.DOTS),
        strengths = "More active with people nearby and can throw objects at great speed.",
        weaknesses = "Its increased activity makes it easier to find and identify."
    ),
    Ghost(
        name = "Onryo",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.FREEZING),
        strengths = "Can start a hunt when a flame is extinguished.",
        weaknesses = "The presence of a flame acts as a crucifix, preventing hunts."
    ),
    Ghost(
        name = "Phantom",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.DOTS),
        strengths = "Looking at a Phantom will drop the player's sanity considerably.",
        weaknesses = "Taking a picture of the Phantom will make it temporarily disappear."
    ),
    Ghost(
        name = "Poltergeist",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.GHOST_WRITING),
        strengths = "Can throw multiple objects at once.",
        weaknesses = "Powerless in a room with no objects to throw."
    ),
    Ghost(
        name = "Raiju",
        evidences = setOf(Evidence.EMF5, Evidence.GHOST_ORB, Evidence.DOTS),
        strengths = "Moves faster when near active electronic equipment.",
        weaknesses = "Its presence disrupts electronics from a greater distance, making it easier to track."
    ),
    Ghost(
        name = "Revenant",
        evidences = setOf(Evidence.GHOST_ORB, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "Travels at a significantly faster speed when hunting its prey.",
        weaknesses = "Hiding from the Revenant will cause it to move very slowly."
    ),
    Ghost(
        name = "Shade",
        evidences = setOf(Evidence.EMF5, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "Being shy makes it harder to find and get evidence.",
        weaknesses = "Will not enter a hunt if there are multiple people nearby."
    ),
    Ghost(
        name = "Spirit",
        evidences = setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING),
        strengths = "No unique strengths.",
        weaknesses = "Using a Smudge Stick will prevent a hunt for 180 seconds instead of the standard 90."
    ),
    Ghost(
        name = "Thaye",
        evidences = setOf(Evidence.GHOST_ORB, Evidence.GHOST_WRITING, Evidence.DOTS),
        strengths = "Is extremely active and fast when it first manifests.",
        weaknesses = "Deteriorates over time, becoming slower and less active."
    ),
    Ghost(
        name = "The Mimic",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.FREEZING),
        strengths = "Can mimic the abilities and traits of any other ghost.",
        weaknesses = "Will always present Ghost Orbs as a fourth, fake evidence."
    ),
    Ghost(
        name = "The Twins",
        evidences = setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.FREEZING),
        strengths = "Can interact with the environment in two separate places at once.",
        weaknesses = "The 'decoy' twin will not trigger motion sensors or smudge sticks."
    ),
    Ghost(
        name = "Wraith",
        evidences = setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.DOTS),
        strengths = "Does not leave UV footprints after stepping in salt.",
        weaknesses = "Stepping in salt will cause it to become more active."
    ),
    Ghost(
        name = "Yokai",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.DOTS),
        strengths = "Can hunt at a higher average sanity if players are talking nearby.",
        weaknesses = "Has a smaller hearing range during a hunt."
    ),
    Ghost(
        name = "Yurei",
        evidences = setOf(Evidence.GHOST_ORB, Evidence.FREEZING, Evidence.DOTS),
        strengths = "Has a stronger effect on player sanity.",
        weaknesses = "Using a Smudge Stick in its room will 'trap' it there for a period of time."
    ),
    Ghost(
        name = "Dayan",
        evidences = setOf(Evidence.EMF5, Evidence.GHOST_ORB, Evidence.SPIRIT_BOX),
        strengths = "The Dayan gains strength to protect herself if people 'dance' too close to her.",
        weaknesses = "The Dayan loses strength if people close to her stand still."
    ),
    Ghost(
        name = "Gallu",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.SPIRIT_BOX),
        strengths = "Using protective equipment pushes the ghost to become enraged, weakening equipment effects.",
        weaknesses = "Being enraged exhausts the Gallu, making protective equipment more effective."
    ),
    Ghost(
        name = "Obambo",
        evidences = setOf(Evidence.GHOST_WRITING, Evidence.FINGERPRINTS, Evidence.DOTS),
        strengths = "While aggressive, the Obambo is quicker to start hunting.",
        weaknesses = "While calm, the Obambo is slower to start hunting and easier to track."
    )
).sortedBy { it.name }

fun getEvidenceIcon(evidence: Evidence): ImageVector {
    return when (evidence) {
        Evidence.EMF5 -> Icons.Default.Speed
        Evidence.SPIRIT_BOX -> Icons.Default.Radio
        Evidence.FINGERPRINTS -> Icons.Default.Fingerprint
        Evidence.GHOST_ORB -> Icons.Default.Circle
        Evidence.GHOST_WRITING -> Icons.Default.AutoStories
        Evidence.FREEZING -> Icons.Default.AcUnit
        Evidence.DOTS -> Icons.Default.LensBlur
    }
}