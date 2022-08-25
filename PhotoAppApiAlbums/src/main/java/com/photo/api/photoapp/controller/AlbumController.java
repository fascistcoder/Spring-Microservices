package com.photo.api.photoapp.controller;

import com.photo.api.photoapp.Model.Albums;
import com.photo.api.photoapp.dto.AlbumResponseDto;
import com.photo.api.photoapp.service.AlbumService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/08/22
 */
@RestController
@RequestMapping("/users/{id}/albums")
@AllArgsConstructor
@Slf4j
public class AlbumController {
	private final AlbumService albumService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, })
	public List<AlbumResponseDto> userAlbums(@PathVariable String id) {
		List<AlbumResponseDto> returnValue = new ArrayList<>();
		List<Albums> albumsEntities = albumService.getAlbums(id);

		if (albumsEntities == null || albumsEntities.isEmpty()) {
			return returnValue;
		}

		Type listType = new TypeToken<List<AlbumResponseDto>>() {
		}.getType();

		returnValue = new ModelMapper().map(albumsEntities, listType);
		log.info("Returning " + returnValue.size() + " albums");
		return returnValue;
	}
}
