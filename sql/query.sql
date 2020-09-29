SELECT DISTINCT o.id AS c0
FROM t_order o
    INNER JOIN t_order_item i ON o.id = i.order_id
    ANY LEFT JOIN (SELECT  ol.orderId AS orderId, ol.log AS log
                        FROM (SELECT  ot.order_id AS orderId, ot.log AS log  FROM t_order_log ot GROUP BY ot.order_id,ot.log ) ol
                        WHERE ol.orderId > 1  GROUP BY ol.orderId, ol.log) l
        ON o.id = l.orderId
WHERE i.name IN ( 'test' ) AND i.name IS NOT NULL  AND l.log IS NOT NULL  GROUP BY o.id ORDER BY o.id DESC LIMIT 0,10