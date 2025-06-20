@Test public void activationTest() throws ExecutionException, InterruptedException {
assertTrue(actor1.getActivationWasCalled().get());
}