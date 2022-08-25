package com.photo.api.photoapp.service;

import com.photo.api.photoapp.Model.Albums;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
public interface AlbumService {
	List<Albums> getAlbums(String userId);
}
