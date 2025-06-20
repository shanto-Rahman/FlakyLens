@Test public void testGenerateNewDayPairsNoPastState(){
  DevPairCombinations pairs=new DevPairCombinations(new ArrayList<>());
  List<Developer> devs=getStandardDevs();
  List<String> tracks=Arrays.asList("track1","track2","track3");
  Map<Pair,Integer> pairsWeight=subject.buildPairsWeightFromPastPairing(pairs,devs);
  DayPairs dayPairs=subject.generateNewDayPairs(tracks,devs,pairs,pairsWeight,getStandardCompanies());
  assertThat(dayPairs.getTracks().size(),is(2));
  assertThat(dayPairs.getTracks(),contains("track1","track2"));
}
