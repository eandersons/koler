package com.chooloo.www.koler.interactor.recents

import android.Manifest.permission.WRITE_CALL_LOG
import android.content.Context
import androidx.annotation.RequiresPermission
import com.chooloo.www.koler.contentresolver.RecentsContentResolver
import com.chooloo.www.koler.data.Recent
import com.chooloo.www.koler.interactor.base.BaseInteractorImpl

class RecentsInteractorImpl(
    private val context: Context
) : BaseInteractorImpl<RecentsInteractor.Listener>(), RecentsInteractor {

    override fun getRecent(recentId: Long): Recent? =
        RecentsContentResolver(context, recentId).content.getOrNull(0)

    @RequiresPermission(WRITE_CALL_LOG)
    override fun deleteRecent(recentId: Long) {
        RecentsContentResolver(context, recentId).delete()
    }
}