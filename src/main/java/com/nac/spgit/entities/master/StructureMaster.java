package com.nac.spgit.entities.master;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nac.spgit.beans.Structure;
import com.nac.spgit.exception.InvalidInputException;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "structure_master")
@Slf4j
public class StructureMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description")
    private String description;

    public StructureMaster() {
    }

    @JsonIgnore
    public static StructureMasterBuilder builder(Structure structure) {
        return new StructureMasterBuilder(structure);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class StructureMasterBuilder {

        private final long id;
        private final String description;

        private StructureMasterBuilder(Structure structure) {
            if (structure == null) {
                String message = "Missing information structure " + null;
                log.error(message);
                throw new InvalidInputException(message);
            }

            if (structure.getDescription() == null || structure.getDescription().isEmpty()) {
                String message = String.format("Missing information description [%s]", structure.getDescription());
                log.error(message);
                throw new InvalidInputException(message);
            }

            this.id = structure.getId();
            this.description = structure.getDescription();
        }

        public StructureMaster build() {
            StructureMaster structureMaster = new StructureMaster();
            structureMaster.setId(this.id);
            structureMaster.setDescription(this.description);
            return structureMaster;
        }
    }
}
