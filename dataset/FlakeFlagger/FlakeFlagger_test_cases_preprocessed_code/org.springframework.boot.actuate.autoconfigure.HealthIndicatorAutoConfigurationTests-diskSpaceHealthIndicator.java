@Test public void diskSpaceHealthIndicator(){
assertEquals(1,beans.size());
assertEquals(DiskSpaceHealthIndicator.class,beans.values().iterator().next().getClass());
}