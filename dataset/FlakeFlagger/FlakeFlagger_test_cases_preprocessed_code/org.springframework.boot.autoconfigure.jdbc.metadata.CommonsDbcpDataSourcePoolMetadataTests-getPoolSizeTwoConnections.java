@Test public void getPoolSizeTwoConnections(){
assertEquals(Integer.valueOf(2),getDataSourceMetadata().getActive());
assertEquals(Float.valueOf(1F),getDataSourceMetadata().getUsage());
}