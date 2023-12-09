package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employeeClass = Class.forName("ord_example.Employee");
//        Class employeeClass2 = Employee.class; эти строчки когда - это альтернативные способы создания объекта класса Класс
//        Employee emp = new Employee();
//        Class employeeClass3 = emp.getClass();

        Field someField = employeeClass.getField("id");
        System.out.println("Type of id  field = " + someField.getType());
        System.out.println("************");

        Field [] fields = employeeClass.getFields();
        for (Field field:fields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("***********");

        Field [] allFields = employeeClass.getDeclaredFields();
        for(Field field:allFields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("***********");

        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = " +
                someMethod1.getReturnType() + ", paremetr types = " +
                Arrays.toString(someMethod1.getParameterTypes()));
        System.out.println("***********");

        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method increaseSalary = " +
                someMethod2.getReturnType() + ", paremetr types = " +
                Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("***********");

        Method [] methods = employeeClass.getMethods();
        for(Method method: methods) {
            System.out.println("Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", paremetr types = " +
                    Arrays.toString(someMethod2.getParameterTypes()));
            System.out.println("***********");
        }

            Method [] allMethods = employeeClass.getDeclaredMethods();
            for(Method method: allMethods) {
                System.out.println("Name of method = " + method.getName() +
                        ", return type = " + method.getReturnType() +
                        ", paremetr types = " +
                        Arrays.toString(someMethod2.getParameterTypes()));
                System.out.println("***********");
            }

        Method [] allMethods2 = employeeClass.getDeclaredMethods();
        for(Method method: allMethods2) {
            if(Modifier.isPublic(method.getModifiers()))
            System.out.println("Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", paremetr types = " +
                    Arrays.toString(someMethod2.getParameterTypes()));

        }
    }
}
