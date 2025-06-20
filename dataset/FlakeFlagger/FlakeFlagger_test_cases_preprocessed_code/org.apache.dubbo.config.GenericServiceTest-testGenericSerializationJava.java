@Test public void testGenericSerializationJava() throws Exception {
Assert.assertTrue(obj instanceof byte[]);
Assert.assertEquals(ref.sayName(name),ExtensionLoader.getExtensionLoader(Serialization.class).getExtension("nativejava").deserialize(null,new ByteArrayInputStream(result)).readObject().toString());
Assert.assertTrue(obj instanceof byte[]);
Assert.assertEquals(users,ExtensionLoader.getExtensionLoader(Serialization.class).getExtension("nativejava").deserialize(null,new ByteArrayInputStream(result)).readObject());
Assert.assertTrue(obj instanceof byte[]);
Assert.assertEquals(Integer.MAX_VALUE,ExtensionLoader.getExtensionLoader(Serialization.class).getExtension("nativejava").deserialize(null,new ByteArrayInputStream((byte[])obj)).readObject());
}