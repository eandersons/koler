package com.chooloo.www.kontacts.ui.main

import androidx.lifecycle.MutableLiveData
import com.chooloo.www.chooloolib.interactor.navigation.NavigationsInteractor
import com.chooloo.www.chooloolib.model.ContactAccount
import com.chooloo.www.chooloolib.ui.base.BaseViewState
import com.chooloo.www.chooloolib.util.LiveEvent
import com.chooloo.www.kontacts.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewState @Inject constructor(
    private val navigations: NavigationsInteractor
) : BaseViewState() {
    
    val filter = MutableLiveData<String?>()
    val searchText = MutableLiveData<String?>()
    val isSearching = MutableLiveData(false)
    val searchHintRes = MutableLiveData(R.string.hint_search_contacts)

    val showMenuEvent = LiveEvent()


    fun onSettingsClick() {
        showMenuEvent.call()
    }

    fun onAddContactClick() {
        navigations.addContact("")
    }

    fun onSearchTextChange(text: String) {
        filter.value = text
    }

    fun onSearchFocusChange(isFocus: Boolean) {
        if (isFocus) {
            isSearching.value = true
        }
    }

    fun onContactClick(contact: ContactAccount) {
    }
}