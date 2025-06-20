@Test public void test_Float() throws Exception {
assertTrue(1.28F == deserialize.readFloat());
fail();
}