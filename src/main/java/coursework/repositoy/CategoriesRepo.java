package coursework.repositoy;

import coursework.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository <Categories, Integer>  {
}
