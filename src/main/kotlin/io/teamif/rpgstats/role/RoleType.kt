package io.teamif.rpgstats.role

enum class RoleType(val roleName: String, val roleClass: Class<out AbstractRole>) {
    Warrior("전사", WarriorRole::class.java),
    Rogue("도적", RogueRole::class.java),
    Wizard("마법사", WizardRole::class.java);
}