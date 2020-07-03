package com.apontador.data.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@Relation(collectionRelation = "locations")
@JsonPropertyOrder({ "id", "name", "phone", "address"})
public class LocationVO extends RepresentationModel<LocationVO> implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String name;
    private String phone;
    private String address;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationVO)) return false;
        if (!super.equals(o)) return false;
        LocationVO locationVO = (LocationVO) o;
        return key.equals(locationVO.key) &&
                name.equals(locationVO.name) &&
                phone.equals(locationVO.phone) &&
                address.equals(locationVO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, name, phone, address);
    }

}
