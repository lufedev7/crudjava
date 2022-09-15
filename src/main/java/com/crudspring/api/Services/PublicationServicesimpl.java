package com.crudspring.api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

import com.crudspring.api.DTOs.PublicationDTO;
import com.crudspring.api.DTOs.PublicationResponse;
import com.crudspring.api.Exceptions.ResourceNotFountException;
import com.crudspring.api.Models.Publication;
import com.crudspring.api.Repository.PublicationRepository;

@Service
public class PublicationServicesimpl implements PublicationServices {
    @Autowired
    private PublicationRepository publicationrepository;
    @Override
    public PublicationDTO createpublication(PublicationDTO publicationdto){
        Publication publication = mapEntity(publicationdto);
        Publication newpublication = publicationrepository.save(publication);
        PublicationDTO publicationresponse = mapdto(newpublication);
        return publicationresponse;
    }
    @Override
    public PublicationResponse getpublication(int numberPage, int measure, String orderBy, String sortdir) {
        Sort sort = sortdir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numberPage, measure, sort);
        Page<Publication> publications = publicationrepository.findAll(pageable);

        List<Publication> listPublications = publications.getContent();

        List<PublicationDTO> content = listPublications.stream().map(publication -> mapdto(publication))
                .collect(Collectors.toList());
        PublicationResponse publicationresponse = new PublicationResponse();
        publicationresponse.setContenido(content);
        publicationresponse.setNumPage(publications.getNumber());
        publicationresponse.setSizePage(publications.getSize());
        publicationresponse.setTotalElemnt(publications.getTotalElements());
        publicationresponse.setTotalpage(publications.getTotalPages());
        publicationresponse.setLatest(publications.isLast());
        return publicationresponse;
    }
    private PublicationDTO mapdto(Publication publication) {
        PublicationDTO publicationdto = new PublicationDTO();
        publicationdto.setId(publication.getId());
        publicationdto.setContent(publication.getContent());
        publicationdto.setDescription(publication.getDescription());
        publicationdto.setTittle(publication.getTittle());
        return publicationdto;

    }
    private Publication mapEntity(PublicationDTO publicationdto){
          Publication publication = new Publication();
          publication.setTittle(publicationdto.getTittle());
          publication.setContent(publicationdto.getContent());
          publication.setDescription(publicationdto.getDescription());

        return publication;
    }
    @Override
    public PublicationDTO getpublicationId(Long id)    {
        Publication publication = publicationrepository.findById(id)
            .orElseThrow(()-> new ResourceNotFountException("publication", "id", id));
            return mapdto(publication);
    }

    @Override
    public PublicationDTO updatePublication(PublicationDTO publicationdto, Long id) {
        Publication publication = publicationrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("publication", "id", id));
        publication.setTittle(publicationdto.getTittle());
        publication.setContent(publicationdto.getContent());
        publication.setDescription(publication.getDescription());
        Publication updatepublication = publicationrepository.save(publication);
        return mapdto(updatepublication);
    }

    @Override
    public void deletePublication(long id) {
        Publication publication = publicationrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("Publication", "Id", id));
        publicationrepository.delete(publication);
    }
}
