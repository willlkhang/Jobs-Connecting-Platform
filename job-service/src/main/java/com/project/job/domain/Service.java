package com.project.job.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "user_id")
    private Long userId;


}
