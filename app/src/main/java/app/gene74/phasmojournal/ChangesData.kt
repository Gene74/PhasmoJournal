package app.gene74.phasmojournal

data class Change(val date: String, val description: String)

val changeLog = listOf(
    Change(
        "2026-01-04",
        "Version 1.0.0 - Initial release"
    ),
)