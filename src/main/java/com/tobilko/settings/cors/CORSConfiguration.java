package com.tobilko.settings.cors;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class CORSConfiguration implements Configuration {

    private boolean enabled;

    private Map<Boolean, List<URL>> urls;

}
