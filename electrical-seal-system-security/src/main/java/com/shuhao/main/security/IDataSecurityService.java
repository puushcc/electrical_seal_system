package com.shuhao.main.security;


import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @Description: 获取权限资源
 * @author: XiaoShu
 * @date: 2020年11月25日 9:48
 */
public interface IDataSecurityService {

    Map<String, ConfigAttribute> loadDataSource();
}
