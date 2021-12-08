package de.hfu;

import static org.easymock.EasyMock.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentService;

public class ResidentServiceMockTest {

	ResidentRepository resrepoMock;

	@Before
	public void createResidentRepositoryMock() {
		// residents to create
		Date res1Date = new Date(1982, 3, 12);
		Resident resident1 = new Resident("Paula", "Schmidt", "Baumstraße 12", "Ulm", res1Date);
		Date res2Date = new Date(1964, 5, 1);
		Resident resident2 = new Resident("Francesco", "Bellini", "Hauptstraße 114", "München", res2Date);
		Date res3Date = new Date(1998, 11, 24);
		Resident resident3 = new Resident("Fatima", "Müller", "Beethovenallee 3", "Bonn", res3Date);
		Resident resident4 = new Resident("Ali", "Müller", "Beethovenallee 3", "Bonn", res3Date);
		Resident resident5 = new Resident("Frank", "Sauter", "Waldweg 25", "Furtwangen", res3Date);
		List<Resident> residents = new ArrayList<Resident>();
		residents.add(resident1);
		residents.add(resident2);
		residents.add(resident3);
		residents.add(resident4);
		residents.add(resident5);
		
		// initializing ResidentRepository Mock
		resrepoMock = createMock(ResidentRepository.class);
		expect(resrepoMock.getResidents()).andReturn(residents);
	}

	@Test
	public void testFilterResidentsWithGivenNameStartingWithFMock() {
		
		replay(resrepoMock);
		
		// initializing BaseResidentService and setting ResidentRepository
		ResidentService resservice = new BaseResidentService();
		((BaseResidentService) resservice).setResidentRepository(resrepoMock);

		// get filtered list for residents with given name starting with F
		List<Resident> filteredResF = new ArrayList<Resident>();
		Resident resF = new Resident("F*", "", "", "", null);
		filteredResF = resservice.getFilteredResidentsList(resF);
		
		verify(resrepoMock);
		
		assertThat(filteredResF.size(), equalTo(3));
	}
}
