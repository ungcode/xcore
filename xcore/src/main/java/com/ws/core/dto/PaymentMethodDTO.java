
package com.ws.core.dto;

import com.ws.core.models.PaymentMethod;
import java.util.ArrayList;
import java.util.List;


public class PaymentMethodDTO
{

    private Long   id;

    private String cash;

    private String card;

    public PaymentMethodDTO()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getCash()
    {
        return cash;
    }

    public void setCash( String cash )
    {
        this.cash = cash;
    }

    public String getCard()
    {
        return card;
    }

    public void setCard( String card )
    {
        this.card = card;
    }

    public PaymentMethodDTO mapper( PaymentMethod paymentMethod )
    {

        return create( paymentMethod );

    }

    public List< PaymentMethodDTO >
        mapper( List< PaymentMethod > PaymentMethods )
    {

        List< PaymentMethodDTO > dtos = new ArrayList< PaymentMethodDTO >();
        PaymentMethods.forEach( paymentMethod -> {
            dtos.add( create( paymentMethod ) );
        } );

        return dtos;

    }

    private PaymentMethodDTO create( PaymentMethod paymentMethod )
    {
        PaymentMethodDTO dto = new PaymentMethodDTO();
        dto.setId( paymentMethod.getId() );
        dto.setCard( paymentMethod.getCard() );
        dto.setCash( paymentMethod.getCash() );
        return dto;
    }

}
