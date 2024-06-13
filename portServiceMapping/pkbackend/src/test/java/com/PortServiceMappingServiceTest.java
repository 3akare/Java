package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.portkeeper.pkbackend.Data.PortServiceMapping;
import com.portkeeper.pkbackend.Data.PortServiceMappingRepository;
import com.portkeeper.pkbackend.Data.PortServiceMappingService;
import com.portkeeper.pkbackend.Data.PortServiceMappingStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PortServiceMappingServiceTest {

    @Mock
    private PortServiceMappingRepository portServiceMappingRepository;

    @InjectMocks
    private PortServiceMappingService portServiceMappingService;

    @Test
    public void getAllPortsTest() throws Exception {
        when(portServiceMappingRepository.findAll()).thenReturn(Arrays.asList(
                new PortServiceMapping(8080L, "service-name-1", "IpAddress-1","Java Version-1", PortServiceMappingStatus.INACTIVE),
                new PortServiceMapping(8081L, "service-name-2", "IpAddress-2", "Java Version-2", PortServiceMappingStatus.ACTIVE
                )));

        List<PortServiceMapping> portServiceMapping = portServiceMappingService.getPortMappings();
        assertNotNull(portServiceMapping);
        assertEquals(2, portServiceMapping.size());
        assertEquals("IpAddress-1", portServiceMapping.get(0).getServiceIpAddress());
        assertEquals("service-name-1", portServiceMapping.get(0).getAssociateService());
        assertEquals("IpAddress-2", portServiceMapping.get(1).getServiceIpAddress());
        assertEquals("service-name-2", portServiceMapping.get(1).getAssociateService());

        verify(portServiceMappingRepository).findAll();
    }

    @Test
    public void postPortsTest() throws Exception{
        PortServiceMapping portServiceMapping = new PortServiceMapping(8080L, "service-name-1", "IpAddress-1","Java Version-1", PortServiceMappingStatus.INACTIVE);
        when(portServiceMappingRepository.save(portServiceMapping)).thenReturn(new PortServiceMapping(8080L, "service-name-1", "IpAddress-1","Java Version-1", PortServiceMappingStatus.INACTIVE));
        PortServiceMapping portServiceMapping1 = portServiceMappingService.createPortMapping(portServiceMapping);

        assertNotNull(portServiceMapping1);
        assertEquals(8080L, portServiceMapping1.getServicePortNumber());
        verify(portServiceMappingRepository, times(1)).save(portServiceMapping);
    }
}
