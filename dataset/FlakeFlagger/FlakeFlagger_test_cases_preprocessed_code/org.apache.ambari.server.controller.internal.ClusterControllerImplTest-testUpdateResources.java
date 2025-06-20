@Test public void testUpdateResources() throws Exception {
Assert.assertEquals(TestResourceProvider.Action.Update,resourceProvider.getLastAction());
Assert.assertSame(request,resourceProvider.getLastRequest());
Assert.assertSame(predicate,resourceProvider.getLastPredicate());
}