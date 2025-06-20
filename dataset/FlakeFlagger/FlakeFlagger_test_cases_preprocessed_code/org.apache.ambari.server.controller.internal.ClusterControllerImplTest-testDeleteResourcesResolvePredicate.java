@Test public void testDeleteResourcesResolvePredicate() throws Exception {
Assert.assertEquals(TestResourceProvider.Action.Delete,resourceProvider.getLastAction());
Assert.assertNull(resourceProvider.getLastRequest());
Assert.assertFalse(predicate.equals(lastPredicate));
Assert.assertEquals(predicatePropertyIds.size(),keyPropertyIds.size());
Assert.assertTrue(keyPropertyIds.containsAll(predicatePropertyIds));
}