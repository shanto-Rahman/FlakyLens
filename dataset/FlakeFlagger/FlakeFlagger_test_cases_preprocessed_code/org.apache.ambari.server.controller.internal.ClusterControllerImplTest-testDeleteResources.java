@Test public void testDeleteResources() throws Exception {
Assert.assertEquals(TestResourceProvider.Action.Delete,resourceProvider.getLastAction());
Assert.assertNull(resourceProvider.getLastRequest());
Assert.assertSame(predicate,resourceProvider.getLastPredicate());
}