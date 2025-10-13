package com.democde.inventryservice.controller;


import com.democde.inventryservice.response.EventInventoryResponse;
import com.democde.inventryservice.response.VenueInventoryResponse;
import com.democde.inventryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class InventoryController {


    private InventoryService inventoryService;

    @Autowired
    public InventoryController( final InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("inventory/events")
    public @ResponseBody  List<EventInventoryResponse> InventoryGetAllEvents(){
        return inventoryService.getAllEvents();
    }

    @GetMapping("inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryByVenuId(@PathVariable Long venueId){
        return inventoryService.getVenueInformation(venueId);
    }
}
