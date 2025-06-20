@Test public void testUpdateWithEpz() throws Throwable {
assertEquals("new-name",latestState.resourcePoolState.name);
assertNotNull(latestState.resourcePoolState.query);
assertEquals(patchState.epzState.tagLinksToMatch,latestState.epzState.tagLinksToMatch);
assertEquals("new-name",rp.name);
assertEquals(patchState.epzState.tagLinksToMatch,epz.tagLinksToMatch);
}