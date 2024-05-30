
package com.ws.core.pagination;

public class Pagination
{
    // ---------------------------------------------------------------------
    // Properties
    // ---------------------------------------------------------------------
    private int pageSize;
    private String cursorPosition;
    // ---------------------------------------------------------------------
    // Construction
    // ---------------------------------------------------------------------
    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize( int pageSize )
    {
        this.pageSize = pageSize;
    }

    public String getCursorPosition()
    {
        return cursorPosition;
    }

    public void setCursorPosition( String cursorPosition )
    {
        this.cursorPosition = cursorPosition;
    }

    // ---------------------------------------------------------------------
    // Private Helper Methods
    // ---------------------------------------------------------------------

    // ---------------------------------------------------------------------
    // Public Methods
    // ---------------------------------------------------------------------

}

