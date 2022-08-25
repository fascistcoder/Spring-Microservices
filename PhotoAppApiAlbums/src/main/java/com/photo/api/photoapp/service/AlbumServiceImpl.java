package com.photo.api.photoapp.service;

import com.photo.api.photoapp.Model.Albums;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
@Service
public class AlbumServiceImpl implements AlbumService{
	@Override public List<Albums> getAlbums(String userId) {
		List<Albums> returnValue = new ArrayList<>();

		Albums albums = new Albums();
		albums.setUserId(userId);
		albums.setAlbumId("album1Id");
		albums.setDescription("album 1 description");
		albums.setId(1L);
		albums.setName("album 1 name");

		Albums albums2 = new Albums();
		albums2.setUserId(userId);
		albums2.setAlbumId("album2Id");
		albums2.setDescription("album 2 description");
		albums2.setId(2L);
		albums2.setName("album 2 name");

		returnValue.add(albums);
		returnValue.add(albums2);

		return returnValue;
	}
}
