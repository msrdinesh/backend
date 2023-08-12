package com.example.demo;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleSheetsService {

    @Autowired
    private Sheets sheetsService; // Initialize this service using Google Sheets API setup

    public boolean addToGoogleSheets(String name, String mobile) {
        String spreadsheetId = "YOUR_SHEET_ID"; // Replace with your Google Sheets ID
        List<List<Object>> values = Collections.singletonList(
                Arrays.asList(name, mobile)
        );

        ValueRange body = new ValueRange()
                .setValues(values);

        try {
            AppendValuesResponse result = sheetsService.spreadsheets().values()
                    .append(spreadsheetId, "Sheet1", body)
                    .setValueInputOption("RAW")
                    .execute();

            return result.getUpdates().getUpdatedRows() > 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
