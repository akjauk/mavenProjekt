package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {

	List<Resident> residents = new ArrayList<Resident>();

	Date res1Date = new Date(1982, 3, 12);
	Resident resident1 = new Resident("Paula", "Schmidt", "Baumstraße 12", "Ulm", res1Date);
	Date res2Date = new Date(1964, 5, 1);
	Resident resident2 = new Resident("Francesco", "Bellini", "Hauptstraße 114", "München", res2Date);
	Date res3Date = new Date(1998, 11, 24);
	Resident resident3 = new Resident("Fatima", "Müller", "Beethovenallee 3", "Bonn", res3Date);	
	Resident resident4 = new Resident("Ali", "Müller", "Beethovenallee 3", "Bonn", res3Date);	
	Resident resident5 = new Resident("Frank", "Sauter", "Waldweg 25", "Furtwangen", res3Date);

	public ResidentRepositoryStub() {
		residents.add(resident1);
		residents.add(resident2);
		residents.add(resident3);
		residents.add(resident4);
		residents.add(resident5);
	}
	
	@Override
	public List<Resident> getResidents() {
		return residents;
	}

}
