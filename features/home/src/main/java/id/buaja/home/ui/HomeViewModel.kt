package id.buaja.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.buaja.abstraction.BuildConfig
import id.buaja.abstraction.until.state.ResultState
import id.buaja.data.entity.RecordsItem
import id.buaja.data.entity.SheetsGoldResponse
import id.buaja.domain.home.HomeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val useCase: HomeUseCase) : ViewModel() {
    private val _sheetGold = MutableLiveData<List<RecordsItem>>()
    val sheetGold: LiveData<List<RecordsItem>> get() = _sheetGold

    private val _state = MutableLiveData<Boolean>()
    val state: LiveData<Boolean> get() = _state

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _totalWeight = MutableLiveData<Int>()
    val totalWeight: LiveData<Int> get() = _totalWeight

    private val _totalPrice = MutableLiveData<Int>()
    val totalPrice: LiveData<Int> get() = _totalPrice

    fun getSheetsGold() {
        _state.value = true
        viewModelScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {
                useCase.getSheetGold(BuildConfig.ID_SHEETS, "readAll")
            }

            when(response) {
                is ResultState.Success -> {
                    val goldResponse = response.data as SheetsGoldResponse
                    var totalWeight = 0
                    var totalPrice = 0

                    goldResponse.records?.let {
                        for (i in it.indices) {
                            totalWeight += it[i].berat ?: 0
                            totalPrice += it[i].totalHarga ?: 0
                        }
                    }

                    _totalWeight.postValue(totalWeight)
                    _totalPrice.postValue(totalPrice)
                    _sheetGold.postValue(goldResponse.records)
                }

                is ResultState.Message -> {
                    _message.postValue(response.message)
                }

                is ResultState.Error -> {
                    _error.postValue(response.error)
                }
            }
            _state.value = false
        }
    }
}