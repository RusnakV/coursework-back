package coursework.controller;

import coursework.model.MapMarker;
import coursework.repositoy.MapMarkerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/map_marker")
public class MapMarkerController {
    private final MapMarkerRepo mapMarkerRepo;

    public MapMarkerController(MapMarkerRepo mapMarkerRepo) {
        this.mapMarkerRepo = mapMarkerRepo;
    }

    @GetMapping
    public Iterable<MapMarker> getMapMarker(){
        return mapMarkerRepo.findAll();
    }

    @GetMapping("{id}")
    public MapMarker getContract(@PathVariable("id") MapMarker mapMarker) {
        return mapMarker;
    }

    @PostMapping
    public MapMarker addMapMarker(@RequestBody MapMarker mapMarker) {
        return mapMarkerRepo.save(mapMarker);
    }

    @PutMapping("{id}")
    public MapMarker updateMapMarker(@PathVariable("id") MapMarker mapMarkerFromDB,
                                     @RequestBody MapMarker newMapMarker) {
        BeanUtils.copyProperties(newMapMarker, mapMarkerFromDB, "id");
        return mapMarkerRepo.save(mapMarkerFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteMapMarker(@PathVariable("id") MapMarker mapMarker) {
        mapMarkerRepo.delete(mapMarker);
    }
}
