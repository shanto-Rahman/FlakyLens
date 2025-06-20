@Test public void mergesMultipleResultsFromMultipleChecksWithConflictingKeys(){
  final Map<String,PluginMetadataSummary> result=new ViewRequirements(ImmutableSet.of(view -> ImmutableMap.of("parameters",plugin,"aioverlord",plugin),view -> Collections.emptyMap(),view -> ImmutableMap.of("parameters",new EnterpriseMetadataSummary(),"aioverlord",new EnterpriseMetadataSummary())),view);
  assertThat(result).contains(Maps.immutableEntry("aioverlord",plugin),Maps.immutableEntry("parameters",plugin));
}
