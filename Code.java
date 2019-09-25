

package com.SCL.BasicDemand;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Code{
    static   int annotationLine = 0;
    static int blankLine;
    static int codeLine;
    static int  totalLine;


    public   static  void  code(String s)throws FileNotFoundException {
        System.out.println("������Ҫͳ�ƴ�������java�ļ���");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        File file = new File(filePath);
        Start(file);
        System.out.println("��������������������ͳ�ƽ��������������������");

        System.out.println(file + "�ļ�/Ŀ¼��������" + totalLine);
        System.out.println("����������" + codeLine);
        System.out.println("ע��������" + annotationLine);
        System.out.println("�հ�������" + blankLine);


    }  private static void  Start(File file) throws FileNotFoundException {
        if (file == null || !file.exists())
            throw new FileNotFoundException(file + "���ļ������ڣ�");



        if (file.isDirectory()) {
            File[] files = file.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".java") || pathname.isDirectory();
                }
            });

            for (File target : files) {
             Start(target);
            }
        } else {
            BufferedReader bufr = null;
            try {
                // ��ָ��·�����ļ����ַ�����
                bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException(file + "���ļ������ڣ�" + e);
            }

            // ����ƥ��ÿһ�е�����ƥ����
            Pattern annotationLinePattern = Pattern.compile("((//)|(/\\*+)|((^\\s)*\\*)|((^\\s)*\\*+/))+",
                    Pattern.MULTILINE + Pattern.DOTALL);   // ע��ƥ����(ƥ�䵥�С����С��ĵ�ע��)

            Pattern blankLinePattern = Pattern.compile("^\\s*$");  // �հ���ƥ������ƥ��س���tab�����ո�

            String line = null;
            try {
                while((line = bufr.readLine()) != null) {
                    if (annotationLinePattern.matcher(line).find()) {
                        annotationLine ++;
                    }

                    if (blankLinePattern.matcher(line).find()) {
                        blankLine ++;
                    }
                     else {
                        codeLine++;// ���հ��к�ע�����⣬�����Ϊ������
                    }

                    totalLine ++;
                }
            } catch (IOException e) {
                throw new RuntimeException("��ȡ�ļ�ʧ�ܣ�" + e);
            } finally {
                try {
                    bufr.close();  // �ر��ļ����������ͷ�ϵͳ��Դ
                } catch (IOException e) {
                    throw new RuntimeException("�ر��ļ�������ʧ�ܣ�");
                }
            }
        }
    }

}
