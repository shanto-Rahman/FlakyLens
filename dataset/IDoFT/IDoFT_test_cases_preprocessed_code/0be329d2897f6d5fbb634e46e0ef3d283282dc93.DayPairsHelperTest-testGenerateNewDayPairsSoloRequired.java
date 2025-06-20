@Test public void testGenerateNewDayPairsSoloRequired(){
assertThat(dayPairs.getTracks().size(),is(2));
assertThat(dayPairs.getTracks(),contains("track1","track2"));
assertThat(dayPairs.getPairByTrack("track1"),is((new Pair(Arrays.asList(new Developer("dev1"),new Developer("dev2"))))));
}