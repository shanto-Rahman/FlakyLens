@Test public void testGenerateNewDayPairsNoPastStateAndRotationNeeded(){
assertThat(dayPairs.getTracks().size(),is(2));
assertThat(dayPairs.getTracks(),contains("track1","track2"));
}