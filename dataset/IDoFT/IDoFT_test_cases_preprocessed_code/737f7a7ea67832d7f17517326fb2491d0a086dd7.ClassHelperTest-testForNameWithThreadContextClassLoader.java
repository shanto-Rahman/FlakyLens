@Test public void testForNameWithThreadContextClassLoader() throws Exception {
ClassLoader oldClassLoader=Thread.currentThread().getContextClassLoader();
Thread.currentThread().setContextClassLoader(classLoader);
Thread.currentThread().setContextClassLoader(oldClassLoader);
}