package com.nac.spgit.beans;

import com.nac.spgit.entities.master.StructureMaster;

public class Structure {
    private long id;
    private String description;

    public Structure() {
    }

    Structure(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public static StructureBuilder builder(StructureMaster structureMaster) {
        return new StructureBuilder(structureMaster);
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

    public static class StructureBuilder {
        private final long id;
        private final String description;

        private StructureBuilder(StructureMaster structureMaster) {
            this.id = structureMaster.getId();
            this.description = structureMaster.getDescription();
        }

        public Structure build() {
            return new Structure(id, description);
        }

        public String toString() {
            return "Structure.StructureBuilder(id=" + this.id + ", description=" + this.description + ")";
        }
    }
}
