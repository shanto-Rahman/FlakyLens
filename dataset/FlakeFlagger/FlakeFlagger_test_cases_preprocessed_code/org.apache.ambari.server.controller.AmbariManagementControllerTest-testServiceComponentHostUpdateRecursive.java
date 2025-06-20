@Test public void testServiceComponentHostUpdateRecursive() throws AmbariException {
fail("Expected failure for invalid transition");
fail("Expected failure for invalid states");
Assert.assertNotNull(trackAction);
Assert.assertFalse(actionDB.getAllStages(requestId).isEmpty());
Assert.assertNull(trackAction);
}