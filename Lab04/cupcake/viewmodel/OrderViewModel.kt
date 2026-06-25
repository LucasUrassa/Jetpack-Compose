package com.suza.cupcake.viewmodel

import androidx.lifecycle.ViewModel
import com.suza.cupcake.data.Flavor
import com.suza.cupcake.data.OrderUiState
import com.suza.cupcake.data.PickupDate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setQuantity(quantity: Int) {
        _uiState.update { it.copy(quantity = quantity, price = calculatePrice(quantity)) }
    }

    fun setFlavor(flavor: Flavor) {
        _uiState.update { it.copy(flavor = flavor) }
    }

    fun setPickupDate(date: PickupDate) {
        _uiState.update { it.copy(pickupDate = date) }
    }

    private fun calculatePrice(quantity: Int): Double {
        return when (quantity) {
            1 -> 2.0
            6 -> 10.0
            12 -> 18.0
            else -> 0.0
        }
    }
}