@Test public void testLoadUserByUsername() throws Exception {
assertEquals("Wrong username","administrator",userDetails.getUsername());
assertTrue("Password not matches",passwordEncoder.matches("admin",userDetails.getPassword()));
assertFalse("Wrong password accepted",passwordEncoder.matches("wrong",userDetails.getPassword()));
}