package cn.spring.mvn.batch;

//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import cn.spring.mvn.batch.tools.BatchTools;

public class TestBatch {/*
	@Test
	public void testBatch(){
		List<String> staticFileList = new ArrayList<String>();
		List<String> staticSubClassList = new ArrayList<String>();
		String filePath = "D:\\Eclipse\\eclipse-workspaces\\spring-maven\\spring-mvc-maven\\src\\main\\java\\cn\\spring\\mvc\\global\\comm\\batch";
		File file = new File(filePath);
		staticFileList = BatchTools.getSubFileNameListByFilePath(file,staticFileList);
		for(String staticClass : staticFileList){
			if(BatchTools.isChildClass(staticClass, BatchManger.class)){
				staticSubClassList.add(staticClass);
			}
		}
		try {
			List<Object> staticObjectList = BatchTools.getAttributeByAutowiredAnnotation(staticSubClassList);
			for(Object staticObj : staticObjectList){
				System.out.println(staticObj);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
*/}
