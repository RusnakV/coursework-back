package coursework.controller;

import coursework.model.Users;
import coursework.repositoy.UsersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UsersRepo usersRepo;

    public UsersController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @GetMapping
    public Iterable<Users> getUsers(){
        return usersRepo.findAll();
    }

    @GetMapping("{id}")
    public Users getContract(@PathVariable("id") Users users) {
        return users;
    }

    @PostMapping
    public Users addUsers(@RequestBody Users users) {
        return usersRepo.save(users);
    }

    @PutMapping("{id}")
    public Users updateUsers(@PathVariable("id") Users usersFromDB,
                                     @RequestBody Users newUsers) {
        BeanUtils.copyProperties(newUsers, usersFromDB, "id");
        return usersRepo.save(usersFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteUsers(@PathVariable("id") Users users) {
        usersRepo.delete(users);
    }
}
