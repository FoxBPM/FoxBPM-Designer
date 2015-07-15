package org.foxbpm.bpmn.designer.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

public class FoxBPMPerspective implements IPerspectiveFactory {
	protected static final String ID_SERVERS_VIEW = "org.eclipse.wst.server.ui.ServersView";
	protected static final String ID_SEARCH_VIEW = "org.eclipse.search.ui.views.SearchView";
	protected static final String ID_HISTORY_VIEW = "org.eclipse.team.ui.GenericHistoryView";
	protected static final String ID_FOXBPM_VIEW = "org.foxbpm.bpmn.designer.ui.foxbpmview";
	@Override
	public void createInitialLayout(IPageLayout layout) {
		// 获取透明视图的编辑空间标示
		String editerArea = layout.getEditorArea();

		// 编辑器左上部视图
		IFolderLayout leftTop = layout.createFolder("leftTop", IPageLayout.LEFT, 0.25f, editerArea); // 相对于‘editerArea’编辑器的位置left
		leftTop.addView(ID_FOXBPM_VIEW);//FOXBPM视图
		leftTop.addView(IPageLayout.ID_PROJECT_EXPLORER); // 工程视图

		// 编辑器左下角视图
		IFolderLayout leftBottom = layout.createFolder("leftBottom", IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_PROJECT_EXPLORER); // 相对于上面‘left’视图的位置在底部
		leftBottom.addView(IPageLayout.ID_OUTLINE); // OUTLINE视图

		// 编辑器底部视图
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.65f, editerArea); // 相对于‘editerArea’编辑器的位置底部
		bottom.addView(IPageLayout.ID_PROP_SHEET); // 属性视图
		bottom.addView(ID_SERVERS_VIEW);// 服务器视图
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW); // 问题视图
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);// 控制台视图
		bottom.addView(ID_SEARCH_VIEW);// 搜索视图
		bottom.addView(ID_HISTORY_VIEW);// 历史视图
	}

}
