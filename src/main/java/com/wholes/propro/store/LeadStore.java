package com.wholes.propro.store;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class LeadStore {

    public static class Lead {
        private final Long id;
        private final String name;
        private final String email;
        private final String phone;
        private final String service;
        private final String message;
        private final Instant createdAt;

        public Lead(Long id, String name, String email, String phone,
                    String service, String message, Instant createdAt) {
            this.id = id; this.name = name; this.email = email;
            this.phone = phone; this.service = service;
            this.message = message; this.createdAt = createdAt;
        }
        public Long getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
        public String getService() { return service; }
        public String getMessage() { return message; }
        public Instant getCreatedAt() { return createdAt; }
    }

    private final Map<Long, Lead> data = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public Lead save(String name, String email, String phone, String service, String message) {
        Long id = seq.getAndIncrement();
        Lead lead = new Lead(id, name, email, phone, service, message, Instant.now());
        data.put(id, lead);
        return lead;
    }

    public List<Lead> findAll() {
        return data.values().stream()
            .sorted(Comparator.comparing(Lead::getCreatedAt).reversed())
            .toList();
    }
}