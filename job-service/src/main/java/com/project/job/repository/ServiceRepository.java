package com.project.job.repository;

import com.project.job.domain.Service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    @Query("SELECT s FROM Service s JOIN s.categories c WHERE c.categoryId =:categoryId")
    List<Service> getServiceByCategoryId(@Param("category_id") Long categoryId);

    @Query("SELECT s FROM  Service s WHERE s.serviceName =:serviceName")
    List<Service> getServiceByName(@Param("serviceName") String serviceName);

    //The query which interrupts the data such as update requires these 2 annotations
    @Transactional
    @Modifying
    @Query(value = "UPDATE Service s SET s.processedNumber = (s.processedNumber + 1) WHERE s.serviceId =:serviceId")
    void increaseProcessedNumber(@Param("serviceId") Integer serviceId, @Param("processedNumber") Integer processedNumber);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Service s SET s.processedNumber = (s.processedNumber - 1) WHERE s.serviceId =:serviceId")
    void decreaseProcessedNumber(@Param("serviceId") Integer serviceId, @Param("processedNumber") Integer processedNumber);
}
