package com.nac.spgit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nac.spgit.beans.Structure;
import com.nac.spgit.entities.master.StructureMaster;
import com.nac.spgit.exception.InvalidInputException;
import com.nac.spgit.exception.ResourceMissingException;
import com.nac.spgit.master.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class StructureMasterServiceTest implements BaseTest {

    private static final String MASTER_FILE_JSON_STRUCTURE_TYPE = "/table_data/structure_master.json";
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private StructureMasterService service;

    /**
     * For testing the master data table insert,get, delete and update
     * All you need the jdbc connection to the database and the
     * dao for the table with its Repository
     * So create a Spring boot starter and config for these only
     */

    @BeforeEach
    public void setUp() {
    }

    @Test
    void add() {
        String jsonData = readJsonFromFile(MASTER_FILE_JSON_STRUCTURE_TYPE);
        Structure deserializedStructureObject = deserialize(objectMapper, Structure.class, jsonData);
        Structure add = service.add(deserializedStructureObject);
        Assertions.assertTrue(add.getId() >= 0);
        Assertions.assertEquals(add.getDescription(), "3 bhk");
    }

    @Test
    void add_when_desc_null() {
        String expectedMessage = "Missing information description [null]";
        Structure structure = new Structure();
        structure.setId(1);
        structure.setDescription(null);
        InvalidInputException exceptionOccurred = Assertions.assertThrows(InvalidInputException.class, () -> {
            service.add(structure);
        }, "Exception occurred");
        Assertions.assertEquals(expectedMessage, exceptionOccurred.getMessage());
    }

    @Test
    void add_null() {
        String expectedMessage = "Missing information structure null";
        InvalidInputException missingInformationStructureNull = Assertions.assertThrows(InvalidInputException.class, () -> {
            service.add(null);
        }, "Exception occurred");
        Assertions.assertEquals(expectedMessage, missingInformationStructureNull.getMessage());
    }

    @Test
    void get() {
        Structure structure = new Structure();
        structure.setDescription("Hello");
        Structure addedStructure = service.add(structure);
        Structure structureGot = service.get(addedStructure.getId());
        Assertions.assertNotNull(structureGot);
    }

    @Test
    void get_when_no_value() {
        String expectedErrorMessage = "No data present for the id [-1]";
        ResourceMissingException exceptionOccurred = Assertions.assertThrows(ResourceMissingException.class, () -> {
            Structure structureGot = service.get(-1);
        }, "Exception occurred");
        Assertions.assertEquals(expectedErrorMessage, exceptionOccurred.getMessage());
    }

    @Test
    void update() {
        //Add a structure
        Structure structure = new Structure();
        structure.setDescription("Hello");
        Structure addedStructure = service.add(structure);
        //get the added structure
        Structure structure1 = service.get(addedStructure.getId());
        Assertions.assertEquals("Hello", structure1.getDescription());

        //update the structure description
        structure1.setDescription("Hello world");
        StructureMaster updatedStructureMaster = service.update(structure1);
        //check the old id is correct
        Assertions.assertEquals(addedStructure.getId(), updatedStructureMaster.getId());
        //check the updated description is reflecting
        Assertions.assertEquals("Hello world", updatedStructureMaster.getDescription());
    }

    @Test
    void update_when_null() {
        String expectedMessage = "Missing information structure null";
        InvalidInputException exceptionOccurred = Assertions.assertThrows(InvalidInputException.class, () -> {
            StructureMaster updatedStructureMaster = service.update(null);
        }, "Exception occurred");
        Assertions.assertEquals(expectedMessage, exceptionOccurred.getMessage());
    }

    @Test
    void update_when_no_item_present() {
        String expectedMessage = "No items present for the id [0]";
        Structure structure = new Structure();
        structure.setDescription("Abc");
        ResourceMissingException exceptionOccurred = Assertions.assertThrows(ResourceMissingException.class, () -> {
            service.update(structure);
        }, "Exception occurred");
        Assertions.assertEquals(expectedMessage, exceptionOccurred.getMessage());
    }

    @Test
    void delete() {
        Structure structure = new Structure();
        structure.setDescription("PQR");
        Structure addedItem = service.add(structure);
        service.delete(addedItem.getId());
    }

    @Test
    void delete_when_no_item_present() {
        String expectedMessage = "No item present to delete for the id [1]";
        ResourceMissingException exceptionOccurred = Assertions.assertThrows(ResourceMissingException.class, () -> {
            service.delete(1);
        }, "Exception occurred");
        Assertions.assertEquals(expectedMessage, exceptionOccurred.getMessage());
    }

}