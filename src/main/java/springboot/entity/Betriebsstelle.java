package springboot.entity;

import java.util.Objects;

public class Betriebsstelle {

    private String plc, rlCode, longName, shortName, type, typeLong, status, dateFrom, dateUntil, branch, region, latestChange;

    public Betriebsstelle(String[] csvValues) throws CsvReaderException {
        if (csvValues.length != 12) {
            throw new CsvReaderException("CsvReaderException: there must be 12 csvValues but " + csvValues.length + " where given");
        }
        this.plc = csvValues[0];
        this.rlCode = csvValues[1].toLowerCase();
        this.longName = csvValues[2];
        this.shortName = csvValues[3];
        this.type = csvValues[4];
        this.typeLong = csvValues[5];
        this.status = csvValues[6];
        this.dateFrom = csvValues[7];
        this.dateUntil = csvValues[8];
        this.branch = csvValues[9];
        this.region = csvValues[10];
        this.latestChange = csvValues[11];
    }

    public String toJson() {
        return "{\n" +
                "\"Name\": \"" + longName + "\",\n\n" +
                "\"Kurzname\": \"" + shortName + "\",\n\n" +
                "\"Typ\": \"" + typeLong + "\"\n}";
    }

    public String getPlc() {
        return plc;
    }

    public void setPlc(String plc) {
        this.plc = plc;
    }

    public String getRlCode() {
        return rlCode;
    }

    public void setRlCode(String rlCode) {
        this.rlCode = rlCode;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeLong() {
        return typeLong;
    }

    public void setTypeLong(String typeLong) {
        this.typeLong = typeLong;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(String dateUntil) {
        this.dateUntil = dateUntil;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLatestChange() {
        return latestChange;
    }

    public void setLatestChange(String latestChange) {
        this.latestChange = latestChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Betriebsstelle that = (Betriebsstelle) o;

        return Objects.equals(rlCode, that.rlCode);
    }

    @Override
    public int hashCode() {
        return rlCode != null ? rlCode.hashCode() : 0;
    }
}