package com.fields.fields_report.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProtoDocument {

    @Id
    private UUID id = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtoDocument protoDocument = (ProtoDocument) o;
        return Objects.equals(id, protoDocument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}