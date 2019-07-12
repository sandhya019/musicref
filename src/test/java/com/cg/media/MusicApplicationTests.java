package com.cg.media;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.media.entity.Composer;
import com.cg.media.repository.IComposerRepository;
import com.cg.media.service.ComposerServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class MusicApplicationTests {

	@Mock
	private IComposerRepository iComposerRepository;

	@InjectMocks
	private ComposerServiceImpl composerServiceImpl;

	
	//---------------------GETALL METHOD------------------------------
	@Test
	public void getAllComposerTest() throws Exception{
		List<Composer> expectedComposerList= new ArrayList<>();
		Composer expectedComposer = new Composer();
		expectedComposer.setComposerId(100000);
		expectedComposer.setComposerBornDate("11-11-2017");
		expectedComposer.setComposerCaeipiNumber("NNNN");
		expectedComposer.setComposerDiedDate("11-11-1999");
		expectedComposer.setComposerName("Nikhil");

		/*
		 * MusicSociety musicSociety=new MusicSociety();
		 * musicSociety.setComposerMusicSocietyId(1234); actualComposer.setM
		 */
		expectedComposer.setComposerMusicSocietyId(12333);
		expectedComposer.setCreatedBy(111);
		expectedComposer.setCreatedOn("12-12-2019");
		expectedComposer.setUpdatedBy(22);
		expectedComposer.setUpdatedOn("11-02-2011");
		expectedComposer.setComposerDeletedFlag(false);
		expectedComposerList.add(expectedComposer);
		when(iComposerRepository.findAll()).thenReturn(expectedComposerList);
		List<Composer> actualComposerList = composerServiceImpl.getAllComposer();
		System.out.println(actualComposerList.toString());
		System.out.println(actualComposerList.toString());
		assertEquals(actualComposerList, expectedComposerList);

	}

	
	//--------------------POST METHOD----------------------------
	@Test
	public void createComposerTest() throws Exception{
		Composer actualComposer = new Composer();
		actualComposer.setComposerName("Nikhil");
		actualComposer.setComposerBornDate("11-11-2222");
		actualComposer.setComposerDiedDate("22-22-2019");
		actualComposer.setComposerCaeipiNumber("NNNNNNNN");
		actualComposer.setComposerMusicSocietyId(111111);
		actualComposer.setCreatedBy(11);
		actualComposer.setCreatedOn("11-11-2222");
		actualComposer.setComposerDeletedFlag(false);
		when(iComposerRepository.save(actualComposer)).thenReturn(actualComposer);

		Composer expectedComposer = composerServiceImpl.createComposer(actualComposer);
		System.out.println(actualComposer.toString());
		System.out.println(expectedComposer.toString());
		assertEquals(expectedComposer, actualComposer);

	}
	
	//-----------------------------------------PUT METHOD------------------------------------------

	@Test
	public void updateComposerTest() {
		Composer actualComposer = new Composer();
		actualComposer.setComposerId(100001);
		actualComposer.setComposerName("Nikhil");
		actualComposer.setComposerBornDate("11-11-2222");
		actualComposer.setComposerDiedDate("22-22-2019");
		actualComposer.setComposerCaeipiNumber("NNNNNNNN");
		actualComposer.setComposerMusicSocietyId(111111);
		actualComposer.setCreatedBy(11);
		actualComposer.setCreatedOn("11-11-2222");
		actualComposer.setComposerDeletedFlag(false);
		when(iComposerRepository.getOne(100001)).thenReturn(actualComposer).thenReturn(actualComposer);
		Composer expectedComposer = composerServiceImpl.updateComposer(actualComposer, actualComposer.getComposerId());
		System.out.println(actualComposer.toString());
		System.out.println(expectedComposer.toString());
		assertEquals(expectedComposer, actualComposer);
		
		
	}
}
