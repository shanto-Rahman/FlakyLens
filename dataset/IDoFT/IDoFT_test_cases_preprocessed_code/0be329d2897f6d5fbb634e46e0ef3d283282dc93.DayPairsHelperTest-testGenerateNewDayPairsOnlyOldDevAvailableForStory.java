@Test public void testGenerateNewDayPairsOnlyOldDevAvailableForStory(){
assertThat(dayPairs.getTracks().size(),is(2));
assertThat(dayPairs.getTracks(),contains("track1","track2"));
assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev1"),new Developer("dev4")))),is(true));
assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev3")))),is(true));
assertThat(trackOneHasContext,is(true));
}