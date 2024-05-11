package com.portkeeper.pkbackend.Data;

import jakarta.persistence.*;

@Entity
public class PortServiceMapping {
    @Id
    @SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "generator")
    @GeneratedValue(generator = "generator", strategy = GenerationType.IDENTITY)

    private Long mappingId;

    @Column(nullable = false, unique = true)
    private Long servicePortNumber;

    @Column(nullable = false)
    private String associateService;

    public PortServiceMapping() {
    }

    public PortServiceMapping(Long servicePortNumber, String associateService) {
        this.servicePortNumber = servicePortNumber;
        this.associateService = associateService;
    }

    public PortServiceMapping(Long mappingId, Long servicePortNumber, String associateService) {
        this.mappingId = mappingId;
        this.servicePortNumber = servicePortNumber;
        this.associateService = associateService;
    }

    public Long getMappingId() {
        return mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }

    public Long getServicePortNumber() {
        return servicePortNumber;
    }

    public void setServicePortNumber(Long servicePortNumber) {
        this.servicePortNumber = servicePortNumber;
    }

    public String getAssociateService() {
        return associateService;
    }

    public void setAssociateService(String associateService) {
        this.associateService = associateService;
    }
}
