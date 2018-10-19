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

package net.sourceforge.atunes.gui.views.menu;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

import net.sourceforge.atunes.gui.images.ImageLoader;
import net.sourceforge.atunes.gui.models.menu.ApplicationPlayListMenuModel;
import net.sourceforge.atunes.gui.models.menu.ApplicationViewMenuModel;
import net.sourceforge.atunes.utils.language.LanguageTool;



public class ApplicationMenuBar extends JMenuBar {

	private static final long serialVersionUID = 234977404080329591L;

	private JMenu file;
	private JMenu edit;
	private JMenu view;
	private JMenu player;
	private JMenu playList;
	private JMenu tools;
	private JMenu device;
	private JMenu about;
	
	
	// File Menu
	private JMenuItem selectRepository;
	private JMenuItem refreshRepository;
	private JMenu recentRepositories;
	private JMenuItem exit;
	
	// Edit Menu
	private JMenuItem editPreferences;
	
	
	// View Menu
	private ApplicationViewMenuModel appViewMenu;
	
	// PlayList Menu
	private ApplicationPlayListMenuModel appPlayListMenu;

	
	// Player Menu
	private JMenuItem volumeDown;
	private JMenuItem volumeUp;
	private JMenuItem mute;
	
	
	
	// Tools Menu
	private JMenuItem toolsExport;
	private JMenuItem ripCd;
	private JMenuItem stats;
	
	// Device Menu
	private JMenuItem deviceConnect;
	private JMenuItem deviceRefresh;
	private JMenuItem deviceDisconnect;
	private JRadioButtonMenuItem deviceViewByTag;
	private JRadioButtonMenuItem deviceViewByFolder;
	
	// About Menu
	private JMenuItem checkUpdates;
	private JMenuItem aboutItem;
	
	public ApplicationMenuBar() {
		super();
		addMenus();
	}
	
