@Test public void testToString(){
Assert.assertTrue(String.format("BusinessIdentity.toString() failed!! recieved[%s]",toString),toString.startsWith("com.openpojo.business.BusinessIdentityTest$ToStringTestData [@") && toString.endsWith(": instance_name=Instance Name, STATIC_FINAL_NAME=Static Final Name, static_name=Static Name]"));
}