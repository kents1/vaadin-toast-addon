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

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ToastEasingTest {

    @Test
    public void shouldFindLinearToastEasingByString() throws Exception {
        final Optional<ToastEasing> toastEasingOpt = ToastEasing.find("linear");
        assertThat(toastEasingOpt.isPresent(), is(true));
        assertThat(toastEasingOpt.get(), is(ToastEasing.Linear));
    }

    @Test
    public void shouldFindSwingToastEasingByString() throws Exception {
        final Optional<ToastEasing> toastEasingOpt = ToastEasing.find("swing");
        assertThat(toastEasingOpt.isPresent(), is(true));
        assertThat(toastEasingOpt.get(), is(ToastEasing.Swing));
    }

    @Test
    public void shouldFindEaseOutBounceToastEasingByString() throws Exception {
        final Optional<ToastEasing> toastEasingOpt = ToastEasing.find("easeoutbounce");
        assertThat(toastEasingOpt.isPresent(), is(true));
        assertThat(toastEasingOpt.get(), is(ToastEasing.EaseOutBounce));
    }

    @Test
    public void shouldFindEaseInBackToastEasingByString() throws Exception {
        final Optional<ToastEasing> toastEasingOpt = ToastEasing.find("easeinback");
        assertThat(toastEasingOpt.isPresent(), is(true));
        assertThat(toastEasingOpt.get(), is(ToastEasing.EaseInBack));
    }

    @Test
    public void shouldReturnEmptyWhenNullValuePassed() throws Exception {
        final Optional<ToastEasing> toastEasingOpt = ToastEasing.find(null);
        assertThat(toastEasingOpt.isPresent(), is(false));
    }

    @Test
    public void shouldReturnEmptyWhenUnknownValuePassed() throws Exception {
        final Optional<ToastEasing> toastEasingOpt = ToastEasing.find("non-existing-value");
        assertThat(toastEasingOpt.isPresent(), is(false));
    }

}
