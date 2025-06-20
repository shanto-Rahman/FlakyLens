@Test public void nodeDropTest() throws ExecutionException, InterruptedException {
assertEquals("bla",someActor.sayHello("bla").get());
assertEquals(uuid,someActor_r3.getUniqueActivationId().get());
assertEquals(secondUUID,someActor_r4.getUniqueActivationId().get());
}