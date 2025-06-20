@Test @WithContextClassLoader(NullClassLoader.class) public void testValidationProvidersCanBeLoadedIfContextLoaderIsNull(){
assertEquals(2,validationProviders.size());
}