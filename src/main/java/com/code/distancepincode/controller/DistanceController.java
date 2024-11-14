package com.code.distancepincode.controller;

import com.code.distancepincode.entity.DistanceInfo;
import com.code.distancepincode.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/distance")
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @GetMapping
    public ResponseEntity<DistanceInfo> getDistance(
            @RequestParam String fromPincode,
            @RequestParam String toPincode) {
        DistanceInfo distanceInfo = distanceService.getDistanceAndDuration(fromPincode, toPincode);
        if (distanceInfo != null) {
            return ResponseEntity.ok(distanceInfo);
        }
        return ResponseEntity.notFound().build();
    }


}