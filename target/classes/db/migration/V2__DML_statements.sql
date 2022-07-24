INSERT INTO order.tb_order_type
    (id, order_type_description)
    values
        (1, 'SALE'),
        (2, 'CANCEL');

INSERT INTO order.tb_order_state
       (id, order_state_description)
       values
       (1, 'PROCESSING'),
       (2, 'CREATED'),
       (3, 'DELETED'),
       (4, 'UPDATED'),
       (5, 'COMPLETED'),
       (9, 'ERROR');


