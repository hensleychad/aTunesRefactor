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
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import net.sourceforge.atunes.gui.models.menu.ApplicationPlayListMenuModel;
import net.sourceforge.atunes.gui.models.menu.ApplicationViewMenuModel;
import net.sourceforge.atunes.gui.views.menu.ApplicationMenuBar;
import net.sourceforge.atunes.kernel.HandlerProxy;
import net.sourceforge.atunes.kernel.Kernel;
import net.sourceforge.atunes.kernel.controllers.model.Controller;
import net.sourceforge.atunes.kernel.handlers.ApplicationDataHandler;


/**
 * @author fleax
 *
 */
public class MenuController extends Controller {

	ApplicationMenuBar menu;
	ApplicationViewMenuModel vmenu;
	ApplicationPlayListMenuModel pmenu;
	
	public MenuController(ApplicationMenuBar menu) {
		super();
		this.menu = menu;
		this.vmenu = menu.getAppViewMenu();
		this.pmenu = menu.getAppPlayListMenu();
		addBindings();
		addStateBindings();
	}
	
	protected void addBindings() {
		// Keys
		menu.getRefreshRepository().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		vmenu.getTagView().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		vmenu.getFolderView().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		vmenu.getFavoriteView().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		vmenu.getDeviceView().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		
		menu.getVolumeDown().setAccelerator(KeyStroke.getKeyStroke('-'));
		menu.getVolumeUp().setAccelerator(KeyStroke.getKeyStroke('+'));
		menu.getMute().setAccelerator(KeyStroke.getKeyStroke('m'));
		pmenu.getPlayListDelete().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		pmenu.getPlayListPlay().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		pmenu.getPlayListEditTag().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0));
		pmenu.getPlayListInfo().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		pmenu.getPlayListSave().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		pmenu.getPlayListLoad().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		pmenu.getPlayListClear().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		pmenu.getPlayListTop().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		pmenu.getPlayListDown().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, ActionEvent.CTRL_MASK));
		pmenu.getPlayListUp().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, ActionEvent.CTRL_MASK));
		pmenu.getPlayListBottom().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		pmenu.getPlayListFavoriteSong().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		pmenu.getPlayListFavoriteAlbum().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		pmenu.getPlayListFavoriteArtist().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		// End Keys
		
		// Listener
		AppMenuListener listener = new AppMenuListener(menu,vmenu,pmenu);
		menu.getSelectRepository().addActionListener(listener);
		menu.getRefreshRepository().addActionListener(listener);
		menu.getRecentRepositories().addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent arg0) {
				menu.getRecentRepositories().removeAll();
				ArrayList<String> reps = ApplicationDataHandler.getSavedRepositoriesList();
				if (reps == null)
					return;
				for (final String s: reps) {
					JMenuItem item = new JMenuItem(s);
					item.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							HandlerProxy.getRepositoryHandler().changeToRepository(s);
						}
					});
					menu.getRecentRepositories().add(item);
				}
			}
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
		});
		menu.getExit().addActionListener(listener);
		menu.getEditPreferences().addActionListener(listener);
		vmenu.getTagView().addActionListener(listener);
		vmenu.getFolderView().addActionListener(listener);
		vmenu.getFavoriteView().addActionListener(listener);
		vmenu.getDeviceView().addActionListener(listener);
		vmenu.getShowStatusBar().addActionListener(listener);
		vmenu.getShowNavigationPanel().addActionListener(listener);
		vmenu.getShowNavigationTable().addActionListener(listener);
		vmenu.getShowProperties().addActionListener(listener);
		vmenu.getShowOSD().addActionListener(listener);
		menu.getVolumeDown().addActionListener(listener);
		menu.getVolumeUp().addActionListener(listener);
		menu.getMute().addActionListener(listener);
		pmenu.getPlayListPlay().addActionListener(listener);
		pmenu.getPlayListEditTag().addActionListener(listener);
		pmenu.getPlayListAutoSetTrack().addActionListener(listener);
		pmenu.getPlayListAutoSetGenre().addActionListener(listener);
		pmenu.getPlayListSave().addActionListener(listener);
		pmenu.getPlayListLoad().addActionListener(listener);
		pmenu.getPlayListFilter().addActionListener(listener);
		pmenu.getPlayListInfo().addActionListener(listener);
		pmenu.getPlayListDelete().addActionListener(listener);
		pmenu.getPlayListClear().addActionListener(listener);
		pmenu.getPlayListTop().addActionListener(listener);
		pmenu.getPlayListUp().addActionListener(listener);
		pmenu.getPlayListDown().addActionListener(listener);
		pmenu.getPlayListBottom().addActionListener(listener);
		pmenu.getPlayListFavoriteSong().addActionListener(listener);
		pmenu.getPlayListFavoriteAlbum().addActionListener(listener);
		pmenu.getPlayListFavoriteArtist().addActionListener(listener);
		pmenu.getPlayListArtist().addActionListener(listener);
		pmenu.getPlayListAlbum().addActionListener(listener);
		pmenu.getPlayListShowButtons().addActionListener(listener);
		menu.getDeviceConnect().addActionListener(listener);
		menu.getDeviceRefresh().addActionListener(listener);
		menu.getDeviceDisconnect().addActionListener(listener);
		menu.getDeviceViewByTag().addActionListener(listener);
		menu.getDeviceViewByFolder().addActionListener(listener);
		menu.getToolsExport().addActionListener(listener);
		menu.getRipCd().addActionListener(listener);
		menu.getStats().addActionListener(listener);
		menu.getCheckUpdates().addActionListener(listener);
		menu.getAboutItem().addActionListener(listener);
	}
	
	public void disablePlayListItems(boolean disable) {
		pmenu.getPlayListPlay().setEnabled(!disable);
		pmenu.getPlayListInfo().setEnabled(!disable);
		pmenu.getPlayListDelete().setEnabled(!disable);
		pmenu.getPlayListClear().setEnabled(true);
		pmenu.getPlayListTop().setEnabled(!disable);
		pmenu.getPlayListUp().setEnabled(!disable);
		pmenu.getPlayListDown().setEnabled(!disable);
		pmenu.getPlayListBottom().setEnabled(!disable);
		pmenu.getPlayListFavoriteSong().setEnabled(!disable);
		pmenu.getPlayListFavoriteAlbum().setEnabled(!disable);
		pmenu.getPlayListFavoriteArtist().setEnabled(!disable);
		pmenu.getPlayListArtist().setEnabled(!disable);
		pmenu.getPlayListAlbum().setEnabled(!disable);
	}
	
	protected void addStateBindings() {
		disablePlayListItems(true);
		vmenu.getShowOSD().setSelected(Kernel.getInstance().state.isShowOSD());
		setDeviceConnected(false);
	}
	
	public void setShowSongProperties(boolean show) {
		vmenu.getShowProperties().setSelected(show);
	}
	
	public void setShowStatusBar(boolean show) {
		vmenu.getShowStatusBar().setSelected(show);
	}
	
	public void setShowNavigationTable(boolean show) {
		vmenu.getShowNavigationTable().setSelected(show);
	}
	
	public void setShowNavigationPanel(boolean show) {
		vmenu.getShowNavigationPanel().setSelected(show);
	}
	
	protected void notifyReload() {}

	public void enableSavePlaylist(boolean enable) {
		pmenu.getPlayListSave().setEnabled(enable);
	}
	
	public void setSortDeviceByTag(boolean enable) {
		menu.getDeviceViewByTag().setSelected(enable);
		menu.getDeviceViewByFolder().setSelected(!enable);
	}
	
	public void setDeviceConnected(boolean enable) {
		menu.getDeviceConnect().setEnabled(!enable);
		menu.getDeviceRefresh().setEnabled(enable);
		menu.getDeviceDisconnect().setEnabled(enable);
	}
	
	public void setShowOSD(boolean enable) {
		vmenu.getShowOSD().setSelected(enable);
	}
	
	public void setShowPlaylistControls(boolean enable) {
		pmenu.getPlayListShowButtons().setSelected(enable);
	}
	
	public void setRipCDEnabled(boolean enable) {
		menu.getRipCd().setEnabled(enable);
	}
}
