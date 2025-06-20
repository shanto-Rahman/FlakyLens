public void testUpperSnakeCaseTranslations() throws Exception {
assertEquals("{\"FIRST_NAME\":\"Joe\",\"LAST_NAME\":\"Sixpack\",\"AGE\":42}",json);
assertEquals("Joe",result.firstName);
assertEquals("Sixpack",result.lastName);
assertEquals(42,result.age);
}