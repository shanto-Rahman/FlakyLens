@Test public void test() throws IOException {
  final ActorReferenceModule actorReferenceModule=new ActorReferenceModule(DefaultDescriptorFactory.get());
  final ObjectMapper mapper=new ObjectMapper();
  mapper.registerModule(actorReferenceModule);
  mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE).withIsGetterVisibility(JsonAutoDetect.Visibility.NONE).withSetterVisibility(JsonAutoDetect.Visibility.NONE).withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
  mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
  TypeResolverBuilder<?> typer=new ClassIdTypeResolverBuilder(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
  typer=typer.init(JsonTypeInfo.Id.NAME,null);
  typer=typer.inclusion(JsonTypeInfo.As.PROPERTY);
  mapper.setDefaultTyping(typer);
{
    String str="{\"payload\":[{\"@type\":\"-47419438\",\"payload\":5}]}";
    String str2="{\"payload\":[{\"@type\":-47419438,\"payload\":5}]}";
    SomeObject obj=mapper.readValue(str,SomeObject.class);
    assertEquals(str2,mapper.writeValueAsString(obj));
  }
{
    String str="[{\"@type\":-47419438,\"payload\":5}]";
    assertEquals(str,mapper.writeValueAsString(new Object[]{new SomeObject(5)}));
  }
{
    String str="[{\"@type\":-47419438,\"payload\":5}]";
    Object obj=mapper.readValue(str,Object.class);
    assertEquals(str,mapper.writeValueAsString(obj));
  }
{
    String str="{\"payload\":[\"test\",{\"@type\":\"-47419438\",\"payload\":5}]}";
    String str2="{\"payload\":[\"test\",{\"@type\":-47419438,\"payload\":5}]}";
    SomeObject obj=mapper.readValue(str,SomeObject.class);
    assertEquals(str2,mapper.writeValueAsString(obj));
  }
{
    String str="{\"payload\":[\"test\",{\"@type\":\"-47419438\",\"payload\":5}],\"headers\":{}}";
    String str2="{\"payload\":[\"test\",{\"@type\":-47419438,\"payload\":5}],\"headers\":{}}";
    SomeObject obj=mapper.readValue(str,SomeObject.class);
    SomeObject obj2=mapper.readValue(str,SomeObject.class);
    assertEquals(str2,mapper.writeValueAsString(obj));
    assertEquals(str2,mapper.writeValueAsString(obj2));
  }
{
    String str="{\"payload\":[\"test\",{\"@type\":-47419438,\"payload\":5}],\"headers\":{}}";
    SomeObject obj=mapper.readValue(str,SomeObject.class);
    assertEquals(str,mapper.writeValueAsString(obj));
  }
  assertEquals("{\"payload\":{\"@type\":-47419438,\"payload\":5}}",mapper.writeValueAsString(new SomeObject(new SomeObject(5))));
  mapper.readValue("{\"payload\":[\"tes\"]}",SomeObject.class);
{
    final String json="[[{\"@type\":\"-47419438\",\"payload\":5}]]";
    final Object obj=mapper.readValue(json,Object[].class);
  }
{
    final String json="[[{\"@type\":-47419438,\"payload\":5}]]";
    final Object obj=mapper.readValue(json,Object[].class);
  }
  assertEquals("[[]]",mapper.writeValueAsString(new Object[]{new Object[]{}}));
  assertEquals("[[[]]]",mapper.writeValueAsString(new Object[]{new Object[]{new ArrayList<Object>()}}));
  assertEquals("[[{}]]",mapper.writeValueAsString(new Object[]{new Object[]{new HashMap()}}));
  assertEquals("[{\"@type\":-47419438,\"payload\":5}]",mapper.writeValueAsString(new Object[]{new SomeObject(5)}));
  assertEquals("[[{\"@type\":-47419438,\"payload\":5}]]",mapper.writeValueAsString(new Object[]{new Object[]{new SomeObject(5)}}));
}
