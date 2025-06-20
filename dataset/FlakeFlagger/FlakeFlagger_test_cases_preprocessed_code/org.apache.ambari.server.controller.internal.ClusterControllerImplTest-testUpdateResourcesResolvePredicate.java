@Test public void testUpdateResourcesResolvePredicate() throws Exception {
Assert.assertEquals(TestResourceProvider.Action.Update,resourceProvider.getLastAction());
Assert.assertSame(request,resourceProvider.getLastRequest());
Assert.assertFalse(predicate.equals(lastPredicate));
Assert.assertEquals(predicatePropertyIds.size(),keyPropertyIds.size());
Assert.assertTrue(keyPropertyIds.containsAll(predicatePropertyIds));
}