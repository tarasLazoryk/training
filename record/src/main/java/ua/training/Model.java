package ua.training;

import java.util.ArrayList;

public class Model {
	 /**
     * recordsList contains records.
     */
    private ArrayList<Record> recordsList = new ArrayList<Record>();

    /**
     * Adds a record to recordsList
     *
     * @param a record to be added.
     */
    public void addRecord(Record record) {
        recordsList.add(record);
    }

    public ArrayList<Record> getRecordsList() {
        return recordsList;
    }
}
