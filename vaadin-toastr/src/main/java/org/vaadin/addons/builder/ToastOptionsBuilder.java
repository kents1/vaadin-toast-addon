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

import org.vaadin.addons.ToastDisplayMethod;
import org.vaadin.addons.ToastEasing;
import org.vaadin.addons.ToastOptions;
import org.vaadin.addons.ToastPosition;

public class ToastOptionsBuilder {

    private ToastOptions toastOptions;

    private ToastOptionsBuilder() {
        super();
        this.toastOptions = new ToastOptions();
    }

    public static ToastOptionsBuilder having() {
        return new ToastOptionsBuilder();
    }

    public ToastOptionsBuilder position(final ToastPosition position) {
        this.toastOptions.setToastPosition(position);
        return this;
    }

    public ToastOptionsBuilder debug(boolean debug) {
        this.toastOptions.setDebug(debug);
        return this;
    }

    public ToastOptionsBuilder newestOnTop(boolean newestOnTop) {
        this.toastOptions.setNewestOnTop(newestOnTop);
        return this;
    }

    public ToastOptionsBuilder closeButton(boolean closeButton) {
        this.toastOptions.setCloseButton(closeButton);
        return this;
    }

    public ToastOptionsBuilder progressBar(boolean progressBar) {
        this.toastOptions.setProgressBar(progressBar);
        return this;
    }

    public ToastOptionsBuilder tapToDismiss(boolean tapToDismiss) {
        this.toastOptions.setTapToDismiss(tapToDismiss);
        return this;
    }

    public ToastOptionsBuilder preventDuplicates(boolean preventDuplicates) {
        this.toastOptions.setPreventDuplicates(preventDuplicates);
        return this;
    }

    public ToastOptionsBuilder showDuration(Integer showDurationMs) {
        this.toastOptions.setShowDuration(showDurationMs);
        return this;
    }

    public ToastOptionsBuilder hideDuration(Integer hideDurationMs) {
        this.toastOptions.setHideDuration(hideDurationMs);
        return this;
    }

    public ToastOptionsBuilder timeOut(Integer timeOutMs) {
        this.toastOptions.setTimeOut(timeOutMs);
        return this;
    }

    public ToastOptionsBuilder rightToLeft(boolean rtl) {
        this.toastOptions.setRightToLeft(rtl);
        return this;
    }

    public ToastOptionsBuilder extendedTimeOut(Integer extendedTimeOutMs) {
        this.toastOptions.setExtendedTimeOut(extendedTimeOutMs);
        return this;
    }

    public ToastOptionsBuilder showEasing(ToastEasing easing) {
        this.toastOptions.setShowEasing(easing);
        return this;
    }

    public ToastOptionsBuilder hideEasing(ToastEasing easing) {
        this.toastOptions.setHideEasing(easing);
        return this;
    }

    public ToastOptionsBuilder showMethod(ToastDisplayMethod method) {
        this.toastOptions.setShowMethod(method);
        return this;
    }

    public ToastOptionsBuilder hideMethod(ToastDisplayMethod method) {
        this.toastOptions.setHideMethod(method);
        return this;
    }

    public ToastOptions build() {
        return toastOptions;
    }

}
