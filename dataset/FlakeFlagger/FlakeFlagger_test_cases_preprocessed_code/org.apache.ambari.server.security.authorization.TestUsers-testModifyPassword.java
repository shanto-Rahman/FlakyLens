@Test(expected=AmbariException.class) public void testModifyPassword() throws Exception {
assertNotSame("user",userEntity.getUserPassword());
assertTrue(passwordEncoder.matches("user",userEntity.getUserPassword()));
assertNotSame(userEntity.getUserPassword(),userDAO.findLocalUserByName("user").getUserPassword());
fail("Exception was not thrown");
}