package es.guzman.tizona.screen.main;

import java.util.Set;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class TabFavoritos extends VerticalLayout {

    Table table = new Table();

    public TabFavoritos() {
	addComponent(table);

	// Label to indicate current selection
	final Label selected = new Label("No selection");
	addComponent(selected);

	// set a style name, so we can style rows and cells
	// table.setStyleName("iso3166");

	// size
	table.setWidth("100%");
	table.setHeight("100%");

	// selectable
	table.setSelectable(false);
	table.setMultiSelect(false);
	table.setImmediate(false); // react at once when something is selected

	// connect data source
	table.setContainerDataSource(getContainer());

	// turn on column reordering and collapsing
	table.setColumnReorderingAllowed(true);
	table.setColumnCollapsingAllowed(true);

	// set column headers
	table.setColumnHeaders(new String[] { "Pais", "Codigo"});

	// Column alignment
	table.setColumnAlignment(COLUMNA_NHC, Table.ALIGN_CENTER);

	// Column width
	table.setColumnExpandRatio(COLUMNA_NOMBRE, 1);
	table.setColumnWidth(COLUMNA_NHC, 70);

	// Collapse one column - the user can make it visible again
//	table.setColumnCollapsed(COLUMNA_BANDERA, true);

	// show row header w/ icon
//	table.setRowHeaderMode(Table.ROW_HEADER_MODE_ICON_ONLY);
//	table.setItemIconPropertyId(COLUMNA_NOMBRE);

	// listen for valueChange, a.k.a 'select' and update the label
	table.addListener(new Table.ValueChangeListener() {
	    public void valueChange(ValueChangeEvent event) {
		// in multiselect mode, a Set of itemIds is returned,
		// in singleselect mode the itemId is returned directly
		Set<?> value = (Set<?>) event.getProperty().getValue();
		if (null == value || value.size() == 0) {
		    selected.setValue("No selection");
		} else {
		    selected.setValue("Selected: " + table.getValue());
		}
	    }
	});

    }

    public static final Object COLUMNA_NOMBRE = "nombre";
    public static final Object COLUMNA_NHC = "nhc";
//    public static final Object COLUMNA_BANDERA = "bandera";

    public IndexedContainer getContainer() {
	IndexedContainer container = new IndexedContainer();

	container.addContainerProperty(COLUMNA_NOMBRE, String.class, null);
	container.addContainerProperty(COLUMNA_NHC, String.class, null);
	
	
	for (int i = 0; i < iso3166.length; i++) {
	    String name = iso3166[i++];
	    String id = iso3166[i];
	    Item item = container.addItem(id);
	    
//	    VerticalLayout vl = new VerticalLayout();
//	    vl.addComponent(new Label("iteracion " + i));
//	    vl.addComponent(new Label(name));
//	    Button btn = new Button("clic!");
//	    btn.setData(name);
//	    btn.addListener(new ClickListener() {
//	        
//	        @Override
//	        public void buttonClick(ClickEvent event) {
//	            doClic(((Button) event.getSource()).getData());
//	        }
//	    });
//	    vl.addComponent(btn);
	    
	    item.getItemProperty(COLUMNA_NOMBRE).setValue(name);
	    item.getItemProperty(COLUMNA_NHC).setValue(id);
	    // item.getItemProperty(COLUMNA_BANDERA).setValue(
	    // new ThemeResource("../sampler/flags/" + id.toLowerCase()
	    // + ".gif"));
	}
	container.sort(new Object[] { COLUMNA_NOMBRE }, new boolean[] { true });

	return container;
    }

    private void doClic(Object data) {
	getWindow().showNotification((String) data);
    }
    
    private static final String[] iso3166 = new String[] { "AFGHANISTAN", "AF", "��LAND ISLANDS", "AX", "ALBANIA",
	    "AL", "ALGERIA", "DZ", "AMERICAN SAMOA", "AS", "ANDORRA", "AD", "ANGOLA", "AO", "ANGUILLA", "AI",
	    "ANTARCTICA", "AQ", "ANTIGUA AND BARBUDA", "AG", "ARGENTINA", "AR", "ARMENIA", "AM", "ARUBA", "AW",
	    "AUSTRALIA", "AU", "AUSTRIA", "AT", "AZERBAIJAN", "AZ", "BAHAMAS", "BS", "BAHRAIN", "BH", "BANGLADESH",
	    "BD", "BARBADOS", "BB", "BELARUS", "BY", "BELGIUM", "BE", "BELIZE", "BZ", "BENIN", "BJ", "BERMUDA", "BM",
	    "BHUTAN", "BT", "BOLIVIA", "BO", "BOSNIA AND HERZEGOVINA", "BA", "BOTSWANA", "BW", "BOUVET ISLAND", "BV",
	    "BRAZIL", "BR", "BRITISH INDIAN OCEAN TERRITORY", "IO", "BRUNEI DARUSSALAM", "BN", "BULGARIA", "BG",
	    "BURKINA FASO", "BF", "BURUNDI", "BI", "CAMBODIA", "KH", "CAMEROON", "CM", "CANADA", "CA", "CAPE VERDE",
	    "CV", "CAYMAN ISLANDS", "KY", "CENTRAL AFRICAN REPUBLIC", "CF", "CHAD", "TD", "CHILE", "CL", "CHINA", "CN",
	    "CHRISTMAS ISLAND", "CX", "COCOS (KEELING) ISLANDS", "CC", "COLOMBIA", "CO", "COMOROS", "KM", "CONGO",
	    "CG", "CONGO, THE DEMOCRATIC REPUBLIC OF THE", "CD", "COOK ISLANDS", "CK", "COSTA RICA", "CR",
	    "C��TE D'IVOIRE", "CI", "CROATIA", "HR", "CUBA", "CU", "CYPRUS", "CY", "CZECH REPUBLIC", "CZ", "DENMARK",
	    "DK", "DJIBOUTI", "DJ", "DOMINICA", "DM", "DOMINICAN REPUBLIC", "DO", "ECUADOR", "EC", "EGYPT", "EG",
	    "EL SALVADOR", "SV", "EQUATORIAL GUINEA", "GQ", "ERITREA", "ER", "ESTONIA", "EE", "ETHIOPIA", "ET",
	    "FALKLAND ISLANDS (MALVINAS)", "FK", "FAROE ISLANDS", "FO", "FIJI", "FJ", "FINLAND", "FI", "FRANCE", "FR",
	    "FRENCH GUIANA", "GF", "FRENCH POLYNESIA", "PF", "FRENCH SOUTHERN TERRITORIES", "TF", "GABON", "GA",
	    "GAMBIA", "GM", "GEORGIA", "GE", "GERMANY", "DE", "GHANA", "GH", "GIBRALTAR", "GI", "GREECE", "GR",
	    "GREENLAND", "GL", "GRENADA", "GD", "GUADELOUPE", "GP", "GUAM", "GU", "GUATEMALA", "GT", "GUERNSEY", "GG",
	    "GUINEA", "GN", "GUINEA-BISSAU", "GW", "GUYANA", "GY", "HAITI", "HT", "HEARD ISLAND AND MCDONALD ISLANDS",
	    "HM", "HOLY SEE (VATICAN CITY STATE)", "VA", "HONDURAS", "HN", "HONG KONG", "HK", "HUNGARY", "HU",
	    "ICELAND", "IS", "INDIA", "IN", "INDONESIA", "ID", "IRAN, ISLAMIC REPUBLIC OF", "IR", "IRAQ", "IQ",
	    "IRELAND", "IE", "ISLE OF MAN", "IM", "ISRAEL", "IL", "ITALY", "IT", "JAMAICA", "JM", "JAPAN", "JP",
	    "JERSEY", "JE", "JORDAN", "JO", "KAZAKHSTAN", "KZ", "KENYA", "KE", "KIRIBATI", "KI",
	    "KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF", "KP", "KOREA, REPUBLIC OF", "KR", "KUWAIT", "KW", "KYRGYZSTAN",
	    "KG", "LAO PEOPLE'S DEMOCRATIC REPUBLIC", "LA", "LATVIA", "LV", "LEBANON", "LB", "LESOTHO", "LS",
	    "LIBERIA", "LR", "LIBYAN ARAB JAMAHIRIYA", "LY", "LIECHTENSTEIN", "LI", "LITHUANIA", "LT", "LUXEMBOURG",
	    "LU", "MACAO", "MO", "MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF", "MK", "MADAGASCAR", "MG", "MALAWI",
	    "MW", "MALAYSIA", "MY", "MALDIVES", "MV", "MALI", "ML", "MALTA", "MT", "MARSHALL ISLANDS", "MH",
	    "MARTINIQUE", "MQ", "MAURITANIA", "MR", "MAURITIUS", "MU", "MAYOTTE", "YT", "MEXICO", "MX",
	    "MICRONESIA, FEDERATED STATES OF", "FM", "MOLDOVA, REPUBLIC OF", "MD", "MONACO", "MC", "MONGOLIA", "MN",
	    "MONTENEGRO", "ME", "MONTSERRAT", "MS", "MOROCCO", "MA", "MOZAMBIQUE", "MZ", "MYANMAR", "MM", "NAMIBIA",
	    "NA", "NAURU", "NR", "NEPAL", "NP", "NETHERLANDS", "NL", "NETHERLANDS ANTILLES", "AN", "NEW CALEDONIA",
	    "NC", "NEW ZEALAND", "NZ", "NICARAGUA", "NI", "NIGER", "NE", "NIGERIA", "NG", "NIUE", "NU",
	    "NORFOLK ISLAND", "NF", "NORTHERN MARIANA ISLANDS", "MP", "NORWAY", "NO", "OMAN", "OM", "PAKISTAN", "PK",
	    "PALAU", "PW", "PALESTINIAN TERRITORY, OCCUPIED", "PS", "PANAMA", "PA", "PAPUA NEW GUINEA", "PG",
	    "PARAGUAY", "PY", "PERU", "PE", "PHILIPPINES", "PH", "PITCAIRN", "PN", "POLAND", "PL", "PORTUGAL", "PT",
	    "PUERTO RICO", "PR", "QATAR", "QA", "REUNION", "RE", "ROMANIA", "RO", "RUSSIAN FEDERATION", "RU", "RWANDA",
	    "RW", "SAINT BARTH��LEMY", "BL", "SAINT HELENA", "SH", "SAINT KITTS AND NEVIS", "KN", "SAINT LUCIA", "LC",
	    "SAINT MARTIN", "MF", "SAINT PIERRE AND MIQUELON", "PM", "SAINT VINCENT AND THE GRENADINES", "VC", "SAMOA",
	    "WS", "SAN MARINO", "SM", "SAO TOME AND PRINCIPE", "ST", "SAUDI ARABIA", "SA", "SENEGAL", "SN", "SERBIA",
	    "RS", "SEYCHELLES", "SC", "SIERRA LEONE", "SL", "SINGAPORE", "SG", "SLOVAKIA", "SK", "SLOVENIA", "SI",
	    "SOLOMON ISLANDS", "SB", "SOMALIA", "SO", "SOUTH AFRICA", "ZA",
	    "SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS", "GS", "SPAIN", "ES", "SRI LANKA", "LK", "SUDAN", "SD",
	    "SURINAME", "SR", "SVALBARD AND JAN MAYEN", "SJ", "SWAZILAND", "SZ", "SWEDEN", "SE", "SWITZERLAND", "CH",
	    "SYRIAN ARAB REPUBLIC", "SY", "TAIWAN, PROVINCE OF CHINA", "TW", "TAJIKISTAN", "TJ",
	    "TANZANIA, UNITED REPUBLIC OF", "TZ", "THAILAND", "TH", "TIMOR-LESTE", "TL", "TOGO", "TG", "TOKELAU", "TK",
	    "TONGA", "TO", "TRINIDAD AND TOBAGO", "TT", "TUNISIA", "TN", "TURKEY", "TR", "TURKMENISTAN", "TM",
	    "TURKS AND CAICOS ISLANDS", "TC", "TUVALU", "TV", "UGANDA", "UG", "UKRAINE", "UA", "UNITED ARAB EMIRATES",
	    "AE", "UNITED KINGDOM", "GB", "UNITED STATES", "US", "UNITED STATES MINOR OUTLYING ISLANDS", "UM",
	    "URUGUAY", "UY", "UZBEKISTAN", "UZ", "VANUATU", "VU", "VENEZUELA", "VE", "VIET NAM", "VN",
	    "VIRGIN ISLANDS, BRITISH", "VG", "VIRGIN ISLANDS, U.S.", "VI", "WALLIS AND FUTUNA", "WF", "WESTERN SAHARA",
	    "EH", "YEMEN", "YE", "ZAMBIA", "ZM", "ZIMBABWE", "ZW" };

}
