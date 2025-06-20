@Test public void testSessionCookieSettingWorks() throws Exception {
assertEquals("NINJA_SESSION",cookieCaptor.getValue().getName());
assertEquals(computedSign,cookieString.substring(0,cookieString.indexOf("-")));
assertTrue(cookieString.contains("___TS"));
}