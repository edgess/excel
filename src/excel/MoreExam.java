package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MoreExam {
	public static void main(String[] args) throws Exception, IOException {
		//ԭʼ���Ŀ¼
		String path = "./done";
		//new File(path).mkdir();
		
		File dir = new File(path);
		while (dir.exists()) {
			path = path + "a";
			dir = new File(path);
		}

		dir.mkdir();		
		// �����ģ�壬���ɴ������
		FileInputStream is = new FileInputStream("./answer.jar");
		FileOutputStream os = new FileOutputStream(path+ "/" + "answer.xls");
		Workbook moban = Workbook.getWorkbook(is);
		WritableWorkbook workbook = Workbook.createWorkbook(os, moban);
		WritableSheet sheet = workbook.getSheet(0);
		SetCell setCell = new SetCell(sheet);
		// ����10����ϰ
		for (int i = 1; i < 11; i++) {
			// ƴ��Ŀ¼���ļ���
			String file = "exam_" + i + ".xls";
			Lianxi lianxi = new Lianxi();
			// ������ϰ������ֵΪ��
			String answer = lianxi.exam(path, file);
			// System.out.println(file);
			// System.out.println(answer);
			// ��д��answer.xls
			setCell.middleCell(0, 0, "�𰸰�˳��ÿ����--�ָ..��Ϊ��������");
			setCell.answerCell(0, i, file);
			setCell.answerCell(1, i, answer);
		}
		// ����
		workbook.write();
		workbook.close();
		os.close();
		System.out.println("---job done---");
	}
}
