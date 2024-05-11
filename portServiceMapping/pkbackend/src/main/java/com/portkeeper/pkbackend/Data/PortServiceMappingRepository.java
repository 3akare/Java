package com.portkeeper.pkbackend.Data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortServiceMappingRepository extends JpaRepository<PortServiceMapping,Long> {
    PortServiceMapping findPortMappingByServicePortNumber(Long ServicePortNumber);
}
