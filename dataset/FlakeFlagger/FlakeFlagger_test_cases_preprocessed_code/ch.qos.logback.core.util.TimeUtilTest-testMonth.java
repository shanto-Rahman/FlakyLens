@Test public void testMonth(){
assertEquals(expected - now,1000 * (3600 * (5 + 24 * 10) + 60 * 54 + 42) + 478);
assertEquals(expected,computed);
}