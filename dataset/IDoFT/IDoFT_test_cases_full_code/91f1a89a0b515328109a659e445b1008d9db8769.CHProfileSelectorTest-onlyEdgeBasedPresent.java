@Test public void onlyEdgeBasedPresent(){
  List<CHProfile> chProfiles=Collections.singletonList(CHProfile.edgeBased(fastestWeighting,INFINITE_U_TURN_COSTS));
  assertCHProfileSelectionError("Found 1 edge-based CH profile(s) for weighting map {weighting=fastest, vehicle=car}, but requested node-based CH",chProfiles,false,null);
  assertCHProfileSelectionError("Found 1 edge-based CH profile(s) for weighting map {weighting=fastest, vehicle=car}, but requested node-based CH",chProfiles,false,20);
  assertProfileFound(chProfiles.get(0),chProfiles,true,null);
  assertProfileFound(chProfiles.get(0),chProfiles,null,null);
}
