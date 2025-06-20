@Test public void test() throws IOException {
assertEquals(str2,mapper.writeValueAsString(obj));
assertEquals(str,mapper.writeValueAsString(new Object[]{new SomeObject(5)}));
assertEquals(str,mapper.writeValueAsString(obj));
assertEquals(str2,mapper.writeValueAsString(obj));
assertEquals(str2,mapper.writeValueAsString(obj));
assertEquals(str2,mapper.writeValueAsString(obj2));
assertEquals(str,mapper.writeValueAsString(obj));
assertEquals("{\"payload\":{\"@type\":-47419438,\"payload\":5}}",mapper.writeValueAsString(new SomeObject(new SomeObject(5))));
assertEquals("[[]]",mapper.writeValueAsString(new Object[]{new Object[]{}}));
assertEquals("[[[]]]",mapper.writeValueAsString(new Object[]{new Object[]{new ArrayList<Object>()}}));
assertEquals("[[{}]]",mapper.writeValueAsString(new Object[]{new Object[]{new HashMap()}}));
assertEquals("[{\"@type\":-47419438,\"payload\":5}]",mapper.writeValueAsString(new Object[]{new SomeObject(5)}));
assertEquals("[[{\"@type\":-47419438,\"payload\":5}]]",mapper.writeValueAsString(new Object[]{new Object[]{new SomeObject(5)}}));
}