@Test public void testBuildEnvPropertiesWithPkgNull(){
assertEquals(4,props.size());
assertEquals(appender.getInitialContextFactoryName(),props.getProperty(Context.INITIAL_CONTEXT_FACTORY));
assertEquals(appender.getProviderURL(),props.getProperty(Context.PROVIDER_URL));
assertEquals(null,props.getProperty(Context.URL_PKG_PREFIXES));
assertEquals(appender.getSecurityPrincipalName(),props.getProperty(Context.SECURITY_PRINCIPAL));
assertEquals(appender.getSecurityCredentials(),props.getProperty(Context.SECURITY_CREDENTIALS));
assertEquals(0,context.getStatusManager().getCount());
}