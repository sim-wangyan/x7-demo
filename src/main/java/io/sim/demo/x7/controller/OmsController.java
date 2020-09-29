package io.sim.demo.x7.controller;

import io.sim.demo.x7.ro.FindRo;
import io.sim.demo.x7.service.OmsService;
import io.xream.sqli.builder.*;
import io.xream.sqli.page.Page;
import io.xream.x7.base.web.ViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author Sim
 */
@RestController
@RequestMapping("/oms")
public class OmsController {

    @Autowired
    private OmsService omsService;

    @RequestMapping("/list")
    public ViewEntity list(@RequestBody FindRo ro) {
        CriteriaBuilder.ResultMapBuilder builder = CriteriaBuilder.resultMapBuilder();
        builder.distinct("o.id");
        builder.beginSub().eq("o.name",null).endSub();
        builder.in("i.name", Arrays.asList("test"));
        builder.nonNull("i.name").nonNull("l.log");
        builder.sourceBuilder().source("order").alia("o");
        builder.sourceBuilder().source("orderItem").alia("i").join(JoinType.INNER_JOIN)
                .on("orderId", JoinFrom.of("o","id"));
        builder.sourceBuilder().sub(//demo for clickhouse
                subBuilder -> { // sub0
                    subBuilder.resultKey("ol.orderId", "orderId")
                            .resultKey("ol.log","log").gt("ol.orderId",1).groupBy("ol.orderId").groupBy("ol.log");
                    subBuilder.sourceBuilder().sub(
                            subBuilder1 -> { //sub1
                                subBuilder1.resultKey("ot.orderId","orderId")
                                        .resultKey("ot.log","log")
                                        .sourceScript("FROM orderLog ot ")
                                        .groupBy("ot.orderId").groupBy("ot.log");
                    } ).alia("ol");
                }).alia("l")
                .join("ANY LEFT JOIN")
                .on("orderId", JoinFrom.of("o","id"));

        builder.groupBy("o.id").sort("o.id", Direction.DESC);
        builder.paged().page(1).rows(10);

        Criteria.ResultMapCriteria criteria = builder.build();

        Page<Map<String,Object>> page = this.omsService.find(criteria);

        return ViewEntity.ok(page);
    }
}
