package io.teamif.rpgstats.tribe

import io.teamif.rpgstats.role.AbstractRole

abstract class AbstractTribe(val tribeType: TribeType, val hostileType: TribeType, val roleType: AbstractRole)