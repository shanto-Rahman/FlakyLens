@Test public void testGenerateNewDayPairsWithEverydayRotation(){
assertThat(dayPairs.getTracks().size(),is(2));
assertThat(dayPairs.getTracks(),contains("track1","track2"));
assertThat(dayPairs.getPairByTrack("track1"),is(not(new Pair(Arrays.asList(new Developer("dev1"),new Developer("dev2"))))));
assertThat(dayPairs.getPairByTrack("track2"),is(not(new Pair(Arrays.asList(new Developer("dev3"),new Developer("dev4"))))));
assertThat(trackOneHasDev2,is(true));
assertThat(trackTwoHasDev4,is(true));
}