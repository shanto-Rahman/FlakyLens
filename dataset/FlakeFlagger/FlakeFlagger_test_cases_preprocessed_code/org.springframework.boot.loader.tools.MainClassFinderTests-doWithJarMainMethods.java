@Test public void doWithJarMainMethods() throws Exception {
assertThat(callback.getClassNames().toString(),equalTo("[a.b.G, a.b.c.D]"));//IT
}