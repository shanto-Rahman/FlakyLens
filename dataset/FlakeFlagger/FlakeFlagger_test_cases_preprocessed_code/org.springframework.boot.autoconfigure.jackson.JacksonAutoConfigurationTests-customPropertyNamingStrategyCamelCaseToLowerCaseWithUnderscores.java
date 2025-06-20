@Test public void customPropertyNamingStrategyCamelCaseToLowerCaseWithUnderscores() throws Exception {
assertEquals("{\"property_name\":null}",mapper.writeValueAsString(new Bar()));
}