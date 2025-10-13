package com.democde.inventryservice.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenueInventoryResponse {

    private Long venuId;
    private String venueName;
    private Long totalCapacity;
}
