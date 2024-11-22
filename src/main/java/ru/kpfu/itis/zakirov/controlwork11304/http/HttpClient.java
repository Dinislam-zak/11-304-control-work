package ru.kpfu.itis.zakirov.controlwork11304.http;

import java.io.IOException;
import java.util.Map;

public interface HttpClient {
    String get(String url, Map<String, String> headers, Map<String, String> params);
    String post(String url, Map<String, String> headers, Map<String, String> data) throws IOException;
    String put(String url, Map<String, String> headers, Map<String, String> data) throws IOException;
    String delete(String url, Map<String, String> headers, Map<String, String> data) throws IOException;
}