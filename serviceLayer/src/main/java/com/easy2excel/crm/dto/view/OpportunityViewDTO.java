package com.easy2excel.crm.dto.view;
import com.esay2excel.crm.domain.Auditable;
import com.esay2excel.crm.domain.Opportunity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class OpportunityViewDTO extends BaseViewDTO {
    private Long id;
    private String name;

    public OpportunityViewDTO(Auditable auditable, final Long id, final String name, boolean setTimeFields) {
        super(auditable, setTimeFields);
        this.id = id;
        this.name = name;
    }

    public static OpportunityViewDTO from(final Opportunity opportunity, final boolean setExtendedProperties) {
        OpportunityViewDTO opportunityViewDTO;
        if (opportunity == null)
            opportunityViewDTO = null;
        else {
            opportunityViewDTO = new OpportunityViewDTO(opportunity, opportunity.getId(), opportunity.getOpportunity_name(), setExtendedProperties);
        }
        return opportunityViewDTO;
    }
}
