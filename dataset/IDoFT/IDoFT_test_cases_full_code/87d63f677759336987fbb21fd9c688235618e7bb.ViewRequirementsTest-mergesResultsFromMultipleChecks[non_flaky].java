@Test public void mergesResultsFromMultipleChecks(){
  final Map<String,PluginMetadataSummary> result=new ViewRequirements(ImmutableSet.of(view -> Collections.singletonMap("aioverlord",plugin),view -> Collections.emptyMap(),view -> Collections.singletonMap("parameters",new EnterpriseMetadataSummary())),view);
  assertThat(result).containsOnly(Maps.immutableEntry("aioverlord",plugin),Maps.immutableEntry("parameters",new EnterpriseMetadataSummary()));
}
