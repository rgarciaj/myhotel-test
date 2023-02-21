INSERT INTO `myhotel-test`.vehicle (dtype,brand,engine_capacity,milage,model,patent,`year`,axles_quantity,capacity,`type`,doors,passengers,trunk_capacity) VALUES
	 ('Car','Fiat',1.8,40000,'Argo','KZDW90',2019,NULL,NULL,1,4,2,200.0),
	 ('Truck','Subaru',5000.0,40000,'Optimus Prime','XXXX54',2015,3,1.5,1,NULL,NULL,NULL);

INSERT INTO `myhotel-test`.maintenance (`date`,maintenance_detail,vehicle_id) VALUES
	 ('2022-01-01 00:00:00','Se cambiaron bujias',1),
	 ('2022-01-01 00:00:00','Se revisaron los frenos',2);
