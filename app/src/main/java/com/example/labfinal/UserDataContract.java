package com.example.labfinal;

public final class UserDataContract {

    private UserDataContract() {
    }

    public static class UserDataEntry {
        public static final String TABLE_NAME = "UserData";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_FIRST_NAME = "first_name";
        public static final String COLUMN_LAST_NAME = "last_name";
        public static final String COLUMN_REGISTRATION_NO = "registration_no";
        public static final String COLUMN_PHONE_NO = "phone_no";
        public static final String COLUMN_USER_EMAIL = "user_email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_ADDRESS = "address";
    }
}

