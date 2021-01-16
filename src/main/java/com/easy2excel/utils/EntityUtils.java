package com.easy2excel.utils;

import com.easy2excel.dto.BaseViewDTO;
import com.easy2excel.entity.Auditable;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityUtils {
    public static <K,V> V findByIdOrThrow(CrudRepository<V,K> repository ,K id,String fieldName){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found for "+fieldName+" id "+id));
    }
    public static void setBaseViewProperties(BaseViewDTO baseViewDTO, Auditable auditable){
        BeanUtils.copyProperties(baseViewDTO,auditable);
    }
}
