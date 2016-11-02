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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static org.vaadin.addons.ToastPosition.find;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToastOptions {

    @JsonProperty("positionClass") private String toastPosition;
    private boolean debug;
    private boolean newestOnTop;
    private boolean closeButton;
    private boolean progressBar;
    private boolean preventDuplicates;
    private boolean tapToDismiss;
    @JsonProperty("rtl") private boolean rightToLeft;
    private String showDuration;
    private String hideDuration;
    private String timeOut;
    private String extendedTimeOut;
    private String showEasing;
    private String hideEasing;
    private String showMethod;
    private String hideMethod;

    public void setToastPosition(final ToastPosition toastPosition) {
        this.toastPosition = toastPosition.position();
    }

    public ToastPosition getToastPosition() {
        return find(toastPosition).orElse(ToastPosition.Top_Right);
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isNewestOnTop() {
        return newestOnTop;
    }

    public void setNewestOnTop(boolean newestOnTop) {
        this.newestOnTop = newestOnTop;
    }

    public boolean isCloseButton() {
        return closeButton;
    }

    public void setCloseButton(boolean closeButton) {
        this.closeButton = closeButton;
    }

    public boolean isProgressBar() {
        return progressBar;
    }

    public void setProgressBar(boolean progressBar) {
        this.progressBar = progressBar;
    }

    public boolean isPreventDuplicates() {
        return preventDuplicates;
    }

    public void setPreventDuplicates(boolean preventDuplicates) {
        this.preventDuplicates = preventDuplicates;
    }

    public boolean isTapToDismiss() {
        return tapToDismiss;
    }

    public void setTapToDismiss(boolean tapToDismiss) {
        this.tapToDismiss = tapToDismiss;
    }

    public boolean isRightToLeft() {
        return rightToLeft;
    }

    public void setRightToLeft(boolean rightToLeft) {
        this.rightToLeft = rightToLeft;
    }

    public Integer getShowDuration() {
        if (showDuration == null)
            return null;
        return Integer.valueOf(showDuration);
    }

    public void setShowDuration(Integer showDurationMs) {
        this.showDuration = String.valueOf(showDuration);
    }

    public Integer getHideDuration() {
        if (hideDuration == null)
            return null;
        return Integer.valueOf(hideDuration);
    }

    public void setHideDuration(Integer hideDuration) {
        this.hideDuration = String.valueOf(hideDuration);
    }

    public Integer getTimeOut() {
        if (timeOut == null)
            return null;
        return Integer.valueOf(timeOut);
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = String.valueOf(timeOut);
    }

    public Integer getExtendedTimeOut() {
        if (extendedTimeOut == null)
            return null;
        return Integer.valueOf(extendedTimeOut);
    }

    public void setExtendedTimeOut(Integer extendedTimeOut) {
        this.extendedTimeOut = String.valueOf(extendedTimeOut);
    }

    public ToastEasing getShowEasing() {
        return ToastEasing.valueOf(showEasing);
    }

    public void setShowEasing(final ToastEasing showEasing) {
        this.showEasing = showEasing.name().toLowerCase();
    }

    public ToastEasing getHideEasing() {
        return ToastEasing.valueOf(hideEasing);
    }

    public void setHideEasing(final ToastEasing hideEasing) {
        this.hideEasing = hideEasing.name().toLowerCase();
    }

    public ToastDisplayMethod getShowMethod() {
        return ToastDisplayMethod.find(showMethod).orElse(null);
    }

    public void setShowMethod(ToastDisplayMethod showMethod) {
        this.showMethod = showMethod.method();
    }

    public ToastDisplayMethod getHideMethod() {
        return ToastDisplayMethod.find(hideMethod).orElse(null);
    }

    public void setHideMethod(ToastDisplayMethod hideMethod) {
        this.hideMethod = hideMethod.method();
    }

}