package com.crudspring.api.Services;

import java.util.List;

import com.crudspring.api.DTOs.PublicationDTO;

public interface PublicationServices {
    public PublicationDTO createpublication(PublicationDTO publicationdto);
    public List<PublicationDTO> getpublication();
    public PublicationDTO getpublicationId(Long id);

    public PublicationDTO updatePublication(PublicationDTO publicationdto, Long id);

    public void deletePublication(long id);
}
