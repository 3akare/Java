package com.portkeeper.pkbackend.Data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortDataRepository extends JpaRepository<PortData,Long> {
    PortData findByPortNumber(Long portNumber);
}
