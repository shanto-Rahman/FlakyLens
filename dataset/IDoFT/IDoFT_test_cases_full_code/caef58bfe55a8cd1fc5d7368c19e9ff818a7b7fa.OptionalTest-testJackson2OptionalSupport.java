@Test public void testJackson2OptionalSupport() throws Exception {
  final ObjectMapper objectMapper=new ObjectMapper().registerModule(new Jdk8Module()).setSerializationInclusion(JsonInclude.Include.NON_NULL);
  final Person personWithEmail=new Person("afh",Optional.of("af@h.cz"));
  final Person personWithEmptyEmail=new Person("afh",Optional.<String>empty());
  final Person personWithoutEmail=new Person("afh",null);
  final String jsonWithEmail="{'name':'afh','email':'af@h.cz'}".replace('\'','\"');
  final String jsonWithNullEmail="{'name':'afh','email':null}".replace('\'','\"');
  final String jsonWithoutEmail="{'name':'afh'}".replace('\'','\"');
  Assert.assertEquals(jsonWithEmail,objectMapper.writeValueAsString(personWithEmail));
  Assert.assertEquals(jsonWithNullEmail,objectMapper.writeValueAsString(personWithEmptyEmail));
  Assert.assertEquals(jsonWithoutEmail,objectMapper.writeValueAsString(personWithoutEmail));
  Assert.assertEquals(personWithEmail,objectMapper.readValue(jsonWithEmail,Person.class));
  Assert.assertEquals(personWithEmptyEmail,objectMapper.readValue(jsonWithNullEmail,Person.class));
  Assert.assertEquals(personWithoutEmail,objectMapper.readValue(jsonWithoutEmail,Person.class));
}
