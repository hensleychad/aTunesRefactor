package net.sourceforge.atunes.gui.models.menu;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;

public class ApplicationViewMenuModel {
	
	private JMenuItem tagView;
	private JMenuItem folderView;
	private JMenuItem favoriteView;
	private JMenuItem deviceView;
	private JCheckBoxMenuItem showStatusBar;
	private JCheckBoxMenuItem showNavigationPanel;
	private JCheckBoxMenuItem showNavigationTable;
	private JCheckBoxMenuItem showProperties;
	private JCheckBoxMenuItem showOSD;
	
	public JMenuItem getTagView() {
		return tagView;
	}
	public void setTagView(JMenuItem tagView) {
		this.tagView = tagView;
	}
	public JMenuItem getFolderView() {
		return folderView;
	}
	public void setFolderView(JMenuItem folderView) {
		this.folderView = folderView;
	}
	public JMenuItem getFavoriteView() {
		return favoriteView;
	}
	public void setFavoriteView(JMenuItem favoriteView) {
		this.favoriteView = favoriteView;
	}
	public JMenuItem getDeviceView() {
		return deviceView;
	}
	public void setDeviceView(JMenuItem deviceView) {
		this.deviceView = deviceView;
	}
	public JCheckBoxMenuItem getShowStatusBar() {
		return showStatusBar;
	}
	public void setShowStatusBar(JCheckBoxMenuItem showStatusBar) {
		this.showStatusBar = showStatusBar;
	}
	public JCheckBoxMenuItem getShowNavigationPanel() {
		return showNavigationPanel;
	}
	public void setShowNavigationPanel(JCheckBoxMenuItem showNavigationPanel) {
		this.showNavigationPanel = showNavigationPanel;
	}
	public JCheckBoxMenuItem getShowNavigationTable() {
		return showNavigationTable;
	}
	public void setShowNavigationTable(JCheckBoxMenuItem showNavigationTable) {
		this.showNavigationTable = showNavigationTable;
	}
	public JCheckBoxMenuItem getShowProperties() {
		return showProperties;
	}
	public void setShowProperties(JCheckBoxMenuItem showProperties) {
		this.showProperties = showProperties;
	}
	public JCheckBoxMenuItem getShowOSD() {
		return showOSD;
	}
	public void setShowOSD(JCheckBoxMenuItem showOSD) {
		this.showOSD = showOSD;
	}
	
	
	

}
