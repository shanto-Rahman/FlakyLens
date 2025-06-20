@Test public void mergesMultipleResultsFromMultipleChecksWithConflictingKeys(){
assertThat(result).contains(Maps.immutableEntry("aioverlord",plugin),Maps.immutableEntry("parameters",plugin));
}