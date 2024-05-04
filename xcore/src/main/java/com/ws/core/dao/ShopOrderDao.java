
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.CartProduct;
import com.ws.core.models.ShippingAddress;
import com.ws.core.models.ShopOrder;
import com.ws.core.models.UserPayment;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class ShopOrderDao< T >
    extends Dao< ShopOrder >
{

    @Inject
    private ShippingAddressDao< ShippingAddress > shippingAddressDao;
    @Inject
    private UserPaymentDao< UserPayment >         userPaymentDao;
	@Override
    public void persist( ShopOrder shopOrder )
	{
        getEntityManager().persist( shopOrder );

	}

	@Override
    public void update( ShopOrder shopOrder )
	{
        add( shopOrder );
        getEntityManager().merge( shopOrder );
	}

	@Override
    public void delete( ShopOrder shopOrder )
	{
        getEntityManager().remove( shopOrder );

	}

    @Override
    public ShopOrder fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT so FROM ShopOrder so WHERE so.id =:id",
                                                      ShopOrder.class );
        query.setParameter( "id",
                            id );
        return ( ShopOrder )query.getSingleResult();
	}


    @Override
    public List< ShopOrder > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT so FROM ShopOrder so ",
                                               ShopOrder.class )
                                 .getResultList();
	}

    private void add( ShopOrder shopOrder )
    {
        if( shopOrder.getCartItem() != null
            && shopOrder.getCartItem().getId() != null )
        {
            CartProductDao< CartProduct > cartPropertyDao = new CartProductDao< CartProduct >();
            CartProduct cartItem = cartPropertyDao.fetch( shopOrder.getCartItem()
                                                            .getId() );
            shopOrder.setCartItem( cartItem );
        }
        if( shopOrder.getUserPayment() != null
            && shopOrder.getUserPayment().getId() != null )
        {
            UserPayment userPayment = userPaymentDao.fetch( shopOrder.getUserPayment()
                                                            .getId() );
            shopOrder.setUserPayment( userPayment );
        }
        if( shopOrder.getShippingAddress() != null
            && shopOrder.getShippingAddress().getId() != null )
        {
            ShippingAddress shippingAddress = shippingAddressDao.fetch( shopOrder.getShippingAddress()
                                                            .getId() );
            shopOrder.setShippingAddress( shippingAddress );
        }
    }

	
}
