@Test public void onlyNodeBasedPresent(){
  List<CHProfile> chProfiles=Collections.singletonList(CHProfile.nodeBased(fastestWeighting));
  assertCHProfileSelectionError("Found a node-based CH profile for weighting map {weighting=fastest, vehicle=car}, but requested edge-based CH",chProfiles,true,null);
  assertCHProfileSelectionError("Found a node-based CH profile for weighting map {weighting=fastest, vehicle=car}, but requested edge-based CH",chProfiles,true,20);
  assertProfileFound(chProfiles.get(0),chProfiles,false,null);
  assertProfileFound(chProfiles.get(0),chProfiles,false,20);
  assertProfileFound(chProfiles.get(0),chProfiles,null,null);
  assertProfileFound(chProfiles.get(0),chProfiles,null,30);
  assertCHProfileSelectionError("Cannot find CH profile for weighting map",chProfiles,"foot","fastest",false,null);
}
