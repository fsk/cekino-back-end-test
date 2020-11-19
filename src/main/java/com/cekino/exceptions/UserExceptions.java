package com.cekino.exceptions;

public class UserExceptions {

    private UserExceptions(){

    }

    public static final String BASE_EXCEPTION = " *** ERROR.! *** ";

    public static final String GET_ALL_USER_EXCEPTION = BASE_EXCEPTION + " USERS WERE NOT BE LISTED.!";

    public static final String  USER_NOT_FOUND = BASE_EXCEPTION + " USER NOT FOUND.!";

    public static final String USER_GET_BY_ID_EXCEPTION = BASE_EXCEPTION + " AN ERROR OCCURED WHILE FETCHING THE RECORD BY ID.!";

    public static final String COMPULSORY_FIELDS = "NAME" + "\n" + "SURNAME" + "\n"  + "EMAIL" + "\n"  + "USERNAME" + "\n"  + "IDENTITY NUMBER(nullable = false)";

    public static final String COMPULSORY_FIELDS_EXCEPTION = BASE_EXCEPTION + "  COMPULSORY FIELDS CAN NOT BE LEFT BLANK.!\" + \" COMPULSORY FIELDS: ";

    public static final String EMAIL_ALREADY_EXISTS = BASE_EXCEPTION + " THIS EMAIL ALREADY EXIST.!";

    public static final String INVALID_EMAIL = BASE_EXCEPTION + " INVALID EMAIL.!";

    public static final String USER_NAME_ALREADY_EXISTS = BASE_EXCEPTION + " THIS USERNAME ALREADY EXIST.!";
    
    public static final String IDENTITY_NUMBER_ALREADY_EXISTS = BASE_EXCEPTION + " THIS IDENTITY NUMBER ALREADY EXIST.!";

    public static final String MIN_CHARACTER_EXCEPTION = BASE_EXCEPTION + " USER NAME MUST BE AT LEAST 3(Three) CHARACTER.!";

    public static final String IDENTITY_NUMBER_EXCEPTION = BASE_EXCEPTION + " IDENTITY NUMBER MUST BE 11(Eleven) CHARACTER.!";

    public static final String GENDER_EXCEPTION = BASE_EXCEPTION + " GENDER MUST BE 1(One) CHARACTER.!";

    public static final String INSERT_EXCEPTION = BASE_EXCEPTION + " AN ERROR OCCURED WHILE ADDING THE RECORD.!";

    public static final String UPDATE_NOT_IDENTITY_NUMBER = BASE_EXCEPTION + " IDENTITY NUMBER CAN NOT UPDATE.!";

    public static final String UPDATE_NOT_ID = BASE_EXCEPTION + " ID CAN NOT UPDATE.!";

    public static final String UPDATE_NOT_DATE_OF_CREATE = BASE_EXCEPTION + " DATE of CREATED COULD NOT UPDATE.!";

    public static final String UPDATE_BY_ID_EXCEPTION = BASE_EXCEPTION + " AN ERROR OCCURED WHILE UPDATING THE RECORD.!";

    public static final String DELETE_BY_ID_EXCEPTION =  BASE_EXCEPTION + " AN ERROR OCCURED WHILE DELETING THE RECORD.!";

    public static final String DELETE_ALL_USERS_EXCEPTION = BASE_EXCEPTION + " AN ERROR OCCURED WHILE DELETING ALL RECORDS.!";
    
    public static final String INVALID_GENDER_CHARACTER_LENGTH = BASE_EXCEPTION + " GENDER MUST BE 1(One) CHARACTER.!";
    
    public static final String INVALID_GENDER_CHARACTER = BASE_EXCEPTION + " GENDER MUST BE 'E' or 'K'.!";
    
    public static final String INVALID_AGE = BASE_EXCEPTION + " THIS AGE IS INVALID.!";
}
