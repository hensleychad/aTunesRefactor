/**
 * aTunes 1.6.0
 * Copyright (C) 2006-2007 Alex Aranda (fleax) alex.aranda@gmail.com
 *
 * http://www.atunes.org
 * http://sourceforge.net/projects/atunes
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package net.sourceforge.atunes.kernel.controllers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.atunes.gui.models.menu.ApplicationPlayListMenuModel;
import net.sourceforge.atunes.gui.models.menu.ApplicationViewMenuModel;
import net.sourceforge.atunes.gui.views.menu.ApplicationMenuBar;
import net.sourceforge.atunes.kernel.HandlerProxy;
import net.sourceforge.atunes.kernel.Kernel;
import net.sourceforge.atunes.kernel.controllers.navigation.NavigationControllerViews;
import net.sourceforge.atunes.kernel.modules.updates.ApplicationUpdates;


public class AppMenuListener implements ActionListener {

	private ApplicationMenuBar menu;
	private ApplicationViewMenuModel vmenu;
	private ApplicationPlayListMenuModel pmenu;
	
	protected AppMenuListener(ApplicationMenuBar menu, ApplicationViewMenuModel vmenu, ApplicationPlayListMenuModel pmenu) {
		this.vmenu = vmenu;
		this.pmenu = pmenu;
		this.menu = menu;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(menu.getSelectRepository()))
			HandlerProxy.getRepositoryHandler().selectRepository();
		else if (e.getSource().equals(menu.getRefreshRepository()))
			HandlerProxy.getRepositoryHandler().refreshRepository();
		else if (e.getSource().equals(menu.getExit())) {
			HandlerProxy.getVisualHandler().setFullFrameVisible(false);
			Kernel.getInstance().finish();
		}
		else if (e.getSource().equals(menu.getEditPreferences()))
			HandlerProxy.getControllerHandler().getEditPreferencesDialogController().start();
		else if (e.getSource().equals(vmenu.getTagView())) 
			HandlerProxy.getControllerHandler().getNavigationController().setNavigationView(NavigationControllerViews.TAG_VIEW);
		else if (e.getSource().equals(vmenu.getFolderView()))
			HandlerProxy.getControllerHandler().getNavigationController().setNavigationView(NavigationControllerViews.FILE_VIEW);
		else if (e.getSource().equals(vmenu.getFavoriteView()))
			HandlerProxy.getControllerHandler().getNavigationController().setNavigationView(NavigationControllerViews.FAVORITE_VIEW);
		else if (e.getSource().equals(vmenu.getDeviceView()))
			HandlerProxy.getControllerHandler().getNavigationController().setNavigationView(NavigationControllerViews.DEVICE_VIEW);
		else if (e.getSource().equals(vmenu.getShowStatusBar()))
			HandlerProxy.getVisualHandler().showStatusBar(vmenu.getShowStatusBar().isSelected());
		else if (e.getSource().equals(vmenu.getShowNavigationPanel()))
			HandlerProxy.getVisualHandler().showNavigationPanel(vmenu.getShowNavigationPanel().isSelected(), true);
		else if (e.getSource().equals(vmenu.getShowNavigationTable()))
			HandlerProxy.getVisualHandler().showNavigationTable(vmenu.getShowNavigationTable().isSelected());
		else if (e.getSource().equals(vmenu.getShowProperties()))
			HandlerProxy.getVisualHandler().showSongProperties(vmenu.getShowProperties().isSelected(), true);
		else if (e.getSource().equals(vmenu.getShowOSD())) {
			Kernel.getInstance().state.setShowOSD(vmenu.getShowOSD().isSelected());
			HandlerProxy.getSystemTrayHandler().setShowOSD(vmenu.getShowOSD().isSelected());
		}
		else if (e.getSource().equals(menu.getVolumeDown()))
			HandlerProxy.getPlayerHandler().volumeDown();
		else if (e.getSource().equals(menu.getVolumeUp()))
			HandlerProxy.getPlayerHandler().volumeUp();
		else if (e.getSource().equals(menu.getMute()))
			HandlerProxy.getControllerHandler().getPlayerControlsController().setMute(!HandlerProxy.getPlayerHandler().isMute());
		else if (e.getSource().equals(pmenu.getPlayListPlay()))
			HandlerProxy.getControllerHandler().getPlayListController().playSelectedSong();
		else if (e.getSource().equals(pmenu.getPlayListEditTag()))
			HandlerProxy.getPlayListHandler().editTags();
		else if (e.getSource().equals(pmenu.getPlayListAutoSetTrack()))
			HandlerProxy.getControllerHandler().getPlayListController().setTrackNumber();
		else if (e.getSource().equals(pmenu.getPlayListAutoSetGenre()))
			HandlerProxy.getControllerHandler().getPlayListController().setGenre();
		else if (e.getSource().equals(pmenu.getPlayListSave()))
			HandlerProxy.getPlayListHandler().savePlaylist();
		else if (e.getSource().equals(pmenu.getPlayListLoad()))
			HandlerProxy.getPlayListHandler().loadPlaylist();
		else if (e.getSource().equals(pmenu.getPlayListFilter()))
			HandlerProxy.getVisualHandler().showFilter(true);
		else if (e.getSource().equals(pmenu.getPlayListInfo()))
			HandlerProxy.getVisualHandler().showInfo();
		else if (e.getSource().equals(pmenu.getPlayListDelete()))
			HandlerProxy.getControllerHandler().getPlayListController().deleteSelection();
		else if (e.getSource().equals(pmenu.getPlayListClear()))
			HandlerProxy.getPlayListHandler().clearList();
		else if (e.getSource().equals(pmenu.getPlayListTop()))
			HandlerProxy.getControllerHandler().getPlayListController().moveToTop();
		else if (e.getSource().equals(pmenu.getPlayListUp()))
			HandlerProxy.getControllerHandler().getPlayListController().moveUp();
		else if (e.getSource().equals(pmenu.getPlayListDown()))
			HandlerProxy.getControllerHandler().getPlayListController().moveDown();
		else if (e.getSource().equals(pmenu.getPlayListBottom()))
			HandlerProxy.getControllerHandler().getPlayListController().moveToBottom();
		else if (e.getSource().equals(pmenu.getPlayListFavoriteSong()))
			HandlerProxy.getControllerHandler().getPlayListController().setAsFavoriteSongs(HandlerProxy.getControllerHandler().getPlayListController().getSelectedSongs());
		else if (e.getSource().equals(pmenu.getPlayListFavoriteAlbum()))
			HandlerProxy.getControllerHandler().getPlayListController().setAsFavoriteAlbums(HandlerProxy.getControllerHandler().getPlayListController().getSelectedSongs());
		else if (e.getSource().equals(pmenu.getPlayListFavoriteArtist()))
			HandlerProxy.getControllerHandler().getPlayListController().setAsFavoriteArtists(HandlerProxy.getControllerHandler().getPlayListController().getSelectedSongs());
		else if (e.getSource().equals(pmenu.getPlayListArtist()))
			HandlerProxy.getControllerHandler().getPlayListController().setArtistAsPlaylist();
		else if (e.getSource().equals(pmenu.getPlayListAlbum()))
			HandlerProxy.getControllerHandler().getPlayListController().setAlbumAsPlaylist();
		else if (e.getSource().equals( pmenu.getPlayListShowButtons()))
			HandlerProxy.getControllerHandler().getPlayListController().showPlaylistControls(pmenu.getPlayListShowButtons().isSelected());
		else if (e.getSource().equals(menu.getDeviceConnect()))
			HandlerProxy.getRepositoryHandler().connectDevice();
		else if (e.getSource().equals(menu.getDeviceRefresh()))
			HandlerProxy.getRepositoryHandler().refreshDevice();
		else if (e.getSource().equals(menu.getDeviceDisconnect()))
			HandlerProxy.getRepositoryHandler().disconnectDevice();
		else if (e.getSource().equals(menu.getDeviceViewByTag())) {
			Kernel.getInstance().state.setSortDeviceByTag(true);
			HandlerProxy.getControllerHandler().getNavigationController().refreshDeviceTreeContent();
		}
		else if (e.getSource().equals(menu.getDeviceViewByFolder())) {
			Kernel.getInstance().state.setSortDeviceByTag(false);
			HandlerProxy.getControllerHandler().getNavigationController().refreshDeviceTreeContent();
		}
		else if (e.getSource().equals(menu.getToolsExport()))
			HandlerProxy.getControllerHandler().getExportOptionsController().beginExportProcess();
		else if (e.getSource().equals(menu.getRipCd()))
			HandlerProxy.getRipperHandler().startCdRipper();
		else if (e.getSource().equals(menu.getStats()))
			HandlerProxy.getControllerHandler().getStatsDialogController().showStats();
		else if (e.getSource().equals(menu.getCheckUpdates()))
			ApplicationUpdates.checkUpdates(Kernel.getInstance().state.getProxy());
		else if (e.getSource().equals(menu.getAboutItem()))
			HandlerProxy.getVisualHandler().showAboutDialog();
	}
}
