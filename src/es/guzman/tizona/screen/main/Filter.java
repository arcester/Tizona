package es.guzman.tizona.screen.main;

import java.text.DateFormat;
import java.util.Date;

import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;

import es.guzman.tizona.common.Constantes;
import es.guzman.tizona.common.StringsContainer;

public class Filter implements PopupView.Content {

    // Componentes visuales
    private ComboBox centros = new ComboBox();
    private ComboBox servicios = new ComboBox();
    private ComboBox zonas = new ComboBox();
    private ComboBox agendas = new ComboBox();
    private InlineDateField fecha = new InlineDateField();
    private HorizontalLayout root = new HorizontalLayout();

    // Datos para mostrar
    private String sCentro;
    private String sServicio;
    private String sFecha;
    
    public Filter() {
	
	root.setSizeUndefined();
	root.setSpacing(true);
	root.setMargin(true);
	
	/* CENTROS */

	String[] listCentros = new String[] { "Hospital Nuestra Señora de Sonsoles" };
	for (int i = 0; i < listCentros.length; i++) {
	    centros.addItem(listCentros[i]);
	}
	centros.setValue(listCentros[0]);
	centros.setFilteringMode(Filtering.FILTERINGMODE_OFF);
	centros.setTextInputAllowed(false);
	centros.setImmediate(true);
	centros.setNullSelectionAllowed(false);

	/* SERVICIOS */

	String[] listServicios = new String[] { "Hematología", "Nefrología", "Urgencias" };
	for (int i = 0; i < listServicios.length; i++) {
	    servicios.addItem(listServicios[i]);
	}
	servicios.setValue(listServicios[1]);
	servicios.setFilteringMode(Filtering.FILTERINGMODE_OFF);
	servicios.setTextInputAllowed(false);
	servicios.setImmediate(true);
	servicios.setNullSelectionAllowed(false);

	/* ZONAS */

	String[] listZonas = new String[] { "BOX" };
	for (int i = 0; i < listZonas.length; i++) {
	    zonas.addItem(listZonas[i]);
	}
	zonas.setValue(listZonas[0]);
	zonas.setFilteringMode(Filtering.FILTERINGMODE_OFF);
	zonas.setTextInputAllowed(false);
	zonas.setImmediate(true);
	zonas.setNullSelectionAllowed(false);

	/* AGENDAS */

	String[] listAgendas = new String[] { "AGENDA1" };
	for (int i = 0; i < listAgendas.length; i++) {
	    agendas.addItem(listAgendas[i]);
	}
	agendas.setValue(listAgendas[0]);
	agendas.setFilteringMode(Filtering.FILTERINGMODE_OFF);
	agendas.setTextInputAllowed(false);
	agendas.setImmediate(true);
	agendas.setNullSelectionAllowed(false);
	
	/* FECHA */
	
	fecha.setResolution(InlineDateField.RESOLUTION_DAY);
	fecha.setDateFormat(Constantes.PATTERN_FECHAS_COMBO);
	fecha.setValue(new java.util.Date());
	fecha.addListener(new Listener() {
	    @Override
	    public void componentEvent(Event event) {
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
	        sFecha = dateFormatter.format(fecha.getValue());
	    }
	});
	
	
	/* COLOCACIÓN VISUAL */

	VerticalLayout layoutCombos = new VerticalLayout();
	layoutCombos.setSpacing(true);
	layoutCombos.setMargin(false, true, false, false);
	root.addComponent(layoutCombos);
	layoutCombos.addComponent(new Label(StringsContainer.getString("tizona.principal.filtro.centro")));
	layoutCombos.addComponent(centros);
	layoutCombos.addComponent(new Label(StringsContainer.getString("tizona.principal.filtro.servicio")));
	layoutCombos.addComponent(servicios);
	layoutCombos.addComponent(new Label(StringsContainer.getString("tizona.principal.filtro.zona")));
	layoutCombos.addComponent(zonas);
	layoutCombos.addComponent(new Label(StringsContainer.getString("tizona.principal.filtro.agenda")));
	layoutCombos.addComponent(agendas);

	VerticalLayout layoutFecha = new VerticalLayout();
	layoutFecha.setMargin(false, false, false, true);
	root.addComponent(layoutFecha);
	layoutFecha.addComponent(new Label("Fecha:"));
	layoutFecha.addComponent(fecha);

    }

    public String getMinimizedValueAsHTML() {
	sCentro = (String) centros.getValue();
	sServicio = (String) servicios.getValue();
	DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        String sFecha = dateFormatter.format((Date) fecha.getValue());
	return sCentro + " - " + sServicio + " - " + sFecha;
    }

    public Component getPopupComponent() {
	return root;
    }

}
