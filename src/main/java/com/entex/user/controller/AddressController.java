package com.entex.user.controller;

import com.entex.user.model.County;
import com.entex.user.model.Locality;
import com.entex.user.repository.CountyRepository;
import com.entex.user.repository.LocalityRepository;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    CountyRepository countyService;

    @Autowired
    LocalityRepository localityService;

    @PostMapping("/upload_county")
    public String uploadCounty(@RequestParam("file")MultipartFile file) throws Exception{
        List<County> countyList  = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            County county = new County();
            county.setIdCounty(Long.valueOf(record.getString("id_county")));
            county.setCountyName(record.getString("county_name"));
            county.setCountyCode(record.getString("county_code"));
            countyList.add(county);
        });
        countyService.saveAll(countyList);
        return "Upload Successful";
    }

    @PostMapping("/upload_locality")
    public String uploadLocality(@RequestParam("file")MultipartFile file) throws Exception{
        List<Locality> localityList  = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            County myCounty = new County();
            Locality locality = new Locality();
            locality.setId(Long.valueOf(record.getString("id")));
            locality.setLocalityName(record.getString("locality_name"));
            myCounty= countyService.findByCountyCode(record.getString("county_code"));
            locality.setCountyCode(myCounty);
            localityList.add(locality);
        });
        localityService.saveAll(localityList);
        return "Upload Successful";
    }
}
