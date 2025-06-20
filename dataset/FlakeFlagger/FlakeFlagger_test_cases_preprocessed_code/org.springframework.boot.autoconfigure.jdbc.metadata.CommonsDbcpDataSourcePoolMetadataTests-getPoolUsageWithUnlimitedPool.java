@Test public void getPoolUsageWithUnlimitedPool(){
assertEquals(Float.valueOf(-1F),unlimitedDataSource.getUsage());
}