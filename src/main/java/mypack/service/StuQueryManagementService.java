package mypack.service;

import mypack.Response.ScoreInfo;

public interface StuQueryManagementService {

    String scoreQuery(long id,String learnYear,int learnTerms,int courseType);

}
