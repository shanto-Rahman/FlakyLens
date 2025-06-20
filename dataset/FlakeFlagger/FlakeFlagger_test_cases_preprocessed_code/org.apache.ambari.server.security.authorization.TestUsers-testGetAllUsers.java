@Test public void testGetAllUsers() throws Exception {
assertEquals(2,userList.size());
assertEquals(false,user.isLdapUser());
assertEquals(2,userDAO.findAll().size());
assertNotNull("user",userEntity.getUserPassword());
assertNotSame(userEntity.getUserPassword(),userDAO.findLocalUserByName("user").getUserPassword());
}