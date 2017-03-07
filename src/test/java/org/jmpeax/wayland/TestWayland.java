package org.jmpeax.wayland;

import com.jmpeax.wayland.Wayland;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.*;
import java.net.URISyntaxException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by cortiz on 3/6/17.
 */

public class TestWayland {

    @Test
    public void testOK() throws ScriptException, IOException, URISyntaxException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Wayland.main(null);
        assertFalse(StringUtils.isBlank(out.toString()));
    }
}
