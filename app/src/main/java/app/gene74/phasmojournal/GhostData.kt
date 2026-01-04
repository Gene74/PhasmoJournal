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
    EMF5("EMF5"),
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

data class Ghost(
    val name: String,
    val evidences: Set<Evidence>,
    val strengths: String,
    val weaknesses: String,
    val trivia: String)

val ghosts = listOf(
    Ghost(
        name = "Banshee",
        evidences = setOf(Evidence.FINGERPRINTS, Evidence.GHOST_ORB, Evidence.DOTS),
        strengths = "A Banshee will weaken their target before striking.",
        weaknesses = "Banshees can sometimes be heard screaming with a parabolic microphone.",
        trivia = "The singing siren, known for attracting its victims through song. " +
                "It has been known to single out its prey before making a killing blow."
    ),
    Ghost(
        name = "Demon",
        evidences = setOf(Evidence.FINGERPRINTS, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "Demons will initiate hunts more often than other ghosts.",
        weaknesses = "Demons fear the crucifix and will be less aggressive near one.",
        trivia = "Demons are the most aggressive ghosts we've ever encountered. " +
                "Known to attack without reason, they seem to enjoy the thrill of the hunt."
    ),
    Ghost(
        name = "Deogen",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING, Evidence.DOTS),
        strengths = "Deogen constantly sense the living. You can run but you can't hide.",
        weaknesses = "Deogen require a lot of energy to form and will move very slowly when approaching its victim.",
        trivia = "Sometimes surrounded by an endless fog, Deogen have been eluding ghost hunters for years. " +
                "These ghosts have been reported to find even the most hidden prey, before stalking them into exhaustion."
    ),
    Ghost(
        name = "Goryo",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.DOTS),
        strengths = "A Goryo will usually only show itself on camera if there are now people nearby.",
        weaknesses = "They are rarely seen far from their place of death.",
        trivia = "When a Goryo passes through a DOTS projector, using a video camery is the only way to see it."
    ),
    Ghost(
        name = "Hantu",
        evidences = setOf(Evidence.FINGERPRINTS, Evidence.GHOST_ORB, Evidence.FREEZING),
        strengths = "Lower temperatures allow the Hantu to move at faster speeds.",
        weaknesses = "Hantus move slower in warmer areas.",
        trivia = "A Hantu is a rare ghost that thrives in the coldest climates. " +
                "The cold seems to make them more aggressive and empowered."
    ),
    Ghost(
        name = "Jinn",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.FREEZING),
        strengths = "A Jinn will travel at a faster speed if its victim is far away.",
        weaknesses = "Turning off the location's power source will prevent the Jinn from using its ability.",
        trivia = "A Jinn is a territorial ghost that will attack when threatened. " +
                "It has also been known to be able to travel at significant speed."
    ),
    Ghost(
        name = "Mare",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.GHOST_WRITING),
        strengths = "A Mare will have an increased chance to attack in the dark.",
        weaknesses = "Turning the lights on around the Mare will lower its chance to attack.",
        trivia = "A Mare is the source of all nightmares, making it more powerful in the dark."
    ),
    Ghost(
        name = "Moroi",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "The weaker their victims, the stronger the Moroi becomes.",
        weaknesses = "Moroi suffer from hyperosmia, weakening them for longer periods.",
        trivia = "Moroi have risen from the grave to drain energy from the living. " +
                "They have been known to place curses on their victims, curable only by antidotes " +
                "or moving very far away."
    ),
    Ghost(
        name = "Myling",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.GHOST_WRITING),
        strengths = "A Myling is known to be quieter when hunting.",
        weaknesses = "Mylings more frequently make paranormal sounds.",
        trivia = "A Myling is a very vocal and active ghost. " +
                "They are rumoured to be quiet when hunting their prey."
    ),
    Ghost(
        name = "Obake",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.GHOST_ORB),
        strengths = "When interacting with the environment, an Obake will rarely leave a trace.",
        weaknesses = "Sometimes this ghost will shapeshift leaving behind unique evidence.",
        trivia = "Obake are terrifying shape-shifters, capable of taking on many forms. " +
                "They have been seen taking on humanoid shapes to attract their prey."
    ),
    Ghost(
        name = "Oni",
        evidences = setOf(Evidence.EMF5, Evidence.FREEZING, Evidence.DOTS),
        strengths = "Oni are much more active whilst people nearby and will drain their sanity faster when manifesting.",
        weaknesses = "Oni disappear less often while hunting their prey.",
        trivia = "Onis love to scare their victims as much as possible before attacking. " +
                "They are often seen in their physical form, guarding their place of death."
    ),
    Ghost(
        name = "Onryo",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.FREEZING),
        strengths = "Extinguishing a flame can cause the Onryo to attack.",
        weaknesses = "When threatened, this ghost will be less likely to hunt.",
        trivia = "The Onryo is often referred to as \"The Wrathful Spirit\". " +
                "It steals souls from dying victims bodies to seek revenge. " +
                "This ghost has been known to fear any form of fire, and will do anything to be far from it."
    ),
    Ghost(
        name = "Phantom",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.DOTS),
        strengths = "Looking at a Phantom will drop your sanity considerably faster.",
        weaknesses = "Taking a photo of the Phantom will make it temporarily disappear.",
        trivia = "A Phantom is a ghost that can possess the living, inducing fear into those around it. " +
                "They are most commonly summoned Ouija Boards."
    ),
    Ghost(
        name = "Poltergeist",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.GHOST_WRITING),
        strengths = "Poltergeists can throw multiple objects at once, and with great force.",
        weaknesses = "With nothing to throw, Poltergeists become powerless.",
        trivia = "One of the most famous ghosts, the Poltergeist. " +
                "Known to manipulate objects around it to spread fear into it's victims."
    ),
    Ghost(
        name = "Raiju",
        evidences = setOf(Evidence.EMF5, Evidence.GHOST_ORB, Evidence.DOTS),
        strengths = "A Raiju can siphon power from nearby electrical devices, making it move faster.",
        weaknesses = "Raiju are constantly disrupting electronic equipment attacking, making it easier to track.",
        trivia = "A Raiju is a demon that thrives on electrical current. While generally calm, " +
                "they can become agitated when overwhelmed with power."
    ),
    Ghost(
        name = "Revenant",
        evidences = setOf(Evidence.GHOST_ORB, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "A Revenant will travel at a significantly faster speed when hunting their prey.",
        weaknesses = "Hiding from the Revenant will cause it to move very slowly.",
        trivia = "A Revenant is a violent ghost that will attack indiscriminately. Their speed can be deceiving, " +
                "as they are slow while dormant; however as soon as they hunt they can move incredibly fast."
    ),
    Ghost(
        name = "Shade",
        evidences = setOf(Evidence.EMF5, Evidence.GHOST_WRITING, Evidence.FREEZING),
        strengths = "Shades are much harder to find.",
        weaknesses = "The ghost will not enter a hunt if there are people nearby.",
        trivia = "A Shade is known to be very shy. There is evidence to suggest that a Shade will stop " +
                "all paranormal activity if there are people nearby."
    ),
    Ghost(
        name = "Spirit",
        evidences = setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.GHOST_WRITING),
        strengths = "Nothing to report.",
        weaknesses = "A Spirit can be temporarily stopped by burning Incense near them.",
        trivia = "Spirits are very common ghosts. They are very powerful, but passive, only attacking " +
                "when they need to. They defend their place of death to the utmost degree, " +
                "killing anyone that is caught overstaying their welcome."
    ),
    Ghost(
        name = "Thaye",
        evidences = setOf(Evidence.GHOST_ORB, Evidence.GHOST_WRITING, Evidence.DOTS),
        strengths = "Upon entering their location, Thaye will become active, defensive and agile.",
        weaknesses = "Thaye will weaken over time, making them weaker, slower amd less aggressive",
        trivia = "Thaye have been known to rapidly ager over time, even in the afterlife. From what we've " +
                "learned, they seem to deteriorate faster while within the presence of the living."
    ),
    Ghost(
        name = "The Mimic",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.FINGERPRINTS, Evidence.FREEZING),
        strengths = "We're unsure what this ghost is capable of. Be careful.",
        weaknesses = "Several reports have noted ghost orb sightings near Mimics.",
        trivia = "The Mimic is an elusive, mysterious, copycat ghost that mirrors traits and behaviours " +
                "from others, including other ghost types."
    ),
    Ghost(
        name = "The Twins",
        evidences = setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.FREEZING),
        strengths = "Either Twin can be angered and initiate an attack on their prey.",
        weaknesses = "The Twins will often interact with the environment at the same time.",
        trivia = "These ghosts have been reported to mimic each other's actions. They alternate " +
                "their attacks to confuse their prey."
    ),
    Ghost(
        name = "Wraith",
        evidences = setOf(Evidence.EMF5, Evidence.SPIRIT_BOX, Evidence.DOTS),
        strengths = "Wraiths almost never touch the ground, meaning it can't be tracked by footprints.",
        weaknesses = "Wraiths are afraid of salt and will actively avoid it.",
        trivia = "Wraiths are one of the most dangerous ghosts you will find. It is also the only known ghost " +
                "that has the ability of flight and has sometimes been known to travel through walls."
    ),
    Ghost(
        name = "Yokai",
        evidences = setOf(Evidence.SPIRIT_BOX, Evidence.GHOST_ORB, Evidence.DOTS),
        strengths = "Talking near a Yokai will anger it, increasing the chance of an attack.",
        weaknesses = "When hunting, a Yokai can only hear voices close to it.",
        trivia = "Yokai are common ghosts that are attracted to human voices. They can usually found " +
                "haunting family homes."
    ),
    Ghost(
        name = "Yurei",
        evidences = setOf(Evidence.GHOST_ORB, Evidence.FREEZING, Evidence.DOTS),
        strengths = "Yureis have been known to have a stronger effect on people's sanity.",
        weaknesses = "Smudging the Yurei's place of death will trap it temporarily, reducing how much it wanders.",
        trivia = "A Yurei is a ghost that has returned to the physical world, usually for the purpose " +
                "of revenge or hatred."
    ),
    Ghost(
        name = "Dayan",
        evidences = setOf(Evidence.EMF5, Evidence.GHOST_ORB, Evidence.SPIRIT_BOX),
        strengths = "The Dayan gains strength to protect herself if people 'dance' too close to her.",
        weaknesses = "The Dayan loses strength if people close to her stand still.",
        trivia = "The Dayan is born from the soul who suffered immense cruelty in life. Now, in death, " +
                "she is hyper-vigilant of anyone who 'dances' too close."
    ),
    Ghost(
        name = "Gallu",
        evidences = setOf(Evidence.EMF5, Evidence.FINGERPRINTS, Evidence.SPIRIT_BOX),
        strengths = "Using protective equipment pushes the ghost to become enraged, weakening equipment effects.",
        weaknesses = "Being enraged exhausts the Gallu, making protective equipment more effective.",
        trivia = "Another form of demon, the Gallu is a reminder that death comes for us all. Using protective " +
                "equipment provokes the ghost until it's no longer effective."
    ),
    Ghost(
        name = "Obambo",
        evidences = setOf(Evidence.GHOST_WRITING, Evidence.FINGERPRINTS, Evidence.DOTS),
        strengths = "While aggressive, the Obambo is quicker to start hunting.",
        weaknesses = "While calm, the Obambo is slower to start hunting and easier to track.",
        trivia = "The Obambo is the ghost of someone never properly laid to rest. Fickle and defensive, " +
                "it flickers between states of calm and aggression."
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