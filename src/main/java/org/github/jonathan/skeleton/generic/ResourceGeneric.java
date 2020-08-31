package org.github.jonathan.skeleton.generic;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class ResourceGeneric<T> {

    protected final JpaRepository<T, Long> repo;

    public ResourceGeneric(JpaRepository<T, Long> repo) {
        this.repo = repo;
    }

    @ApiOperation(value= ConstantGeneric.GET_LIST_ALL)
    @GetMapping("")
    public List<T> getAll() {
        return repo.findAll();
    }

    @ApiOperation(value= ConstantGeneric.GET_T)
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value= ConstantGeneric.POST_T)
    @PostMapping
    public T create(@RequestBody T entity) {
        return repo.save(entity);
    }

    @ApiOperation(value= ConstantGeneric.PUT_T)
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody T source) {
        return repo.findById(id)
                .map(target -> { BeanUtils.copyProperties(source, target, "id"); return target; })
                .map(repo::save)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value= ConstantGeneric.DELETE_T)
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return repo.findById(id)
                .map(entity -> { repo.delete(entity); return entity; })
                .map(t -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
