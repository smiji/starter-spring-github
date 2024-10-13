package com.nac.spgit.repo.master;

import com.nac.spgit.entities.master.StructureMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureMasterRepo extends JpaRepository<StructureMaster,Long> {
}
