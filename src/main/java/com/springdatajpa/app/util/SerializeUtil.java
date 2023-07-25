package com.springdatajpa.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeUtil<T> {
	private static final ObjectMapper om = new ObjectMapper();

	/**
	 * DeSerializes the JSON string passed in the method argument to the respective
	 * class type passed in the method argument
	 *
	 * @param json
	 * @param toValueType
	 * @param <T>
	 * @return POJO deSerialized from the JSON string or null if deSerialization
	 *         fails
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String json, @SuppressWarnings("rawtypes") Class clazz) {
		T t = null;
		try {
			t = (T) om.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * Serializes the POJO and returns JSON string
	 *
	 * @param toValueType
	 * @param <T>
	 * @return Serialized JSON String of the POJO passed in the method argument
	 */
	public static <T> String serialize(T toValueType) {
		String s = null;
		try {
			s = om.writeValueAsString(toValueType);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return s;
	}
}