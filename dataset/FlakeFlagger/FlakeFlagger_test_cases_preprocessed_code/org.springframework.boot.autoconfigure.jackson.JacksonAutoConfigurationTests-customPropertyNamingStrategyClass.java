@Test public void customPropertyNamingStrategyClass() throws Exception {
assertEquals("{\"property_name\":null}",mapper.writeValueAsString(new Bar()));
}