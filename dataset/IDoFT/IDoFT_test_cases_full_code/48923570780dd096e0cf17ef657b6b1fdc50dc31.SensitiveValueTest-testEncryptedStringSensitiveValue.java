@Test public void testEncryptedStringSensitiveValue(){
  final String originalValue="foo";
  final String encryptedString="{Encrypted}foo";
  SensitiveValue value=ValueFactory.createEncryptedString(originalValue,false);
  verifyEncrypted(value,originalValue,encryptedString);
  value.encrypt();
  verifyEncrypted(value,originalValue,encryptedString);
  value.decrypt();
  verifyDecrypted(value,originalValue);
  value.decrypt();
  verifyDecrypted(value,originalValue);
  value.encrypt();
  verifyEncrypted(value,originalValue,encryptedString);
  value.encrypt();
  verifyEncrypted(value,originalValue,encryptedString);
}
