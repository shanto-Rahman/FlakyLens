@Test public void setDataSource() throws Exception {
given(xaConnection.getConnection()).willReturn(connection);
}