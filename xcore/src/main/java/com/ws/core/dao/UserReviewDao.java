
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.ShopOrder;
import com.ws.core.models.Tuser;
import com.ws.core.models.UserReview;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class UserReviewDao< T >
    extends Dao< UserReview >
{

    @Inject
    private ShopOrderDao< ShopOrder > shopOrderDao;
    @Inject
    private UserDao< Tuser >          userDao;
	@Override
    public void persist( UserReview userReview )
	{
        getEntityManager().persist( userReview );

	}

	@Override
    public void update( UserReview userReview )
	{
        add( userReview );
        getEntityManager().merge( userReview );
	}

	@Override
    public void delete( UserReview userReview )
	{
        getEntityManager().remove( userReview );

	}

    @Override
    public UserReview fetch( Long id )
	{
        Query query = getEntityManager().createQuery( "SELECT ur FROM UserReview ur WHERE ur.id =:id",
                                                      UserReview.class );
        query.setParameter( "id",
                            id );
        return ( UserReview )query.getSingleResult();
	}


    @Override
    public List< UserReview > fetchAll()
	{
        return getEntityManager().createQuery( "SELECT ur FROM UserReview ur ",
                                               UserReview.class )
                                 .getResultList();
	}

    private void add( UserReview userReview )
    {
        if( userReview.getUser() != null
            && userReview.getUser().getId() != null )
        {
            Tuser user = userDao.fetch( userReview.getUser().getId() );
            userReview.setUser( user );
        }
        if( userReview.getShopOrder() != null
            && userReview.getShopOrder().getId() != null )
        {
            ShopOrder shopOrder = shopOrderDao.fetch( userReview.getShopOrder()
                                                                .getId() );
            userReview.setShopOrder( shopOrder );
        }
    }

	
}
