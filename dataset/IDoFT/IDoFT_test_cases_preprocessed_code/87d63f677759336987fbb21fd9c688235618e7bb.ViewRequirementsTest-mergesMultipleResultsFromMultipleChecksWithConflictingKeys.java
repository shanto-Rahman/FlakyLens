@Test public void mergesMultipleResultsFromMultipleChecksWithConflictingKeys(){
assertThat(result).containsExactly(Maps.immutableEntry("aioverlord",plugin),Maps.immutableEntry("parameters",plugin));
}