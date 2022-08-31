package edu.eci.arep.http;

import java.io.IOException;

public interface AlphAPI {
    String getAlphaReportWithDate(String symbol, String date) throws IOException;
    String getAlphaAPIData(String symbol) throws IOException;
}
