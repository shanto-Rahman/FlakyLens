@Test public void testStatColumnEntriesCompat(){
  Map<String,String> params0=new HashMap<>();
  StatsSetupConst.setBasicStatsState(params0,String.valueOf(true));
  StatsSetupConst.setColumnStatsState(params0,Lists.newArrayList("Foo"));
  assertEquals("{\"BASIC_STATS\":\"true\",\"COLUMN_STATS\":{\"Foo\":\"true\"}}",params0.get(StatsSetupConst.COLUMN_STATS_ACCURATE));
}
