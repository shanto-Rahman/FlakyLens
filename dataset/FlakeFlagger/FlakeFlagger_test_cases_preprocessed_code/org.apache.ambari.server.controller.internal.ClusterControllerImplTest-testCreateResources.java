@Test public void testCreateResources() throws Exception {
Assert.assertEquals(TestResourceProvider.Action.Create,resourceProvider.getLastAction());
Assert.assertSame(request,resourceProvider.getLastRequest());
Assert.assertNull(resourceProvider.getLastPredicate());
}