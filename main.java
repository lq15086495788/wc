 package com.SCL.BasicDemand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main{
public static void main(String[] args) {

while (true){

// ������
System.out.println("\n--------------------- WC����---------------------");
System.out.println("************ ***********");
System.out.println(" ** -all �����ַ����������������� ");
System.out.println(" ** -a [�ļ�·��] ͳ�ƴ�����/����/ע���� ");
System.out.println("-----------------------------------------------------------");

// ��ȡ����ָ��

System.out.print("[Please...] ���������");
Scanner input=new Scanner(System.in);
// String c=input.next();
String m=input.nextLine();
String arr[]=m.split("\\s");

// ���ݻ�ȡָ����ִ�к���
try{
switch(arr[0]){
case"-all":Counter.counter(); break; //�����ַ�����������������
case"-a": Code.code(arr[0]) ;break; //ͳ�ƴ����� / ���� / ע����
default:System.out.println("\n******** �����ڸù���ָ��!");break;
}
} catch (FileNotFoundException e) {
System.out.println("\n******** ������������·���ļ��Ҳ��������� **********");
} catch (IOException e){
System.out.println("\n******** ���������ļ����뷢���쳣������ **********");
} catch (Exception e) {
e.printStackTrace();
}
}
}
}