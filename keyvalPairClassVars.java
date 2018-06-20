/*to show the class varibles and thier value using map (key,value) pair  */

import java.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Hello {
    static public class customer{
        private  String firstname="",lastname="",city = "";
        private int num = 0;
        List<Object> l = new ArrayList<Object> ();
        public customer(String fn , String ln,String cit,int nu){
            this.firstname = fn;
            l.add(fn);
            this.lastname = ln;
            l.add(ln);
            this.city = cit;
            l.add(cit);
            this.num = nu;
            l.add(nu);
        }
        public static class billAddress{
            List<Object> bilList = new ArrayList<> ();
            private String city="";
            private int zipCode = 0;
            public billAddress(String city,int zipcode){
                this.city = city;
                bilList.add(city);
                this.zipCode = zipcode;
                bilList.add(zipcode);
            }
        }
        billAddress bilobj = new billAddress("chennai" , 600001);
    }
    
    public static void toString(Map<String,Object> mp){
        System.out.println("{");
        for(Map.Entry<String,Object> entry : mp.entrySet()){
            System.out.print("     \" "+entry.getKey()+" \" "+":");
            if(entry.getValue() instanceof String){
                System.out.print("     \" "+entry.getValue()+" \" ");    
            }
            else if(entry.getValue() instanceof Integer){
                System.out.print("     "+entry.getValue());
            }
            else{
                toString((Map<String,Object>)entry.getValue());
            }
            System.out.println();
        }
        System.out.println("}");
    }
    
    public static void main(String[] args) {
        int i=0;
		customer c=new customer("adharsh","sandeep","chennai",9090);
		
		Map<String,Object> dict = new LinkedHashMap<String,Object>();
		Map<String,Object> dictBill = new LinkedHashMap<String,Object>();
		Field[] fields = customer.class.getDeclaredFields();
		for(Field field : fields){
		    if(Modifier.isPrivate(field.getModifiers())){
		        field.setAccessible(true);
		        dict.put(field.getName() , c.l.get(i++));
		    }
		}i=0;
		Class[] classes = customer.class.getDeclaredClasses();
		for(Class innerclass : classes){
		    Field[] fieldsOfInner = innerclass.getDeclaredFields();
		    for(Field field : fieldsOfInner){
		        if(Modifier.isPrivate(field.getModifiers())){
		            field.setAccessible(true);
		            dictBill.put(field.getName() , c.bilobj.bilList.get(i++));
		        }
		    }
		}
		dict.put("billAddress" , dictBill);
	    toString(dict);
    }
}
