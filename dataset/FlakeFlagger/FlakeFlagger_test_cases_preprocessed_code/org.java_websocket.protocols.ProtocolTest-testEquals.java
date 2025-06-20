@Test public void testEquals() throws Exception {
assertTrue(!protocol0.equals(protocol1));
assertTrue(!protocol0.equals(protocol2));
assertTrue(protocol1.equals(protocol2));
}