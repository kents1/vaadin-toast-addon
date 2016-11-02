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
package org.vaadin.addons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import org.vaadin.addons.client.ToastrComponentState;

import java.util.ArrayList;
import java.util.Collection;

import static org.vaadin.addons.Toastr.ToastrJavaScriptFunctions.*;

@JavaScript({ "jquery-2.1.4.min.js", "toastr/2_1_3/toastr.min.js", "toastr-connector.js" })
@StyleSheet({ "toastr/2_1_3/toastr.min.css" })
public class Toastr extends AbstractJavaScriptComponent {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Collection<ToastrListener> toastrListenerCollection = new ArrayList<>();

    public Toastr() {
        addFunction(ACTION_SHOWN, (JavaScriptFunction) args -> toastrListenerCollection.forEach(ToastrListener::onShown));
        addFunction(ACTION_HIDDEN, (JavaScriptFunction) args -> toastrListenerCollection.forEach(ToastrListener::onHidden));
        addFunction(ACTION_CLICKED, (JavaScriptFunction) args -> toastrListenerCollection.forEach(ToastrListener::onClick));
        addFunction(ACTION_CLOSE_BUTTON_CLICKED, (JavaScriptFunction) args -> toastrListenerCollection.forEach(ToastrListener::onCloseButtonClick));
   }

    @Override
    protected ToastrComponentState getState() {
        return (ToastrComponentState) super.getState();
    }

    public void toast(final Toast toast) {
        toastr(toast.getMessage(), toast.getCaption(), toast.getType(), toast.getOptions());
    }

    public void clear() {
        callFunction(FUNCTION_CLEAR);
    }

    public void remove() {
        callFunction(FUNCTION_REMOVE);
    }

    public void registerToastrListener(final ToastrListener listener) {
        if (listener != null)
            toastrListenerCollection.add(listener);
    }

    private void toastr(final String message, final String caption, final ToastType type, final ToastOptions options) {
        try {
            final String jsonOpts = OBJECT_MAPPER.writeValueAsString(options);
            callFunction(JS_METHOD_NAME, type.name().toLowerCase(), message, caption, jsonOpts);
        }
        catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Unable to convert options to JSON.", e);
        }
    }

    static class ToastrJavaScriptFunctions {
        static final String JS_METHOD_NAME = "vaadinToastr";

        static final String ACTION_SHOWN = "onShown";
        static final String ACTION_HIDDEN = "onHidden";
        static final String ACTION_CLICKED = "onClick";
        static final String ACTION_CLOSE_BUTTON_CLICKED = "onCloseClick";

        static final String FUNCTION_CLEAR = "clear";
        static final String FUNCTION_REMOVE = "remove";
    }
}
