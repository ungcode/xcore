
package com.ws.core.util;


import com.google.gson.Gson;
import jakarta.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON
{
    private Gson       GsonObj;
    private JsonObject obj;
    public ParseJSON( JsonObject obj )
    {
        this.obj = obj;
        this.GsonObj = new Gson();
    }

    public Gson getGsonObj()
    {
        return GsonObj;
    }

    public JsonObject getObj()
    {
        return obj;
    }

    public < T > T GetObj( Class< T > _class )
    {
        return this.GsonObj.fromJson( this.obj.toString(),
                                      _class );
    }
    public < T > T buildObj( String _key,
                           Class< T > _class )
    {
        return this.GsonObj.fromJson( this.obj.get( _key ).toString(),
                                      _class );
    }

    public < T > List< T > buildObjList( String _key,
                                         Class< T > _class )
    {
        List< T > variable = new ArrayList<>();
        this.obj.get( _key ).asJsonArray().forEach( prop -> {
            variable.add( this.GsonObj.fromJson( prop.toString(),
                                                 _class ) );
        } );
        return variable;
    }

}
