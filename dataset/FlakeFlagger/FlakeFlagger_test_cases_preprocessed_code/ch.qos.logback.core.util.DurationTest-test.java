@Test public void test(){
assertEquals(12,d.getMilliseconds());
assertEquals(159,d.getMilliseconds());
assertEquals(15,d.getMilliseconds());
assertEquals(8,d.getMilliseconds());
assertEquals(10,d.getMilliseconds());
assertEquals(10 * 1000,d.getMilliseconds());
assertEquals(12 * 1000,d.getMilliseconds());
assertEquals(14 * 1000,d.getMilliseconds());
assertEquals(12 * 1000,d.getMilliseconds());
assertEquals(10700,d.getMilliseconds());
assertEquals(1000 * 60,d.getMilliseconds());
assertEquals(2200 * 60,d.getMilliseconds());
assertEquals(1000 * HOURS_CO,d.getMilliseconds());//RW
assertEquals(4200 * HOURS_CO,d.getMilliseconds());//RW
assertEquals(5000 * DAYS_CO,d.getMilliseconds());//RW
}