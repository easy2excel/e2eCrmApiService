package com.easy2excel.dto;

import com.easy2excel.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseViewDTO {
    private String createdBy;
    private Date createdAt;
    private String modifiedBy;
    private Date modifiedAt;
    private boolean active = true;

    public BaseViewDTO(final Auditable auditable,boolean setTimeFields){
        this.active=auditable.isActive();
        if (setTimeFields){
            this.createdBy = auditable.getCreatedBy();
            this.createdAt = auditable.getCreateAt();
            this.modifiedBy = auditable.getModifiedBy();
            this.modifiedAt = auditable.getModifiedAt();
        }
    }

}
