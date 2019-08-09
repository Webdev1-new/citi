package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Request1 extends CrudRepository<SimplPojo,String>
{
List<SimplPojo> findByid3(String name);
List<SimplPojo> findByid4(String name);
}
