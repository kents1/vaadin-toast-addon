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

public class ToastDisplayMethodTest {

    @Test
    public void shouldFindFadeInToastDisplayByString() throws Exception {
        final Optional<ToastDisplayMethod> toastDisplayMethodOpt = ToastDisplayMethod.find("fadeIn");
        assertThat(toastDisplayMethodOpt.isPresent(), is(true));
        assertThat(toastDisplayMethodOpt.get(), is(ToastDisplayMethod.FadeIn));
    }

    @Test
    public void shouldFindFadeOutToastDisplayByString() throws Exception {
        final Optional<ToastDisplayMethod> toastDisplayMethodOpt = ToastDisplayMethod.find("fadeOut");
        assertThat(toastDisplayMethodOpt.isPresent(), is(true));
        assertThat(toastDisplayMethodOpt.get(), is(ToastDisplayMethod.FadeOut));
    }

    @Test
    public void shouldFindSlideDownToastDisplayByString() throws Exception {
        final Optional<ToastDisplayMethod> toastDisplayMethodOpt = ToastDisplayMethod.find("slideDown");
        assertThat(toastDisplayMethodOpt.isPresent(), is(true));
        assertThat(toastDisplayMethodOpt.get(), is(ToastDisplayMethod.SlideDown));
    }

    @Test
    public void shouldFindSlideUpToastDisplayByString() throws Exception {
        final Optional<ToastDisplayMethod> toastDisplayMethodOpt = ToastDisplayMethod.find("slideUp");
        assertThat(toastDisplayMethodOpt.isPresent(), is(true));
        assertThat(toastDisplayMethodOpt.get(), is(ToastDisplayMethod.SlideUp));
    }

    @Test
    public void shouldReturnEmptyWhenNullValuePassed() throws Exception {
        final Optional<ToastDisplayMethod> toastDisplayMethodOpt = ToastDisplayMethod.find(null);
        assertThat(toastDisplayMethodOpt.isPresent(), is(false));
    }

    @Test
    public void shouldReturnEmptyWhenUnknownValuePassed() throws Exception {
        final Optional<ToastDisplayMethod> toastDisplayMethodOpt = ToastDisplayMethod.find("non-existing-value");
        assertThat(toastDisplayMethodOpt.isPresent(), is(false));
    }

}
