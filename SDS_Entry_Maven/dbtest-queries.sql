 select sum(claimed_charge) from document where status="EXPORTED";
 Select insured_name, insured_address , claimed_charge from batch
    join
    (select batch_id ,insured_name, insured_address ,claimed_charge from document where status="TO_REPRICE") p
    on
     id=batch_id
    where customer_id=1 or customer_id=2;
