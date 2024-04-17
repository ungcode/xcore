package com.ws.core.dto;

import com.ws.core.models.UserPayment;
import java.util.ArrayList;
import java.util.List;


public class UserPaymentDTO
{

	private long id;
	private boolean isDefault;
    private TuserDTO          user;
    private PaymentMethodDTO paymentMethod;

    public UserPaymentDTO()
    {
	}

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public boolean isDefault()
    {
        return isDefault;
    }

    public void setDefault( boolean isDefault )
    {
        this.isDefault = isDefault;
    }

    public TuserDTO getUser()
    {
        return user;
    }

    public void setUser( TuserDTO user )
    {
        this.user = user;
    }

    public PaymentMethodDTO getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod( PaymentMethodDTO paymentMethod )
    {
        this.paymentMethod = paymentMethod;
    }

    public UserPaymentDTO mapper( UserPayment userPayment )
    {


        return create( userPayment );

    }

    public List< UserPaymentDTO >
        mapper( List< UserPayment > UserPayments )
    {

        List< UserPaymentDTO > dtos = new ArrayList< UserPaymentDTO >();
        
        UserPayments.forEach( userPayment -> {
            dtos.add( create( userPayment ) );
        } );

        return dtos;

    }

    private UserPaymentDTO create( UserPayment userPayment )
    {
        UserPaymentDTO dto = new UserPaymentDTO();
        dto.setId( userPayment.getId() );
        dto.setDefault( userPayment.isDefault() );
        dto.setUser( new TuserDTO().mapper( userPayment.getUser() ) );
        dto.setPaymentMethod( new PaymentMethodDTO().mapper( userPayment.getPaymentMethod() ) );
        return dto;
    }


}
