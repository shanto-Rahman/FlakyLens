/** 
 * Makes sure  {@link Capability#read(InputStream)} rejects unexpected payload.
 */
@Test public void capabilityRead() throws Exception {
  ByteArrayOutputStream baos=new ByteArrayOutputStream();
  ObjectOutputStream oos=new ObjectOutputStream(Mode.TEXT.wrap(baos));
  oos.writeObject(new Security218("rifle"));
  oos.close();
  try {
    Capability.read(new ByteArrayInputStream(baos.toByteArray()));
  }
 catch (  SecurityException e) {
    assertEquals("Rejected: " + Security218.class.getName(),e.getMessage());
  }
}
