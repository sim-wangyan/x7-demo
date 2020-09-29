package io.sim.demo.x7.service;

import io.sim.demo.x7.repository.OmsRepository;
import io.xream.sqli.builder.Criteria;
import io.xream.sqli.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Sim
 */
@Service
public class OmsServiceImpl implements OmsService{
    @Autowired
    private OmsRepository omsRepository;

    @Override
    public List<Map<String, Object>> list(Criteria.ResultMapCriteria resultMapCriteria) {
        return this.omsRepository.list(resultMapCriteria);
    }

    @Override
    public Page<Map<String, Object>> find(Criteria.ResultMapCriteria criteria) {
        return this.omsRepository.find(criteria);
    }
}
