package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public class AirplaneServiceImpl implements AirplaneService {
    private final ExternalApproveService approveService;
    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneServiceImpl(ExternalApproveService approveService, AirplaneRepository airplaneRepository) {
        this.approveService = approveService;
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public boolean approve(AirplaneDto airplaneDto) {
        return approveService.approve(new AirplaneAdapter(airplaneDto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto airplaneDto) {
        return new Airplane(
                airplaneDto.getId(),
                airplaneDto.getBrand(),
                airplaneDto.getModel(),
                airplaneDto.getManufactures(),
                airplaneDto.getYear(),
                airplaneDto.getFuelCapacity(),
                airplaneDto.getSeats(),
                airplaneDto.getEvaluations()
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuelCapacity(),
                airplane.getSeats(),
                airplane.getEvaluations()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}


