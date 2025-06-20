@Test public void noCustomPropertyNamingStrategy() throws Exception {
assertEquals("{\"propertyName\":null}",mapper.writeValueAsString(new Bar()));
}