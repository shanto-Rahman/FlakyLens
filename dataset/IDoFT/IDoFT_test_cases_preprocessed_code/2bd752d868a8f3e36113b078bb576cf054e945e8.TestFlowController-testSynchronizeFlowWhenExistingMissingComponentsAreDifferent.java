@Test public void testSynchronizeFlowWhenExistingMissingComponentsAreDifferent() throws IOException {
Assert.fail("Should have thrown exception");
assertTrue(e.getMessage(),e.getMessage().contains("Current flow has missing components that are not considered missing in the proposed flow (1,2,3)"));
}