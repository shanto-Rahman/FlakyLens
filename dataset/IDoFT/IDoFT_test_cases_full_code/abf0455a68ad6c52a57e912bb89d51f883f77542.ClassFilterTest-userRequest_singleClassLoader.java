/** 
 * Variant of  {@link #userRequest()} test that targets{@link UserRequest#deserialize(Channel,byte[],ClassLoader)} *without* multiclassloader support.
 */
@Test public void userRequest_singleClassLoader() throws Exception {
  setUpWithNoCapacity();
  userRequestTestSequence();
}
