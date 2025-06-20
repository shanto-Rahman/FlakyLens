@Test public void mergesResultsFromMultipleChecks(){
assertThat(result).containsOnly(Maps.immutableEntry("aioverlord",plugin),Maps.immutableEntry("parameters",new EnterpriseMetadataSummary()));
}