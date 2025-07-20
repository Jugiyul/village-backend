package com.jugiyul.village.typetest.domain;

import com.jugiyul.village.typetest.domain.enums.Browser;
import com.jugiyul.village.typetest.domain.enums.DeviceType;
import com.jugiyul.village.typetest.domain.enums.OS;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "typetest_sessions")
public class TestSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sessionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type", nullable = false, length = 30)
    private DeviceType deviceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "os", nullable = false, length = 30)
    private OS os;

    @Enumerated(EnumType.STRING)
    @Column(name = "browser", nullable = false, length = 30)
    private Browser browser;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String refererUrl;

    @CreatedDate
    @Column(name = "started_at",
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime startedAt;
}
