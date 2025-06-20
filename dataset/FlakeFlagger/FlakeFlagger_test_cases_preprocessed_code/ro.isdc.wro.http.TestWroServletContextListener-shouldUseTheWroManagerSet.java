@Test public void shouldUseTheWroManagerSet(){
Assert.assertSame(managerFactory,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()));
}