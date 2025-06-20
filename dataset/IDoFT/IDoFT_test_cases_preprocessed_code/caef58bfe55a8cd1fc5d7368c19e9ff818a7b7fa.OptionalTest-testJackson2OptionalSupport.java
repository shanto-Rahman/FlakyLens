@Test public void testJackson2OptionalSupport() throws Exception {
Assert.assertEquals(jsonWithEmail,objectMapper.writeValueAsString(personWithEmail));
Assert.assertEquals(jsonWithNullEmail,objectMapper.writeValueAsString(personWithEmptyEmail));
Assert.assertEquals(jsonWithoutEmail,objectMapper.writeValueAsString(personWithoutEmail));
Assert.assertEquals(personWithEmail,objectMapper.readValue(jsonWithEmail,Person.class));
Assert.assertEquals(personWithEmptyEmail,objectMapper.readValue(jsonWithNullEmail,Person.class));
Assert.assertEquals(personWithoutEmail,objectMapper.readValue(jsonWithoutEmail,Person.class));
}