@Test public void customPropertyNamingStrategyLowerCase() throws Exception {
assertEquals("{\"propertyname\":null}",mapper.writeValueAsString(new Bar()));
}