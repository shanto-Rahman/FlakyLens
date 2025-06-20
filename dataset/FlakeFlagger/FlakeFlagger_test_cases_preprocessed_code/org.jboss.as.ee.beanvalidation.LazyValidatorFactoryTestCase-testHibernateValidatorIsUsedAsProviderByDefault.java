@Test public void testHibernateValidatorIsUsedAsProviderByDefault(){
assertNotNull("LazyValidatorFactory should delegate to the HV factory by default",hibernateValidatorFactory);
assertNotNull("LazyValidatorFactory should provide a validator",validator);
}