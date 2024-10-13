package com.nac.spgit.service;

import com.nac.spgit.beans.Structure;
import com.nac.spgit.dao.StructureMasterDao;
import com.nac.spgit.entities.master.StructureMaster;
import com.nac.spgit.exception.ResourceMissingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StructureMasterService {

    private final StructureMasterDao structureMasterDao;

    public StructureMasterService(@Autowired StructureMasterDao structureMasterDao) {
        this.structureMasterDao = structureMasterDao;
    }

    public Structure add(Structure structure) {
        StructureMaster addedStructure = structureMasterDao.add(StructureMaster.builder(structure).build());
        return Structure.builder(addedStructure).build();
    }

    public Structure get(long id) {
        Optional<StructureMaster> structureMaster = structureMasterDao.get(id);
        if (structureMaster.isPresent()) {
            return Structure.builder(structureMaster.get()).build();
        }
        String message = String.format("No data present for the id [%d]", id);
        log.error(message);
        throw new ResourceMissingException(message);
    }

    public StructureMaster update(Structure structure) {
        return structureMasterDao.update(StructureMaster.builder(structure).build());
    }

    public void delete(long id) {
        structureMasterDao.delete(id);
    }

}
