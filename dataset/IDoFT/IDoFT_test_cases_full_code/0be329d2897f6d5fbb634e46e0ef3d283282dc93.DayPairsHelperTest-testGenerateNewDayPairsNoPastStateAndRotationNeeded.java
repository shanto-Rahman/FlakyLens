@Test public void testGenerateNewDayPairsNoPastStateAndRotationNeeded(){
  DevPairCombinations pairs=new DevPairCombinations(new ArrayList<>());
  List<Developer> devs=getStandardDevs();
  List<String> tracks=Arrays.asList("track1","track2","track3");
  Map<Pair,Integer> pairsWeight=subject.buildPairsWeightFromPastPairing(pairs,devs);
  DayPairsHelper subjectWithEverydayRotation=new DayPairsHelper(trelloPairsRepository,true);
  DayPairs dayPairs=subjectWithEverydayRotation.generateNewDayPairs(tracks,devs,pairs,pairsWeight,getStandardCompanies());
  assertThat(dayPairs.getTracks().size(),is(2));
  assertThat(dayPairs.getTracks(),contains("track1","track2"));
}
