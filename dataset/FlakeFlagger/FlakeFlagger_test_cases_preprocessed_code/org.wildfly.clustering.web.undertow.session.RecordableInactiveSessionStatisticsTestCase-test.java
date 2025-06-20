@Test public void test(){
assertEquals(0L,this.statistics.getExpiredSessionCount());
assertEquals(20L,this.statistics.getMaxSessionLifetime().toMinutes());
assertEquals(20L,this.statistics.getMeanSessionLifetime().toMinutes());
assertEquals(1L,this.statistics.getExpiredSessionCount());
assertEquals(20L,this.statistics.getMaxSessionLifetime().toMinutes());
assertEquals(15L,this.statistics.getMeanSessionLifetime().toMinutes());
assertEquals(0L,this.statistics.getExpiredSessionCount());
assertEquals(0L,this.statistics.getMaxSessionLifetime().toMinutes());
assertEquals(0L,this.statistics.getMeanSessionLifetime().toMinutes());
}