	private void addMenus() {
		file = new JMenu(LanguageTool.getString("FILE"));
		 appViewMenu = new ApplicationViewMenuModel();
		 appPlayListMenu = new ApplicationPlayListMenuModel();

		selectRepository = new JMenuItem(LanguageTool.getString("SELECT_REPOSITORY"), ImageLoader.FOLDER);
		file.add(selectRepository);
		refreshRepository = new JMenuItem(LanguageTool.getString("REFRESH_REPOSITORY"), ImageLoader.REFRESH);
		file.add(refreshRepository);
		file.add(new JSeparator());
		recentRepositories = new JMenu(LanguageTool.getString("RECENT_REPOSITORIES"));
		file.add(recentRepositories);
		file.add(new JSeparator());
		exit = new JMenuItem(LanguageTool.getString("EXIT"), ImageLoader.EXIT);
		file.add(exit);
		
		edit = new JMenu(LanguageTool.getString("EDIT"));
		editPreferences = new JMenuItem(LanguageTool.getString("PREFERENCES") + "...", ImageLoader.PREFS);
		edit.add(editPreferences);
		
		view = new JMenu(LanguageTool.getString("VIEW"));

		
		
		appViewMenu.setTagView(new JMenuItem(LanguageTool.getString("TAGS"), ImageLoader.INFO));
		appViewMenu.setFolderView (new JMenuItem(LanguageTool.getString("FOLDERS"), ImageLoader.FOLDER));
		appViewMenu.setFavoriteView  (new JMenuItem(LanguageTool.getString("FAVORITES"), ImageLoader.FAVORITE));
		appViewMenu.setDeviceView (new JMenuItem(LanguageTool.getString("DEVICE"), ImageLoader.DEVICE));
		appViewMenu.setShowStatusBar  (new JCheckBoxMenuItem(LanguageTool.getString("SHOW_STATUS_BAR"), null));
		appViewMenu.setShowNavigationPanel  (new JCheckBoxMenuItem(LanguageTool.getString("SHOW_NAVIGATION_PANEL"), null));
		appViewMenu.setShowNavigationTable  (new JCheckBoxMenuItem(LanguageTool.getString("SHOW_NAVIGATION_TABLE"), null));
		appViewMenu.setShowProperties(new JCheckBoxMenuItem(LanguageTool.getString("SHOW_SONG_PROPERTIES"), null));
		appViewMenu.setShowOSD  (new JCheckBoxMenuItem(LanguageTool.getString("SHOW_OSD"), null));
		
		

		view.add(appViewMenu.getTagView());
		view.add(appViewMenu.getFolderView());
		view.add(appViewMenu.getFavoriteView());
		view.add(appViewMenu.getDeviceView());
		view.add(new JSeparator());
		view.add(appViewMenu.getShowStatusBar());
		view.add(appViewMenu.getShowNavigationPanel());
		view.add(appViewMenu.getShowNavigationTable());
		view.add(appViewMenu.getShowProperties());
		view.add(appViewMenu.getShowOSD());
		
		player = new JMenu(LanguageTool.getString("PLAYER"));
		volumeDown = new JMenuItem(LanguageTool.getString("VOLUME_DOWN"));
		volumeUp = new JMenuItem(LanguageTool.getString("VOLUME_UP"));
		mute = new JMenuItem(LanguageTool.getString("MUTE"));
		player.add(volumeDown);
		player.add(volumeUp);
		player.add(mute);
		
		playList = new JMenu(LanguageTool.getString("PLAYLIST"));
		
		appPlayListMenu.setPlayListPlay ( new JMenuItem(LanguageTool.getString("PLAY"), ImageLoader.PLAY_MENU));
		appPlayListMenu.setPlayListTags ( new JMenu(LanguageTool.getString("TAGS")));
		appPlayListMenu.setPlayListEditTag ( new JMenuItem(LanguageTool.getString("EDIT_TAG")));
		appPlayListMenu.setPlayListAutoSetTrack ( new JMenuItem(LanguageTool.getString("AUTO_SET_TRACK_NUMBER")));
		appPlayListMenu.setPlayListAutoSetGenre ( new JMenuItem(LanguageTool.getString("AUTO_SET_GENRE")));
	//	appPlayListMenu.getPlayListTags().add(playLIstEditTag);
	//	appPlayListMenu.getPlayListTags().add(playListAutoSetTrack);
	//	appPlayListMenu.getPlayListTags().add(playListAutoSetGenre);

		
		appPlayListMenu.setPlayListSave ( new JMenuItem(LanguageTool.getString("SAVE") + "...", ImageLoader.SAVE));
		appPlayListMenu.setPlayListLoad ( new JMenuItem(LanguageTool.getString("LOAD") + "...", ImageLoader.FOLDER));
		appPlayListMenu.setPlayListFilter ( new JMenuItem(LanguageTool.getString("FILTER")));
		appPlayListMenu.setPlayListInfo ( new JMenuItem(LanguageTool.getString("INFO"), ImageLoader.INFO));
		appPlayListMenu.setPlayListDelete ( new JMenuItem(LanguageTool.getString("REMOVE"), ImageLoader.REMOVE));
		appPlayListMenu.setPlayListClear ( new JMenuItem(LanguageTool.getString("CLEAR"), ImageLoader.CLEAR));
		appPlayListMenu.setPlayListTop ( new JMenuItem(LanguageTool.getString("MOVE_TO_TOP"), ImageLoader.GO_TOP));
		appPlayListMenu.setPlayListUp ( new JMenuItem(LanguageTool.getString("MOVE_UP"), ImageLoader.GO_UP));
		appPlayListMenu.setPlayListDown ( new JMenuItem(LanguageTool.getString("MOVE_DOWN"), ImageLoader.GO_DOWN));
		appPlayListMenu.setPlayListBottom ( new JMenuItem(LanguageTool.getString("MOVE_TO_BOTTOM"), ImageLoader.GO_BOTTOM));
		appPlayListMenu.setPlayListFavoriteSong ( new JMenuItem(LanguageTool.getString("SET_FAVORITE_SONG"), ImageLoader.FAVORITE));
		appPlayListMenu.setPlayListFavoriteAlbum ( new JMenuItem(LanguageTool.getString("SET_FAVORITE_ALBUM"), ImageLoader.FAVORITE));
		appPlayListMenu.setPlayListFavoriteArtist ( new JMenuItem(LanguageTool.getString("SET_FAVORITE_ARTIST"), ImageLoader.FAVORITE));
		appPlayListMenu.setPlayListArtist ( new JMenuItem(LanguageTool.getString("SET_ARTIST_AS_PLAYLIST"), ImageLoader.ARTIST));
		appPlayListMenu.setPlayListAlbum ( new JMenuItem(LanguageTool.getString("SET_ALBUM_AS_PLAYLIST"), ImageLoader.ALBUM));
		appPlayListMenu.setPlayListShowButtons ( new JCheckBoxMenuItem(LanguageTool.getString("SHOW_PLAYLIST_CONTROLS"), null));
		
		tools = new JMenu(LanguageTool.getString("TOOLS"));
		toolsExport = new JMenuItem(LanguageTool.getString("EXPORT") + "...");
		ripCd = new JMenuItem(LanguageTool.getString("RIP_CD") + "...");
		stats = new JMenuItem(LanguageTool.getString("STATS"));
		tools.add(toolsExport);
		tools.add(ripCd);
		tools.add(stats);
		
		device = new JMenu(LanguageTool.getString("DEVICE"));
		deviceConnect = new JMenuItem(LanguageTool.getString("CONNECT"));
		device.add(deviceConnect);
		deviceRefresh = new JMenuItem(LanguageTool.getString("REFRESH"));
		device.add(deviceRefresh);
		deviceDisconnect = new JMenuItem(LanguageTool.getString("DISCONNECT"));
		device.add(deviceDisconnect);
		device.add(new JSeparator());
		deviceViewByTag = new JRadioButtonMenuItem(LanguageTool.getString("SORT_BY_TAG"));
		device.add(deviceViewByTag);
		deviceViewByFolder = new JRadioButtonMenuItem(LanguageTool.getString("SORT_BY_FOLDER"));
		device.add(deviceViewByFolder);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(deviceViewByTag);
		group2.add(deviceViewByFolder);
		
		playList.add(appPlayListMenu.getPlayListPlay());
		playList.add(appPlayListMenu.getPlayListInfo());
		playList.add(appPlayListMenu.getPlayListTags());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListSave());
		playList.add(appPlayListMenu.getPlayListLoad());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListFilter());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListDelete());
		playList.add(appPlayListMenu.getPlayListClear());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListTop());
		playList.add(appPlayListMenu.getPlayListUp());
		playList.add(appPlayListMenu.getPlayListDown());
		playList.add(appPlayListMenu.getPlayListBottom());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListFavoriteSong());
		playList.add(appPlayListMenu.getPlayListFavoriteAlbum());
		playList.add(appPlayListMenu.getPlayListFavoriteArtist());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListArtist());
		playList.add(appPlayListMenu.getPlayListAlbum());
		playList.add(new JSeparator());
		playList.add(appPlayListMenu.getPlayListShowButtons());
		
		about = new JMenu(LanguageTool.getString("ABOUT"));
		checkUpdates = new JMenuItem(LanguageTool.getString("CHECK_FOR_UPDATES"));
		aboutItem = new JMenuItem(LanguageTool.getString("ABOUT"));

		about.add(checkUpdates);
		about.add(new JSeparator());
		about.add(aboutItem);
		
		add(file);
		add(edit);
		add(view);
		add(player);
		add(playList);
		add(device);
		add(tools);
		add(about);
	}
	
	public JPopupMenu getMenuAsPopupMenu() {
		JPopupMenu menu = new JPopupMenu();
		menu.add(file);
		menu.add(edit);
		menu.add(view);
		menu.add(player);
		menu.add(playList);
		menu.add(tools);
		menu.add(about);
		return menu;
	}

	public JMenuItem getSelectRepository() {
		return selectRepository;
	}

	public JMenuItem getAboutItem() {
		return aboutItem;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public JMenuItem getRefreshRepository() {
		return refreshRepository;
	}

	public JMenuItem getToolsExport() {
		return toolsExport;
	}

	public JMenuItem getDeviceConnect() {
		return deviceConnect;
	}
	
	public JMenuItem getDeviceRefresh() {
		return deviceRefresh;
	}

	public JMenuItem getDeviceDisconnect() {
		return deviceDisconnect;
	}

	public JRadioButtonMenuItem getDeviceViewByFolder() {
		return deviceViewByFolder;
	}

	public JRadioButtonMenuItem getDeviceViewByTag() {
		return deviceViewByTag;
	}

	public JMenuItem getRipCd() {
		return ripCd;
	}


	public JMenuItem getEditPreferences() {
		return editPreferences;
	}

	public JMenu getRecentRepositories() {
		return recentRepositories;
	}

	public JMenuItem getStats() {
		return stats;
	}

	public JMenuItem getCheckUpdates() {
		return checkUpdates;
	}

	public JMenuItem getVolumeDown() {
		return volumeDown;
	}

	public JMenuItem getVolumeUp() {
		return volumeUp;
	}

	public JMenuItem getMute() {
		return mute;
	}

	public ApplicationViewMenuModel getAppViewMenu() {
		return appViewMenu;
	}

	public void setAppViewMenu(ApplicationViewMenuModel appViewMenu) {
		this.appViewMenu = appViewMenu;
	}

	public ApplicationPlayListMenuModel getAppPlayListMenu() {
		return appPlayListMenu;
	}

	public void setAppPlayListMenu(ApplicationPlayListMenuModel appPlayListMenu) {
		this.appPlayListMenu = appPlayListMenu;
	}

}
