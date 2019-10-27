package com.mindtree.devops;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.mindtree.devops.business.Photograph;
import com.mindtree.devops.business.PhotographRepository;

@SpringBootTest
class DevopsPhotographApplicationTests {

	@Autowired
	PhotographRepository pr;
	
	@Test
	void contextLoads() {
		Photograph photo = new Photograph();
		photo.setCustomerId(1);
		photo.setImage_date(new Date());
		photo.setTitle("Title");
		photo.setCaption("Eiffil Tower in Spring");
		photo.setImageFile("Image_file_name.jpg");
		photo.setThumbnailFile("Thumbnail File");
		
		List<Photograph> items = pr.findAll();
		int nextId = items.get(items.size() - 1).getId() +1;
		pr.save(photo);
		
		Assert.isTrue(nextId == pr.save(photo).getId(), "Save");
	}

}
