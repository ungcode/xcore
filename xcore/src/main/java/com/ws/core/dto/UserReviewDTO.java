package com.ws.core.dto;

import com.ws.core.models.UserReview;
import java.util.ArrayList;
import java.util.List;


public class UserReviewDTO
{

	private Long id;
	
	private int rating;
	
	private String comment;

    private TuserDTO                 user;
	
	public UserReviewDTO()
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

    public int getRating()
    {
        return rating;
    }

    public void setRating( int rating )
    {
        this.rating = rating;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment( String comment )
    {
        this.comment = comment;
    }



    public TuserDTO getUser()
    {
        return user;
    }

    public void setUser( TuserDTO user )
    {
        this.user = user;
    }


    public UserReviewDTO mapper( UserReview userReview )
    {

        return create( userReview );

    }

    public List< UserReviewDTO > mapper( List< UserReview > userReviews )
    {

        List< UserReviewDTO > dtos = new ArrayList< UserReviewDTO >();
        userReviews.forEach( userReview -> {
            dtos.add( create( userReview ) );
        } );

        return dtos;

    }

    private UserReviewDTO create( UserReview userReview )
    {
        UserReviewDTO dto = new UserReviewDTO();
        dto.setId( userReview.getId() );
        dto.setComment( userReview.getComment() );
        dto.setRating( userReview.getRating() );
        dto.setUser( new TuserDTO().mapper( userReview.getUser() ) );
        return dto;
    }

}
