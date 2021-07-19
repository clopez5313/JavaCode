import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.university.domain.Staff;

/**
 * DataSource Management for the Staff at the University.
 *
 * Created by maryellenbowman
 */
public interface StaffRepository extends PagingAndSortingRepository<Staff,Integer> {
}
