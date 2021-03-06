package com.oracle.gdms.util;

import java.util.ResourceBundle;


public class Factory {
	 private static ResourceBundle rb;//定义一个资源绑定对象
	    
	    static {
	    	rb=ResourceBundle.getBundle("config/application");
	    }
	    
		private Factory() {}
	    	
	    private static Factory fac;
	    
		public static Factory getInstance() {
		fac=fac==null?new Factory():fac;
			return fac;
		}
		
		
		
		public Object getObject(String key) {
			
			//读取配置文件，找到key对应的class路径名称
			String classname=rb.getString(key);
			Object o=null;
			try {
				o = Class.forName(classname).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return o;
		}
}
