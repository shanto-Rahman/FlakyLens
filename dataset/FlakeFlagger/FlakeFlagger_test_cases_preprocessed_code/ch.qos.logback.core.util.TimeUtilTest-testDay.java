@Test public void testDay(){
assertEquals(expected - now,1000 * (3600 * 5 + 60 * 54 + 42) + 478);
assertEquals(expected,computed);
}