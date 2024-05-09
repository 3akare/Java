package com.portkeeper.pkbackend.Data;

import jakarta.persistence.*;

@Entity
public class PortData {
    @Id
    @SequenceGenerator(name = "sequence_generator", allocationSize = 1, sequenceName = "sequence_generator")
    @GeneratedValue(generator = "sequence_generator", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String portService;

    @Column( nullable = false, unique = true)
    private Long portNumber;

    public PortData(String portService, Long portNumber) {
        this.portService = portService;
        this.portNumber = portNumber;
    }

    public PortData(Long id, String portService, Long portNumber) {
        this.id = id;
        this.portService = portService;
        this.portNumber = portNumber;
    }

    public PortData(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortService() {
        return portService;
    }

    public void setPortService(String portService) {
        this.portService = portService;
    }

    public Long getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Long portNumber) {
        this.portNumber = portNumber;
    }
}
