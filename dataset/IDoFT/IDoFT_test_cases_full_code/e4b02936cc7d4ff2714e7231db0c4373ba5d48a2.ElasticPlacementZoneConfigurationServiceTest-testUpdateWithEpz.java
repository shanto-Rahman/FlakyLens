@Test public void testUpdateWithEpz() throws Throwable {
  ElasticPlacementZoneConfigurationState state=createState(true);
  state.resourcePoolState=buildRpState();
  state.epzState=buildEpzState(null,"tag1","tag2");
  ElasticPlacementZoneConfigurationState createdState=sendState(state,Action.POST);
  ElasticPlacementZoneConfigurationState patchState=createState(true);
  patchState.resourcePoolState.documentSelfLink=createdState.resourcePoolState.documentSelfLink;
  patchState.resourcePoolState.name="new-name";
  patchState.epzState=buildEpzState(patchState.resourcePoolState.documentSelfLink,"tag3","tag4");
  patchState.epzState.documentSelfLink=createdState.epzState.documentSelfLink;
  ElasticPlacementZoneConfigurationState latestState=sendState(patchState,Action.PATCH);
  assertEquals("new-name",latestState.resourcePoolState.name);
  assertNotNull(latestState.resourcePoolState.query);
  assertEquals(patchState.epzState.tagLinksToMatch,latestState.epzState.tagLinksToMatch);
  ResourcePoolState rp=getDocument(ResourcePoolState.class,createdState.resourcePoolState.documentSelfLink);
  assertEquals("new-name",rp.name);
  ElasticPlacementZoneState epz=getDocument(ElasticPlacementZoneState.class,createdState.epzState.documentSelfLink);
  assertEquals(patchState.epzState.tagLinksToMatch,epz.tagLinksToMatch);
}
