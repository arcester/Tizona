package es.guzman.tizona.screen.main;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window.Notification;

import es.guzman.tizona.common.StringsContainer;
import es.horus.g2common.beans.ui.PrincipalBean;

@SuppressWarnings("serial")
public class TabsContainer extends TabSheet implements TabSheet.SelectedTabChangeListener, TabSheet.CloseHandler {

    // Aquí se declara cada tab
    private Tab tabFavoritos;
    private Tab tabUrgencias;

    // Estos son los iconos
    private static final ThemeResource ICONO_FAVORITOS = new ThemeResource("../tizonatheme/iconos/star.png");
    private static final ThemeResource ICONO_BUSCAR = new ThemeResource("../tizonatheme/iconos/buscar.png");

    public TabsContainer() {

	setHeight("100%");
	setWidth("100%");

	tabFavoritos = addTab(new TabFavoritos(this), "", ICONO_FAVORITOS);
	tabUrgencias = addTab(new TabConsulta(this), StringsContainer.getString("tizona.principal.tabs.consulta"));
	tabUrgencias = addTab(new TabHospitalizados(this),
		StringsContainer.getString("tizona.principal.tabs.hospitalizados"));
	tabUrgencias = addTab(new TabUrgencias(this), StringsContainer.getString("tizona.principal.tabs.urgencias"));
	tabFavoritos = addTab(new TabBuscar(this), "", ICONO_BUSCAR);
	addListener(this);
	setCloseHandler(this);

    }

    public void selectedTabChange(SelectedTabChangeEvent event) {
	// if (getTab(event.getTabSheet().getSelectedTab()) == tabFavoritos) {
	// getWindow().showNotification("Favoritos");
	// } else if (getTab(event.getTabSheet().getSelectedTab()) ==
	// tabUrgencias) {
	// getWindow().showNotification("Urgencias");
	// }
	// String c = getTab(event.getTabSheet().getSelectedTab()).getCaption();
	// getWindow().showNotification("Selected tab: " + c);
    }

    /**
     * Gestión de pestañas
     */
    private int maxPatientTabs = 3;
    private int actualPatientTabs = 0;

    /**
     * Abrir una nueva pestaña con los datos del paciente
     * 
     * @param bean
     */
    public void doSeleccionaPaciente(PrincipalBean bean) {

	if (actualPatientTabs < maxPatientTabs) {
	    getWindow().showNotification(
		    StringsContainer.getString("tizona.principal.tabs.abriendoPaciente") + bean.getIdPaciente());
	    TabPaciente tabPaciente = new TabPaciente(bean);
	    Tab tab = addTab(tabPaciente, bean.getNombre());
	    tab.setClosable(true);
	    actualPatientTabs++;
	    setSelectedTab(tabPaciente);
	} else {
	    getWindow().showNotification(StringsContainer.getString("tizona.principal.tabs.error.abriendoPaciente"),
		    Notification.TYPE_WARNING_MESSAGE);
	}

    }

    public void onTabClose(TabSheet tabsheet, Component tabContent) {
	getWindow().showNotification("Closed tab: " + tabsheet.getTab(tabContent).getCaption());
	tabsheet.removeComponent(tabContent);
	actualPatientTabs--;
    }

}
