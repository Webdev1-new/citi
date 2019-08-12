package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Request1 extends CrudRepository<SimplPojo,String>
{
List<SimplPojo> findById3(String name);
List<SimplPojo> findById4(String name);
}
