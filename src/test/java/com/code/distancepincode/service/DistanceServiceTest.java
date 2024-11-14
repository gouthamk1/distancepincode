package com.code.distancepincode.service;

import com.code.distancepincode.entity.DistanceInfo;
import com.code.distancepincode.repository.DistanceInfoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DistanceServiceTest {

    @InjectMocks
    private DistanceService distanceService;

    @Mock
    private DistanceInfoRepository distanceInfoRepository;

    public DistanceServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDistanceAndDuration_Cached() {
        // Setup mock behavior
        DistanceInfo cachedInfo = new DistanceInfo();
        cachedInfo.setDistance("10 km");
        cachedInfo.setDuration("30 mins");
        when(distanceInfoRepository.findByFromPincodeAndToPincode("141106", "110060")).thenReturn(cachedInfo);

        // Call the service method
        DistanceInfo result = distanceService.getDistanceAndDuration("141106", "110060");

        // Verify the result
        assertEquals("10 km", result.getDistance());
        assertEquals("30 mins", result.getDuration());
        verify(distanceInfoRepository, times(1)).findByFromPincodeAndToPincode("141106", "110060");
    }
}
