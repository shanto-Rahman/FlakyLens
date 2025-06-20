@Test void testFragmentPathStructured() throws ServletException, IOException {
  DataSource dataSource=getDataSource(servlet,DS_FRAGMENT_PATH_STRUCTURED);
  assertDataSource(dataSource,ELEMENT_NAMES,ELEMENT_TITLES);
}
