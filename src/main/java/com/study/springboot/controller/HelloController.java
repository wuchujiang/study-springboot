package com.study.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.springboot.dao.ProductDao;
import com.study.springboot.mapper.CategoryMapper;
import com.study.springboot.pojo.Category;
import com.study.springboot.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
//@Validated
public class HelloController {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductDao productDao;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "start",defaultValue = "0") @Max(value = 5,message = "超过5了") int start,
                        @RequestParam(value = "size",defaultValue = "5") int size) {
        PageHelper.startPage(start, size);
        List<Category> categories = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(categories);
        System.out.println(page.getList().size());
        System.out.println(page);

//        categoryMapper.save(category);
//        categoryMapper.delete(category.getId());
//        categoryMapper.update(category);
        return "";
    }

    @PutMapping("/put/{id}")
    public Category save(Category category){
        System.out.println(category);
        return category;
    }

    @PostMapping("/product")
    public Product addProduct(@Validated  @RequestBody Product product){
        productDao.save(product);
        return product;
    }

    @GetMapping("/product")
    public Product listProduct(int id){
        System.out.println(id);
        Product p = productDao.getOne(id);
        System.out.println(p);
        return p;
    }


    @GetMapping("/productList")
    public Page<Product> products(@RequestParam(name = "start",defaultValue = "0") int start,
                                  @RequestParam(name="size",defaultValue = "10") int size
                                  ){
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page<Product> page = productDao.findAll(pageable);

        return page;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(int id){
        List<Product> list = productDao.findByIdGreaterThan(id);
        return list;
    }

    @GetMapping("/exc")
    public void exception() throws Exception{
        System.out.println("error test");
        throw new Exception("error");
    }
}
