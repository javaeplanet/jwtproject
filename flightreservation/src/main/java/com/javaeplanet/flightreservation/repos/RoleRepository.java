package com.javaeplanet.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaeplanet.flightreservation.entity.Role;

public interface RoleRepository extends JpaRepository<Role	, Long> {

}
