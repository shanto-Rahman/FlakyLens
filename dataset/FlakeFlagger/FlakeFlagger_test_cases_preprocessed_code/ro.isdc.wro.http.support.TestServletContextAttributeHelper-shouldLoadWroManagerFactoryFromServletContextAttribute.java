@Test public void shouldLoadWroManagerFactoryFromServletContextAttribute() throws Exception {
Assert.assertSame(expectedManagerFactory,AbstractDecorator.getOriginalDecoratedObject(filter.getWroManagerFactory()));
}