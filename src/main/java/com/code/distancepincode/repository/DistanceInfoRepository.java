package com.code.distancepincode.repository;

import com.code.distancepincode.entity.DistanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanceInfoRepository extends JpaRepository<DistanceInfo, Long> {
    DistanceInfo findByFromPincodeAndToPincode(String fromPincode, String toPincode);
}
