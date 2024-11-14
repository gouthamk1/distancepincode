package com.code.distancepincode.repository;

import com.code.distancepincode.entity.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeRepository extends JpaRepository<Pincode, String> {
}
