package com.suza.cupcake.data

enum class Flavor { VANILLA, CHOCOLATE, STRAWBERRY }

enum class PickupDate { TODAY, TOMORROW, IN_THREE_DAYS }

data class OrderUiState(
    val quantity: Int = 1,
    val flavor: Flavor = Flavor.VANILLA,
    val pickupDate: PickupDate = PickupDate.TODAY,
    val price: Double = 0.0
)