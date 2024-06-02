
package com.ws.core.pagination;

import com.ws.core.util.XcoreLogger;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import java.util.List;


public class Paginator< T >
{
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------

    private final String          CURSOR_POSITION = "cursorPosition";
    private Query      query;
    private Pagination pagination;
    private PaginationResult< T > paginationResult;
    List< Tuple >                 tuples;

    public Paginator()
    {

    }

    public Paginator( Pagination pagination )
    {
        this.pagination = pagination;
        setPaginationResult( new PaginationResult<>() );

    }

    @SuppressWarnings( "unchecked" )
    public void search()
    {
        long totalRecords = getTotalRecords( query );
        int lastPageNumber = calculateLastPageNumber( pagination,
                                                      totalRecords );

        query.setFirstResult( 0 );
        query.setMaxResults( pagination.getPageSize() );

        paginationResult.setPageSize( pagination.getPageSize() );
        paginationResult.setLastPageNumber( lastPageNumber );
        paginationResult.setTotalRecords( totalRecords );
        
        List< Tuple > tuples = query.getResultList();

        setTuples( tuples );

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

    public List< Tuple > getTuples()
    {

        return tuples;
    }

    public void setTuples( List< Tuple > tuples )
    {
        this.tuples = tuples;
    }

    public Query getQuery()
    {
        return query;
    }

    // to do: extract cursor from the supplied cursor token
    private Long getCursor()
    {
        final String TAG = "Paginator.getCursor";

        try
        {
            if( !pagination.getCursorPosition().equals( "0" ) )
            {
                // to do...
            }
        }
        catch( Exception e )
        {
            XcoreLogger.error( TAG,
                               e.getMessage() );

        }
        return Long.valueOf( pagination.getCursorPosition() );
    }

    // to do: encrypt the the nextPageToken
    public String encryptNextPageToken( String nextPageToken )
    {

        final String TAG = "Paginator.encryptNextPageToken";

        try
        {
            // to do ...
        }
        catch( Exception e )
        {
            XcoreLogger.error( TAG,
                               e.getMessage() );

        }
        return nextPageToken;
    }

    public void setQuery( Query query )
    {
        query.setParameter( CURSOR_POSITION,
                            getCursor() );
        this.query = query;
    }

    public void setFinalResult( Paginator< T > paginator,
                           List< T > data,
                           String nextToken )
    {
        if( !data.isEmpty() )
        {
            paginator.getPaginationResult()
                     .setNextPageToken( paginator.encryptNextPageToken( nextToken ) );
            paginator.getPaginationResult().setRecords( data );
        }
    }



}

// -------------------------------------------------------------------------
// end of class Paginator.java
