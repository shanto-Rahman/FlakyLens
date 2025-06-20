@Test public void testWeek(){
if (dayOffset != 0) {
}
assertEquals(expected - now,1000 * (3600 * (5 + 24 * (5 + dayOffset)) + 60 * 54 + 42) + 478);
assertEquals(expected,computed);
}