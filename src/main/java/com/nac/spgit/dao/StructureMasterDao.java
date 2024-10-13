package com.nac.spgit.dao;

import com.nac.spgit.entities.master.StructureMaster;

import java.util.Optional;

public interface StructureMasterDao {

    StructureMaster add(StructureMaster structure);

    Optional<StructureMaster> get(long id);

    StructureMaster update(StructureMaster structure);

    void delete(long id);
}
