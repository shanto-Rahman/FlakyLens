@Test public void testToString(){
  final ToStringTestData toStringTestData=new ToStringTestData();
  final String toString=BusinessIdentity.toString(toStringTestData);
  Assert.assertTrue(String.format("BusinessIdentity.toString() failed!! recieved[%s]",toString),toString.startsWith("com.openpojo.business.BusinessIdentityTest$ToStringTestData [@") && toString.endsWith(": instance_name=Instance Name, static_name=Static Name, STATIC_FINAL_NAME=Static Final Name]"));
}
