@Test public void testReflectionHierarchy(){
assertEquals(baseString + "[a=a]",ToStringBuilder.reflectionToString(baseA));
assertEquals(baseString + "[a=a]",ToStringBuilder.reflectionToString(baseA,null));
assertEquals(baseString + "[a=a]",ToStringBuilder.reflectionToString(baseA,null,false));
assertEquals(baseString + "[a=a,transientA=t]",ToStringBuilder.reflectionToString(baseA,null,true));
assertEquals(baseString + "[a=a]",ToStringBuilder.reflectionToString(baseA,null,false,null));
assertEquals(baseString + "[a=a]",ToStringBuilder.reflectionToString(baseA,null,false,Object.class));
assertEquals(baseString + "[a=a]",ToStringBuilder.reflectionToString(baseA,null,false,ReflectionTestFixtureA.class));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB,null));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB,null,false));
assertEquals(baseString + "[b=b,transientB=t,a=a,transientA=t]",ToStringBuilder.reflectionToString(baseB,null,true));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB,null,false,null));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB,null,false,Object.class));
assertEquals(baseString + "[b=b,a=a]",ToStringBuilder.reflectionToString(baseB,null,false,ReflectionTestFixtureA.class));
assertEquals(baseString + "[b=b]",ToStringBuilder.reflectionToString(baseB,null,false,ReflectionTestFixtureB.class));
}