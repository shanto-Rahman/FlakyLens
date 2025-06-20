@Test public void shouldUseOverridenManagerFactory(){
Assert.assertSame(managerFactory,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()));
}