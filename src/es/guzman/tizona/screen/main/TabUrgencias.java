package es.guzman.tizona.screen.main;

import java.util.Set;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import es.horus.g2common.beans.ui.PrincipalBean;

public class TabUrgencias extends VerticalLayout {

    private static final ThemeResource ICONO_FAVORITO = new ThemeResource("../tizonatheme/iconos/star.png");
    private static final ThemeResource ICONO_FAVORITO_DESACTIVADO = new ThemeResource(
	    "../tizonatheme/iconos/star_disabled.png");
    private static final ThemeResource ICONO_ALERTA = new ThemeResource("../tizonatheme/iconos/alerta.png");
    private static final ThemeResource ICONO_PROCESO = new ThemeResource("../tizonatheme/iconos/proceso.png");
    private static final ThemeResource ICONO_NOTA = new ThemeResource("../tizonatheme/iconos/nota.png");

    private Table table = new Table();
    
    private TabsContainer parent;

    public TabUrgencias(TabsContainer t) {

	this.parent = t;
	
	setWidth("100%");
	setHeight("100%");

	addComponent(table);

	// size
	table.setWidth("100%");
	table.setHeight("100%");

	// selectable
	table.setSelectable(true);
	table.setMultiSelect(false);
	table.setImmediate(true); // react at once when something is selected

	// connect data source
	table.setContainerDataSource(getContainer());

	// Column alignment
	table.setColumnAlignment(COLUMNA_TRIAJE, Table.ALIGN_CENTER);

	// Column width
	table.setColumnExpandRatio(COLUMNA_OBSERVACIONES, 1);
	table.setColumnWidth(COLUMNA_NHC, 70);
	
	// Llamamos a esta función al hacer clic
	table.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                parent.doSeleccionaPaciente(((PrincipalBean) table.getValue()));
            }
        });

    }

    public static final Object COLUMNA_NHC = "nhc/tsi";
    public static final Object COLUMNA_SEXO = "sexo";
    public static final Object COLUMNA_NOMBRE = "nombre";
    public static final Object COLUMNA_FECHA = "fecha";
    public static final Object COLUMNA_ZONA = "zona";
    public static final Object COLUMNA_TRIAJE = "triaje";
    public static final Object COLUMNA_OBSERVACIONES = "observaciones";
    public static final Object COLUMNA_ACCIONES = "acciones";

    public IndexedContainer getContainer() {
	IndexedContainer container = new IndexedContainer();

	container.addContainerProperty(COLUMNA_NHC, String.class, null);
	container.addContainerProperty(COLUMNA_SEXO, String.class, null);
	container.addContainerProperty(COLUMNA_NOMBRE, String.class, null);
	container.addContainerProperty(COLUMNA_FECHA, String.class, null);
	container.addContainerProperty(COLUMNA_ZONA, String.class, null);
	container.addContainerProperty(COLUMNA_TRIAJE, String.class, null);
	container.addContainerProperty(COLUMNA_OBSERVACIONES, String.class, null);
	container.addContainerProperty(COLUMNA_ACCIONES, HorizontalLayout.class, null);

	PrincipalBean bean;
	for (int i = 0; i < 50; i++) {

	    bean = new PrincipalBean();
	    bean.setIdPaciente(Integer.toString(i));
	    bean.setNombre("paciente " + i);
	    bean.setSexo(i % 2 == 0 ? "H" : "M");
	    bean.setFecha("hoy");
	    bean.setHistoria("NHC" + i);
	    bean.setCama("cama " + i);
	    bean.setTriaje(Integer.toString(new Double(Math.random() * 4).intValue() + 1));
	    bean.setObservaciones("observaciones superlargas larguisimas de la muerte, a ver si salen correctamente o no "
		    + i);

	    // Generar el contenedor de datos
	    Item item = container.addItem(bean);

	    // Generar el contenedor visual
	    HorizontalLayout filaBotones = new HorizontalLayout();
	    filaBotones.setSpacing(false);

	    /* Creamos los botones */
//	    String sizeBotones = "35px";

	    // Botón de favoritos
	    NativeButton btn = new NativeButton();
	    btn.setIcon(ICONO_FAVORITO);
	    btn.setStyleName("principal-fila-boton");
	    btn.setData(bean.getNombre());
//	    btn.setWidth(sizeBotones);
	    btn.setSizeUndefined();
	    btn.addListener(new ClickListener() {

		@Override
		public void buttonClick(ClickEvent event) {
		    Button btn = ((Button) event.getSource());
		    if (btn.getIcon() == ICONO_FAVORITO) {
			btn.setIcon(ICONO_FAVORITO_DESACTIVADO);
		    } else {
			btn.setIcon(ICONO_FAVORITO);
		    }
		    doClicFavorito(btn.getData());
		}
	    });
	    filaBotones.addComponent(btn);

	    // Botón de alertas
	    btn = new NativeButton();
	    int numAlertas = new Double(Math.random() * 3).intValue();
	    btn.setCaption(Integer.toString(numAlertas));
	    if (numAlertas > 0) {
		btn.setStyleName("principal-fila-boton");
	    } else {
		btn.setStyleName("principal-fila-boton-cero");
	    }
	    btn.setIcon(ICONO_ALERTA);
	    btn.setData(bean.getNombre());
//	    btn.setWidth(sizeBotones);
	    btn.setSizeUndefined();
	    filaBotones.addComponent(btn);

	    // Botón de procesos
	    btn = new NativeButton();
	    int numProcesos = new Double(Math.random() * 4).intValue();
		btn.setCaption(Integer.toString(numProcesos));
	    if (numProcesos > 0) {
		btn.setStyleName("principal-fila-boton");
	    } else {
		btn.setStyleName("principal-fila-boton-cero");
	    }
	    btn.setIcon(ICONO_PROCESO);
	    btn.setStyleName("principal-fila-boton");
	    btn.setData(bean.getNombre());
//	    btn.setWidth(sizeBotones);
	    btn.setSizeUndefined();
	    filaBotones.addComponent(btn);

	    // Botón de notas
	    btn = new NativeButton();
	    int numNotas = new Double(Math.random() * 5).intValue();
		btn.setCaption(Integer.toString(numNotas));
	    if (numNotas > 0) {
		btn.setStyleName("principal-fila-boton");
	    } else {
		btn.setStyleName("principal-fila-boton-cero");
	    }
	    btn.setIcon(ICONO_NOTA);
	    btn.setStyleName("principal-fila-boton");
	    btn.setData(bean.getNombre());
//	    btn.setWidth(sizeBotones);
	    btn.setSizeUndefined();
	    filaBotones.addComponent(btn);

	    item.getItemProperty(COLUMNA_NOMBRE).setValue(bean.getNombre());
	    item.getItemProperty(COLUMNA_NHC).setValue(bean.getHistoria());
	    item.getItemProperty(COLUMNA_SEXO).setValue(bean.getSexo());
	    item.getItemProperty(COLUMNA_FECHA).setValue(bean.getFecha());
	    item.getItemProperty(COLUMNA_ZONA).setValue(bean.getCama());
	    item.getItemProperty(COLUMNA_TRIAJE).setValue(bean.getTriaje());
	    item.getItemProperty(COLUMNA_OBSERVACIONES).setValue(bean.getObservaciones());
	    item.getItemProperty(COLUMNA_ACCIONES).setValue(filaBotones);
	}
	container.sort(new Object[] { COLUMNA_NOMBRE }, new boolean[] { true });

	return container;
    }

    private void doClicFavorito(Object data) {
	getWindow().showNotification("Modificado favorito " + (String) data);
    }

}
