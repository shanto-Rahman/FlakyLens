@Test public void testEncryptedStringSensitiveValuePreEncrypted(){
  final String encryptedString="{Encrypted}bar";
  final String expectedDecryptedValue="bar";
  SensitiveValue value=ValueFactory.createEncryptedString(encryptedString,true);
  verifyEncrypted(value,expectedDecryptedValue,encryptedString);
  value.encrypt();
  verifyEncrypted(value,expectedDecryptedValue,encryptedString);
  value.decrypt();
  verifyDecrypted(value,expectedDecryptedValue);
  value.decrypt();
  verifyDecrypted(value,expectedDecryptedValue);
  value.encrypt();
  verifyEncrypted(value,expectedDecryptedValue,encryptedString);
  value.encrypt();
  verifyEncrypted(value,expectedDecryptedValue,encryptedString);
}
