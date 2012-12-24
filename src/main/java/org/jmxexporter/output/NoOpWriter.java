/*
 * Copyright 2008-2012 Xebia and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmxexporter.output;

import org.jmxexporter.QueryResult;

import java.io.IOException;
import java.io.Writer;

/**
 * Used for testing.
 *
 * @author <a href="mailto:cleclerc@xebia.fr">Cyrille Le Clerc</a>
 */
public class NoOpWriter extends AbstractOutputWriter {

    static class NullWriter extends Writer {

        @Override
        public void write(char[] buffer, int off, int len) throws IOException {
        }

        @Override
        public void flush() throws IOException {
        }

        @Override
        public void close() throws IOException {
        }
    }

    private Writer out = new NullWriter();

    @Override
    public void write(Iterable<QueryResult> results) {
        for (QueryResult result : results) {
            try {
                out.write(result.toString());
            } catch (IOException e) {
                // never occurs
            }
        }
    }
}
