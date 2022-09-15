package com.crudspring.api.Services;



import com.crudspring.api.DTOs.PublicationDTO;
import com.crudspring.api.DTOs.PublicationResponse;

public interface PublicationServices {
    public PublicationDTO createpublication(PublicationDTO publicationdto);

    public PublicationResponse getpublication(int numberPage, int measure, String orderBy, String sortDir);
    public PublicationDTO getpublicationId(Long id);

    public PublicationDTO updatePublication(PublicationDTO publicationdto, Long id);

    public void deletePublication(long id);
}
