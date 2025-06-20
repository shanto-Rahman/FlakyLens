@Test public void mergesResultsFromMultipleChecks(){
assertThat(result).containsExactly(Maps.immutableEntry("aioverlord",plugin),Maps.immutableEntry("parameters",new EnterpriseMetadataSummary()));
}