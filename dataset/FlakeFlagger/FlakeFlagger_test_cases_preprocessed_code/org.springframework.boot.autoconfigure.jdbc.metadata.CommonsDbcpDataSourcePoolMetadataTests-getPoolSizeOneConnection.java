@Test public void getPoolSizeOneConnection(){
assertEquals(Integer.valueOf(1),getDataSourceMetadata().getActive());
assertEquals(Float.valueOf(0.5F),getDataSourceMetadata().getUsage());
}