package app.tomsgenesis.phasmojournal

data class Change(val date: String, val description: String)

val changeLog = listOf(
    Change(
        "2025-12-28",
        "Initial version"
    )
)