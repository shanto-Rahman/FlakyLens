@Test public void singleActorSingleStageTest() throws ExecutionException, InterruptedException {
assertEquals("bla",someActor.sayHello("bla").get());
}