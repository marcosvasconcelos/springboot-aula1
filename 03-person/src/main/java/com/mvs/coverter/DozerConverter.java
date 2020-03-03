package com.mvs.coverter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	
	private static Mapper map = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parserObject(O origin, Class<D> destination) {
		
		return map.map(origin, destination);
		
	}
	
	public static <O, D> List<D> parserListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		
		for(Object o : origin) {
			destinationObjects.add(map.map(o, destination));
		}
		return destinationObjects;
		
	}

}
