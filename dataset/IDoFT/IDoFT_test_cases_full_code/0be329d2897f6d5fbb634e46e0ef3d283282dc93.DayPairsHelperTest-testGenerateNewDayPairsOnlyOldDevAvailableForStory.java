@Test public void testGenerateNewDayPairsOnlyOldDevAvailableForStory(){
  PairCombinations pairs=getLongPairsList();
  List<Developer> devs=Arrays.asList(new Developer("dev1"),new Developer("dev3"),new Developer("dev4"));
  List<String> tracks=Arrays.asList("track1","track2","track3");
  Map<Pair,Integer> pairsWeight=subject.buildPairsWeightFromPastPairing(pairs,devs);
  DayPairs dayPairs=subject.generateNewDayPairs(tracks,devs,pairs,pairsWeight,getStandardCompanies());
  assertThat(dayPairs.getTracks().size(),is(2));
  assertThat(dayPairs.getTracks(),contains("track1","track2"));
  assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev1"),new Developer("dev4")))),is(true));
  assertThat(dayPairs.hasPair(new Pair(Arrays.asList(new Developer("dev3")))),is(true));
  boolean trackOneHasContext=dayPairs.getPairByTrack("track1").getFirstDev().hasContext() || dayPairs.getPairByTrack("track1").getSecondDev().hasContext();
  assertThat(trackOneHasContext,is(true));
}
