package whz.pti.eva.pizza.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<Ordered,String> {
}
