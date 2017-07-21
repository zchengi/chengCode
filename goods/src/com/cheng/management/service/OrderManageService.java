package com.cheng.management.service;

import java.util.List;

import com.cheng.order.povo.DingdanPovo;

public interface OrderManageService {
    List<DingdanPovo> toList();

    DingdanPovo findByOid(String oid);

    public List<DingdanPovo> findByStatus(int status);

    String deliver(String oid);

    String cancel(String oid);
}
