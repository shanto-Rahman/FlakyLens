@Test public void customPropertyNamingStrategyPascalCaseToCamelCase() throws Exception {
assertEquals("{\"PropertyName\":null}",mapper.writeValueAsString(new Bar()));
}