/*
 * MIT License
 *
 * Copyright (c) 2016 Simon Kent
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.vaadin.addons.demo.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.addons.*;
import org.vaadin.addons.builder.ToastBuilder;

import javax.annotation.PostConstruct;

import static org.vaadin.addons.builder.ToastOptionsBuilder.having;

@SpringView(name = DemoView.VIEW_NAME)
public class DemoView extends VerticalLayout implements View, ToastrListener {

    static final String VIEW_NAME = "";

    @PostConstruct
    void init() {
        setWidth(100, Unit.PERCENTAGE);
        setHeightUndefined();
        setSpacing(true);

        final Label titleLabel = new Label("Vaadin Toastr Demo");
        titleLabel.setStyleName(ValoTheme.LABEL_H2);
        addComponent(titleLabel);

        final HorizontalLayout columnsLayout = new HorizontalLayout();
        columnsLayout.setWidth(100, Unit.PERCENTAGE);
        columnsLayout.setHeightUndefined();

        final VerticalLayout columnOneLayout = new VerticalLayout();
        columnOneLayout.setWidth(100, Unit.PERCENTAGE);
        columnOneLayout.setHeightUndefined();
        columnOneLayout.setSpacing(true);

        final TextField titleField = new TextField("Title");
        titleField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        titleField.setPlaceholder("Enter a title...");
        columnOneLayout.addComponent(titleField);

        final TextArea messageField = new TextArea("Message");
        messageField.setStyleName(ValoTheme.TEXTAREA_SMALL);
        messageField.setPlaceholder("Enter a message...");
        messageField.setRows(3);
        columnOneLayout.addComponent(messageField);

        final CheckBox closeButton = new CheckBox("Close Button");
        closeButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(closeButton);

        final CheckBox debugButton = new CheckBox("Debug");
        debugButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(debugButton);

        final CheckBox progressBarButton = new CheckBox("Progress Bar");
        progressBarButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(progressBarButton);

        final CheckBox preventDuplicatesButton = new CheckBox("Prevent Duplicates");
        preventDuplicatesButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(preventDuplicatesButton);

        final CheckBox tapToDismissButton = new CheckBox("Add button to force clearing a toast, ignoring focus");
        tapToDismissButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(tapToDismissButton);

        final CheckBox newestOnTopButton = new CheckBox("Newest on top");
        newestOnTopButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(newestOnTopButton);

        final CheckBox rtlButton = new CheckBox("Right to Left");
        rtlButton.setStyleName(ValoTheme.BUTTON_SMALL);
        columnOneLayout.addComponent(rtlButton);

        final VerticalLayout columnTwoLayout = new VerticalLayout();
        columnTwoLayout.setWidth(100, Unit.PERCENTAGE);
        columnTwoLayout.setHeightUndefined();
        columnTwoLayout.setSpacing(true);

        final RadioButtonGroup<String> toastTypeGroup = new RadioButtonGroup<>("Toast Type");
        toastTypeGroup.setStyleName(ValoTheme.BUTTON_SMALL);
        toastTypeGroup.setItems("Success", "Info", "Warning", "Error");
        toastTypeGroup.setValue("Success");
        columnTwoLayout.addComponent(toastTypeGroup);

        final RadioButtonGroup<String> positionGroup = new RadioButtonGroup<>("Position");
        positionGroup.setStyleName(ValoTheme.BUTTON_SMALL);
        positionGroup.setItems("Top Right", "Bottom Right", "Bottom Left", "Top Left", "Top Full Width", "Bottom Full Width", "Top Center", "Bottom Center");
        positionGroup.setValue("Top Right");
        columnTwoLayout.addComponent(positionGroup);

        final GridLayout columnThreeLayout = new GridLayout(2, 4);
        columnThreeLayout.setSpacing(true);
        columnThreeLayout.setWidth(100, Unit.PERCENTAGE);
        columnThreeLayout.setHeightUndefined();

        final TextField showEasingField = new TextField("Show Easing");
        showEasingField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        showEasingField.setValue("swing");
        columnThreeLayout.addComponent(showEasingField);

        final TextField showDurationField = new TextField("Show Duration");
        showDurationField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        showDurationField.setValue("300");
        columnThreeLayout.addComponent(showDurationField);

        final TextField hideEasingField = new TextField("Hide Easing");
        hideEasingField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        hideEasingField.setValue("linear");
        columnThreeLayout.addComponent(hideEasingField);

        final TextField hideDurationField = new TextField("Hide Duration");
        hideDurationField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        hideDurationField.setValue("1000");
        columnThreeLayout.addComponent(hideDurationField);

        final TextField showMethodField = new TextField("Show Method");
        showMethodField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        showMethodField.setValue("fadeIn");
        columnThreeLayout.addComponent(showMethodField);

        final TextField timeOutField = new TextField("Time out");
        timeOutField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        timeOutField.setValue("5000");
        columnThreeLayout.addComponent(timeOutField);

        final TextField hideMethodField = new TextField("Hide Method");
        hideMethodField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        hideMethodField.setValue("fadeOut");
        columnThreeLayout.addComponent(hideMethodField);

        final TextField extendedTimeOutField = new TextField("Extended time out");
        extendedTimeOutField.setStyleName(ValoTheme.TEXTFIELD_SMALL);
        extendedTimeOutField.setValue("1000");
        columnThreeLayout.addComponent(extendedTimeOutField);

        final Toastr toastr = new Toastr();
        toastr.registerToastrListener(this);

        final Button showToastButton = new Button("Show Toast");
        showToastButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        showToastButton.addStyleName(ValoTheme.BUTTON_SMALL);
        showToastButton.addClickListener(event -> toastr.toast(
                ToastBuilder.of(ToastType.valueOf(toastTypeGroup.getValue()), messageField.getValue())
                        .caption(titleField.getValue())
                        .options(having()
                                    .closeButton(closeButton.getValue())
                                    .debug(debugButton.getValue())
                                    .progressBar(progressBarButton.getValue())
                                    .preventDuplicates(preventDuplicatesButton.getValue())
                                    .newestOnTop(newestOnTopButton.getValue())
                                    .tapToDismiss(!tapToDismissButton.getValue())
                                    .position(getPosition(positionGroup.getValue()))
                                    .rightToLeft(rtlButton.getValue())
                                    .showEasing(ToastEasing.find(showEasingField.getValue()).orElse(ToastEasing.Swing))
                                    .hideEasing(ToastEasing.find(hideEasingField.getValue()).orElse(ToastEasing.Linear))
                                    .showDuration(Integer.valueOf(showDurationField.getValue()))
                                    .hideDuration(Integer.valueOf(hideDurationField.getValue()))
                                    .showMethod(ToastDisplayMethod.find(showMethodField.getValue()).orElse(ToastDisplayMethod.FadeIn))
                                    .hideMethod(ToastDisplayMethod.find(hideMethodField.getValue()).orElse(ToastDisplayMethod.FadeOut))
                                    .timeOut(Integer.valueOf(timeOutField.getValue()))
                                    .extendedTimeOut(Integer.valueOf(extendedTimeOutField.getValue()))
                                    .build())
                        .build()));

        final Button clearToastsButton = new Button("Clear Toasts");
        clearToastsButton.setStyleName(ValoTheme.BUTTON_DANGER);
        clearToastsButton.addStyleName(ValoTheme.BUTTON_SMALL);
        clearToastsButton.addClickListener(event -> toastr.clear());

        final Button removeToastsButton = new Button("Remove Toasts");
        removeToastsButton.setStyleName(ValoTheme.BUTTON_DANGER);
        removeToastsButton.addStyleName(ValoTheme.BUTTON_SMALL);
        removeToastsButton.addClickListener(event -> toastr.remove());

        columnsLayout.addComponent(columnOneLayout);
        columnsLayout.addComponent(columnTwoLayout);
        columnsLayout.addComponent(columnThreeLayout);

        final HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);
        buttonLayout.setSizeUndefined();
        buttonLayout.addComponents(showToastButton, clearToastsButton, removeToastsButton);

        addComponent(columnsLayout);
        addComponent(buttonLayout);
        addComponent(toastr);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }

    @Override
    public void onShown() {
        System.out.println("On Shown...");
    }

    @Override
    public void onHidden() {
        System.out.println("On Hidden...");
    }

    @Override
    public void onClick() {
        System.out.println("On Click...");
    }

    @Override
    public void onCloseButtonClick() {
        System.out.println("On Close Click...");
    }

    private ToastPosition getPosition(final String position) {
        if (position == null)
            return ToastPosition.Top_Right;
        return ToastPosition.valueOf(position.replaceAll(" ", "_"));
    }

}
