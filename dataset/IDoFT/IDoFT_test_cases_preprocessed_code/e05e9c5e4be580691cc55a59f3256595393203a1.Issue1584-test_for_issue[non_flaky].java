public void test_for_issue() throws Exception {
assertTrue(key.equals("v") || key.equals("k"));
if (key.equals("v")) {
assertEquals("A",value);
assertEquals(1,value);
}
assertEquals(1,entry.getKey());
assertEquals("A",entry.getValue());
}