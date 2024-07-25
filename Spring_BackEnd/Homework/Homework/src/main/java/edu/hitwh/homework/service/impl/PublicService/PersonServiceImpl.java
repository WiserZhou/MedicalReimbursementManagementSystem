package edu.hitwh.homework.service.impl.PublicService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import edu.hitwh.homework.mapper.PublicService.PersonMapper;
import edu.hitwh.homework.pojo.PageBean;
import edu.hitwh.homework.pojo.PublicService.Person;
import edu.hitwh.homework.service.PublicService.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PageBean page(int page, int size, String personName, String personType) {
        PageHelper.startPage(page, size);
        List<Person> personList = personMapper.list(personName, personType);
        Page<Person> p = (Page<Person>) personList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Integer id) {
        personMapper.delete(id);
    }

    @Override
    public void add(Person person) {
        personMapper.add(person);
    }

    @Override
    public Person selectById(Integer id) {
        return personMapper.selectById(id);
    }

    @Override
    public void update(Person person) {
        personMapper.update(person);
    }
}

