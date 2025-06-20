@Test public void testGenerateNewDayPairsWithSmallestWeight(){
assertThat(dayPairs.getTracks().size(),is(3));
assertThat(dayPairs.getTracks(),contains("track1","track2","track3"));
assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev1"),new Developer("dev6")))),is(true));
assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev3"),new Developer("dev2")))),is(true));
assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev5"),new Developer("dev4")))),is(true));
}