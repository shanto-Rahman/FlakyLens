@Test public void testGetScopeRegistration() throws Exception {
  ScopeRegistration scopeRegistration=ScopeRegistrationServiceStubFactory.getScopeRegistration();
  Assert.assertTrue(scopeRegistration instanceof DefaultScopeRegistrationImpl);
}
