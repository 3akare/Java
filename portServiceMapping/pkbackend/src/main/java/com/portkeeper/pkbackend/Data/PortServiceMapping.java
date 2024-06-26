package com.portkeeper.pkbackend.Data;

import jakarta.persistence.*;

@SuppressWarnings("unused")
@Entity
public class PortServiceMapping {
    @Id
    @SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "generator")
    @GeneratedValue(generator = "generator", strategy = GenerationType.IDENTITY)

    private Long mappingId;

    @Column(nullable = false)
    private Long servicePortNumber;

    @Column(nullable = false)
    private String associateService;

    @Column(nullable = false)
    private String serviceIpAddress;

    @Column(nullable = false)
    private String javaVersion;

    @Enumerated(EnumType.STRING)
    private PortServiceMappingStatus serviceStatus;

    public PortServiceMapping() {
    }

    public PortServiceMapping(Long servicePortNumber, String serviceIpAddress) {
        this.servicePortNumber = servicePortNumber;
        this.serviceIpAddress = serviceIpAddress;
    }

    public PortServiceMapping(Long servicePortNumber, String associateService, String serviceIpAddress,
            String javaVersion, PortServiceMappingStatus serviceStatus) {
        this.servicePortNumber = servicePortNumber;
        this.associateService = associateService;
        this.serviceIpAddress = serviceIpAddress;
        this.javaVersion = javaVersion;
        this.serviceStatus = serviceStatus;
    }

    public PortServiceMapping(Long mappingId, Long servicePortNumber, String associateService, String serviceIpAddress,
            String javaVersion, PortServiceMappingStatus serviceStatus) {
        this.mappingId = mappingId;
        this.servicePortNumber = servicePortNumber;
        this.associateService = associateService;
        this.serviceIpAddress = serviceIpAddress;
        this.javaVersion = javaVersion;
        this.serviceStatus = serviceStatus;
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

    public String getServiceIpAddress() {
        return serviceIpAddress;
    }

    public void setServiceIpAddress(String serviceIpAddress) {
        this.serviceIpAddress = serviceIpAddress;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public PortServiceMappingStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(PortServiceMappingStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    @Override
    public String toString() {
        return "PortServiceMapping{" +
                "mappingId=" + mappingId +
                ", servicePortNumber=" + servicePortNumber +
                ", associateService='" + associateService + '\'' +
                ", serviceIpAddress='" + serviceIpAddress + '\'' +
                ", javaVersion='" + javaVersion + '\'' +
                ", serviceStatus=" + serviceStatus +
                '}';
    }
}