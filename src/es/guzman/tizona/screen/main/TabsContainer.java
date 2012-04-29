package es.guzman.tizona.screen.main;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TabsContainer extends VerticalLayout implements TabSheet.SelectedTabChangeListener {

    // Aqui guardamos los tabs
    private TabSheet tabs;

    // Aquí se declara cada tab
    private Tab tabFavoritos;

    // Estos son los iconos
    private static final ThemeResource ICONO_FAVORITOS = new ThemeResource(
            "../tizonatheme/iconos/tab_favoritos.ico");

    public TabsContainer() {

	setSpacing(true);
	// setMargin(true);

	tabs = new TabSheet();
	tabs.setHeight("100%");
	tabs.setWidth("100%");
	tabFavoritos = tabs.addTab(new TabFavoritos(), "Favoritos", ICONO_FAVORITOS);
	tabs.addListener(this);

	addComponent(tabs);

    }

    public void selectedTabChange(SelectedTabChangeEvent event) {
	String c = tabs.getTab(event.getTabSheet().getSelectedTab()).getCaption();
	getWindow().showNotification("Selected tab: " + c);
    }

}
