package coursework.controller;

import coursework.model.AdminMap;
import coursework.repositoy.AdminMapRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin_map")
public class AdminMapController {
    private final AdminMapRepo adminMapRepo;

    public AdminMapController(AdminMapRepo adminMapRepo) {
        this.adminMapRepo = adminMapRepo;
    }

    @GetMapping
    public Iterable<AdminMap> getAdminMap(){
        return adminMapRepo.findAll();
    }

    @GetMapping("{id}")
    public AdminMap getContract(@PathVariable("id") AdminMap adminMap) {
        return adminMap;
    }

    @PostMapping
    public AdminMap addAdminMap(@RequestBody AdminMap adminMap) {
        return adminMapRepo.save(adminMap);
    }

    @PutMapping("{id}")
    public AdminMap updateAdminMap(@PathVariable("id") AdminMap adminMapFromDB,
                                     @RequestBody AdminMap newAdminMap) {
        BeanUtils.copyProperties(newAdminMap, adminMapFromDB, "id");
        return adminMapRepo.save(adminMapFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteAdminMap(@PathVariable("id") AdminMap adminMap) {
        adminMapRepo.delete(adminMap);
    }
}
