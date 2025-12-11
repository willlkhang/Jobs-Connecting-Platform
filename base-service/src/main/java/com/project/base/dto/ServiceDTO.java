package com.project.base.dto;

public class ServiceDTO {

    private Long serviceId;
    private String serviceName;
    private String description;
    private Integer processedNumber;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProcessedNumber() {
        return processedNumber;
    }

    public void setProcessedNumber(Integer processedNumber) {
        this.processedNumber = processedNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
