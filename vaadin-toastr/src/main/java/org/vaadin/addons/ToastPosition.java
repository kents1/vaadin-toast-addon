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

import java.util.Optional;

import static java.util.Arrays.stream;

public enum ToastPosition {

    Top_Right("toast-top-right"),
    Bottom_Right("toast-bottom-right"),
    Bottom_Left("toast-bottom-left"),
    Top_Left("toast-top-left"),
    Top_Full_Width("toast-top-full-width"),
    Bottom_Full_Width("toast-bottom-full-width"),
    Top_Center("toast-top-center"),
    Bottom_Center("toast-bottom-center");

    private String toastPosition;

    ToastPosition(final String toastPosition) {
        this.toastPosition = toastPosition;
    }

    String position() {
        return toastPosition;
    }

    public static Optional<ToastPosition> find(final String toastPosition) {
        if (toastPosition == null)
            return Optional.empty();
        return stream(ToastPosition.values()).filter(t -> t.position().equals(toastPosition)).findFirst();
    }

}
