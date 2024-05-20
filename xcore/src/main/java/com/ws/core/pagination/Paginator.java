
package com.ws.core.pagination;

import jakarta.persistence.Query;


public class Paginator< T >
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------

    private Query      query;
    private Pagination pagination;
    private PaginationResult< T > paginationResult;

    public Paginator( Query query,
                      Pagination pagination )
    {
        this.query = query;
        this.pagination = pagination;
        setPaginationResult( new PaginationResult<>() );
        createResult();

    }

    @SuppressWarnings( "unchecked" )
    public void createResult()
    {

        long totalRecords = getTotalRecords( query );
        int lastPageNumber = calculateLastPageNumber( pagination,
                                                      totalRecords );
        int start = ( pagination.getPageNumber()
                          - 1 )
                        * pagination.getPageSize();

        query.setFirstResult( start );
        query.setMaxResults( pagination.getPageSize() );

        paginationResult.setCurrentPageNumber( pagination.getPageNumber() );
        paginationResult.setPageSize( pagination.getPageSize() );
        paginationResult.setLastPageNumber( lastPageNumber );
        paginationResult.setTotalRecords( totalRecords );
        paginationResult.setRecords( query.getResultList() );

    }

    private long getTotalRecords( Query query )
    {
        return query.getResultList().size();
    }

    private int calculateLastPageNumber( final Pagination pagination,
                                        long totalRecords )
    {
        if( totalRecords
            % pagination.getPageSize() == 0 )
        {
            return ( int )( totalRecords
                            / pagination.getPageSize() );

        }
        return ( int )( totalRecords
                        / pagination.getPageSize() )
               + 1;

    }

    public PaginationResult< T > getPaginationResult()
    {
        return paginationResult;
    }

    public void setPaginationResult( PaginationResult< T > paginationResult )
    {
        this.paginationResult = paginationResult;
    }

}

// -------------------------------------------------------------------------
// end of class Paginator.java
