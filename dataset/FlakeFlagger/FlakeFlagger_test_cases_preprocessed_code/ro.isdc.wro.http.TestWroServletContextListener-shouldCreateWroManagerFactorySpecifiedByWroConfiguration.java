@Test public void shouldCreateWroManagerFactorySpecifiedByWroConfiguration(){
Assert.assertEquals(DefaultWroManagerFactory.class,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()).getClass());
}