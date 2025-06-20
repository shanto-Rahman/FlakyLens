@Test void testComponentPathStructured() throws ServletException, IOException {
  DataSource dataSource=getDataSource(servlet,DS_COMPONENT_PATH_STRUCTURED);
  assertDataSource(dataSource,ELEMENT_NAMES,ELEMENT_TITLES);
}
