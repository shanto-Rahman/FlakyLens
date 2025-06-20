@Test public void warLayout() throws Exception {
assertThat(layout.getLibraryDestination("lib.jar",LibraryScope.COMPILE),equalTo("WEB-INF/lib/"));
assertThat(layout.getLibraryDestination("lib.jar",LibraryScope.PROVIDED),equalTo("WEB-INF/lib-provided/"));
assertThat(layout.getLibraryDestination("lib.jar",LibraryScope.RUNTIME),equalTo("WEB-INF/lib/"));
}