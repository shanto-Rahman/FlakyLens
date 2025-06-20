@Test public void shouldCreateBaseWroManagerFactoryByDefault(){
Assert.assertEquals(DefaultWroManagerFactory.class,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()).getClass());
}