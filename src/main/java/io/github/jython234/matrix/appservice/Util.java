/*
 * Copyright © 2018, jython234
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package io.github.jython234.matrix.appservice;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;

/**
 * Misc. Utility methods used by the appservice.
 *
 * @author jython234
 */
public class Util {
    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    /**
     * Copies a "resource" file from the JAR or resource folder to
     * the filesystem.
     * @param resource The resource file name.
     * @param copyLocation The location to copy the resource to on the
     *                     filesystem.
     * @throws IOException If there is an exception while attempting to
     *                     copy the file.
     */
    public static void copyResourceTo(String resource, File copyLocation) throws IOException {
        var in = resourceLoader.getResource(resource).getInputStream();
        FileUtils.copyInputStreamToFile(in, copyLocation);
    }

    /**
     * Get an alias's localpart from the full alias.
     *
     * ex. <code>@fakeuser:fakedomain.net</code> would return <code>fakeuser</code>
     * @param aliasFull The full alias of the room or user.
     * @return The localpart of the room or user.
     */
    public static String getLocalpart(String aliasFull) {
        var localpart = aliasFull.split(":")[0]; // Get rid of domain
        return localpart.substring(1, localpart.length()); // Remove @ from beginning
    }
}
