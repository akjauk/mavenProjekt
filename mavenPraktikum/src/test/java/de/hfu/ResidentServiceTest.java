package de.hfu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentServiceTest {

	@Test
	public void testFilterResidentsWithGivenNameStartingWithF() {

		// initializing ResidentRepositoryStub
		ResidentRepository resrepo = new ResidentRepositoryStub();

		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepo);

		// get filtered list for residents with given name starting with F
		List<Resident> filteredResF = new ArrayList<Resident>();
		Resident resF = new Resident("F*", "", "", "", null);
		filteredResF = resservice.getFilteredResidentsList(resF);

		assertEquals(3, filteredResF.size());
	}

	@Test
	public void testFilterResidentsWithFamilyNameStartingWithS() {

		// initializing ResidentRepositoryStub
		ResidentRepository resrepo = new ResidentRepositoryStub();

		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepo);

		// get filtered list for residents with family name starting with S
		List<Resident> filteredResS = new ArrayList<Resident>();
		Resident resS = new Resident("", "S*", "", "", null);
		filteredResS = resservice.getFilteredResidentsList(resS);

		assertEquals(2, filteredResS.size());
	}

	@Test
	public void testFilterResidentWithBirthday19981124() {

		// initializing ResidentRepositoryStub
		ResidentRepository resrepo = new ResidentRepositoryStub();

		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepo);

		// get filtered list for residents with birthday 24.11.1998
		List<Resident> filteredResBirthday = new ArrayList<Resident>();
		Date date = new Date(1998, 11, 24);
		Resident resS = new Resident("", "", "", "", date);
		filteredResBirthday = resservice.getFilteredResidentsList(resS);

		assertEquals(3, filteredResBirthday.size());
	}

	@Test
	public void testFilterResidentWithBirthday196451() {
		// initializing ResidentRepositoryStub
		ResidentRepository resrepo = new ResidentRepositoryStub();

		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepo);

		// get filtered resident with birthday 1.5.1964
		Date date = new Date(1964, 5, 1);
		Resident resS = new Resident("", "", "", "", date);
		Resident resident = new Resident();
		try {
			resident = resservice.getUniqueResident(resS);
		} catch (ResidentServiceException e) {

		}

		assertEquals(date, resident.getDateOfBirth());
	}

	@Test
	public void testFilterResidentFrank() {
		// initializing ResidentRepositoryStub
		ResidentRepository resrepo = new ResidentRepositoryStub();

		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepo);

		// get filtered resident with given name Frank
		Resident resS = new Resident("Frank", "", "", "", null);
		Resident resident = new Resident();
		try {
			resident = resservice.getUniqueResident(resS);
		} catch (ResidentServiceException e) {

		}

		assertEquals("Frank", resident.getGivenName());
	}

	@Test(expected = ResidentServiceException.class, timeout = 1000)
	public void testFilterMultipleEntriesWithUnique() throws ResidentServiceException {
		// initializing ResidentRepositoryStub
		ResidentRepository resrepo = new ResidentRepositoryStub();

		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepo);

		// get filtered resident with family name starting with m
		Resident resS = new Resident("", "M*", "", "", null);
		Resident resident = resservice.getUniqueResident(resS);
	}
}
