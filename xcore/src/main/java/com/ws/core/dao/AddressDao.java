
package com.ws.core.dao;
import com.ws.core.idao.IDao;
import com.ws.core.models.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;


public class AddressDao< T >
    implements IDao< Address >
{

	@PersistenceContext
	private EntityManager em;


	@Override
    public void persist( Address address )
	{
		em.persist(address);

	}

	@Override
	public void update(Address address)
	{
        em.merge( address );
	}

	@Override
	public void delete(Address address)
	{
        em.remove( address );

	}

    @Override
	public Address fetch(Long id)
	{
        String strQuery = "SELECT a FROM Address a WHERE id =:id";
        Query query = em.createQuery( strQuery );
        query.setParameter( "id",
                            id );
        return ( Address )query.getSingleResult();
	}



    @Override
	public List<Address> fetchAll()
	{
        return em.createQuery( "select a from Address a ",
                               Address.class )
                 .getResultList();
	}
	
}
