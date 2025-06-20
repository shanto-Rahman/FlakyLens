@Test(timeout=3000) public void test_LoopReference() throws Exception {
assertEquals("v1",output.get("k1"));
assertSame(output,output.get("self"));
}