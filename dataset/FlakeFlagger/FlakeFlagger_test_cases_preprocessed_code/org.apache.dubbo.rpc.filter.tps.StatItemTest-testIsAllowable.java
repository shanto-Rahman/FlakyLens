@Test public void testIsAllowable() throws Exception {
assertEquals(true,statItem.isAllowable());
Thread.sleep(1100L);
assertEquals(true,statItem.isAllowable());
assertTrue(lastResetTime != statItem.getLastResetTime());
assertEquals(4,statItem.getToken());
}