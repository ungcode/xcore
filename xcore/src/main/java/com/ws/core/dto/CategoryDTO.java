package com.ws.core.dto;

import com.ws.core.models.Category;
import java.util.ArrayList;
import java.util.List;


public class CategoryDTO {


	private Long id;

	private String name;

	private CategoryDTO parentCategory;

    public CategoryDTO()
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

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public CategoryDTO getParentCategory()
    {
        return parentCategory;
    }

    public void setParentCategory( CategoryDTO parentCategory )
    {
        this.parentCategory = parentCategory;
    }

    public CategoryDTO mapper( Category category )
    {

        return create( category );

    }

    public List< CategoryDTO > mapper( List< Category > categories )
    {
        List< CategoryDTO > dtos = new ArrayList< CategoryDTO >();

        categories.forEach( category -> {

            dtos.add( create( category ) );
        } );

        return dtos;

    }

    // to review this recursion
    private CategoryDTO create( Category category )
    {
        CategoryDTO dto = new CategoryDTO();
        dto.setId( category.getId() );
        dto.setName( category.getName() );
        dto.setParentCategory( create( category.getParentCategory() ) );
        return dto;
    }
	
}