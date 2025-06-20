@Test public void testDisabledPlugins() throws Exception {
assertNotNull(lifeCycle);
assertNull(lifeCycle.getContext().getPlugin(GroovyRepl.class));
assertNull(lifeCycle.getContext().getPlugin(ProcessorIOHandler.class));
assertNull(lifeCycle.getContext().getPlugin(JaasAuthenticationPlugin.class));
}