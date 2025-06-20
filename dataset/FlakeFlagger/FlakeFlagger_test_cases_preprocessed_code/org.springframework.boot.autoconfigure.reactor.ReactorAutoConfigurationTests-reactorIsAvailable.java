@Test public void reactorIsAvailable(){
assertNotNull(this.context.getBean(Reactor.class));
}