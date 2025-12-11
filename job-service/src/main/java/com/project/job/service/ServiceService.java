package com.project.job.service;

import com.project.base.dto.ServiceDTO;

import java.util.List;

public interface ServiceService {

    List<ServiceDTO> getServiceByName(String serviceName);

    void save(com.project.job.domain.Service service);

    void delete(com.project.job.domain.Service service);

    ServiceDTO getServiceById(Long id);

    void increaseProcessedNumber(Long id);
    void decreaseProcessedNumber(Long id);
}
