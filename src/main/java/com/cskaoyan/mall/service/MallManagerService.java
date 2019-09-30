package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Region;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MallManagerService {

    List<Region> getAllRegions();
}
