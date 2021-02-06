package softuni.lection2.lection2.service;

import softuni.lection2.lection2.models.dtos.OfferSummaryDto;

import java.util.List;

public interface OfferService {
    public List<OfferSummaryDto> getAllOffers();
}
