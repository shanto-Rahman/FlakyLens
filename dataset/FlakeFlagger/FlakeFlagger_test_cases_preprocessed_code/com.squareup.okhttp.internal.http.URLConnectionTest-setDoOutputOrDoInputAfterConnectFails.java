@Test public void setDoOutputOrDoInputAfterConnectFails() throws Exception {
connection.setDoOutput(true);//ET
fail();
connection.setDoInput(true);//ET
fail();
}