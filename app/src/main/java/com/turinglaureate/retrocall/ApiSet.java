package com.turinglaureate.retrocall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet
{

   @GET("awardees")
   Call<List<ResponseModel>> getData();

}
