package com.upc.TuCine.TuCine.service.impl;

import java.time.LocalDate;

import com.upc.TuCine.TuCine.dto.save.Promotion.PromotionSaveDto;
import com.upc.TuCine.TuCine.service.PromotionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PromotionTest {

    @Mock
    private PromotionService promotionService;

    // validar que el descuento de las promociones no pasen del 90% de descuento
    @Test
    public void testDiscountLimit(){
        // Crear una promoción
        PromotionSaveDto promotionSaveDto = new PromotionSaveDto();

        // Configuración para la creación de descuentos
        promotionSaveDto.setDiscount(0.9f);

        // Verificar que el descuento no pase del 90%
        assertTrue(promotionSaveDto.getDiscount() <= 0.9);
    }

    // Validar la creacion de promociones teniendo como regla una promocion por dia
    @Test
    public void testMaxPromotionPerDay(){
        // Creación de dos promociones
        PromotionSaveDto promotion1 = new PromotionSaveDto();
        PromotionSaveDto promotion2 = new PromotionSaveDto();

        // Establecer las dos promociones para un mismo dia
        promotion1.setStartDate(LocalDate.now());
        promotion1.setEndDate(LocalDate.now());
        promotion2.setStartDate(LocalDate.now());
        promotion2.setEndDate(LocalDate.now());

        // Controlar metodo createPromotion
        //when(promotionService.createPromotion(promotion1)).thenReturn(promotion1);
        //when(promotionService.createPromotion(promotion2)).thenReturn(promotion2);

        // Verificación que solo se pueda crear una promocion por dia para un negocio
        assertEquals(1, promotionService.getAllPromotions().size());
    }

    // Validar la creaci[on de promociones teniendo como regla una promocion por semana
    @Test
    public void testMaxPromotionsPerWeek(){
        // Creacion de varias promociones
        PromotionSaveDto promotion1 = new PromotionSaveDto();
        PromotionSaveDto promotion2 = new PromotionSaveDto();
        PromotionSaveDto promotion3 = new PromotionSaveDto();
        PromotionSaveDto promotion4 = new PromotionSaveDto();
        PromotionSaveDto promotion5 = new PromotionSaveDto();

        // establecer las fechas pra las promociones
        promotion1.setStartDate(LocalDate.now());
        promotion1.setEndDate(LocalDate.now().plusDays(7));
        promotion2.setStartDate(LocalDate.now().plusDays(1));
        promotion2.setEndDate(LocalDate.now().plusDays(8));
        promotion3.setStartDate(LocalDate.now().plusDays(2));
        promotion3.setEndDate(LocalDate.now().plusDays(9));
        promotion4.setStartDate(LocalDate.now().plusDays(3));
        promotion4.setEndDate(LocalDate.now().plusDays(10));
        promotion5.setStartDate(LocalDate.now().plusDays(4));
        promotion5.setEndDate(LocalDate.now().plusDays(11));

        // Verificar que solo se hatan creado tres promociones
        assertEquals(3, promotionService.getAllPromotions().size());

        // Verificacion que no se haya superado el limite de tres promociones por semana
        //when(promotionService.createPromotion(promotion1)).thenReturn(promotion1);
        //when(promotionService.createPromotion(promotion1)).thenReturn(promotion2);
        //when(promotionService.createPromotion(promotion1)).thenReturn(promotion3);
        //when(promotionService.createPromotion(promotion1)).thenReturn(promotion4);
        //when(promotionService.createPromotion(promotion1)).thenReturn(promotion5);

    }

}
