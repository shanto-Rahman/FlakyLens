@Test public void testToJSON(){
assertNotNull(userStatusJson);
assertEquals(userStatusJson,"{\"phoneNumber\":\"456 758 8990\"," + "\"devices\":\"[deviceA, deviceB]\",\"success\":\"true\"," + "\"countryCode\":\"1\",\"registered\":\"true\",\"userId\":\"1234\",\"confirmed\":\"true\"}");
}