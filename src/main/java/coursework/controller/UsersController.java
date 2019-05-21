package coursework.controller;

import coursework.model.User;
import coursework.repositoy.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserRepo usersRepo;

    public UsersController(UserRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @GetMapping
    public Iterable<User> getUsers(){
        return usersRepo.findAll();
    }

    @GetMapping("{id}")
    public User getContract(@PathVariable("id") User users) {
        return users;
    }

    @PostMapping
    public User addUsers(@RequestBody User users) {
        return usersRepo.save(users);
    }

    @PutMapping("{id}")
    public User updateUsers(@PathVariable("id") User usersFromDB,
                            @RequestBody User newUsers) {
        BeanUtils.copyProperties(newUsers, usersFromDB, "id");
        return usersRepo.save(usersFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteUsers(@PathVariable("id") User users) {
        usersRepo.delete(users);
    }
}
