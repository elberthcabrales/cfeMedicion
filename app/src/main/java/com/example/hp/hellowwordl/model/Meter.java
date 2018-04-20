package com.example.hp.hellowwordl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Meter {
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String code;

    @DatabaseField
    private String angle;

    @DatabaseField
    private String powerFactory;

    @DatabaseField
    private String timeRevKwh;

    @DatabaseField
    private String timeRehKvarh;

    @DatabaseField
    private String kh;

    @DatabaseField
    private String rtp;

    @DatabaseField
    private String rtc;

    @DatabaseField
    private String kvaCron;

    @DatabaseField
    private String kvaReales;

    @DatabaseField
    private String efficiency;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getPowerFactory() {
        return powerFactory;
    }

    public void setPowerFactory(String powerFactory) {
        this.powerFactory = powerFactory;
    }

    public String getTimeRevKwh() {
        return timeRevKwh;
    }

    public void setTimeRevKwh(String timeRevKwh) {
        this.timeRevKwh = timeRevKwh;
    }

    public String getTimeRehKvarh() {
        return timeRehKvarh;
    }

    public void setTimeRehKvarh(String timeRehKvarh) {
        this.timeRehKvarh = timeRehKvarh;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getRtp() {
        return rtp;
    }

    public void setRtp(String rtp) {
        this.rtp = rtp;
    }

    public String getRtc() {
        return rtc;
    }

    public void setRtc(String rtc) {
        this.rtc = rtc;
    }

    public String getKvaCron() {
        return kvaCron;
    }

    public void setKvaCron(String kvaCron) {
        this.kvaCron = kvaCron;
    }

    public String getKvaReales() {
        return kvaReales;
    }

    public void setKvaReales(String kvaReales) {
        this.kvaReales = kvaReales;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
