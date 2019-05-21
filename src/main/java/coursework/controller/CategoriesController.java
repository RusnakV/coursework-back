package coursework.controller;

import coursework.model.Categories;
import coursework.repositoy.CategoriesRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    private final CategoriesRepo categoriesRepo;

    public CategoriesController(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    @GetMapping
    public Iterable<Categories> getCategories(){
        return categoriesRepo.findAll();
    }

    @GetMapping("{id}")
    public Categories getCategories(@PathVariable("id") Categories categories) {
        return categories;
    }

    @PostMapping
    public Categories addCategories(@RequestBody Categories categories) {
        return categoriesRepo.save(categories);
    }

    @PutMapping("{id}")
    public Categories updateCategories(@PathVariable("id") Categories categoriesFromDB,
                                     @RequestBody Categories newCategories) {
        BeanUtils.copyProperties(newCategories, categoriesFromDB, "id");
        return categoriesRepo.save(categoriesFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteCategories(@PathVariable("id") Categories categories) {
        categoriesRepo.delete(categories);
    }
    
}
