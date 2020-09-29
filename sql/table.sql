CREATE TABLE IF NOT EXISTS t_order (id UInt64, create_at UInt64, user_id UInt64, name String, type String)
    ENGINE=MergeTree ORDER BY id SETTINGS index_granularity = 8192;

CREATE TABLE IF NOT EXISTS t_order_item (id UInt64, order_id UInt64, user_id UInt64, quantity UInt32, name String, type String)
    ENGINE=MergeTree ORDER BY id SETTINGS index_granularity = 8192;

CREATE TABLE IF NOT EXISTS t_order_log (id UInt64, order_id UInt64, log String)
    ENGINE=MergeTree ORDER BY id SETTINGS index_granularity = 8192;

