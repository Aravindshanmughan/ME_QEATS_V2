/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
//  Implement GetRestaurantsRequest.
//  Complete the class such that it is able to deserialize the incoming query params from
//  REST API clients.
//  For instance, if a REST client calls API
//  /qeats/v1/restaurants?latitude=28.4900591&longitude=77.536386&searchFor=tamil,
//  this class should be able to deserialize lat/long and optional searchFor from that.

@NoArgsConstructor
public class GetRestaurantsRequest {
     
     private Double latitude;
     private Double longitude;
     
     @JsonIgnore
     private String searchFor;
 
     public GetRestaurantsRequest(Double latitude, Double longitude) {
         setLatitude(latitude);
         setLongitude(longitude);
     }
     @NotNull
     public Double getLatitude() {
         return latitude;
     }
     
     public void setLatitude(Double latitude) {
         validateLatitude(latitude);
         this.latitude = latitude;
     }
     @NotNull
     public Double getLongitude() {
         return longitude;
     }
    
     public void setLongitude(Double longitude) {
         validateLongitude(longitude);
         this.longitude = longitude;
     }
 
     private void validateLatitude(Double latitude) {
         if (latitude == null || latitude < -90 || latitude > 90) {
             throw new IllegalArgumentException("Latitude must be between -90 and 90");
         }
     }
 
     private void validateLongitude(Double longitude) {
         if (longitude == null || longitude < -180 || longitude > 180) {
             throw new IllegalArgumentException("Longitude must be between -180 and 180");
         }
     }
 }
