@Test public void shouldUseInitiallySetManagerEvenIfAnInvalidAppFactoryClassNameIsSet() throws Exception {
Assert.assertSame(mockManagerFactory,AbstractDecorator.getOriginalDecoratedObject(victim.getWroManagerFactory()));
}