package utils;

import java.util.List;

public interface BaseTable {
    public int getRowCount();
    public int getColumnCount();
    public int getColumnIndex(String columnHeader);
    public int getColumnNumber(String columnHeader);
    public int getRowIndex(String text);
    public int getRowNumber(String text);
    public List<String> getColumnHeaders();
    public List<String> getRowContent(int rowNumber);
    public List<String> getColumnContent(int columnNumber);
    public List<String> getColumnContent(String columnName);
    public String getCellContent(int rowNumber, int columnNumber);
    public String getCellContent(int rowNumber, String columnName);
}
