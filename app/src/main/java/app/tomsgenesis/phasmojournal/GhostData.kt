package app.tomsgenesis.phasmojournal

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
    Ghost("Spirit", setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING), strengths = "No unique strengths.", weaknesses = "Using a Smudge Stick will prevent a hunt for 180 seconds instead of the standard 90."),
    Ghost("Wraith", setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.DOTS), strengths = "Does not leave UV footprints after stepping in salt.", weaknesses = "Stepping in salt will cause it to become more active."),
    Ghost("Phantom", setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.DOTS), strengths = "Looking at a Phantom will drop the player\'s sanity considerably.", weaknesses = "Taking a picture of the Phantom will make it temporarily disappear."),
    Ghost("Poltergeist", setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.GHOST_WRITING), strengths = "Can throw multiple objects at once.", weaknesses = "Powerless in a room with no objects to throw."),
    Ghost("Banshee", setOf(Evidence.FINGERPRINTS, Evidence.GHOST_ORB, Evidence.DOTS), strengths = "Will focus on one player at a time during a hunt.", weaknesses = "Has a chance for a unique wail sound on the Parabolic Microphone."),
    Ghost("Jinn", setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.FREEZING), strengths = "Moves faster than normal if a player is far away and the fuse box is on.", weaknesses = "Cannot use its ability if the fuse box is off."),
    Ghost("Mare", setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.GHOST_WRITING), strengths = "Has an increased chance to attack in the dark.", weaknesses = "Has a decreased chance to attack when the lights are on."),
    Ghost("Revenant", setOf(Evidence.GHOST_ORB, Evidence.GHOST_WRITING, Evidence.FREEZING), strengths = "Travels at a significantly faster speed when hunting its prey.", weaknesses = "Hiding from the Revenant will cause it to move very slowly."),
    Ghost("Shade", setOf(Evidence.EMF5, Evidence.GHOST_WRITING, Evidence.FREEZING), strengths = "Being shy makes it harder to find and get evidence.", weaknesses = "Will not enter a hunt if there are multiple people nearby."),
    Ghost("Demon", setOf(Evidence.FINGERPRINTS, Evidence.GHOST_WRITING, Evidence.FREEZING), strengths = "Can initiate a hunt more often than other ghosts.", weaknesses = "Smudge Sticks will prevent a hunt for 60 seconds instead of the standard 90."),
    Ghost("Yurei", setOf(Evidence.GHOST_ORB, Evidence.FREEZING, Evidence.DOTS), strengths = "Has a stronger effect on player sanity.", weaknesses = "Using a Smudge Stick in its room will \'trap\' it there for a period of time."),
    Ghost("Oni", setOf(Evidence.EMF5, Evidence.FREEZING, Evidence.DOTS), strengths = "More active with people nearby and can throw objects at great speed.", weaknesses = "Its increased activity makes it easier to find and identify."),
    Ghost("Yokai", setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.DOTS), strengths = "Can hunt at a higher average sanity if players are talking nearby.", weaknesses = "Has a smaller hearing range during a hunt."),
    Ghost("Hantu", setOf(Evidence.FINGERPRINTS, Evidence.GHOST_ORB, Evidence.FREEZING), strengths = "Moves faster in colder rooms.", weaknesses = "Moves slower in warmer rooms."),
    Ghost("Goryo", setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.DOTS), strengths = "Will only show itself on a video camera if no one is in the room.", weaknesses = "Tends to not wander far from its ghost room."),
    Ghost("Myling", setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.GHOST_WRITING), strengths = "Its footsteps are almost silent during a hunt.", weaknesses = "Produces paranormal sounds more frequently on the Parabolic Microphone."),
    Ghost("Onryo", setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.FREEZING), strengths = "Can start a hunt when a flame is extinguished.", weaknesses = "The presence of a flame acts as a crucifix, preventing hunts."),
    Ghost("The Twins", setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.FREEZING), strengths = "Can interact with the environment in two separate places at once.", weaknesses = "The \'decoy\' twin will not trigger motion sensors or smudge sticks."),
    Ghost("Raiju", setOf(Evidence.EMF5, Evidence.GHOST_ORB, Evidence.DOTS), strengths = "Moves faster when near active electronic equipment.", weaknesses = "Its presence disrupts electronics from a greater distance, making it easier to track."),
    Ghost("Obake", setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.GHOST_ORB), strengths = "Can leave a unique six-fingered handprint and may shapeshift during a hunt.", weaknesses = "Sometimes will not leave fingerprints at all."),
    Ghost("The Mimic", setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.FREEZING), strengths = "Can mimic the abilities and traits of any other ghost.", weaknesses = "Will always present Ghost Orbs as a fourth, fake evidence."),
    Ghost("Moroi", setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING, Evidence.FREEZING), strengths = "Curses players, causing rapid sanity drain. Moves faster at low sanity.", weaknesses = "Is blinded by Smudge Sticks for a longer duration."),
    Ghost("Deogen", setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING, Evidence.DOTS), strengths = "Can sense the living, always knowing player locations.", weaknesses = "Moves very slowly when it gets close to a player."),
    Ghost("Thaye", setOf(Evidence.GHOST_ORB, Evidence.GHOST_WRITING, Evidence.DOTS), strengths = "Is extremely active and fast when it first manifests.", weaknesses = "Deteriorates over time, becoming slower and less active.")
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