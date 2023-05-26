package com.example.lesson4_5.service;

import com.example.lesson4_5.dao.entity.BankAccountEntity;
import com.example.lesson4_5.dao.entity.CardEntity;
import com.example.lesson4_5.dao.repository.BankAccountRepository;
import com.example.lesson4_5.dao.repository.CardRepository;
import com.example.lesson4_5.exception.Error;
import com.example.lesson4_5.exception.NotFoundException;
import com.example.lesson4_5.mapper.CardMapper;
import com.example.lesson4_5.model.dto.CardDto;
import com.example.lesson4_5.model.enums.Status;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final BankAccountRepository bankAccountRepository;
    private static final Logger logger = LogManager.getLogger(CardService.class);


    public List<CardDto> getCardList() {
        List<CardEntity> cardEntityList = cardRepository.findAll();
        return CardMapper.toCardDtoList(cardEntityList);
    }

    public CardDto getCardById(Long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow(
                () -> new NotFoundException(
                        Error.CARD_NOT_FOUND_ERROR_CODE,
                        Error.CARD_NOT_FOUND_ERROR_MESSAGE)
        );
        return CardMapper.toCardDto(cardEntity);
    }


    public void createCard(CardDto cardDto) {
        logger.info("create card method called");
//        BankAccountEntity bankAccountEntity =
//                bankAccountRepository.findByIban(cardDto.getIban())
//                        .orElseThrow(() -> NotFoundException.of(Error.BANK_NOT_FOUND_ERROR_CODE,
//                                Error.BANK_NOT_FOUND_ERROR_MESSAGE, cardDto.getIban()));

    //    CardEntity newCard = CardMapper.toCardEntity(cardDto);
      ///  newCard.setBankAccountEntity(bankAccountEntity);
    //    cardRepository.save(newCard);

    }


    public void updateCard(Long id, Status newStatus) {
        Optional<CardEntity> cardEntity = cardRepository.findById(id);
        if (cardEntity.isPresent()) {
            cardEntity.get().setStatus(newStatus);
            cardRepository.save(cardEntity.get());
        }
    }

    public void removeCard(Long id) {
        Optional<CardEntity> cardEntity = cardRepository.findById(id);
        cardEntity.ifPresent(cardRepository::delete);
    }

}
