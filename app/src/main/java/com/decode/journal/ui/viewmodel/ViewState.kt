package com.decode.journal.ui.viewmodel

import android.media.MediaDrm.ErrorCodes
import android.view.View

sealed class ViewState<out T: Any> {
    object initial : ViewState<Nothing>()
    object Loading : ViewState<Nothing>()
    object Empty : ViewState<Nothing>()

}