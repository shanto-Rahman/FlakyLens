@Test public void getPoolSizeNoConnection(){
assertEquals(Integer.valueOf(0),getDataSourceMetadata().getActive());
assertEquals(Float.valueOf(0),getDataSourceMetadata().getUsage());
}