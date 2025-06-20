@Test public void testStatColumnEntriesCompat(){
assertEquals("{\"BASIC_STATS\":\"true\",\"COLUMN_STATS\":{\"Foo\":\"true\"}}",params0.get(StatsSetupConst.COLUMN_STATS_ACCURATE));
}