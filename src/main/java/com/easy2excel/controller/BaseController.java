package com.easy2excel.controller;

import com.easy2excel.dto.BaseDTO;
import com.easy2excel.dto.BaseViewDTO;
import com.easy2excel.utils.EntityUtils;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
public abstract class BaseController<T, U extends BaseDTO, V extends BaseViewDTO> {

    final CrudRepository<T, Long> baseRepository;
    final String baseEntityName;

    public BaseController(final CrudRepository<T, Long> crudRepository, final String baseEntityName) {
        this.baseRepository = crudRepository;
        this.baseEntityName = baseEntityName;
    }

    @DeleteMapping("/{id}")
    @Timed
    @Transactional
    public ResponseEntity<Long> deleteEntityById(@PathVariable Long id) {
        log.debug("Going to delete {} by id {}", baseEntityName, id);
        baseRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<V>> getAllEntities() {
        log.debug("Going to fetch all {}", baseEntityName);
        //Iterable<T> s = baseRepository.findAll();
        final List<V> entities = transferListOnViewEntityDTO(baseRepository.findAll());
        return ResponseEntity.ok(entities);
    }

    List<V> transferListOnViewEntityDTO(Iterable<T> jpaEntities) {
        if (jpaEntities == null)
            return Collections.emptyList();
        else {
            return StreamSupport.stream(jpaEntities.spliterator(), false)
                    .map(e -> setPropertiesOnViewEntityDTO(e, false))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/{id}")
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<V> getEntityById(@PathVariable Long id) {
        log.debug("Going to retrive {} By id {} ", baseEntityName, id);
        return baseRepository.findById(id).map(e -> ResponseEntity.ok(setPropertiesOnViewEntityDTO(e, true)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Timed
    @Transactional
    public ResponseEntity<V> handelSaveRequest(@RequestBody @Valid U input) {
        log.debug("Going to create {} {}", baseEntityName, input);
        T fromDb = createBaseEntityAndSetPropertiesOnInput(input);
        input.setActive(true);
        setExtraProperties(input, fromDb);
        return saveEntity(fromDb);
    }

    T createBaseEntityAndSetPropertiesOnInput(U input) {
        T fromDb = createBaseEntity();
        setPropertiesOnInput(input, fromDb);
        return fromDb;
    }

    void setExtraProperties(U input, T fromDb) {
    }

    ResponseEntity<V> saveEntity(final T entity) {
        final T save = baseRepository.save(entity);
        final V viewDTO = setPropertiesOnViewEntityDTO(save, showExtendedPropertiesFroSave());
        return ResponseEntity.ok(viewDTO);
    }

    abstract T createBaseEntity();

    abstract void setPropertiesOnInput(U input, T fromDb);

    abstract V setPropertiesOnViewEntityDTO(T jpaEntity, boolean setExtendedProperties);

    boolean showExtendedPropertiesFroSave() {
        return false;
    }

    @PutMapping("/{id}")
    @Timed
    @Transactional
    public ResponseEntity<V> handelUpdate(@PathVariable Long id, @RequestBody @Valid U input) {
        log.debug("going to update {} {}", baseEntityName, input);
        T fromDb = findBaseEntityOrThrow(id);
        setPropertiesOnInput(input, fromDb);
        return saveEntity(fromDb);
    }

    public T findBaseEntityOrThrow(Long id) {
        return EntityUtils.findByIdOrThrow(baseRepository, id, baseEntityName);
    }

}
