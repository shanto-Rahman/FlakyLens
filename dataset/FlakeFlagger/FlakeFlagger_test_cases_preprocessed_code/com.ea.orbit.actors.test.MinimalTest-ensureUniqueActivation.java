@Test public void ensureUniqueActivation() throws ExecutionException, InterruptedException {
assertEquals("bla",someActor.sayHello("bla").get());
assertEquals(uuid,someActor.getUniqueActivationId().get());
}