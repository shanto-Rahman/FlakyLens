@Test public void parentContextCreationWithChildShutdown() throws Exception {
assertThat(((SpyApplicationContext)this.context).getRegisteredShutdownHook(),equalTo(true));//IT
}