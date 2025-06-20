@Test public void testToXML(){
assertNotNull(userStatusXml);
assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<user_status><status>200</status><userId>1234</userId><success>true</success><confirmed>true</confirmed>" + "<registered>true</registered><country_code>1</country_code>"+ "<devices><device>deviceA</device><device>deviceB</device></devices>"+ "<phone_number>456 758 8990</phone_number></user_status>",userStatusXml);
}