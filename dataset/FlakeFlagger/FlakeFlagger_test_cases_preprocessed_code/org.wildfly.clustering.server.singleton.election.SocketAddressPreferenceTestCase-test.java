@Test public void test() throws UnknownHostException {
assertTrue(preference.preferred(preferredNode));
assertFalse(preference.preferred(otherNode1));
assertFalse(preference.preferred(otherNode2));
}