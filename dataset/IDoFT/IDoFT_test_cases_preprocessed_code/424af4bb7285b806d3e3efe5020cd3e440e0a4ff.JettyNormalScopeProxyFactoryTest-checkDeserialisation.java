@Test public void checkDeserialisation() throws Exception {
final File base=dir(new File("target/JettyNormalScopeProxyFactoryTest-" + System.nanoTime()));//RO
final File war=createWar(dir(new File(base,"test")),MyWrapper.class,MySessionScoped.class);
sessionDataStore.setStoreDir(new File(base,"sessions"));
Thread thread=Thread.currentThread();
ClassLoader old=thread.getContextClassLoader();
thread.setContextClassLoader(webappLoader);
if (sessionId != null) {
}
if (request.getSession() != null) {
}
assertEquals(expected,getValue.invoke(bean));
assertEquals("new",getValue.invoke(bean));
thread.setContextClassLoader(old);
}