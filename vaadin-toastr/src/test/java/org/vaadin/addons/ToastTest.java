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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ToastTest {

    @Test
    public void shouldHoldAndReturnCorrectTypes() throws Exception {
        /* Fixtures */
        final String message = "Test Message";
        final String caption = "Test Caption";
        final ToastType type = ToastType.Warning;
        final ToastOptions options = new ToastOptions();

        /* Test */
        final Toast toast = new Toast(message, caption, type, options);

        /* Assertions */
        assertThat(toast.getMessage(), is(message));
        assertThat(toast.getCaption(), is(caption));
        assertThat(toast.getType(), is(type));
        assertThat(toast.getOptions(), is(options));
    }

    @Test
    public void shouldBeAbleToPassNullValues() throws Exception {
        /* Test */
        final Toast toast = new Toast(null, null, null, null);

        /* Assertions */
        assertThat(toast, notNullValue());
        assertThat(toast.getMessage(), is(nullValue()));
        assertThat(toast.getCaption(), is(nullValue()));
        assertThat(toast.getType(), is(nullValue()));
        assertThat(toast.getOptions(), is(nullValue()));
    }

}
