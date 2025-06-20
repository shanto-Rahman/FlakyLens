@Test public void sendTest02() throws RemotingException {
Assert.assertEquals(objects.get(0).getClass(),Request.class);
Assert.assertEquals(request.getVersion(),"2.0.2");
}