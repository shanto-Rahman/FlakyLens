@Test public void groups(){
assertEquals(2,groups.size());
assertTrue("Wrong groups: " + groups,groups.contains("foo"));
}