package playground.java;

import java.io.File;

/**
 *
 */
public class StbLib {

    public File apply() {
        File file = new File("some/path");
        file.mkdir();
        return file;
    }

}
