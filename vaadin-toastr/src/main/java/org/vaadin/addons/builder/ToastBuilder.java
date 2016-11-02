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
package org.vaadin.addons.builder;

import org.vaadin.addons.Toast;
import org.vaadin.addons.ToastOptions;
import org.vaadin.addons.ToastPosition;
import org.vaadin.addons.ToastType;

public final class ToastBuilder {

    private String message;
    private String caption;
    private ToastType toastType;
    private ToastOptions toastOptions;

    private ToastBuilder(final ToastType type, final String message) {
        this.toastType = type;
        this.message = message;
        this.toastOptions = new ToastOptions();
    }

    public static ToastBuilder of(final ToastType toastType, final String message) {
        return new ToastBuilder(toastType, message);
    }

    public static ToastBuilder warning(final String message) {
        return new ToastBuilder(ToastType.Warning, message);
    }

    public static ToastBuilder info(final String message) {
        return new ToastBuilder(ToastType.Info, message);
    }

    public static ToastBuilder error(final String message) {
        return new ToastBuilder(ToastType.Error, message);
    }

    public static ToastBuilder success(final String message) {
        return new ToastBuilder(ToastType.Success, message);
    }

    public ToastBuilder caption(final String caption) {
        this.caption = caption;
        return this;
    }

    public ToastBuilder options(final ToastOptions options) {
        this.toastOptions = options;
        return this;
    }

    public Toast build() {
        return new Toast(message, caption, toastType, toastOptions);
    }

}
