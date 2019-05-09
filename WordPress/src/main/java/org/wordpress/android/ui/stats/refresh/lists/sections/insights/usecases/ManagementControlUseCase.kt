package org.wordpress.android.ui.stats.refresh.lists.sections.insights.usecases

import kotlinx.coroutines.CoroutineDispatcher
import org.wordpress.android.R
import org.wordpress.android.fluxc.store.StatsStore.ManagementType
import org.wordpress.android.modules.UI_THREAD
import org.wordpress.android.ui.stats.refresh.NavigationTarget.ViewInsightsManagement
import org.wordpress.android.ui.stats.refresh.lists.sections.BaseStatsUseCase.StatelessUseCase
import org.wordpress.android.ui.stats.refresh.lists.sections.BlockListItem
import org.wordpress.android.ui.stats.refresh.lists.sections.BlockListItem.LinkButton
import org.wordpress.android.ui.stats.refresh.lists.sections.BlockListItem.NavigationAction
import javax.inject.Inject
import javax.inject.Named

class ManagementControlUseCase
@Inject constructor(
    @Named(UI_THREAD) private val mainDispatcher: CoroutineDispatcher
) : StatelessUseCase<Boolean>(ManagementType.CONTROL, mainDispatcher) {
    override suspend fun loadCachedData() = true

    override suspend fun fetchRemoteData(forced: Boolean): State<Boolean> = State.Data(true)

    override fun buildLoadingItem(): List<BlockListItem> = buildUiModel(true)

    override fun buildUiModel(domainModel: Boolean): List<BlockListItem> {
        return listOf(LinkButton(R.string.stats_management_edit, NavigationAction.create(this::onClick)))
    }

    private fun onClick() {
        navigateTo(ViewInsightsManagement)
    }
}
