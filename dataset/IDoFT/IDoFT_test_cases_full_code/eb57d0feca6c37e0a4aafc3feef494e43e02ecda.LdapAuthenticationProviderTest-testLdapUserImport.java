@Test public void testLdapUserImport() throws NamingException {
  Mockito.when(ldapTemplate.getContextSource()).thenReturn(Mockito.mock(ContextSource.class));
  int userCount=10;
  List<User> users=prepareGetAllUserMock(userCount);
  for (int i=0; i < users.size(); i++) {
    User user=users.get(i);
    if (i % 2 == 0) {
      user.setLastName("test");
      Mockito.when(alienUserDao.find(user.getUsername())).thenReturn(user);
    }
 else {
      Mockito.when(alienUserDao.find(user.getUsername())).thenReturn(user);
    }
  }
  ldapAuthenticationProvider.importLdapUsers();
  Mockito.verify(alienUserDao,Mockito.times(users.size())).save(Mockito.any(User.class));
}
