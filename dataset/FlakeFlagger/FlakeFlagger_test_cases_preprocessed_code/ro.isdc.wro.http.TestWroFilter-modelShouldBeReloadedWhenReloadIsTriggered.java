/** 
 * Proves that the model reload has effect.
 */
@Test public void modelShouldBeReloadedWhenReloadIsTriggered() throws Exception {
if (!wasCreated) {
}
assertTrue(modelFactory.create().getGroups().isEmpty());
assertEquals(1,modelFactory.create().getGroups().size());
}