package com.example.tizona.screen;

import org.vaadin.jouni.animator.AnimatorProxy;

import com.example.tizona.TizonaApplication;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class MainScreen extends Window {

    // Common objects
    private AnimatorProxy proxy = new AnimatorProxy();
    private TizonaApplication app;

    public MainScreen() {

	addComponent(proxy);
	addComponent(new Label("main"));

    }

}
