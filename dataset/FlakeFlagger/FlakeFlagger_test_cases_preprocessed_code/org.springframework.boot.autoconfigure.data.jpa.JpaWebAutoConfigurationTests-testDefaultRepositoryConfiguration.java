@Test public void testDefaultRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(CityRepository.class));
assertNotNull(this.context.getBean(PageableHandlerMethodArgumentResolver.class));
assertTrue(this.context.getBean(FormattingConversionService.class).canConvert(Long.class,City.class));
}