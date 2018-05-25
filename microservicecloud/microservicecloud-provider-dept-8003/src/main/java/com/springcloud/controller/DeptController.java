package com.springcloud.controller;

import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id ){
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }

    @RequestMapping(value="/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list=client.getServices();
        System.out.println("=========================="+list);
        List<ServiceInstance> serviceInstances=client.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance instance:serviceInstances){
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.client;
    }
}