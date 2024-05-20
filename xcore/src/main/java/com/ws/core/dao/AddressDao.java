
package com.ws.core.dao;
import com.ws.core.idao.Dao;
import com.ws.core.models.Address;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
public class AddressDao< T >
    extends Dao< Address >
{

	@Override
    public void persist( Address address )
	{
        getEntityManager().persist( address );

	}

	@Override
	public void update(Address address)
	{
        getEntityManager().merge( address );
	}

	@Override
	public void delete(Address address)
	{
        getEntityManager().remove( address );

	}

    @Override
	public Address fetch(Long id)
	{
        Query query = getEntityManager().createQuery( "SELECT a FROM Address a WHERE a.id =:id",
                                                      Address.class );
        query.setParameter( "id",
                            id );
        return ( Address )query.getSingleResult();
	}


    @Override
	public List<Address> fetchAll()
	{
        return getEntityManager().createQuery( "SELECT a FROM Address a ",
                                               Address.class )
                                 .getResultList();
	}

	
}
