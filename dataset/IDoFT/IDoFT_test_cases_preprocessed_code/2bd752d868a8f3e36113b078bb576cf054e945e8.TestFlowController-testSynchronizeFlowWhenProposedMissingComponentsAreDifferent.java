@Test public void testSynchronizeFlowWhenProposedMissingComponentsAreDifferent(){
Assert.fail("Should have thrown exception");
assertTrue(e.getMessage().contains("Proposed flow has missing components that are not considered missing in the current flow (1,2)"));
}