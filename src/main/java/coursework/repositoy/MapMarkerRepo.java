package coursework.repositoy;


import coursework.model.MapMarker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapMarkerRepo extends JpaRepository <MapMarker, Integer> {
}
