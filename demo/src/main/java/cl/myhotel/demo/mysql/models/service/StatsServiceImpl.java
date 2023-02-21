package cl.myhotel.demo.mysql.models.service;

import cl.myhotel.demo.mysql.models.repository.StatsRepository;
import cl.myhotel.demo.mysql.models.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    StatsRepository statsRepository;

    @Override
    public StatsResponse getStats() {
        List<Object> obj;
        List<StatsEmployeesQuantityResponse> statsEmployeesQuantityResponses = new ArrayList<>();
        List<StatsEmployeesAvgSalaryResponse> statsEmployeesAvgSalaryResponses = new ArrayList<>();
        List<StatsEmployeesMaxSalaryResponse> statsEmployeesMaxSalaryResponses = new ArrayList<>();
        List<StatsEmployeesMinSalaryResponse> statsEmployeesMinSalaryResponses = new ArrayList<>();
        List<StatsEmployeesAvgAntiquityResponse> statsEmployeesAvgAntiquityResponses = new ArrayList<>();

        obj = statsRepository.getEmployeesQuantityByCountry();
        for (Object o : obj) {
            Object[] data = (Object[]) o;
            statsEmployeesQuantityResponses.add(new StatsEmployeesQuantityResponse((String) data[0], (long) data[1]));
        }

        obj = statsRepository.getEmployeesAvgSalaryByCountry();
        for (Object o : obj) {
            Object[] data = (Object[]) o;
            statsEmployeesAvgSalaryResponses.add(new StatsEmployeesAvgSalaryResponse((String) data[0], (BigDecimal) data[1]));
        }

        obj = statsRepository.getEmployeesMaxSalaryByCountry();
        for (Object o : obj) {
            Object[] data = (Object[]) o;
            statsEmployeesMaxSalaryResponses.add(new StatsEmployeesMaxSalaryResponse((String) data[0], (BigDecimal) data[1]));
        }

        obj = statsRepository.getEmployeesMinSalaryByCountry();
        for (Object o : obj) {
            Object[] data = (Object[]) o;
            statsEmployeesMinSalaryResponses.add(new StatsEmployeesMinSalaryResponse((String) data[0], (BigDecimal) data[1]));
        }

        obj = statsRepository.getEmployeesAvgAntiquityByCountry();
        for (Object o : obj) {
            Object[] data = (Object[]) o;
            statsEmployeesAvgAntiquityResponses.add(new StatsEmployeesAvgAntiquityResponse((String) data[0], (BigDecimal) data[1]));
        }


        return new StatsResponse(
                statsEmployeesQuantityResponses,
                statsEmployeesAvgSalaryResponses,
                statsEmployeesMaxSalaryResponses,
                statsEmployeesMinSalaryResponses,
                statsEmployeesAvgAntiquityResponses);
    }
}
