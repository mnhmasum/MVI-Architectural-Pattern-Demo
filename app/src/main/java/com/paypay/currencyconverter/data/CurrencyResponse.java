
package com.paypay.currencyconverter.data;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "currency_base")
public class CurrencyResponse {
    @PrimaryKey(autoGenerate = false)
    public int id = 1;

    @SerializedName("disclaimer")
    private String disclaimer;
    @SerializedName("license")
    private String license;
    @SerializedName("timestamp")
    private Integer timestamp;
    @SerializedName("base")
    private String base;

    @Ignore
    @SerializedName("rates")
    public Rates rates;

    @Ignore
    public ArrayList<ExchangeRate> exchangeRateList = new ArrayList();

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public void setExchangeRateList(List<ExchangeRate> exchangeRates){
        exchangeRateList.clear();
        exchangeRateList.addAll(exchangeRates);
    }

    public List<ExchangeRate> getRateListFromAPI() {
        exchangeRateList.clear();
        exchangeRateList.add(new ExchangeRate("AED",rates.getAed()));
        exchangeRateList.add(new ExchangeRate("AFN",rates.getAfn()));
        exchangeRateList.add(new ExchangeRate("ALL",rates.getAll()));
        exchangeRateList.add(new ExchangeRate("AMD",rates.getAmd()));
        exchangeRateList.add(new ExchangeRate("ANG",rates.getAng()));
        exchangeRateList.add(new ExchangeRate("AOA",rates.getAoa()));
        exchangeRateList.add(new ExchangeRate("ARS",rates.getArs()));
        exchangeRateList.add(new ExchangeRate("AUD",rates.getAud()));
        exchangeRateList.add(new ExchangeRate("AWG",rates.getAwg()));
        exchangeRateList.add(new ExchangeRate("AZN",rates.getAzn()));
        exchangeRateList.add(new ExchangeRate("BAM",rates.getBam()));
        exchangeRateList.add(new ExchangeRate("BBD",rates.getBbd()));
        exchangeRateList.add(new ExchangeRate("BDT",rates.getBdt()));
        exchangeRateList.add(new ExchangeRate("BGN",rates.getBgn()));
        exchangeRateList.add(new ExchangeRate("BHD",rates.getBhd()));
        exchangeRateList.add(new ExchangeRate("BIF",rates.getBif()));
        exchangeRateList.add(new ExchangeRate("BMD",rates.getBmd()));
        exchangeRateList.add(new ExchangeRate("BND",rates.getBnd()));
        exchangeRateList.add(new ExchangeRate("BOB",rates.getBob()));
        exchangeRateList.add(new ExchangeRate("BRL",rates.getBrl()));
        exchangeRateList.add(new ExchangeRate("BSD",rates.getBsd()));
        exchangeRateList.add(new ExchangeRate("BTC",rates.getBtc()));
        exchangeRateList.add(new ExchangeRate("BTN",rates.getBtn()));
        exchangeRateList.add(new ExchangeRate("BWP",rates.getBwp()));
        exchangeRateList.add(new ExchangeRate("BYN",rates.getByn()));
        exchangeRateList.add(new ExchangeRate("BZD",rates.getBzd()));
        exchangeRateList.add(new ExchangeRate("CAD",rates.getCad()));
        exchangeRateList.add(new ExchangeRate("CDF",rates.getCdf()));
        exchangeRateList.add(new ExchangeRate("CHF",rates.getChf()));
        exchangeRateList.add(new ExchangeRate("CLF",rates.getClf()));
        exchangeRateList.add(new ExchangeRate("CLP",rates.getClp()));
        exchangeRateList.add(new ExchangeRate("CNH",rates.getCnh()));
        exchangeRateList.add(new ExchangeRate("CNY",rates.getCny()));
        exchangeRateList.add(new ExchangeRate("COP",rates.getCop()));
        exchangeRateList.add(new ExchangeRate("CRC",rates.getCrc()));
        exchangeRateList.add(new ExchangeRate("CUC",rates.getCuc()));
        exchangeRateList.add(new ExchangeRate("CUP",rates.getCup()));
        exchangeRateList.add(new ExchangeRate("CVE",rates.getCve()));
        exchangeRateList.add(new ExchangeRate("CZK",rates.getCzk()));
        exchangeRateList.add(new ExchangeRate("DJF",rates.getDjf()));
        exchangeRateList.add(new ExchangeRate("DKK",rates.getDkk()));
        exchangeRateList.add(new ExchangeRate("DOP",rates.getDop()));
        exchangeRateList.add(new ExchangeRate("DZD",rates.getDzd()));
        exchangeRateList.add(new ExchangeRate("EGP",rates.getEgp()));
        exchangeRateList.add(new ExchangeRate("ERN",rates.getErn()));
        exchangeRateList.add(new ExchangeRate("ETB",rates.getEtb()));
        exchangeRateList.add(new ExchangeRate("EUR",rates.getEur()));
        exchangeRateList.add(new ExchangeRate("FJD",rates.getFjd()));
        //list.add(new Rate("FKP",rates.getFkp()));
        //list.add(new Rate("GBP",rates.getGbp()));
        //list.add(new Rate("GEL",rates.getGel()));
        exchangeRateList.add(new ExchangeRate("GGP",rates.getGgp()));
        exchangeRateList.add(new ExchangeRate("GHS",rates.getGhs()));
        exchangeRateList.add(new ExchangeRate("GIP",rates.getGip()));
        exchangeRateList.add(new ExchangeRate("GMD",rates.getGmd()));
        exchangeRateList.add(new ExchangeRate("GNF",rates.getGnf()));
        exchangeRateList.add(new ExchangeRate("GTQ",rates.getGtq()));
        exchangeRateList.add(new ExchangeRate("GYD",rates.getGyd()));
        exchangeRateList.add(new ExchangeRate("HKD",rates.getHkd()));
        exchangeRateList.add(new ExchangeRate("HNL",rates.getHnl()));
        exchangeRateList.add(new ExchangeRate("HRK",rates.getHrk()));
        exchangeRateList.add(new ExchangeRate("HTG",rates.getHtg()));
        exchangeRateList.add(new ExchangeRate("HUF",rates.getHuf()));
        exchangeRateList.add(new ExchangeRate("IDR",rates.getIdr()));
        exchangeRateList.add(new ExchangeRate("ILS",rates.getIls()));
        exchangeRateList.add(new ExchangeRate("IMP",rates.getImp()));
        exchangeRateList.add(new ExchangeRate("INR",rates.getInr()));
        exchangeRateList.add(new ExchangeRate("IQD",rates.getIqd()));
        exchangeRateList.add(new ExchangeRate("IRR",rates.getIrr()));
        exchangeRateList.add(new ExchangeRate("ISK",rates.getIsk()));
        exchangeRateList.add(new ExchangeRate("JEP",rates.getJep()));
        exchangeRateList.add(new ExchangeRate("JMD",rates.getJmd()));
        exchangeRateList.add(new ExchangeRate("JOD",rates.getJod()));
        exchangeRateList.add(new ExchangeRate("JPY",rates.getJpy()));
        exchangeRateList.add(new ExchangeRate("KES",rates.getKes()));
        exchangeRateList.add(new ExchangeRate("KGS",rates.getKgs()));
        exchangeRateList.add(new ExchangeRate("KHR",rates.getKhr()));
        exchangeRateList.add(new ExchangeRate("KMF",rates.getKmf()));
        exchangeRateList.add(new ExchangeRate("KPW",rates.getKpw()));
        exchangeRateList.add(new ExchangeRate("KRW",rates.getKrw()));
        exchangeRateList.add(new ExchangeRate("KWD",rates.getKwd()));
        exchangeRateList.add(new ExchangeRate("KYD",rates.getKyd()));
        exchangeRateList.add(new ExchangeRate("KZT",rates.getKzt()));
        exchangeRateList.add(new ExchangeRate("LAK",rates.getLak()));
        exchangeRateList.add(new ExchangeRate("LBP",rates.getLbp()));
        exchangeRateList.add(new ExchangeRate("LKR",rates.getLkr()));
        exchangeRateList.add(new ExchangeRate("LRD",rates.getLrd()));
        exchangeRateList.add(new ExchangeRate("LSL",rates.getLsl()));
        exchangeRateList.add(new ExchangeRate("LYD",rates.getLyd()));
        exchangeRateList.add(new ExchangeRate("MAD",rates.getMad()));
        exchangeRateList.add(new ExchangeRate("MDL",rates.getMdl()));
        exchangeRateList.add(new ExchangeRate("MGA",rates.getMga()));
        exchangeRateList.add(new ExchangeRate("MKD",rates.getMkd()));
        exchangeRateList.add(new ExchangeRate("MMK",rates.getMmk()));
        exchangeRateList.add(new ExchangeRate("MNT",rates.getMnt()));
        exchangeRateList.add(new ExchangeRate("MOP",rates.getMop()));
        exchangeRateList.add(new ExchangeRate("MRU",rates.getMru()));
        exchangeRateList.add(new ExchangeRate("MUR",rates.getMur()));
        exchangeRateList.add(new ExchangeRate("MVR",rates.getMvr()));
        exchangeRateList.add(new ExchangeRate("MWK",rates.getMwk()));
        exchangeRateList.add(new ExchangeRate("MXN",rates.getMxn()));
        exchangeRateList.add(new ExchangeRate("MYR",rates.getMyr()));
        exchangeRateList.add(new ExchangeRate("MZN",rates.getMzn()));
        exchangeRateList.add(new ExchangeRate("NAD",rates.getNad()));
        exchangeRateList.add(new ExchangeRate("NGN",rates.getNgn()));
        exchangeRateList.add(new ExchangeRate("NIO",rates.getNio()));
        exchangeRateList.add(new ExchangeRate("NOK",rates.getNok()));
        exchangeRateList.add(new ExchangeRate("NPR",rates.getNpr()));
        exchangeRateList.add(new ExchangeRate("NZD",rates.getNzd()));
        exchangeRateList.add(new ExchangeRate("OMR",rates.getOmr()));
        exchangeRateList.add(new ExchangeRate("PAB",rates.getPab()));
        exchangeRateList.add(new ExchangeRate("PEN",rates.getPen()));
        exchangeRateList.add(new ExchangeRate("PGK",rates.getPgk()));
        exchangeRateList.add(new ExchangeRate("PHP",rates.getPhp()));
        exchangeRateList.add(new ExchangeRate("PKR",rates.getPkr()));
        exchangeRateList.add(new ExchangeRate("PLN",rates.getPln()));
        exchangeRateList.add(new ExchangeRate("PYG",rates.getPyg()));
        exchangeRateList.add(new ExchangeRate("QAR",rates.getQar()));
        exchangeRateList.add(new ExchangeRate("RON",rates.getRon()));
        exchangeRateList.add(new ExchangeRate("RSD",rates.getRsd()));
        exchangeRateList.add(new ExchangeRate("RUB",rates.getRub()));
        exchangeRateList.add(new ExchangeRate("RWF",rates.getRwf()));
        exchangeRateList.add(new ExchangeRate("SAR",rates.getSar()));
        exchangeRateList.add(new ExchangeRate("SBD",rates.getSbd()));
        exchangeRateList.add(new ExchangeRate("SCR",rates.getScr()));
        exchangeRateList.add(new ExchangeRate("SDG",rates.getSdg()));
        exchangeRateList.add(new ExchangeRate("SEK",rates.getSek()));
        exchangeRateList.add(new ExchangeRate("SGD",rates.getSgd()));
        exchangeRateList.add(new ExchangeRate("SHP",rates.getShp()));
        exchangeRateList.add(new ExchangeRate("SLL",rates.getSll()));
        exchangeRateList.add(new ExchangeRate("SOS",rates.getSos()));
        exchangeRateList.add(new ExchangeRate("SRD",rates.getSrd()));
        exchangeRateList.add(new ExchangeRate("SSP",rates.getSsp()));
        exchangeRateList.add(new ExchangeRate("STD",rates.getStd()));
        exchangeRateList.add(new ExchangeRate("ST",rates.getStn()));
        exchangeRateList.add(new ExchangeRate("SVC",rates.getSvc()));
        exchangeRateList.add(new ExchangeRate("SYP",rates.getSyp()));
        exchangeRateList.add(new ExchangeRate("SZL",rates.getSzl()));
        exchangeRateList.add(new ExchangeRate("THB",rates.getThb()));
        exchangeRateList.add(new ExchangeRate("TJS",rates.getTjs()));
        exchangeRateList.add(new ExchangeRate("TMT",rates.getTmt()));
        exchangeRateList.add(new ExchangeRate("TND",rates.getTnd()));
        exchangeRateList.add(new ExchangeRate("TOP",rates.getTop()));
        exchangeRateList.add(new ExchangeRate("TRY",rates.getTry()));
        exchangeRateList.add(new ExchangeRate("TD",rates.getTtd()));
        exchangeRateList.add(new ExchangeRate("TWD",rates.getTwd()));
        exchangeRateList.add(new ExchangeRate("TZS",rates.getTzs()));
        exchangeRateList.add(new ExchangeRate("UAH",rates.getUah()));
        exchangeRateList.add(new ExchangeRate("UGX",rates.getUgx()));
        exchangeRateList.add(new ExchangeRate("USD",rates.getUsd()));
        exchangeRateList.add(new ExchangeRate("UYU",rates.getUyu()));
        exchangeRateList.add(new ExchangeRate("UZS",rates.getUzs()));
        exchangeRateList.add(new ExchangeRate("VES",rates.getVes()));
        exchangeRateList.add(new ExchangeRate("VND",rates.getVnd()));
        exchangeRateList.add(new ExchangeRate("VUV",rates.getVuv()));
        exchangeRateList.add(new ExchangeRate("WST",rates.getWst()));
        exchangeRateList.add(new ExchangeRate("XAF",rates.getXaf()));
        exchangeRateList.add(new ExchangeRate("XAG",rates.getXag()));
        exchangeRateList.add(new ExchangeRate("XAU",rates.getXau()));
        exchangeRateList.add(new ExchangeRate("XCD",rates.getXcd()));
        exchangeRateList.add(new ExchangeRate("XDR",rates.getXdr()));
        exchangeRateList.add(new ExchangeRate("XOF",rates.getXof()));
        exchangeRateList.add(new ExchangeRate("XPD",rates.getXpd()));
        exchangeRateList.add(new ExchangeRate("XPF",rates.getXpf()));
        exchangeRateList.add(new ExchangeRate("XPT",rates.getXpt()));
        exchangeRateList.add(new ExchangeRate("YER",rates.getYer()));
        exchangeRateList.add(new ExchangeRate("ZAR",rates.getZar()));
        exchangeRateList.add(new ExchangeRate("ZMW",rates.getZmw()));
        exchangeRateList.add(new ExchangeRate("ZWL",rates.getZwl()));
        return exchangeRateList;
    }

}
