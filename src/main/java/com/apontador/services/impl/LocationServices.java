package com.apontador.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apontador.data.model.Location;
import com.apontador.data.vo.LocationVO;
import com.apontador.repository.LocationRepository;
import com.apontador.services.ILocationService;
import com.apontador.util.MessagesUtil;
import com.apontador.converter.DozerConverter;
import com.apontador.exception.ResourceNotFoundException;

@Service
public class LocationServices implements ILocationService {

    @Autowired
    LocationRepository repository;

    @Override
    public LocationVO create(LocationVO client) {
        Location entity = DozerConverter.parseObject(client, Location.class);
        return DozerConverter.parseObject(repository.save(entity), LocationVO.class);
    }

    @Override
    public Page<LocationVO> findLocationByName(String name, Pageable pageable) {
        Page<Location> page = repository.findLocationByName(name, pageable);
        return page.map(this::convertToLocationVO);
    }

    @Override
    public Page<LocationVO> findAll(Pageable pageable) {
        Page<Location> page = repository.findAll(pageable);
        return page.map(this::convertToLocationVO);
    }

    private LocationVO convertToLocationVO(Location entity) {
        return DozerConverter.parseObject(entity, LocationVO.class);
    }

    @Override
    public LocationVO findById(Long id) {
    	Location entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessagesUtil.NO_RECORDS_FOUND));
        return DozerConverter.parseObject(entity, LocationVO.class);
    }

    @Override
    public LocationVO update(LocationVO client) {
        Location entity = repository.findById(client.getKey())
                .orElseThrow(() -> new ResourceNotFoundException(MessagesUtil.NO_RECORDS_FOUND));

        entity.setName(client.getName());
        entity.setPhone(client.getPhone());
        entity.setAddress(client.getAddress());

        return DozerConverter.parseObject(repository.save(entity), LocationVO.class);
    }

    @Override
    public void delete(Long id) {
    	Location entity = null;
    	entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessagesUtil.NO_RECORDS_FOUND));
        repository.delete(entity);
    }

}
