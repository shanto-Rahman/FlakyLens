@Test public void testOnlyExternalContextAllowsCache() throws Exception {
Assert.assertTrue(services.isSuccessfulBoot());
if (addr.size() == 2 && addr.getLastElement().getKey().equals(NamingSubsystemModel.BINDING) && BindingType.forName(addOp.get(NamingBindingResourceDefinition.BINDING_TYPE.getName()).asString()) != BindingType.EXTERNAL_CONTEXT) {
}
}