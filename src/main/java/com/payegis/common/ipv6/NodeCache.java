package com.payegis.common.ipv6;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface NodeCache {

    interface Loader {
        JsonNode load(int key) throws IOException;
    }

    JsonNode get(int key, Loader loader) throws IOException;

}
