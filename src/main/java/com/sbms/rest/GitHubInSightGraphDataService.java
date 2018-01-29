package com.sbms.rest;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.sbms.dto.CommitJSON;

/**
 * REST Controller which retrieves data used in the chart.
 */
@RestController
@RequestMapping("/getChart")
public class GitHubInSightGraphDataService {

	private static final Logger log = LoggerFactory.getLogger(GitHubInSightGraphDataService.class);

    @RequestMapping(value = "/chartdata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getChartData() {
        
        RestTemplate restTemplate = new RestTemplate();
        
		CommitJSON[] commitJSONObj = restTemplate.getForObject("https://api.github.com/repos/skylot/jadx/stats/commit_activity", CommitJSON[].class);
		log.info("CommitJSON:"+ Arrays.toString(commitJSONObj));
		
		return ResponseEntity.ok(commitJSONObj);
		
    }
}
