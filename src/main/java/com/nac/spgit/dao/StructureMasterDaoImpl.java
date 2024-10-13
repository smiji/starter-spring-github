package com.nac.spgit.dao;

import com.nac.spgit.entities.master.StructureMaster;
import com.nac.spgit.exception.ResourceMissingException;
import com.nac.spgit.repo.master.StructureMasterRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class StructureMasterDaoImpl implements StructureMasterDao {

    private final StructureMasterRepo structureMasterRepo;


    public StructureMasterDaoImpl(@Autowired StructureMasterRepo structureMasterRepo) {
        this.structureMasterRepo = structureMasterRepo;
    }

    @Override
    public StructureMaster add(StructureMaster structureMaster) {
        return structureMasterRepo.save(structureMaster);
    }

    @Override
    public Optional<StructureMaster> get(long id) {
        return structureMasterRepo.findById(id);
    }

    @Override
    public StructureMaster update(StructureMaster structureMaster) {
        Optional<StructureMaster> structureMasterOptionalFromDB = get(structureMaster.getId());
        if (structureMasterOptionalFromDB.isEmpty()) {
            String message = String.format("No items present for the id [%d]", structureMaster.getId());
            log.error(message);
            throw new ResourceMissingException(message);
        }
        return structureMasterRepo.save(structureMaster);
    }

    @Override
    public void delete(long id) {
        //get to see the item exist ,
        Optional<StructureMaster> structureMaster = get(id);
        if (structureMaster.isEmpty()) {
            String message = String.format("No item present to delete for the id [%d]", id);
            log.error(message);
            throw new ResourceMissingException(message);
        }
        structureMasterRepo.deleteById(id);
        log.info("Item deleted successfully for the id {}",id);
    }
}
